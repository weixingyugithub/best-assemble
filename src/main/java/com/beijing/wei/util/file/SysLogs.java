package com.beijing.wei.util.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SysLogs {
	protected static Logger logger = LoggerFactory.getLogger(SysLogs.class);

	/**
	 * @param level
	 *            log level
	 * @param message
	 */
	public static void print(String level, String message) {
		if ("SQL".equals(level)) {
			logger.info(message);
		} else if ("INFO".equals(level)) {
			logger.info(message);
		} else if ("ERROR".equals(level)) {
			logger.error(message);
		} else if ("DEBUG".equals(level)) {
			logger.debug(message);
		}
	}
	public static void print(String level, Object message) {
		if ("WARN".equals(level)) {
			logger.warn("DAMN IT", message);
		}
	}
	
	
/*************************************************************************************************/	

	public static void printSql(String message) {
		logger.info(message);
	}

	public static void printInfo(String message) {
		logger.info(message);
	}

	public static void printError(String message) {
		logger.error(message);
	}

	public static void printWarn(String message) {
		logger.warn(message);
	}

	public static void printDebug(String message) {
		logger.debug(message);
	}

	public static void printSql(String level, Object message) {
		logger.info(level, message);
	}

	public static void printInfo(String level, Object message) {
		logger.info(level, message);
	}

	public static void printError(String level, Object message) {
		logger.error(level, message);
	}

	public static void printWarn(String level, Object message) {
		logger.warn(level, message);
	}

	public static void printDebug(String level, Object message) {
		logger.debug(level, message);
	}
	
}
