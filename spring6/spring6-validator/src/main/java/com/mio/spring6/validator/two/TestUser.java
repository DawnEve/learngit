package com.mio.spring6.validator.two;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser {
	
	@Test
	public void testValidation1() {
		ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);
		MyValidation1 validation1 = context.getBean(MyValidation1.class);
		
		User user = new User();
		//不同的设置，查看报错
		user.setName("Tom");
		user.setAge(10);
		
		boolean message = validation1.validatorByUser1(user);
		System.out.println(message); //true or false
	}

	@Test
	public void testValidation2() {
		System.out.println("[in spring 6]");
		ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);
		MyValidation2 validation2 = context.getBean(MyValidation2.class);
		
		User user = new User();
		//不同的设置，查看报错
		user.setName("Tom"); //没名字直接抛异常：Object name must not be null
		user.setAge(230);
		
		boolean message = validation2.validatorByUser2(user);
		System.out.println(message); //true or false
	}
}
