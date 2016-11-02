package com.beijing.wei.util.common;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class CommonUtil1 {

	private static String[] hexs = { "0", "1", "2", "3", "4", "5", "6", "7",
			"8", "9", "a", "b", "c", "d", "e", "f" };

	/**
	 * 生成随机UUID
	 * 
	 * @return
	 */
	public static String getRandomId() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}

	public static Date getCurrentDate() {
		return new Date();
	}

	/**
	 * 获取用户登录ip
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	// 将十进制数转换为十六进制数
	public static String BinaryString(int num, int r) {
		StringBuffer buff = new StringBuffer();
		while (num > 0) {
			buff.append(hexs[num % r]);
			num /= r;
		}
		buff.reverse();
		return buff.toString();
	}

	public static HttpServletRequest getRequest() {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		return request;
	}
}
