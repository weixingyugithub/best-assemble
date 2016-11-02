package com.beijing.wei.mail.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.beijing.wei.base.BaseEnum;

public interface MailService {

	public void send(String to, String subject, String text,  BaseEnum enumCode)
			throws AddressException, MessagingException,
			UnsupportedEncodingException;
	
	public String receive() throws Exception;
}
