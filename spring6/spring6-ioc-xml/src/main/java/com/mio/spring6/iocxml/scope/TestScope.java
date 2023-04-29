package com.mio.spring6.iocxml.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestScope {
	public static void main(String[] args) {
		demo1();
	}

	private static void demo1() {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("bean-scope.xml");
		Orders orders=context.getBean("orders", Orders.class);
		System.out.println(orders);
		//再次获取，发现 单实例 地址一致; 多实例 地址不一致;
		Orders orders2=context.getBean("orders", Orders.class);
		System.out.println(orders2);		
	}
}
