package com.mio.spring6.resource;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.FileSystemResource;

//访问系统资源
public class FileSystemResourceDemo {
	public static void main(String[] args) {
		//相对路径
		//loadFileSystemResource("src/main/resources/file1.txt");
		
		//绝对路径
		loadFileSystemResource("G:/learngit/spring6/spring6-resources/src/main/resources/file1.txt");
	}

	private static void loadFileSystemResource(String path) {
		FileSystemResource resource=new FileSystemResource(path);
		System.out.println("1>"+resource.getFilename());
		System.out.println("2>"+resource.getDescription());
		
		try {
			InputStream in=resource.getInputStream();
			byte[] buffer=new byte[1024];
			while(in.read(buffer) != -1) {
				System.out.println(new String(buffer));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
