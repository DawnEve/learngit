package com.mio.spring6.iocxml.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;

public class TestJDBC {
	public static void main(String[] args) {
//		demo1();
		demo2();
	}
	
	private static void demo2() {
		ApplicationContext context=new ClassPathXmlApplicationContext("bean-jdbc.xml");
		DruidDataSource dataSource=context.getBean(DruidDataSource.class);
		System.out.println(dataSource.getUrl());
	}

	public static void demo1() {
		DruidDataSource dataSource=new DruidDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring?serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		System.out.println(dataSource.getUrl());
	}

}
