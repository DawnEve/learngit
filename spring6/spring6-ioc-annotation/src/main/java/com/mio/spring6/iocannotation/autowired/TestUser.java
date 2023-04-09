package com.mio.spring6.iocannotation.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mio.spring6.iocannotation.autowired.config.SpringConfig;
import com.mio.spring6.iocannotation.autowired.controller.UserController;

public class TestUser {
	@Test
	public void test1() {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("bean-ioc-anno-autowired.xml");
		UserController userController = context.getBean(UserController.class);
		userController.add();
	}
	
	@Test
	public void test2() {
		ApplicationContext context=
				new AnnotationConfigApplicationContext(SpringConfig.class);
		UserController userController = context.getBean(UserController.class);
		userController.add();
	}
}
