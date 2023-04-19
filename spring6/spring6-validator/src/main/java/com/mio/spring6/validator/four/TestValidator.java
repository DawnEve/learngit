package com.mio.spring6.validator.four;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestValidator {
	@Test
	public void test01(){
		//新建实体类
		User user=new User();
		user.setName("hi");
		//user.setAge(-20);
		System.out.println("1 >" + user);

		//从spring获取校验方法
		ApplicationContext context=new AnnotationConfigApplicationContext(ValidationConfig.class);
		MyService validator = context.getBean(MyService.class);
		//进行校验		
		System.out.println("2 >" + validator.testMethod(user));
	}
}
