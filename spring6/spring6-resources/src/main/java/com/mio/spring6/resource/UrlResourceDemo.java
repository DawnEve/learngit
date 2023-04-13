package com.mio.spring6.resource;

import org.springframework.core.io.UrlResource;

//演示 UrlResource 访问网络资源
public class UrlResourceDemo {
	public static void main(String[] args) {
		
		//http前缀开头的
//		loadUrlResource("http://www.baidu.com/index.php");
		
		//file 前缀的: 相对于 子模块 的相对路径，或绝对路径
//		loadUrlResource("file:pom.xml");
		loadUrlResource("file:src/main/resources/file1.txt");
		//loadUrlResource("file:///G:/learngit/spring6/spring6-resources/src/main/resources/file1.txt");
	}
	
	//访问http资源
	public static void loadUrlResource(String path) {
		try {
			//1 创建 Resource 接口的实现类
			UrlResource url=new UrlResource(path);
			
			//2 获取资源信息
			System.out.println("1> " + url.getFilename());
			System.out.println("2> " + url.getURI());
			System.out.println("3> " + url.getDescription());
			System.out.println("4> " + url.getInputStream().read()); //输出内容
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
