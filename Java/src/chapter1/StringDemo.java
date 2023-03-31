package chapter1;

public class StringDemo {
	public static void main(String[] args) {
//		demo1();
//		demo2();
		demo3();
	}

	//必须是字符串，或者2个连接运算时至少一个是String
	private static void demo3() {
		//几种错误的定义方式
//		String str1=4; //错误！
		String str1="";
		System.out.println(str1);
	}

	private static void demo2() {
		//测试字符串做加法后，地址是否改变
		String s1="hello";
		String s2="hello";
		String s3=new String("hello");
		//System.identityHashCode(s1)是获取地址，而s1.hashCode()是获取字符串的hash值 
		System.out.println( System.identityHashCode(s1)+" | "+s1.hashCode());
		System.out.println( System.identityHashCode(s2)+" | "+s2.hashCode());
		System.out.println( System.identityHashCode(s3)+" | "+s3.hashCode());
		s1 += "world";
		System.out.println( System.identityHashCode(s1)+" | "+s1.hashCode());
	}

	private static void demo1() {
		//字符可以和8种基本数据类型运算，只能是连接运算
		boolean a1=true;
		String s2="hello";
		String s3=s2+a1; //hellotrue
		System.out.println(s3);
	}

}
