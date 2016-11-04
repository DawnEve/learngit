package chapter3.reflect.Generics;

import java.util.ArrayList;
import java.util.List;
/**
 * 为什么使用泛型？
 * 1.更强的编译时检测
 * 2.减少cast
 * 3.允许实现泛型方法，节省代码
 * @author admin
 *
 */
public class GenericsDemo {
	//https://docs.oracle.com/javase/tutorial/java/generics/why.html
	public static void main(String[] args){
		demo1();
		demo2();
	}

	private static void demo2() {
		List list = new ArrayList();
		list.add("hello");
		list.add(12);
		String s = (String) list.get(0);//must cast
		System.out.println(s);
	}

	private static void demo1() {
		List<String> list = new ArrayList<String>();//use generics
		list.add("hello");
//		list.add(12);//编译时报错
		String s = list.get(0);//no cast
		System.out.println(s);
		
	}
}
