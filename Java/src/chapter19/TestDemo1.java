package chapter19;

import org.junit.Test;

/*
 * JUnit 单元测试
(1)右击当前项目，选择 build path - add libraries - JUnit 4 - 应用。
(2)创建一个Java类，
	要求 public 类
	提供 公共的无参构造器
(3)在该类中声明测试方法
	该方法权限：public 
	返回类型：void 
	没有形参
(4)该方法上面加上注解 @Test
	并导入 import org.junit.Test;
(5)声明好单元测试方法以后，可以在方法体中写测试相关代码。
	没有main方法也能执行了
(6)选中方法名，右击 run as - JUnit Test;
	出现 JUnit 窗口：
		如果执行正常，则出现绿条
		执行异常，出现红条
	在测试类中定义的成员变量，不用new对象，就可以直接使用
 * */
public class TestDemo1 {
	int num=100;
	
	@Test
	public void testToString() {
		String s1="s1";
		String s2="s2";
		System.out.println(s1==s2);
		
		System.out.println(num); //直接调用成员变量
		show(); //调用成员方法
	}

	private void show() {
		System.out.println("show()...");
	}
	
	
		
	@Test
	public void testStudent() {
		Student s1=new Student();
		s1.setAge(3);
		s1.setName("wangcai");
		System.out.println(s1);
	}
}
