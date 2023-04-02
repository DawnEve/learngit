package com.mio.spring6.iocxml.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBook {
	public static void main(String[] args) {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("bean-book-di.xml");
		//1. set方法注入
		Book book1=context.getBean("book1", Book.class);
		System.out.println(book1);
		
		//2.构造器注入
		Book book2= context.getBean("book2", Book.class);
		System.out.println(book2);
		
		//3.特殊符号的注入
		Book book3= context.getBean("book3", Book.class);
		System.out.println(book3);
	}
}
