package com.beijing.wei.util.string;

import java.io.UnsupportedEncodingException;

/**
 * <p>
 * 	对字符串的操作
 * </p>
 * @author com.beijing.wei@live.com
 *
 */

public class StringUtils extends org.apache.commons.lang3.StringUtils {
	
	/**
	 * <p>
	 * 	判断字符串是否为空
	 * </p>
	 * @param str
	 * @return boolean
	 */
	
	public static boolean isEmpty(String str){
		if(null != str && str.length() > 0){
			return false;
		}else{
			return true;
		}
	}
	
	/**
     * 转换为字节数组
     * @param str
     * @return
     */
    public static String toString(byte[] bytes){
    	try {
			return new String(bytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
    }
    
    /**
     * 转换为字节数组
     * @param str
     * @return
     */
    public static byte[] getBytes(String str){
    	if (str != null){
    		try {
				return str.getBytes("UTF-8");
			} catch (UnsupportedEncodingException e) {
				return null;
			}
    	}else{
    		return null;
    	}
    }
	
	public static void main(String[] args) {
		System.out.println(new int[]{1,2,3});
	}
}
