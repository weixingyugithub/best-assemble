package com.beijing.wei.util.filter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import sun.security.krb5.Config;

import com.beijing.wei.login.model.ProjectUser;
import com.beijing.wei.util.common.CommonSession;
import com.beijing.wei.util.common.encryption.MD5Util;
import com.beijing.wei.util.db.ReadProperties;
import com.beijing.wei.util.file.GetAddressByIp;

/**
 * <p>
 * 登录拦截器
 * </p>
 * 
 * @author com.beijing.wei@live.com
 * @data 2015-04-30
 * 
 */
public class PathFilter implements Filter {
	//是否开启开发者模式
	private boolean developMode = false;
	// 可直接访问资源
	private static String[] globalArry = null;

	public void init(FilterConfig filterConfig) throws ServletException {
		String developModeStr = filterConfig.getInitParameter("develop_mode");
		if (!StringUtils.isEmpty(developModeStr)) {
			developMode = Boolean.valueOf(developModeStr);
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String path = req.getContextPath();

		// web路径
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		request.setAttribute("basePath", basePath);
		// 开发者模式放过
		if (developMode) {
			String uri = req.getRequestURI();
			String ch  = URLDecoder.decode(uri);
			if(uri.equals(ch)){
				chain.doFilter(request, response);
				return;
			} 
			ch = ch.substring(req.getContextPath().length());
			request.getRequestDispatcher(ch).forward(request, response);
		} else {
			// 判断是否为静态资源
			if (isStaticLinks(req.getRequestURI(), req)) {
				// 磁盘路径
				@SuppressWarnings("unchecked")
				Map<String, String> contextConfigure = Map.class.cast(req
						.getSession().getServletContext()
						.getAttribute("contextConfigure"));
				String realPath = contextConfigure.get("realPath");
				String uri = req.getRequestURI();
				if (path.equals(uri) || (path + "/").equals(uri)) {
					chain.doFilter(request, response);
				} else {
					if (uri.startsWith(path)) {
						uri = uri.substring(path.length() + 7);
					}
					// 获取磁盘路径
					uri = realPath + "webResource" + uri;
					File file = new File(uri);
					if (!file.exists()) {
						chain.doFilter(request, response);
					} else {
						cache((HttpServletRequest) request,
								(HttpServletResponse) response, uri);
					}
				}
				// 判断是否为可通过后缀资源
			} else if (isUrlSuffixLinks(req.getRequestURI(), req)) {
				chain.doFilter(request, response);
			} else {
				System.out.println(getIpAddr(req) + "*************************"
						+ GetAddressByIp.GetAddressByIp(getIpAddr(req)));
				ProjectUser projectUser = (ProjectUser) req.getSession()
						.getAttribute(CommonSession.PROJECT_USER_SESSION);
				if (projectUser == null
						&& !isURILogin(req.getRequestURI(), req)) {
					String toUrl = req.getRequestURL().toString();
					if (!StringUtils.isEmpty(req.getQueryString())) {
						toUrl += "?" + req.getQueryString();
					}
					// 将用户的请求URL保存在session中，用于登录成功之后，跳到目标URL
					req.getSession().setAttribute(
							CommonSession.LOGIN_URL_SUCCESS_SESSION, toUrl);
					// 转发到登录页面
					request.getRequestDispatcher("/login").forward(request,
							response);
					return;
				}
				chain.doFilter(request, response);
			}
		}
	}

	public void destroy() {
	}

	public String getIpAddr(HttpServletRequest request) {
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

	// 当前URI资源是否需要登录才能访问
	private boolean isURILogin(String requestURI, HttpServletRequest request) {
		String[] globalArry = null;
		String globalUrls = ReadProperties.getWxyValue("wxy.globalUrls");
		if (null != globalUrls && !"".equals(globalUrls)) {
			String servletPath = request.getServletPath();
			// 先判断是否包含在放开资源串里
			if (globalUrls.indexOf(servletPath) >= 0) {
				globalArry = globalUrls.split(",");
				String contextPath = request.getContextPath();
				// 再次判断是否是以放开的资源路径开始
				for (String uri : globalArry) {
					if (requestURI != null && null != uri
							&& requestURI.startsWith(contextPath + uri)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	// 是否为可放过静态资源
	private boolean isStaticLinks(String requestURI, HttpServletRequest request) {
		if (request.getContextPath().equalsIgnoreCase(requestURI)
				|| (request.getContextPath() + "/")
						.equalsIgnoreCase(requestURI)) {
			return true;
		}
		if (requestURI != null
				&& requestURI.startsWith(request.getContextPath() + "/static/")) {
			return true;
		}
		return false;
	}

	// 可放过后缀资源
	private boolean isUrlSuffixLinks(String requestURI,
			HttpServletRequest request) {
		if (requestURI.indexOf(".") == -1) {
			return false;
		}
		String globalSuffixs = ReadProperties.getWxyValue("wxy.globalSuffixs");
		if (null != globalSuffixs
				&& globalSuffixs.indexOf(requestURI.substring(requestURI
						.lastIndexOf("."))) >= 0) {
			return true;
		}
		return false;
	}

	/**
	 * <p>
	 * 应对高并发缓存static 文件数据
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param url
	 * @throws IOException
	 * @author com.beijing.wei@live.com
	 */
	public void cache(HttpServletRequest request, HttpServletResponse response,
			String url) throws IOException {
		// 当前系统时间
		long now = System.currentTimeMillis();
		// 文档可以在浏览器端/proxy上缓存多久
		long maxAge = 10;

		// 弱实体
		String etag = "W/\"" + MD5Util.getMD5ofStr(url) + "\"";
		String ifNoneMatch = request.getHeader("If-None-Match");
		if (StringUtils.equals(ifNoneMatch, etag)) {
			response.sendError(304);
			response.setHeader("Last-Modified",
					request.getHeader("If-Modified-Since"));
			return;
		}
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(
				new File(url)));
		ByteArrayOutputStream memoryOutStream = new ByteArrayOutputStream();
		BufferedOutputStream out = new BufferedOutputStream(memoryOutStream);
		byte[] bytes = new byte[1024];
		int len;
		try {
			while ((len = in.read(bytes)) != -1) {
				out.write(bytes, 0, len);
			}
		} catch (IOException e1) {
			throw e1;
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				in = null;
				out = null;
			}
		}

		byte[] memoryData = memoryOutStream.toByteArray();
		response.setHeader("Cache-control", "max-age=" + maxAge);
		response.setHeader("ETag", etag);
		response.setDateHeader("Last-Modified", new Date(now).getTime());
		OutputStream output = response.getOutputStream();
		output.write(memoryData);
		output.flush();
		output.close();
	}
}
