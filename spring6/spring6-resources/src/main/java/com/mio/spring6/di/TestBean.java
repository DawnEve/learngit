package com.mio.spring6.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");
		ResourceBean resourceBean = context.getBean(ResourceBean.class);
		resourceBean.parse();
	}

}
