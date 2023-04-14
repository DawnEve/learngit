package com.mio.spring6.javai18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceI18N {
	public static void main(String[] args) {
//		demo1();
		demo2();
	}

	private static void demo2() {
		//1 从第一个配置文件读取
		ResourceBundle bundle1 = ResourceBundle.getBundle("messages", 
				new Locale("zh", "CN"));
		System.out.println(bundle1);
		String value1 = bundle1.getString("test");
		System.out.println(value1);
		
		//2 从第二个配置文件读取
		ResourceBundle bundle2 = ResourceBundle.getBundle("messages", 
				new Locale("en", "GB"));
		String value2 = bundle2.getString("test");
		System.out.println(value2);
	}

	//messages
	private static void demo1() {
		Locale locale = new Locale("zh", "CN");
		System.out.println(locale); //zh_CN
	}
}
