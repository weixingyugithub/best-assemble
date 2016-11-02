package com.beijing.wei.util.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * session监听 当前在线人数统计
 * 
 * @author com.beijing.wei@live.com
 * 
 */
public class SessionControlListener implements HttpSessionListener {

	public static Map<String, Object> sessionMap = new HashMap<String, Object>();

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		HttpSession session = arg0.getSession();
		System.out.println("创建session..."+session.getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("session失效...");
		HttpSession session = arg0.getSession();
		removeSession(session.getId());
	}

	// 登录成功时，添加到map中
	public static void putSession(String id, Object session) {
		synchronized (sessionMap) {
			sessionMap.put(id, session);
		}
	}

	// 获取某个session
	public static Object getSession(String id) {
		return sessionMap.get(id);
	}

	// session失效时 删除session
	public static Object removeSession(String id) {
		synchronized (sessionMap) {
			return sessionMap.remove(id);
		}
	}

	// 获取当前在线人数
	public static Integer getNowOnlineCount() {
		return sessionMap.size();
	}

}
