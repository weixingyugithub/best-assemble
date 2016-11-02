package com.beijing.wei.mail.service.serviceImp;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.beijing.wei.base.BaseEnum;
import com.beijing.wei.mail.controller.ReciveOneMail;
import com.beijing.wei.mail.service.MailService;

public class MailServiceImp implements MailService {
	private Properties mailInfo;

	private Session session;

	/**
	 * <p>
	 * 初始化session
	 * </p>
	 */
	public void init() {
		session = Session.getDefaultInstance(mailInfo,null);
	}

	/**
	 * <p>
	 * 用于发送邮件配置
	 * </p>
	 * 
	 * @param to
	 *            发送到哪个邮箱
	 * @param subject
	 *            标题
	 * @param text
	 *            邮箱内容
	 * @param enumCode
	 * 			     发送类型
	 */

	public void send(String to, String subject, String text , BaseEnum enumCode)
			throws AddressException, MessagingException,
			UnsupportedEncodingException {
		String nickName = MimeUtility.encodeText(mailInfo
				.getProperty("nickname"));
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(nickName + "<"
				+ mailInfo.getProperty("from") + ">"));
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
		message.setSubject(subject);
		if(enumCode.toInt() == 1){
			message.setText(text);
		}else{
			// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象    
			Multipart mainPart = new MimeMultipart();    
			// 创建一个包含HTML内容的MimeBodyPart    
			BodyPart html = new MimeBodyPart();    
			// 设置HTML内容    
			html.setContent(text, "text/html; charset=utf-8");    
			mainPart.addBodyPart(html);    
			// 将MiniMultipart对象设置为邮件内容    
			message.setContent(mainPart);  
		}
		send(message);
	}

	/**
	 * <p>
	 * 发送message
	 * </p>
	 * 
	 * @param message
	 * @throws MessagingException
	 */

	private void send(MimeMessage message) throws MessagingException {
		Transport transport = session.getTransport("smtp");
		transport.connect(mailInfo.getProperty("name"),
				mailInfo.getProperty("password"));
		transport.sendMessage(message,
				message.getRecipients(Message.RecipientType.TO));
		transport.close();
	}

	/**
	 * <p>
	 * 接收邮箱信息
	 * </p>
	 */
	public String receive() throws Exception {
		
        URLName urln = new URLName("pop3", "pop3.163.com", 110, null,  
                "13391531597@163.com", "a18217388590");  
        Store store = session.getStore(urln);  
        store.connect(); 
		return receiveMessage(store);
	}

	/**
	 * <p>
	 * 读取信箱信息
	 * </p>
	 * 
	 * @param store
	 * @throws Exception
	 */
	public String receiveMessage(Store store) throws Exception {
		StringBuffer ta_receive = new StringBuffer();
		Folder folder = store.getFolder("INBOX");  
        folder.open(Folder.READ_ONLY);  
        Message message[] = folder.getMessages();  
        System.out.println("Messages's length: " + message.length);  
        ReciveOneMail pmm = null;  
        for (int i = 0; i < message.length; i++) {  
            System.out.println("======================");  
            pmm = new ReciveOneMail((MimeMessage) message[i]);  
            System.out.println("Message " + i + " subject: " + pmm.getSubject());  
            System.out.println("Message " + i + " sentdate: "+ pmm.getSentDate());  
            System.out.println("Message " + i + " replysign: "+ pmm.getReplySign());  
            System.out.println("Message " + i + " hasRead: " + pmm.isNew());  
            System.out.println("Message " + i + "  containAttachment: "+ pmm.isContainAttach((Part) message[i]));  
            System.out.println("Message " + i + " form: " + pmm.getFrom());  
            System.out.println("Message " + i + " to: "+ pmm.getMailAddress("to"));  
            System.out.println("Message " + i + " cc: "+ pmm.getMailAddress("cc"));  
            System.out.println("Message " + i + " bcc: "+ pmm.getMailAddress("bcc"));  
            pmm.setDateFormat("yy年MM月dd日 HH:mm");  
            System.out.println("Message " + i + " sentdate: "+ pmm.getSentDate());  
            System.out.println("Message " + i + " Message-ID: "+ pmm.getMessageId());  
            // 获得邮件内容===============  
            pmm.getMailContent((Part) message[i]);  
            System.out.println("Message " + i + " bodycontent: \r\n"  
                    + pmm.getBodyText());  
            pmm.setAttachPath("c:\\");   
            pmm.saveAttachMent((Part) message[i]);   
        }
		folder.close(false);// 关闭邮件夹，但不删除邮件
		store.close();// 关闭Store对象
		return ta_receive.toString();
	}

	public Properties getMailInfo() {
		return mailInfo;
	}

	public void setMailInfo(Properties mailInfo) {
		this.mailInfo = mailInfo;
	}
}
