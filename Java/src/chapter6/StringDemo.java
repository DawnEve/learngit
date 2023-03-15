package chapter6;

public class StringDemo {
	public static void main(String[] args) {
//		demo1();
//		demo2();
//		demo3();
		demo4();
	}

	//格式化字符串
	private static void demo4() {
		int age=20;
		String name="wangcai";
		//方法1.printf，类C函数
		System.out.printf( "1新人名字是%s,今年%d岁\n", name, age ); 
		// 方法2.String.format 静态方法 
		String fs=String.format("2新人名字是%s,今年%d岁", name, age);
		System.out.println(fs);
	}

	// 连接字符串
	private static void demo3() {
		String s1="hi";
		String s2="Tom";
		System.out.println(s1.concat(s2));//方法1
		System.out.println(s1+" "+s2); //方法2
	}

	// String 类有 11 种构造方法; 获取长度
	private static void demo2() {
		char [] arr1= {'t', 'o', 'm'};
		String str=new String(arr1);
		System.out.println(str.length());
		str=str+"hi";
		System.out.println(str);
		System.out.println(str.length());
	}

	// 怎么判断s1-s3是同一个？而s3和s4不是同一个？
	private static void demo1() {
		String s1="Tom";
		String s2="Tom";
		String s3="Tom";
		String s4=new String("Tom");
		String s5=new String("Tom");
		
		System.out.println(s1.getBytes() + " "+ s1.hashCode());
		System.out.println(s2.getBytes() + " "+ s2.hashCode());
		System.out.println(s3.getBytes() + " "+ s3.hashCode());
		System.out.println(s4.getBytes() + " "+ s4.hashCode());
		System.out.println(s5.getBytes() + " "+ s5.hashCode());
		
		// String是拥有“值语义”的引用类型，字符串常量实现了“享元模式”，
		//equals会按照内容进行比较，==按照地址比较。
		System.out.println();
		System.out.println(s1==s2); //true
		System.out.println(s1==s3); //true
		System.out.println(s1==s4);  //false
		System.out.println(s1==s5);  //false
		System.out.println(s4==s5);  //false
		System.out.println(s1.equals(s5));  //true
		System.out.println(s4.equals(s5));  //true
		
	}
}
