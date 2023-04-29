package com.mio.spring6.resource;

import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;

//访问类根目录下 resource/ 下的文件
public class ClassPathResourceDemo {
	public static void main(String[] args) {
		loadClassPathResource("file1.txt");
	}

	private static void loadClassPathResource(String path) {
		ClassPathResource resource=new ClassPathResource(path);
		System.out.println("1>"+resource.getFilename());
		System.out.println("2>"+resource.getDescription());
		//获取文件内容
		try {
			InputStream in = resource.getInputStream();
			byte[] buffer=new byte[1024];
			while(in.read(buffer) != -1) {
				System.out.println(new String(buffer));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
