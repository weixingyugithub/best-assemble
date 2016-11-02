package com.beijing.wei.util.common;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {
	public static String getFormatDate(Date date) {
		try {
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		String result = formater.format(date);
		return result;
		}catch(Exception e){
			return "";
		}
	}
	
	//获取上一天日期
	public static String getYesterDay(){
		 Calendar cal = Calendar.getInstance();
		 cal.add(Calendar.DAY_OF_MONTH, -1);
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 return sdf.format(cal.getTime());
	}
	//获取前2天时间
	public static String getbeYesterDay(){
		 Calendar cal = Calendar.getInstance();
		 cal.add(Calendar.DAY_OF_MONTH, -2);
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 return sdf.format(cal.getTime());
	}
	//获取前3天时间
	public static String getlaYesterDay(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -3);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(cal.getTime());
	}
	
	//获取前3天时间
	public static String getlastDay(int days){
		if(0 == days){
			return DateUtil.nowDate();
		}
		 Calendar cal = Calendar.getInstance();
		 cal.add(Calendar.DAY_OF_MONTH, -days);
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 return sdf.format(cal.getTime());
	}
	
	/**
	 * 根据传入的日期和天数，获取相加以后的日期
	 * @param date 传入的日期 
	 * @param i 增加的天数
	 * @return
	 */
	public static String addDay(String date,int i){
		Date d = getDateFromStr(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(Calendar.DAY_OF_MONTH, i);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(calendar.getTime());
	}
	
	/**
	 * 输入当前日期，判断能够补填的天数
	 *@param daynum  设置天数 
	 *@param date  日期 yyyy-MM-dd
	 *return 返回具体补填天数
	 */
	public static int getBeforeDays(int daynum,String date){
		int days = 0;
		int weeknum = DateUtil.getDateXq(date);
//		if(weeknum==1){ //判断星期一
//			days = daynum + 3;
//		}
		if(weeknum==6){ //判断星期六
			days = daynum + 1;
		}
		if(weeknum==7){ //判断星期日
			days = daynum + 2;
		} 
//		if(weeknum!=1&&weeknum!=6&&weeknum!=7) { //其他星期类型
		if(weeknum!=6&&weeknum!=7) { //其他星期类型
			days = daynum;
		}
		return days;
	}
	
	
	/**
	 * 判断日期是否显示（用于显示领导审批日志是否可用）
	 *@param date  日期  yyyy-MM-dd
	 *@param daynum  补填天数
	 */
	public static boolean getDateIsDisplay(String date,int daynum){
		if(null == date || "".equals(date.trim())){
			return false;
		}
		//当前日期
		String currDate = DateUtil.nowDate();
		//判断日期和当前日期相差天数
		int days = DateUtil.getTwoDateDays(date,currDate);
		if(days <= -1){
			return false;
		}
		//取得相差天数具体是哪一天
		String leaderDate = DateUtil.getlastDay(daynum);
		//判断改天是星期几，并做处理，避免星期一无法补填上周五的情况等。
		daynum = DateUtil.getBeforeDays(daynum,leaderDate);
		if(days <= daynum){
			return true;
		}else{
			return false;
		}
	}
	
	
	/**
	 *@param weeknum 星期类型  
	 *@param daynum  设置天数 
	 *  补填日期获取日期时间
	 */
	public static List<String> getBeforeDays(int  weeknum ,int daynum){
		List<String> list=new ArrayList<String>();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 int today = Calendar.DAY_OF_MONTH ;
		 String days="";
		 if(weeknum==1){ //判断星期一
			 for (int i =1; i <daynum+2; i++){
				 Calendar cal = Calendar.getInstance();
				 cal.add(today ,-i);
				 days = sdf.format(cal.getTime());
				 list.add(days);
			}
	    }
		 if(weeknum==7){ //判断星期日
			 for (int i = 1; i <daynum+1; i++){
				 Calendar cal = Calendar.getInstance();
				 cal.add(today, -i);
				 days = sdf.format(cal.getTime());
				 list.add(days);
			}
		} 
	    if(weeknum!=1&&weeknum!=7) { //其他星期类型
			 for (int i = 1; i<daynum; i++){
				 Calendar cal = Calendar.getInstance();
				 cal.add(today, -i);
				 days = sdf.format(cal.getTime());
				 list.add(days);
			}
		}
		 return list;
	}
	
	public static String getDayByNow(Integer i){
		 Calendar cal = Calendar.getInstance();
		 cal.add(Calendar.DAY_OF_MONTH, i);
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 return sdf.format(cal.getTime());
	}
	
	//获取用户提供的格式的日期
	public static String getFormatDate(String source,String pattern){
		SimpleDateFormat formator = new SimpleDateFormat("yyyy-MM-dd");
		try {
            Date date = formator.parse(source);
            SimpleDateFormat targetformator = new SimpleDateFormat(pattern);
            return targetformator.format(date);
		} catch (Exception e) {
			return null;
		}
	}
	public static String getFormatDate(Date source,String pattern){
		//SimpleDateFormat formator = new SimpleDateFormat("yyyy-MM-dd");
		try {
            //Date date = formator.parse(source);
            SimpleDateFormat targetformator = new SimpleDateFormat(pattern);
            return targetformator.format(source);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String getFormatDate(String source,String sourcePatton,String pattern){
		SimpleDateFormat formator = new SimpleDateFormat(sourcePatton);
		try {
            Date date = formator.parse(source);
            SimpleDateFormat targetformator = new SimpleDateFormat(pattern);
            return targetformator.format(date);
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 获得当天的午夜时间 yyyy-MM-dd 24:00:00
	 * @param source
	 * @param sourcePatton
	 * @param pattern
	 * @return
	 */
	public static String getFormatDateEnd(String source,String sourcePatton,String pattern){
		SimpleDateFormat formator = new SimpleDateFormat(sourcePatton);
		try {
            Date date = formator.parse(source);
            date = new Date(date.getTime()+(24*60*60)*1000);
            SimpleDateFormat targetformator = new SimpleDateFormat(pattern);
            return targetformator.format(date);
		} catch (Exception e) {
			return null;
		}
	}
	public static Date getDateFromStr(String source,String sourcePattern){
		SimpleDateFormat formator = new SimpleDateFormat(sourcePattern);
		try {
            Date date = formator.parse(source);
            return date;
		} catch (Exception e) {
			return null;
		}
	}
	public static Date getDateFromStr(String source){
		SimpleDateFormat formator = new SimpleDateFormat("yyyy-MM-dd");
		try {
            Date date = formator.parse(source);
            return date;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static Date getDateOffset( Date date, int offset )
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add( Calendar.HOUR_OF_DAY, offset );
		
		return calendar.getTime();		
	}
	/**
	 * 获得当前时间 yyyy-MM-dd  HH:mm:ss
	 * @return String
	 */
	public static String nowTime() {
		  Calendar c = Calendar.getInstance();
		  c.setTimeInMillis(new Date().getTime());
		  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  return dateFormat.format(c.getTime());
	 }
	/**
	 * 获得当前时间 yyyy-MM-dd  HH:mm:ss
	 * @return Date
	 */
	public static Date getNowTime() {
		  Calendar c = Calendar.getInstance();
		  c.setTimeInMillis(new Date().getTime());
		  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = dateFormat.parse(dateFormat.format(c.getTime()));
			  return date;
		} catch (ParseException e) {
			return null;
		}
	 }
	
	/**
	 * 获得当前日期 yyyy-MM-dd
	 * @return string
	 */
	public static String nowDate() {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(new Date().getTime());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(c.getTime());
	}
	
	/**
	 * 获得年份列表
	 * @return string
	 */
	@SuppressWarnings("unchecked")
	public static List<String> getYearlist() {
		String date = DateUtil.nowDate();
		String year = date.substring(0, 4);
		List<String> yearList = new ArrayList<String>();
		Integer nowYear = new Integer(year);
		Integer beginYear = nowYear - 5;
		Integer lastYear = nowYear - 1;
		yearList.add(year);
		while(beginYear < lastYear){
			yearList.add(lastYear.toString());
			lastYear--;
		}
		return yearList;
	}
	
	/**
	 * 获得年份列表，带计划，可以显示当年年的下一年
	 * @return string
	 */
	@SuppressWarnings("unchecked")
	public static List<String> getYearlistPlan() {
		String date = DateUtil.nowDate();
		String year = date.substring(0, 4);
		List<String> yearList = new ArrayList<String>();
		Integer nowYear = new Integer(year);
		Integer beginYear = nowYear - 4;
		Integer lastYear = nowYear + 1;
		yearList.add(year);
		while(beginYear < lastYear){
			if(!nowYear.equals(lastYear)){
				yearList.add(lastYear.toString());
			}
			lastYear--;
		}
		return yearList;
	}
	
	
	//获取年份列表
	
	public static List<String> getYearList(Integer year){
		
		List<String> yearList = new ArrayList<String>();
		yearList.add(Integer.toString(year));
		
		Calendar cal=Calendar.getInstance();
		
		Integer nowYear=cal.get(Calendar.YEAR);
		
		Integer beginYear=nowYear-6;
		
		while(beginYear<=nowYear){
			if(beginYear!=year){
			    yearList.add(beginYear.toString());
			}
			beginYear++;
		}
                    
		return yearList;
	}
	/**
	 * 获得当前年份
	 * @return string
	 */
	@SuppressWarnings("unchecked")
	public static String getYear() {
		String date = DateUtil.nowDate();
		String year = null;
		if(null != date){
			year = date.substring(0, 4);
		}
		return year;
	}
	
	/**
	 * 获得当前月份
	 * @return string
	 */
	@SuppressWarnings("unchecked")
	public static String getMonth() {
		String date = DateUtil.nowDate();
		String month = null;
		if(null != date){
			month = date.substring(5, 7);
		}
		return month;
	}
	
	/**
	 * 获得月份列表
	 * @return string
	 */
	public static List<String> getMonthlist() {
		String date = DateUtil.nowDate();
//		String year = date.substring(0, 4);
//		List<String> yearList = new ArrayList<String>();
		List<String> monthList = new ArrayList<String>();
//		Integer nowYear = new Integer(year);
//		Integer beginYear = nowYear - 5;
//		Integer lastYear = nowYear - 1;
//		yearList.add(year);
		String month = date.split("-")[1];
		monthList.add(month);
//		while(beginYear < lastYear){
//			yearList.add(lastYear.toString());
//			lastYear--;
//		}
		int i = 1;
		int mon = Integer.valueOf(month);
		while(i<=12){
			if(mon != i ){
				if(i<10){
					monthList.add("0"+i);
				}else{
					monthList.add(""+i);
				}
			}
			i++;
		}
		return monthList;
	}
	
	
	
	/**
	 * 获得当前年份的开始时间 yyyy-01-01
	 * @return string
	 */
	public static String getStartDate() {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(new Date().getTime());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		String result = dateFormat.format(c.getTime()) +"-01-01";
		return result;
	}
	
	/**
	 * 获得当前年份的结束时间 yyyy-12-31
	 * @return string
	 */
	public static String getEndDate() {
		  Calendar c = Calendar.getInstance();
		  c.setTimeInMillis(new Date().getTime());
		  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		  String result = dateFormat.format(c.getTime()) +"-12-31";
		  return result;
	 }
	
	/**
	 * 获得当前日期 yyyy-MM-dd
	 * @return Date
	 */
	public static Date getNowDate() {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(new Date().getTime());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = dateFormat.parse(dateFormat.format(c.getTime()));
			return date;
		} catch (ParseException e) {
			return null;
		}
	}
	
	/**
	 * 获得当前时间
	 * @return Timestamp
	 */
	public static Timestamp getTimestamp() {
		return getTimestamp(getNowDate());
	}
	
	/**
	 * 将date类型时间转换成Timestamp类型
	 * @return Timestamp
	 */
	public static Timestamp getTimestamp(Date time)
	{
		if(time == null)
			return null;
		Timestamp tt = null;
		try
		{
			tt = new Timestamp(time.getTime());
		}
		catch(Exception e) { }
		return tt;
	}
	
	/**
	 * 将Timestamp类型时间转换成string的yyyy-MM-dd HH:mm:ss类型
	 * @return String
	 */
	public static String timestampToString(Timestamp time)
	{
		if(time == null){
			return null;
		}
		String result = "";
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			result = sdf.format(time);
		} catch (Exception e) {
			return null;
		}
		return result;
	}
	
	
	
	/**
	 * 将String类型时间转换成Date类型
	 * @return Timestamp
	 */
	public static Date stringToDate(String time)
    {
        if(time == null)
        return null;
        Date date = null;
        SimpleDateFormat formator = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
            date = (Date)formator.parse(time);
        }
        catch(Exception e) { }
        return date;
    }
	
	/**
	 * 将 **秒，转换成 **小时**分钟**秒
	 * @return HMS **小时**分钟**秒
	 */
	public static String secondToHMS(String sec) {
		if(null == sec){
			return null;
		}
		//将小数点后的数去掉
		Long seconds = Long.parseLong(subZeroAndDot(sec));
		String HMS = null;
		long day = seconds/(3600*24);//持续天数
		long hour = (seconds - day*(3600*24))/3600;//持续小时数
		long minute = (seconds - day*(3600*24) -hour*3600)/60;//持续分钟数
		long second = (seconds - day*(3600*24) -hour*3600-minute*60);//持续秒数
		if(day>0){
			HMS = day+"天"+hour+"小时"+ minute+"分钟"+ second+"秒";
		}else if(hour>0){
			HMS = hour+"小时"+ minute+"分钟"+ second+"秒";
		}else if(minute>0){
			HMS = minute+"分钟"+ second+"秒";
		}else{
			HMS = second+"秒";
		}
		return HMS;
	}
	
	/**
	 * 将 **秒，转换成 **小时
	 * @return Hours **小时
	 */
	public static String secondToHours(String sec) {
		if(null == sec){
			return null;
		}
		//将小数点后的数去掉
		Long seconds = Long.parseLong(subZeroAndDot(sec));
		String Hours = null;
		long hour = seconds/3600;//持续小时数
		hour = (long)(Math.round(hour*100)/100.0);
		Hours = hour+"";
		return Hours;
	 }
	
	
	
	 /**  
     * 使用java正则表达式去掉多余的.与0  
     * @param s  
     * @return   
     */  
    public static String subZeroAndDot(String s){
        if(s.indexOf(".") > 0){
        	s = s.substring(0,s.indexOf("."));
//            s = s.replaceAll("0+?$", "");//去掉多余的0   
//            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉   
        }   
        return s;   
    }   
    
    /**  
     * 跟据日期判断星期  
     * @param   
     * @return   
     * @throws ParseException 
     */  
    public static String getXqByDate(String date) throws ParseException{
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Date date2 = sdf.parse(date);
    	SimpleDateFormat sdf2 = new SimpleDateFormat("E");
    	return sdf2.format(date2);

    }
    
    @SuppressWarnings("unused")
    public static Integer getMothDays(String date) throws ParseException{
		Integer year = new Integer(date.substring(0,4));
		Integer moth = new Integer(date.substring(5,7));
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR,year);
		cal.set(Calendar.MONTH, moth-1);
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    
    public static Boolean pdDate(String date1,String date2){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
    	Boolean pd = false;
		try {
			Date da1 = sdf.parse(date1);
			Date da2 = sdf.parse(date2);
			if(da1.getTime()>da2.getTime()){
				pd = true;
			}
		} catch (ParseException e) {
			return pd;
		}
		return pd;
		
    }
    
    public static Boolean pdDateXd(String date1,String date2){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
    	Boolean pd = false;
		try {
			Date da1 = sdf.parse(date1);
			Date da2 = sdf.parse(date2);
			if(da1.getTime()==da2.getTime()){
				pd = true;
			}
		} catch (ParseException e) {
			return pd;
		}
		return pd;
		
    }
    
    public static Integer getNowXq(){
    	String nowDate = DateUtil.nowDate();
    	String nowxq = "";
    	try {
    		nowxq = DateUtil.getXqByDate(nowDate);
    	} catch (ParseException e) {
    		return null;
    	}
    	if(nowxq.equals("星期一"))return 1;
    	else if(nowxq.equals("星期二"))return 2;
    	else if(nowxq.equals("星期三"))return 3;
    	else if(nowxq.equals("星期四"))return 4;
    	else if(nowxq.equals("星期五"))return 5;
    	else if(nowxq.equals("星期六"))return 6;
    	else if(nowxq.equals("星期日"))return 7;
    	else return null;
    }
    
    public static Integer getDateXq(String date){
    	if(null == date || "".equals(date)){
    		date = DateUtil.nowDate();
    	}
		String nowxq = "";
		try {
			nowxq = DateUtil.getXqByDate(date);
		} catch (ParseException e) {
			return null;
		}
		if(nowxq.equals("星期一"))return 1;
		else if(nowxq.equals("星期二"))return 2;
		else if(nowxq.equals("星期三"))return 3;
		else if(nowxq.equals("星期四"))return 4;
		else if(nowxq.equals("星期五"))return 5;
		else if(nowxq.equals("星期六"))return 6;
		else if(nowxq.equals("星期日"))return 7;
		else return null;
    }
    
    /**
     * 求两个时间的相隔多少天
     * @return
     */
    public static int getTwoDateDays(String start,String end){
    	Calendar startDate = Calendar.getInstance();
    	Calendar endDate = Calendar.getInstance();
    	startDate.setTime(getDateFromStr(start,"yyyy-MM-dd"));
    	endDate.setTime(getDateFromStr(end,"yyyy-MM-dd"));
    	int endDay = endDate.get(Calendar.DAY_OF_YEAR);
    	int fristDay = startDate.get(Calendar.DAY_OF_YEAR);
    	int result = Math.abs(endDay-fristDay);
    	if(fristDay > endDay){
    		result = -1*result;
    	}
    	return result;
    }
    
    /**
     * 计算两个时间的天数差
     * @param start
     * @param end
     * @return
     */
    public static int getTwoDateDays(Date start,Date end){
    	Long startTime=start.getTime();
    	Long endTime=end.getTime();
    	Long result=(endTime-startTime)/1000/60/60/24;
    	return Integer.parseInt(result.toString())+1;
    }
    
    public static void main(String[] args) {
    	getTwoDateDays("2012-01-02","2012-01-12");
	}
    
    //生成日期集合
    public static List<String[]> getDayListByMonth(String year,String month){
    	if(null == year || "".equals(year.trim())){
    		year = getYear();
    	}
    	if(null == month || "".equals(month.trim())){
    		month = getMonth();
    	}
		List<String[]> dateStrLs = new ArrayList<String[]>();
		Calendar cal = Calendar.getInstance();
        int nowDate=0;
     	if(cal.get(Calendar.YEAR)==Integer.valueOf(year) && cal.get(Calendar.MONTH)+1==Integer.valueOf(month)){
			nowDate = cal.get(Calendar.DAY_OF_MONTH);
		}else{
			cal.set(Calendar.YEAR, Integer.valueOf(year));
			cal.set(Calendar.MONTH, (Integer.valueOf(month)-1));
			nowDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		}
        String strDate = (cal.get(Calendar.MONTH)+1>9 ? cal.get(Calendar.MONTH)+1 : "0"+(cal.get(Calendar.MONTH)+1))+"-";
//        for(int i=nowDate;i>0; i--){
        for(int i=1;i<=nowDate; i++){
	        cal.set(Calendar.DAY_OF_MONTH, i);
			String weekDayStr = generateWeekDayStr(cal);
			String dateStrings[] = new String[2];
			dateStrings[0] = strDate+(i>9? i :"0"+i);
			dateStrings[1] = weekDayStr;
			dateStrLs.add(dateStrings);
		}
		return dateStrLs;
	}
  
    public static  String generateWeekDayStr(Calendar cal){
    	String [] str={"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
    	int weekDay=cal.get(Calendar.DAY_OF_WEEK);
    	if(weekDay-1<0){
    		weekDay=0;
    	}else{
    		weekDay=weekDay-1;
    	}
    	    return str[weekDay];
    }
    
    public static java.sql.Date todayTime()
    {
    	return new java.sql.Date(System.currentTimeMillis());
    }
    
    /**  
     * 得到某年某月的最后一天  
     * @param year  
     * @param month  
     * @return  
    */  

    public static String getLastDayOfMonth(int year, int month) {  
    	Calendar cal = Calendar.getInstance();  
    	cal.set(Calendar.YEAR, year);  
		cal.set(Calendar.MONTH, month-1);  
		cal.set(Calendar.DAY_OF_MONTH, 1);  
		int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);  
		cal.set(Calendar.DAY_OF_MONTH, value);  
		return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());  
	}  

}
