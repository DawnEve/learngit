package com.mio.spring6.resourceloader;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

public class ResourceLoaderDemo {
	
	@Test
	public void demo1() {
		ApplicationContext context = new ClassPathXmlApplicationContext();
		Resource resource = context.getResource("file1.txt");
		//System.out.println(resource.getFilename());
		System.out.println(resource.getDescription());
		// class path resource [file1.txt]
	}
	
	@Test
	public void demo2() {
		ApplicationContext context = new FileSystemXmlApplicationContext();
		Resource resource = context.getResource("file1.txt");
		System.out.println(resource.getDescription());
		// file [G:\learngit\spring6\spring6-resources\file1.txt]
	}

}
