package com.mio.spring6.iocxml.auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mio.spring6.iocxml.auto.controller.UserController;

public class TestController {
	public static void main(String[] args) {
//		demo1();
//		demo2();
		demo3();
	}

	private static void demo3() {
		//使用xml自动装配: byName
		ApplicationContext context=
				new ClassPathXmlApplicationContext("bean-auto2.xml");
		UserController userController=context.getBean(UserController.class);
		userController.addUser();		
	}

	private static void demo2() {
		//使用xml自动装配: byType
		ApplicationContext context=
				new ClassPathXmlApplicationContext("bean-auto.xml");
		UserController userController=context.getBean(UserController.class);
		userController.addUser();
	}

	private static void demo1() {
		//传统写法
		UserController controller=new UserController();
		controller.addUser();		
	}
}
