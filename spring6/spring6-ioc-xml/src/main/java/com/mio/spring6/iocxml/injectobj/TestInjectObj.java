package com.mio.spring6.iocxml.injectobj;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInjectObj {
	public static void main(String[] args) {
//		demo1();
//		demo2();
//		demo3();
//		demo4();
		demo5();
	}

	private static void demo5() {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("bean-di-list.xml");
		//获取对象
		Department dept=context.getBean("dept2", Department.class);
		//调用方法
		dept.info();
	}

	private static void demo4() {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("bean-di-array.xml");
		//获取员工对象
		Employee worker1=context.getBean("emp1", Employee.class);
		//调用员工方法
		worker1.work();
	}

	private static void demo3() {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("bean-inject-obj.xml");
		//获取员工对象
		Employee worker1=context.getBean("emp1c", Employee.class);
		//调用员工方法
		worker1.work();			
	}

	//test失效，不报错也不输出，啥原因？
	@Test
	private static void demo2() {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("bean-inject-obj.xml");
		//获取员工对象
		Employee worker1=context.getBean("emp1b", Employee.class);
		//调用员工方法
		worker1.work();	
	}

	private static void demo1() {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("bean-inject-obj.xml");
		//获取员工对象
		Employee worker1=context.getBean("emp1", Employee.class);
		//调用员工方法
		worker1.work();		
	}
}