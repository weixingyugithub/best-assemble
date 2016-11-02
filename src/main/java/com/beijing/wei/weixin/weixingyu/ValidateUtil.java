package com.beijing.wei.weixin.weixingyu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.beijing.wei.util.autoReack.XiaoDouMachine;
import com.beijing.wei.util.file.SysLogs;

public class ValidateUtil {
	public final static String WXY_TOKEN = "weixingyu";
	
	public static boolean validate(String token,WeChat weChat){
		String[] tmpArr={token,weChat.getTimestamp(),weChat.getNonce()};  
        Arrays.sort(tmpArr);  
        String tmpStr=ArrayToString(tmpArr);  
        tmpStr=SHA1Encode(tmpStr);  
        if(tmpStr.equalsIgnoreCase(weChat.getSignature())){  
            return true;  
        }else{  
            return false;  
        }  
	}
	
	
	 //数组转字符串  
	   public static String ArrayToString(String [] arr){  
	       StringBuffer bf = new StringBuffer();  
	       for(int i = 0; i < arr.length; i++){  
	        bf.append(arr[i]);  
	       }  
	       return bf.toString();  
	   }  

	   //sha1加密  
	   public static String SHA1Encode(String sourceString) {  
	       String resultString = null;  
	       try {  
	          resultString = new String(sourceString);  
	          MessageDigest md = MessageDigest.getInstance("SHA-1");  
	          resultString = byte2hexString(md.digest(resultString.getBytes()));  
	       } catch (Exception ex) {  
	       }  
	       return resultString;  
	   }  

	    public static String byte2hexString(byte[] bytes) {  
	        StringBuffer buf = new StringBuffer(bytes.length * 2);  
	        for (int i = 0; i < bytes.length; i++) {  
	            if (((int) bytes[i] & 0xff) < 0x10) {  
	                buf.append("0");  
	            }  
	            buf.append(Long.toString((int) bytes[i] & 0xff, 16));  
	        }  
	        return buf.toString().toUpperCase();  
	    }  

	    /**
	     * <p>传值</p>
	     * @param request 当前post值
	     * return String
	     */
	    public static String getStringPostWeixin(HttpServletRequest request){
	    	StringBuilder buffer = new StringBuilder();  
	        BufferedReader reader=null;  
	        try{  
	            reader = new BufferedReader(new InputStreamReader(request.getInputStream(),"UTF-8"));  
	            String line=null;  
	            while((line = reader.readLine())!=null){  
	                buffer.append(line);  
	            }  
	        }catch(Exception e){  
	            e.printStackTrace();  
	            SysLogs.print("INFO", "request -> InputStream 异常");
	            SysLogs.print("WARN", e);
	        }finally{  
	            if(null!=reader){  
	                try {  
	                    reader.close();  
	                } catch (IOException e) {  
	                    e.printStackTrace();  
	                    SysLogs.print("INFO", "IO 异常");
	    	            SysLogs.print("WARN", e);
	                }  
	            }  
	        }  
	        return buffer.toString();  
	    }
	    
	    
	   
	    
	    
	    /**
	     * <p>传入数据转为document</p>
	     * @param domStr 数据字符串
	     * reuturn document
	     */
	    public static Document automatismRestoreDocument(String domStr){
	    	Document document=null;  
	    	if(null != domStr && !domStr.isEmpty()){
	             try{  
	            	 SysLogs.print("INFO","微信---传入数据str"+domStr);
	                 document = DocumentHelper.parseText(domStr);  
	             }catch(Exception e){  
	                 e.printStackTrace();  
	                 SysLogs.print("WARN", e);
	             }  
	             if(null==document){  
	            	 SysLogs.print("INFO","微信---传入数据有误");
	                 return null;
	             }  
	    	}
	    	return document;
	    }
	    
	    /**
	     * <p>自动回复</p>
	     * @throws Throwable 
	     */
	    
	    public static String automatismRestoreEntity(Document document) throws Throwable{
	    	String resultStr = "";
	    	Element root=document.getRootElement();  
            String fromUsername = root.elementText("FromUserName");  
            String toUsername = root.elementText("ToUserName");  
            String keyword = root.elementTextTrim("Content");  
            String MsgType = root.elementTextTrim("MsgType");
            String Event = root.elementTextTrim("Event");
            String time = new Date().getTime()+"";  
            String textTpl = "<xml>"+  
            "<ToUserName><![CDATA[%1$s]]></ToUserName>"+  
            "<FromUserName><![CDATA[%2$s]]></FromUserName>"+  
            "<CreateTime>%3$s</CreateTime>"+  
            "<MsgType><![CDATA[%4$s]]></MsgType>"+  
            "<Content><![CDATA[%5$s]]></Content>"+  
            "<FuncFlag>0</FuncFlag>"+  
            "</xml>";    
            String msgType = "text";  
            String contentStr  = "";
            switch(returnTypeNumber(MsgType)){
	            case 1 : 
	            	if(null!=keyword&&!keyword.equals(""))  
	    			{  
	    			    contentStr = "";//后续功能正在完善。。。";//XiaoDouMachine.getXiaoDouMsg(keyword);//"你说 "+keyword +"?";  
	    			}
	            	break;
	            case 2 : 
	            	if(null != Event && Event.equals("subscribe")){
	            		contentStr = "欢迎关注我、在这里我是你的朋友，你想说什么都可以，不过不可以生气奥,可以语音跟我聊天，你可以输入［讲个笑话］，";
	            	}
	            	break;
            }
            resultStr = textTpl.format(textTpl, fromUsername, toUsername, time, msgType, contentStr);  
	    	return resultStr;
	    }
	    
	    /**
	     * <p>1、text 2、event</p>
	     * @param type
	     * @return 
	     */
	    
	    public static int returnTypeNumber(String type){
	    	int i = 0;
	    	if(null != type && !type.isEmpty()){
	    		if(type.equals("text")){
		    		i = 1;
	    		}else if(type.equals("event")){
	    			i = 2;
	    		}
	    	}
	    	return i;
	    }
	   public static void main(String[] args) throws Throwable {
		System.out.println(XiaoDouMachine.getXiaoDouMsg("你妹"));
	}
}
