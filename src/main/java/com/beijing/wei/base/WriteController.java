package com.beijing.wei.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.beijing.wei.util.file.JsonUtil;
import com.beijing.wei.util.file.SysLogs;

public abstract class WriteController extends UploadController{

	/**
	 * 输出json数据
	 * 
	 * @param response
	 *            HttpServletResponse对象
	 * @param code
	 *            模块编号<br/>
	 * @param flag
	 *            成功状态,true:成功、false:失败
	 * @param msg
	 *            提示信息
	 */
	protected void outResultMessage(HttpServletResponse response, BaseEnum code,
			boolean flag, String msg) {
		try {
			ResultJson result = new ResultJson();
			if (code != null) {
				result.setCode(code.toString());
			}
			result.setResult(flag);
			result.setResultMsg(msg);
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print(JsonUtil.obj2string(result));
			SysLogs.printDebug(JsonUtil.obj2string(result));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			SysLogs.printError("异常" + e.getClass(), e);
		}
	}

	/**
	 * 输出json数据
	 * 
	 * @param response
	 *            HttpServletResponse对象
	 * @param code
	 *            模块编号<br/>
	 * @param flag
	 *            成功状态,true:成功、false:失败
	 */
	protected void outResultMessage(HttpServletResponse response, BaseEnum code,
			boolean flag) {
		try {
			ResultJson result = new ResultJson();
			if (code != null) {
				result.setCode(code.toString());
			}
			result.setResult(flag);
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print(JsonUtil.obj2string(result));
			SysLogs.printDebug(JsonUtil.obj2string(result));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			SysLogs.printError("异常" + e.getClass(), e);
		}
	}

	/**
	 * 输出json数据
	 * 
	 * @param response
	 *            HttpServletResponse对象
	 * @param code
	 *            模块编号<br/>
	 * @param flag
	 *            成功状态,true:成功、false:失败
	 * @param msg
	 *            提示信息
	 * @param data
	 *            数据
	 */
	protected void outResultMessage(HttpServletResponse response, BaseEnum code,
			boolean flag, String msg, String data) {
		try {
			ResultJson result = new ResultJson();
			if (code != null) {
				result.setCode(code.toString());
			}
			result.setResult(flag);
			result.setResultMsg(msg);
			result.setResultData(data);
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print(JsonUtil.obj2string(result));
			SysLogs.printDebug(JsonUtil.obj2string(result));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			SysLogs.printError("异常" + e.getClass(), e);
		}
	}

	/**
	 * 输出json数据字符串
	 * 
	 * @param response
	 *            HttpServletResponse对象
	 * @param jsonDataStr
	 *            字符串
	 */
	protected void outJson(HttpServletResponse response, Object jsonDataStr) {
		try {
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(jsonDataStr);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			SysLogs.printError("异常" + e.getClass(), e);
		}
	}
	
	/**
	 * 输出json数据字符串
	 * 
	 * @param response
	 *            HttpServletResponse对象
	 * @param jsonDataStr
	 *            字符串
	 */
	protected void outXml(HttpServletResponse response, Object jsonDataStr) {
		try {
			response.setContentType("application/xml;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(jsonDataStr);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			SysLogs.printError("异常" + e.getClass(), e);
		}
	}

	/**
	 * 输出String数据字符串
	 * 
	 * @param response
	 *            HttpServletResponse对象
	 * @param dataStr
	 *            字符串
	 */
	protected void outString(HttpServletResponse response, Object dataStr) {
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(dataStr);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			SysLogs.printError("异常" + e.getClass(), e);
		}
	}
}
