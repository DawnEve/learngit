package com.mio.spring6.junit.junit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//@SpringJUnitConfig(locations = "classpath:bean-junit.xml")

//另一种写法：不常用
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:bean-junit.xml")
public class SpringTestJUnit5v2 {
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
