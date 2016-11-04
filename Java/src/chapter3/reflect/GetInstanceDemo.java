package chapter3.reflect;

import chapter3.reflect.bean.Person;

public class GetInstanceDemo {
	/**
	 * 有了Class文件，主要有两种方法可以获取实例
	 * @param args
	 */
	public static void main(String[] args) {
		demo1();
	}

	private static void demo1(){
		Person p=new Person();
		Class clazz=p.getClass();
		Person p2 = null;
		try {
			p2 = (Person) clazz.newInstance();//实例化
			
			//字节码文件时静态的，相同的类的Class文件相同。
			System.out.println(Person.class.equals(clazz));//true
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		p2.say();
	}

}
