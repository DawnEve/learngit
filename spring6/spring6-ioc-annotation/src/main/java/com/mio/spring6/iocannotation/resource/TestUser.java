package com.mio.spring6.iocannotation.resource;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mio.spring6.iocannotation.resource.controller.UserController;

public class TestUser {
	@Test
	public void test2() {
		ApplicationContext context=new 
				ClassPathXmlApplicationContext("bean-ioc-anno-resource.xml");
		UserController userController = context.getBean(UserController.class);
		userController.add();
	}
}
