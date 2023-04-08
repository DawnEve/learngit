package com.mio.spring6.iocannotation.bean;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

	@Test
	public void test002() {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("bean-ioc-anno.xml");
//		User user=context.getBean("user2", User.class);
		User user=context.getBean("user", User.class);
		System.out.println(user);
	}
	
}
