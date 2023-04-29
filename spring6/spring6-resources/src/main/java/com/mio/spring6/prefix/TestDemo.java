package com.mio.spring6.prefix;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

public class TestDemo {
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");
		//可以加通配符
		/*
		 * "classpath*:bean-di.xml" 如果使用 classpath* 表示搜索类加载路径下的所有满足该规则的xml配置文件。
		 * "classpath:bean-di.xml" 如果使用 classpath 表示搜索类加载路径下的第一个满足该规则的xml配置文件。
		 * */
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean-*.xml");
		
		//获取对象
		User user = context.getBean(User.class);
		System.out.println(user);
		
		//获取资源
//		Resource resource = context.getResource("file1.txt");
		Resource resource = context.getResource("classpath:file1.txt");
		System.out.println(resource.getDescription());
		
		// getResource() 可使用资源前缀
		Resource resource2 = context.getResource("file:src/main/resources/file1.txt");
		System.out.println("\n"+resource2.getDescription());
		System.out.println(resource2.isReadable());
	}
}
