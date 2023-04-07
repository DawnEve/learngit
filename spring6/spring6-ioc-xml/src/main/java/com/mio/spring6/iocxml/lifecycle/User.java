package com.mio.spring6.iocxml.lifecycle;

public class User {
	private String name;
	
	//无参构造
	public User() {
		System.out.println("1 调用无参构造，创建对象");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("2 给bean对象设置属性值");
		this.name = name;
	}
	
	//初始化方法
	public void initMethod() {
		System.out.println("4 bean对象初始化，会调用指定的初始化方法");
	}
	
	//销毁方法
	public void destroy() {
		System.out.println("7 bean 对象销毁，会调用指定的销毁方法");
	}
}
