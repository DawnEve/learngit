package com.mio.spring6.aop.xmlaop;

import org.junit.jupiter.api.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCalc {

	@Test
	public void testAdd() {
		System.out.println("test begin...");
		ApplicationContext context=
				new ClassPathXmlApplicationContext("bean.xml");
		Calculator calculator = context.getBean(Calculator.class);
		calculator.add(10, 50);
		//calculator.mul(10, 50);
		
		//除数不能是0异常
		//calculator.div(10, 0);
	}

	@Test
	public void testAdd2() {
		System.out.println("test begin...");
		ApplicationContext context=
				new ClassPathXmlApplicationContext("bean-xmlaop.xml");
		Calculator calculator = context.getBean(Calculator.class);
		calculator.mul(10, 50);
		
		//除数不能是0异常
		//calculator.div(10, 0);
	}
}
