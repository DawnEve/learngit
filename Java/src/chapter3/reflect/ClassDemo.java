package chapter3.reflect;

/**
 * 获取字节码的三种方式
 * http://www.codeceo.com/article/java-reflector-usage.html
1.对象的getClass()方法;
2.类的.class(最安全/性能最好)属性;
3.运用Class.forName(String className)动态加载类,className需要是类的全限定名(最常用).
 * @author admin
 */
public class ClassDemo {
	public static void main(String[] args){
//		demo1();
//		demo2();
//		demo3();
		getClassName("abc");
		getClassName(122);
	}

	private static void demo1() {
		// 方法1 类名.class 缺点：需要知道类名，且不能使字符串
		Class clazz=String.class;
		System.out.println(clazz);//class java.lang.String
	}
	
	private static void demo2() {
		// 方法2  实例名.getClass() 缺点：需要实例
		Class clazz="".getClass();
		System.out.println(clazz);//class java.lang.String
	}
	
	/**
	 *  若存在则加载，否则新建,往往使用第三种,类的名字在写源程序时不需要知道，到运行时再传递过来
	 */
	private static void demo3() {
		// 方法3  Class.forName(完整类名) 缺点：必须带完整包名，之前import过也不行。
		Class clazz=null;
		try {
			clazz = Class.forName("java.lang.String");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(clazz);//class java.lang.String
	}
	
	public static void getClassName(Object obj){
		System.out.println("The object "+obj + " is an instance of "+obj.getClass().getName());
	}
}
