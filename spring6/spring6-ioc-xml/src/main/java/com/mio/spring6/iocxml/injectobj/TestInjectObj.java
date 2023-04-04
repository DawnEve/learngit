package com.mio.spring6.iocxml.injectobj;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInjectObj {
	public static void main(String[] args) {
//		demo1();
//		demo2();
		demo3();
	}

	private static void demo3() {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("bean-inject-obj.xml");
		//获取员工对象
		Employer worker1=context.getBean("emp1c", Employer.class);
		//调用员工方法
		worker1.work();			
	}

	//test失效，不报错也不输出，啥原因？
	@Test
	private static void demo2() {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("bean-inject-obj.xml");
		//获取员工对象
		Employer worker1=context.getBean("emp1b", Employer.class);
		//调用员工方法
		worker1.work();	
	}

	private static void demo1() {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("bean-inject-obj.xml");
		//获取员工对象
		Employer worker1=context.getBean("emp1", Employer.class);
		//调用员工方法
		worker1.work();		
	}
}