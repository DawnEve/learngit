package com.mio.spring6.iocxml.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("bean-lifecycle.xml");
		User user=context.getBean("user", User.class);
		System.out.println("6 bean 创建完成，可以使用");
		System.out.println("\tUser name: " + user.getName());
		
		context.close();//销毁 bean 对象，注意：ClassPathXmlApplicationContext 对象才用close方法
	}
}
