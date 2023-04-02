package com.mio.spring6.iocxml.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserDao {
	public static void main(String[] args) {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("bean.xml");
		//根据 接口类型 获取 接口实现类对应的bean
		//UserDao userDao=context.getBean(UserDao.class);
		
		//一个接口有多个实现类，不能根据 接口类型获取唯一，就会报错。需要使用id
		UserDao userDao=context.getBean("userDaoImpl", UserDao.class);
		System.out.println(userDao);
		userDao.run();
	}
}
