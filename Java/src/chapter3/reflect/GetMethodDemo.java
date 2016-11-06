package chapter3.reflect;

import java.lang.reflect.Method;

public class GetMethodDemo {

	/**
	 * 获取类的方法
	 * 
getMethods()：获得类的public类型的方法。
getDeclaredMethods()：获得类的所有方法。
getMethod(String name, Class[] parameterTypes)：获得类的特定方法，name参数指定方法的名字，parameterTypes 参数指定方法的参数类型。
	 * @param args
	 */
	public static void main(String[] args) {
//		demo1();
		demo2();
	}

	private static void demo1() {
		try {
			Class clazz=Class.forName("java.util.Arrays");//java.util.Stack
			Method[] m=clazz.getMethods();
			for(int i=0;i<m.length;i++){
				System.out.println(i+": "+m[i]);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//列出了java.util.Stack 类的各方法名以及它们的限制符和返回类型。
	private static void demo2() {
		try {
			Class clazz=Class.forName("java.util.Arrays");//java.util.Stack
			Method[] m=clazz.getDeclaredMethods();
			for(int i=0;i<m.length;i++){
				System.out.println(i+": "+m[i]);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
