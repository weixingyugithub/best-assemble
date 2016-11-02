package com.beijing.wei.custom.bean;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class UserNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("tx", new UserBeanDefinitionParser());
	}

}
