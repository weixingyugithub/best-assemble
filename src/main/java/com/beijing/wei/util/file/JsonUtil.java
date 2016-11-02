package com.beijing.wei.util.file;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.beijing.wei.login.model.ProjectUser;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	/**
	 * 将对象转换为json字符串
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static String obj2string(Object obj) {
		StringWriter sw = new StringWriter();
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(sw, obj);
		} catch (Exception e) {
		}
		return sw.toString();
	}

	/**
	 * 将字符串转list对象
	 * 
	 * @param <T>
	 * @param jsonStr
	 * @param cls
	 * @return
	 */
	public static <T> List<T> str2list(String jsonStr, Class<T> cls) {
		ObjectMapper mapper = new ObjectMapper();
		List<T> objList = null;
		try {
			JavaType t = mapper.getTypeFactory().constructParametricType(
					List.class, cls);
			objList = mapper.readValue(jsonStr, t);
		} catch (Exception e) {
		}
		return objList;
	}

	/**
	 * 将字符串转为对象
	 * 
	 * @param <T>
	 * @param jsonStr
	 * @param cls
	 * @return
	 */
	public static <T> T str2obj(String jsonStr, Class<T> cls) {
		ObjectMapper mapper = new ObjectMapper();
		T obj = null;
		try {
			obj = mapper.readValue(jsonStr, cls);
		} catch (Exception e) {
		}
		return obj;
	}
	
	/**
	 * 将字符串转为Page对象
	 * 
	 * @param <T>
	 * @param jsonStr
	 * @param cls
	 * @return
	 */
	/*public static <T> Page<T> str2page(String jsonStr, Class<T> cls) {
		ObjectMapper mapper = new ObjectMapper();
		Page<T> objList = null;
		try {
			JavaType t = mapper.getTypeFactory().constructParametricType(
					Page.class, cls);
			objList = mapper.readValue(jsonStr, t);
		} catch (Exception e) {
		}
		return objList;
	}*/
	
	/**
	 * 将字符串转为json节点
	 * @param jsonStr
	 * @return
	 */
	public static JsonNode str2node(String jsonStr) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readTree(jsonStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		ProjectUser us = new ProjectUser("1","2","3","4","5");
		List list = new ArrayList();
		list.add(us);
		list = JsonUtil.str2list("[{\"userId\":\"1\",\"userName\":\"2\",\"userPass\":\"3\",\"userAllId\":\"4\",\"validate\":\"5\"}]", ProjectUser.class);
		Test test = new Test("sdf",new Date());
		System.out.println(obj2string(test));
	}
}