package com.mio.spring6.validator.three;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(ValidationConfig.class);
		
		MyService service = context.getBean(MyService.class);
		
		User user=new User();
		//arg0.name: 不能为null
		user.setName("Tom");
		//手机号不能为空
		//user.setPhone("123"); //手机号码错误
		user.setPhone("13512345678");
		user.setAge(10-2);
		
		System.out.println( service.testMethod(user) );
	}
}
