package com.mio.spring6.resourceloaderaware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ResourceLoader;

public class TestDemo {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("test-bean.xml");
		TestBean testBean = context.getBean("testBean", TestBean.class);
		ResourceLoader resourceLoader = testBean.getResourceLoader();
		
		System.out.println(resourceLoader);
		System.out.println(context == resourceLoader);
	}

}
