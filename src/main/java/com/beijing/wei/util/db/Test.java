package com.beijing.wei.util.db;

import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;

/**
 * 
 * 
 * 
 * @author leiwei 2011 - 11 - 29
 * 
 * 
 */

public class Test {

	// 在任何需要记录日志的类中

	Log log = LogFactory.getLog(this.getClass());

	public void one() {

		log.info("into one method");

		try {

			System.out.println(9 / 0);

		} catch (RuntimeException e) {

			log.error(e.getMessage());

		}

		log.info("out one method");

	}

	public static void main(String[] args) {

		new Test().one();

	}

}
