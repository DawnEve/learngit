package com.mio.spring6.iocxml.injectmap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStu {
	public static void main(String[] args) {
//		demo1();
//		demo2();
		demo3();
	}

	private static void demo3() {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("bean-di-p.xml");
		Student stu=context.getBean("student2", Student.class);
		stu.run();
	}

	private static void demo2() {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("bean-di-ref.xml");
		Student stu=context.getBean("student", Student.class);
		stu.run();
	}

	private static void demo1() {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("bean-di-map.xml");
		Student stu=context.getBean("student", Student.class);
		stu.run();
	}
}
