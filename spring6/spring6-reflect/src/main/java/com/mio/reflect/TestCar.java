package com.mio.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

public class TestCar {

	//1. 获取class对象的常见3种方式
	@Test
	public void test01() throws ClassNotFoundException {
		//1 类名.class
		Class<Car> clazz1=Car.class;
		System.out.println(clazz1);
		
		//2 对象.getClass()
		Car car=new Car();
		Class clazz2=car.getClass();
		System.out.println(clazz2);
		
		//3 Class.forName("类的全路径")
		Class clazz3=Class.forName("com.mio.reflect.Car");
		System.out.println(clazz3);
		//class com.mio.reflect.Car		
	}
	
	//2. 获取构造方法
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void test02() throws Exception {
		Class clazz3=Class.forName("com.mio.reflect.Car");
		//注意，有两个获取构造函数的方法，差别就是是否有s结尾
		//1.获取构造函数，并实例化
		Car car=(Car)clazz3.getDeclaredConstructor().newInstance();
		System.out.println(car+"\n");

		//2.获取构造函数arr
		//getConstructors() 和 getDeclaredConstructors() 的区别: 前者只能获取public构造
		Constructor[] constructors = clazz3.getDeclaredConstructors(); //所有构造，public+private
//		Constructor[] constructors = clazz3.getConstructors(); //只能获取public构造
		System.out.println("构造方法个数:"+constructors.length);
		//遍历输出
		for(Constructor c: constructors) {
			System.out.println("构造方法:"+c.getName() + ", 参数个数:" + c.getParameterCount());
		}
		System.out.println();
		//实例化
		Car car2 =(Car) constructors[1].newInstance();
		System.out.println("2 "+car2);
		
		//3.默认使用无参构造，怎么使用有参构造？
		Constructor c1=clazz3.getConstructor(String.class, String.class);
		Car car3=(Car) c1.newInstance("宝马", "黑色");
		System.out.println("3 "+car3);
		
		//4.怎么调用 private 构造函数?
		Constructor c2=clazz3.getDeclaredConstructor(String.class, int.class, String.class);
		c2.setAccessible(true); //设置这一步才能访问私有构造，否则报错
		Car car4=(Car) c2.newInstance("比亚迪", 5, "红色");
		System.out.println("4 "+car4);
	}
	
	//3. 获取属性
	@Test
	public void test03() throws Exception {
		//获取对象
		Class clazz=Car.class;
		Car car=(Car) clazz.getDeclaredConstructor().newInstance();
		//获取所有属性
//		Field[] fields = clazz.getFields(); //获取所有的public属性
		Field[] fields = clazz.getDeclaredFields(); //获取所有的public+private 属性
		for(Field field: fields) {
			//设置属性的只
			if(field.getName().equals("name") ) {
				//设置允许访问
				field.setAccessible(true);
				field.set(car, "五菱宏光");
			}
			System.out.println(field.getName() +", \ttype:"+ field.getType());
		}
		//输出对象
		System.out.println(car);
	}
	
	
	//4. 获取方法
	@Test
	public void test04() throws Exception {
		//获取对象
		Car car=new Car("奔驰", "白色");
		Class clazz=car.getClass();
		
		//1.获取 public 方法
		Method[] methods = clazz.getMethods();
		for(Method method: methods) {
			System.out.println(method.getName() + ": "+method.getParameterCount());
			//执行某个方法 toString
			if(method.getName().equals("toString")) {
				String invoke=(String) method.invoke(car);
				System.out.println(" > " + invoke);
			}
		}
		System.out.println();
		
		//2.获取 private 方法
		Method[] methodsAll = clazz.getDeclaredMethods();
		for(Method method: methodsAll) {
			System.out.println(method.getName() + ": "+method.getParameterCount());
			//执行私有方法: run
			if(method.getName().equals("run")) {
				//设置许可
				method.setAccessible(true);
				String invoke=(String) method.invoke(car);
				System.out.println(" > " + invoke);
			}
		}
		
	}

}
