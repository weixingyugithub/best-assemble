package com.beijing.wei.util.file;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.beijing.wei.util.common.CommonAddress;
import com.beijing.wei.util.common.CommonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetAddressByIp {

	/**
	 * 
	 * @param IP
	 * @return
	 */
	public static String GetAddressByIp(String IP) {
		String resout = "";
		if (IP.equals("127.0.0.1")) {
			resout = "本地IP";
		} else {
			try {
				String str = getJsonContent(CommonAddress.GET_ADDRESS_FROM_IP
						+ IP);
				if (null != str && !"".equals(str)) {
					System.out.println(CommonUtils.fromEncodedUnicode(
							str.toCharArray(), 0, str.length()));
					String GENERIC_BINDING = null == str ? "" : str;
					ObjectMapper mapper = new ObjectMapper();
					HashMap<String, Object> modelMap = mapper.readValue(
							GENERIC_BINDING,
							new TypeReference<HashMap<String, Object>>() {
							});// readValue到一个范型数据中.
					String code = modelMap.get("code").toString();
					if (code.equals("0")) {
						Map obj2 = (HashMap) modelMap.get("data");
						resout = obj2.get("country") + "-" + obj2.get("area")
								+ "-" + obj2.get("city") + "-"
								+ obj2.get("isp");
						SysLogs.printInfo("当前用户为：" + resout);
					} else {
						resout = "IP地址有误";
						SysLogs.printInfo("当前用户---------" + resout);
					}
				} else {
					resout = "获取地址异常";
				}
			} catch (Exception e) {
				SysLogs.printError("获取地址有误:", e);
				resout = "获取IP地址异常：" + e.getMessage();
			}
		}
		return resout;

	}

	public static String getJsonContent(String urlStr) {
		try {// 获取HttpURLConnection连接对象
			URL url = new URL(urlStr);
			HttpURLConnection httpConn = (HttpURLConnection) url
					.openConnection();
			// 设置连接属性
			httpConn.setConnectTimeout(3000);
			httpConn.setDoInput(true);
			httpConn.setRequestMethod("GET");
			// 获取相应码
			int respCode = httpConn.getResponseCode();
			if (respCode == 200) {
				return ConvertStream2Json(httpConn.getInputStream());
			}
		} catch (MalformedURLException e) {
			SysLogs.printError("URL异常 "+e.getMessage(), e);
		} catch (IOException e) {
			SysLogs.printError("URL异常 "+e.getMessage(), e);
		}
		return "";
	}

	private static String ConvertStream2Json(InputStream inputStream) {
		String jsonStr = "";
		// ByteArrayOutputStream相当于内存输出流
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		// 将输入流转移到内存输出流中
		try {
			while ((len = inputStream.read(buffer, 0, buffer.length)) != -1) {
				out.write(buffer, 0, len);
			}
			// 将内存流转换为字符串
			jsonStr = new String(out.toByteArray());
		} catch (IOException e) {
			SysLogs.printError("IO异常 "+e.getMessage(), e);
		}
		return jsonStr;
	}

	public static void main(String[] args) throws JsonProcessingException,
			JsonProcessingException, Exception {
		System.out.println(GetAddressByIp("106.37.7.34"));
	}
}