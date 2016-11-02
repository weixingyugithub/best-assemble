package com.beijing.wei.mail.controller;

import com.beijing.wei.base.BaseEnum;
/**
 * <p>
 * 	邮箱枚举类
 * </p>
 * @author com.beijing.wei@live.com
 *
 */
public enum MailEnum implements BaseEnum {
	TEXT(1), HTML(2);

	MailEnum(Object code) {
		this.code = code;
	}

	private Object code;

	@Override
	public String toString() {
		return code.toString();
	}

	public int toInt() {
		return Integer.parseInt(code.toString());
	}
	public static void main(String[] args) {
		System.out.println(MailEnum.TEXT.toInt());
	}
}
