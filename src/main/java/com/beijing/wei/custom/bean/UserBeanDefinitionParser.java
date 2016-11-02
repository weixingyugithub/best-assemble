package com.beijing.wei.custom.bean;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

public class UserBeanDefinitionParser extends
		AbstractSingleBeanDefinitionParser {

	@Override
	protected Class getBeanClass(Element element) {
		return User.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		String userId = element.getAttribute("userId");
		String userName = element.getAttribute("userName");
		if (!StringUtils.isEmpty(userId)) {
			builder.addPropertyValue("userId", userId);
		}
		if (!StringUtils.isEmpty(userName)) {
			builder.addPropertyValue("userName", userName);
		}
	}
}
