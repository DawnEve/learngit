package com.mio;

import org.junit.jupiter.api.Test;

import com.mio.bean.AnnotationApplicationContext;
import com.mio.bean.ApplicationContext;
import com.mio.service.UserService;

public class TestUser {
	@Test
	public void test01() throws Exception {
		ApplicationContext context=
				new AnnotationApplicationContext("com.mio");
		UserService userService = (UserService) context.getBean(UserService.class);
		userService.add();
		System.out.println(userService);
	}
}
