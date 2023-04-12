package com.mio.spring6;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
	//创建 logger 对象
	private Logger logger=LoggerFactory.getLogger(UserTest.class);
	
	//这里常常无法获取xml文件: IO异常 
	//todo? 复制到 User.java 中，执行一次后，再恢复，回来执行test来就可以了!!
	@Test
	public void testUserObject() {
		//1.加载spring配置文件，对象创建
		ApplicationContext context=
				new ClassPathXmlApplicationContext("bean.xml");
		System.out.println(context);
		//2.获取创建对象
		User user=(User) context.getBean("user");
		
		//手动写日志
		logger.info("## 03 执行了 testUserObject()");
		
		//3.使用对象调用方法
		user.add();
	}
	
	
	
	//反射创建对象
	@Test
	public void testUserObject2() throws Exception {
		//1.加载xml文件，获取信息：id, class 略
		//2.获取类对象
		Class clazz=Class.forName("com.mio.spring6.User");
		//3.创建对象
		//User user=clazz.newInstance(); //jdk17已过时
		User user=(User) clazz.getDeclaredConstructor().newInstance();
		//4.执行方法
		user.add();
		System.out.println("from: testUserObject2");
	}
}
