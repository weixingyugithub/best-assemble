package com.beijing.wei.custom.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tests {
	public static void main(String[] args) {
//		ApplicationContext application = new ClassPathXmlApplicationContext("/custom/bean/test.xml");
//		User user = (User) application.getBean("tBean");
//		System.out.println(user.getUserName());
		Example ex=new Example();
        ex.change(ex.str,ex.ch);
        System.out.print(ex.str+" and ");
        System.out.print(ex.ch);
	}
}
class Example{
    String str=new String("hello");
    char[]ch={'a','b'};
    public void change(String str,char ch[]){
        str="test ok";
        ch[0]='c';
    }
}
