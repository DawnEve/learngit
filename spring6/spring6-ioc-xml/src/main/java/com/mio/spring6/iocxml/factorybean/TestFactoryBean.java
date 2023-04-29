package com.mio.spring6.iocxml.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactoryBean {
	public static void main(String[] args) {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("bean-factorybean.xml");
//		User user=context.getBean("user", MyFactoryBean.class);
		User user=(User) context.getBean("user");
		System.out.println(user);
	}
}
