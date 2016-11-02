package com.beijing.wei.util.httpclient;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * <p>HttpClient工具类<p>
 * @author com.beijing.wei@live.com
 *
 */

public class HttpClientUtil {
	
	/**
	 * <p>获取client对像</p>
	 * @param request http请求和https请求两个
	 * @return CloseableHttpClient对像
	 */
	
	public static CloseableHttpClient createSSLClientDefault(String request){
		CloseableHttpClient close = null;
		if(request.equals("http") || request.equals("https")){
			if(request.equals("https")){
				try {

					SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(
							null, new TrustStrategy() {
								// 信任所有
								public boolean isTrusted(X509Certificate[] chain,
										String authType) {
									return true;
								}
							}).build();

					SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
							sslContext);
					return HttpClients.custom().setSSLSocketFactory(sslsf).build();
				} catch (KeyManagementException e) {
					e.printStackTrace();
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				} catch (KeyStoreException e) {
					e.printStackTrace();
				}
				close = HttpClients.createDefault();
			}else{
				// 创建HttpClientBuilder
				HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
				// HttpClient
				close = httpClientBuilder.build();
			}
			return close;
		}else{
			return null;
		}
	}
	
	/**
	 * <p>client Get请求</p>
	 * @param request 传入http https 请求方式
	 * @param url 路径
	 * @param pageEncoding  编码
	 * @return
	 */
	
	public static String getRequest(String request, String url, String pageEncoding) {
		String str = "";
		long length = 0;
		//获取HttpClient
		CloseableHttpClient closeableHttpClient = HttpClientUtil.createSSLClientDefault(request);
		
		HttpGet httpGet = new HttpGet(url);
		
		System.out.println(httpGet.getRequestLine());
		try {
			// 执行get请求
			HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
			// 获取响应消息实体
			HttpEntity entity = httpResponse.getEntity();

			// 响应状态
			System.out.println("status:" + httpResponse.getStatusLine());
			// 判断响应实体是否为空
			if (entity != null) {
				length = entity.getContentLength();
				System.out.println("contentEncoding:"
						+ entity.getContentEncoding());
				str = EntityUtils.toString(entity, pageEncoding);
				EntityUtils.consume(entity); //Consume response content 
				System.out.println("请求地址: " + httpGet.getURI()); 
	            System.out.println("响应状态: " + httpResponse.getStatusLine()); 
	            System.out.println("响应长度: " + length); 
	            System.out.println("响应内容: " + str); 
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭流并释放资源
				closeableHttpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return str;
	}
	
	/**
	 * <p>client Post请求</p>
	 * @param request 传入http https 请求方式
	 * @param url 路径
	 * @param pageEncoding  编码
 	 * @param list  post 参数//post方法使用
			List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
			list.add(new BasicNameValuePair("ActionBean.UserId", "weixinyu"));
			list.add(new BasicNameValuePair("ActionBean.Password", "123456"));
	 * @return 
	 */
	public static String postRequest(String request,String url, String pageEncoding,
			List<BasicNameValuePair> list) {
		String str = "";
		long length = 0;
		//获取HttpClient
		CloseableHttpClient closeableHttpClient = HttpClientUtil.createSSLClientDefault(request);

		HttpPost httpPost = new HttpPost(url);
		// httpPost.setConfig(DEFAULT);
		// 创建参数队列
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		// formparams.add(new BasicNameValuePair("ActionBean.UserId",
		// "weixinyu"));
		// formparams.add(new BasicNameValuePair("ActionBean.Password",
		// "123456"));
		if (null != list && list.size() > 0) {
			for (BasicNameValuePair basic : list) {
				formparams.add(basic);
			}
		}

		UrlEncodedFormEntity entity;
		try {
			entity = new UrlEncodedFormEntity(formparams, pageEncoding);
			httpPost.setEntity(entity);

			HttpResponse httpResponse;
			// post请求
			httpResponse = closeableHttpClient.execute(httpPost);

			// getEntity()
			HttpEntity httpEntity = httpResponse.getEntity();
			if (httpEntity != null) {
				// 打印响应内容
				length = httpEntity.getContentLength();
				str = EntityUtils.toString(httpEntity, pageEncoding);
				System.out.println("请求地址: " + httpPost.getURI()); 
	            System.out.println("响应状态: " + httpResponse.getStatusLine()); 
	            System.out.println("响应长度: " + length); 
	            System.out.println("响应内容: " + str); 
			}
			// 释放资源
			closeableHttpClient.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	
	
	public static void main(String[] args) throws Throwable {
		//get方法使用
		HttpClientUtil.getRequest("http", "http://www.weixingyu.cn/img/execute", "UTF-8");

		//post方法使用
		List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
		list.add(new BasicNameValuePair("TransName", "IQSR"));
		list.add(new BasicNameValuePair("Plain", "transId=IQSR~|~originalorderId=2012~|~originalTransAmt= ~|~merURL= "));
		list.add(new BasicNameValuePair("Signature", "9b759887e6ca9d4c24509d22ee4d22494d0dd2dfbdbeaab3545c1acee62eec7"));
		//HttpClientUtil.postRequest("https", "https://kyfw.12306.cn/otn/login/loginAysnSuggest", "UTF-8", list);
		
		//HttpClientUtil.postRequest("https", "https://kyfw.12306.cn/otn/passcodeNew/getPassCodeNew.do?module=login&rand=sjrand&0.28793143135854015","UTF-8",list);
	}
}
