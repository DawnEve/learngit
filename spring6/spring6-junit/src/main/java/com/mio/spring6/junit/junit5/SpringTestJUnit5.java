package com.mio.spring6.junit.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:bean-junit.xml")
public class SpringTestJUnit5 {
	//注入对象
	@Autowired
	private User user;
	
	//测试方法
	@Test
	public void testUser() {
		System.out.println(user);
		user.run();
	}
}
