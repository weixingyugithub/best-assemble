package com.beijing.wei.util.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

	public static Properties p = null;
	static {
		if (null == p) {
			InputStream is = ReadProperties.class
					.getResourceAsStream("/wxy.properties");
			p = new Properties();
			try {
				p.load(is);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static String getWxyValue(String key) {
		return p.getProperty(key);
	}

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		System.out.println(getWxyValue("wxy.code"));
	}

}
