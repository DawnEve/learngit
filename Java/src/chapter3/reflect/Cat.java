package chapter3.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *  Class类中几个重要的方法:
Class类是Reflection API 中的核心类，它有以下方法
getName()：获得类的完整名字。
getFields()：获得类的public类型的属性。
getDeclaredFields()：获得类的所有属性。
getMethods()：获得类的public类型的方法。
getDeclaredMethods()：获得类的所有方法。
getMethod(String name, Class[] parameterTypes)：获得类的特定方法，name参数指定方法的名字，parameterTypes 参数指定方法的参数类型。
getConstructors()：获得类的public类型的构造方法。
getConstructor(Class[] parameterTypes)：获得类的特定构造方法，parameterTypes 参数指定构造方法的参数类型。
newInstance()：通过类的不带参数的构造方法创建这个类的一个对象。
 * @author admin
 *
 */
public class Cat {
	/**
	 * Class类中几个重要的方法
	 * @param args
	 */
	public static void main(String[] args){
		//showClass(new String(""));//class java.lang.String
		//showClass(123);//class java.lang.Stringclass java.lang.Integer
		//showClass(new String[]{""});//class [Ljava.lang.String;
		//showMethod(new Person());
		//showMethod(1.0);
		//showConstructors(new Person());//共2个
		showFields(new Person());
	}
	
	/**
	 * 1.通过Object类的getClass()方法，获取实例本身的类。
	 */
	static void showClass(Object obj){
		//Class c=new String("").getClass();
		Class c=obj.getClass();
		System.out.print(c);//class java.lang.String
	}
	
	
	//获取public方法
	static void showMethod(Object obj){
		Class c=obj.getClass();
		Method m1[]=c.getMethods();
		for(int i=0;i<m1.length;i++){
			System.out.println(m1[i]);
		}
	}
	
	//获取构造方法
	static void showConstructors(Object obj){
		Class c=obj.getClass();
		Constructor  m1[]=c.getConstructors();
		System.out.println(m1.toString());
		System.out.println();
		
		//System.exit(0);
		//return();
		
		for(int i=0;i<m1.length;i++){
			System.out.println(m1[i]);
		}
	}
	
	//获取可用字段
	static void showFields(Object obj){
		Class c=obj.getClass();
		Field  m1[]=c.getFields();
		System.out.println(m1.toString());
		System.out.println();
		
		for(int i=0;i<m1.length;i++){
			System.out.println(m1[i]);
		}
	}
	
	
	//也可以通过Class类的静态方法——forName()来实现：
	//需要“包名+类名”的完全限定名的方式，而不是一个简单的类名“MyObject”
	static void demo2(){
		Class c = null;
		try {
			c = Class.forName("chapter3.reflect.Person");
			System.out.print(c);//class chapter3.reflect.Person
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
