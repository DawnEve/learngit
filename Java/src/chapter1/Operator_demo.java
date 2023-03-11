package chapter1;

public class Operator_demo {
	public static void main(String[] args){
		test7();
	}

	//求余数
	private static void test1() {
		int i=97;
		int j=10;
		System.out.println(i%j);//求余数
	}
	
	//除法
	private static void test2() {
		int i=10;
		int j=3;
		System.out.print(i/j);
	}
	
	//自增
	private static void test3() {
		int i=10;
		System.out.println(i);//10
		System.out.println(i++); //10
		System.out.println(i);//11
		System.out.println(++i);//12
		System.out.println(i);//12
	}

	//关系运算符
	private static void test4() {
		int i=10;
		System.out.println(i>=20);//false
		
		String s1="123";
		String s2="123";
		String s3=new String("123");
		System.out.println(s1==s2);//true
		System.out.println(s1==s3);//false
	}
	
	//逻辑运算符
	private static void test5() {
		int i=10;
		int j=100;
		boolean b1=i>2 && j>20;
		boolean b2=i>2 & j>20;
		boolean b3=i>2 || j>20;
		
		System.out.println(b1);//true
		System.out.println(b2);//true
		System.out.println(!b2);//false
		System.out.println(b3);//true
	}
		
	
	//三元运算符
	private static void test6() {
		int score1=30;
		int score2=90;
		boolean n1=(score1>=60)?true:false;
		boolean n2=(score2>=60)?true:false;
		System.out.println(n1);//false
		System.out.println(n2);//true
	}	

	//位运算符
	private static void test7() {
		int i=1;
		System.out.println(i<<6); //左移是放大，相当于*2^6
		
		int j=1024;
		System.out.println(j>>10); //右移是缩小，相当于/2^10
	}

}
