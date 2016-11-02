package com.beijing.wei.util.autoReack;

import java.net.URLEncoder;

import org.apache.http.HttpEntity;
 import org.apache.http.HttpResponse;
 import org.apache.http.HttpStatus;
 import org.apache.http.client.HttpClient;
 import org.apache.http.client.methods.HttpPost;
 import org.apache.http.entity.StringEntity;
 import org.apache.http.impl.client.DefaultHttpClient;
 import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
 
/**
  * 小九机器人
  * 
 * @author 李正
  * 
 */
 public class XiaojiuMachine {
     public static void main(String[] args) throws Throwable {
         try {
             System.out.println(getXiaojiuMsg("哈哈"));
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
 
    public static String getXiaojiuMsg(String msg) throws Throwable {
         // 读取结果网页
         StringBuffer sbRes = new StringBuffer();
         HttpClient httpClient = new DefaultHttpClient();// 创建httpClient对象
         try {
             // 请求超时
             httpClient.getParams().setParameter(
                     CoreConnectionPNames.CONNECTION_TIMEOUT, 20000);
             // 读取超时
             httpClient.getParams().setParameter(
                     CoreConnectionPNames.SO_TIMEOUT, 20000);
 
            HttpPost httppost = new HttpPost(
                     "http://www.xiaojo.com/bot/chata.php");
             String parmaStr = "chat=" + URLEncoder.encode(msg, "UTF-8");
             // System.out.println(parmaStr);
             StringEntity reqEntity = new StringEntity(parmaStr);
             reqEntity.setContentType("application/x-www-form-urlencoded");
             httppost.setHeader("User-Agent",
                     "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
             httppost.setHeader("Referer", "http://www.xiaojo.com/");
             httppost.setEntity(reqEntity);
 
            HttpResponse responce = httpClient.execute(httppost);// 得到responce对象
             int resStatu = responce.getStatusLine().getStatusCode();// 返回码
             if (resStatu == HttpStatus.SC_OK) {// 200正常 其他就不对
                 // 获得相应实体
                 HttpEntity entity = responce.getEntity();
                 String html = new String(EntityUtils.toString(entity).getBytes(
                         "ISO-8859-1"), "UTF-8");// 获得html源代码
                 sbRes.append(html.trim());
             }
         } catch (Exception e) {
             System.out.println("小九机器人接口调用出错！" + e.getMessage());
 
            // 调用小黄鸡接口
             return SimsimiTools.getSimsimiResponseMsg(msg);//.getSimsimiContentByNiuren(msg);
         } finally {
             httpClient.getConnectionManager().shutdown();
         }
 
        // 直接返回为空
         if (sbRes.toString().equals("")
                 || sbRes.toString().indexOf("description") != -1) {
             return "伦家不懂官人的话了啦~是否调到问题发布页面   http://localhost:8087/iask/";
         }
         String finalRes = removeNews(sbRes.toString());
         System.out.println("小九机器人回复:" + finalRes);
         return finalRes;
     }
 
    /**
      * 屏蔽当前接口中的广告
      * 
     * @return
      */
     public static String removeNews(String sendMsgs) {
         sendMsgs = sendMsgs.replaceAll("傻逼", "sb");
         sendMsgs = sendMsgs.replaceAll("小九", "毛小驴");
         sendMsgs = sendMsgs.replaceAll("小豆", "毛小驴");
         return sendMsgs;
     }
 
}