package com.mio.bean;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import mio.com.anno.Bean;

public class AnnotationApplicationContext implements ApplicationContext {
	//1.创建map集合，放bean对象
	private Map<Class, Object> beanFactory = new HashMap<>();
	private static String rootPath; //包的根目录 

	//2.返回对象
	@Override
	public Object getBean(Class clazz) {
		return beanFactory.get(clazz);
	}
	
	//3.创建有参数构造，传递包路径，设置包扫描规则
	//设置包扫描规则: 当前包及其子包，如果有 @ Bean注解，把这个类通过反射实例化
	public AnnotationApplicationContext(String basePackage) throws Exception {
		//com.mio
		try {
			//1.把.替换成\
			String pkgPath=basePackage.replaceAll("\\.", "\\\\");
			//System.out.println(pkgPath);
			//2.获取包绝对路径，支持多个路径
			Enumeration<URL> urls =
					Thread.currentThread().getContextClassLoader()
										  .getResources(pkgPath);
			//2.2遍历输出
			while(urls.hasMoreElements()) {
				URL url=urls.nextElement();
				//System.out.println(url);//有乱码: %5c字符
				//为了防止乱码
				String filePath=URLDecoder.decode(url.getFile(), "utf-8");
				//System.out.println(filePath);
				//获取包前面的路径部分，字符串截取
				rootPath=filePath.substring(0, filePath.length() - pkgPath.length());
				
				//3.扫描包，使用函数实现
				loadBean(new File(filePath));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//扫描包的过程，实例化
	private void loadBean(File file) throws Exception {
		//1 判断当前内容是否是文件夹
		if(file.isDirectory()) {
			//2 如果是，获取文件夹内的所有内容
			File[] childrenFiles = file.listFiles();
			//3 如果文件夹为空，直接返回
			if(childrenFiles==null || childrenFiles.length==0) {
				return;
			}
			//4 如果文件夹不为空，遍历文件夹所有内容
			for(File child: childrenFiles) {
				//4.1 遍历每个File对象，继续判断，如果还是文件夹，递归
				if(child.isDirectory()) {
					loadBean(child);
				}else {
					//4.2 遍历得到File对象是文件，则继续
					//4.3 得到包路径 + 类名称部分：字符串截取
					String pathWithClass = child.getAbsolutePath()
								.substring(rootPath.length()-1);
					//4.4 判断当前文件类型是否是.class
					if(pathWithClass.endsWith(".class")) {
						//4.5 如果是 .class类型，把路径\替换成.，把.class去掉 
						// com.mio.service.UserServiceImpl.class
						String fullName=pathWithClass.substring(0, pathWithClass.length()-6);
						fullName=fullName.replaceAll("\\\\", "\\.");
						
						//4.6 判断类上是否有 @ Bean注解，如果有，则实例化
						//4.6.1 获取class
						Class<?> clazz=Class.forName(fullName);
						//4.6.2 不是接口，才实例化
						//if(clazz.toString().startsWith("class")) {
						if(!clazz.isInterface()) {
							//4.6.3 判断是否有注解
							Bean annotation = clazz.getAnnotation(Bean.class);
							//System.out.println( "\t"+ clazz.toString()+"\t"+annotation );
							if(annotation != null) {
								//4.6.4 实例化
								Object instance = clazz.getConstructor().newInstance();
								
								
								//4.7 实例化后的对象，放到map集合 beanFactory
								//有接口，则接口作为key；没有接口，则类名作为key
								//4.7.1 判断当前类是否有接口
								//System.out.println("\t" + instance+"\t"+clazz.getInterfaces()[0] );
								//System.out.println("\t" + instance+"|\t"+clazz );
								if( clazz.getInterfaces().length>0 ) {
									beanFactory.put(clazz.getInterfaces()[0], instance);
								}else {
									beanFactory.put(clazz, instance);
								}
							}
						}
					}
				}
			}
		}
	}

	//测试: 写代码时测试
	public static void main2(String[] args) throws Exception {
//		ApplicationContext context=
//				new AnnotationApplicationContext("com.mio.bean.xml");
		AnnotationApplicationContext app=
				new AnnotationApplicationContext("com.mio");
		System.out.println(app);
	}
}
