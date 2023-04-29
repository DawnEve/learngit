package com.mio.spring6.junit.junit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mio.spring6.junit.junit5.User;

//JUnit4 需要2个注解
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean-junit.xml")
public class SpringUnit4Test {
	//注入对象
	@Autowired
	private User user;

	@Test
	public void testUser() {
		System.out.println("2456");
	}
	
	//测试方法
	@Test //这个为什么不运行呢？
	public void testUser4() {
		System.out.println(user);
		user.run();
	}
}
//没有输出，也没有报错。 //todo