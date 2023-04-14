package com.mio.spring6.springi18n;

import java.util.Date;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ResourceBundleMessageSourceDemo {
	
	public static void main(String[] args) {
		//1.读入配置文件，获取 Spring 容器
		ApplicationContext context = new ClassPathXmlApplicationContext("bean-i18n.xml");
		
		//2.创建数组，2个值，分别是给配置文件 {0} {1} 动态传递参数
		Object[] objs=new Object[]{"CMD_user", new Date().toString()};
		
		//2.2获取容器对象：（可省略）用context对象代替
		MessageSource messageSource = context.getBean(MessageSource.class);
		System.out.println(messageSource);
		System.out.println(messageSource.getMessage("www.mio.com", objs, Locale.FRANCE) + " ~~"); //找不到则使用系统默认
		
		//3.按照key(参数1)从配置文件获取value；然后把数组objs(参数2)中的值组装进去。参数3为 制定配置文件
		String message = context.getMessage("www.mio.com", objs, Locale.CHINA); //中文配置文件
		System.out.println(message);
		
		//System.out.println(Locale.ENGLISH); //en
		String message2 = context.getMessage("www.mio.com", objs, new Locale("en", "GB")); //英语配置文件
		System.out.println(message2);
	}
//	ResourceBundleMessageSource source=new ResourceBundleMessageSource();

}
