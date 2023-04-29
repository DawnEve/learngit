package chapter3;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * 测试 自定义注释
 */
public class MyAnnoTest {
	public static void main(String[] args) {
		demo1();
		System.out.println("====");
		demo2();
	}

	private static void demo1() {
		//测试继承 父类
		Class clazz=Person2.class; //获取类
		//System.out.println(clazz);//class chapter3.Student2
		
		Annotation[] annotations=clazz.getAnnotations();
		for(int i=0; i<annotations.length; i++) {
			System.out.println(annotations[i]);
		}
	}

	private static void demo2() {
		//测试继承 子类
		Class clazz=Student2.class; //获取类
		//System.out.println(clazz);//class chapter3.Student2
		
		Annotation[] annotations=clazz.getAnnotations();
		for(int i=0; i<annotations.length; i++) {
			System.out.println(annotations[i]);
		}
	}
}


@MyAnno({"MyAnno for Person2", "class"})
class Person2{
	public Person2(){}
	
	@SuppressWarnings(value = { "xx1" })
	public Person2(
			@MyAnno(value = { "xx2" })  //加到参数上面
			String[] args) {
	}
	
	@MyAnno(value="book2", number= {1,2,3})
	private static void demo2() {
		System.out.println("hello 123");
	}
	
	@MyAnno(value="hi11")
	public void demo1() {
		System.out.println("Person.demo1()");
	}
}

class Student2 extends Person2{
	@Override
	public void demo1() {
		System.err.println("Stu.demo1()");
	}
}

// 注解加到 类的泛型，需要 Target 加上 TYPE_PARAMETER
class Generic<@MyAnno T>{
	// 数据类型前修饰，甚至异常前，需要 Target 加上 TYPE_USE
	public void show() throws @MyAnno RuntimeException{
		ArrayList<@MyAnno String> list = new ArrayList<>();
		int num = (@MyAnno int)10L;
	}
}
