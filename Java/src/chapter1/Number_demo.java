package chapter1;

public class Number_demo {
	public static void main(String[] args){
		test5();
	}
	
	/*
	 * 整形
	 * */
	static void test1(){
		int i=11;
		int j=-12;
		System.out.println(i);
		System.out.print(j);
	}
	
	/*
	 * 浮点型
	 * */
	static void test2(){
		float i=10F;
		double j=-1.2e5D;
		System.out.println(i/3);
		System.out.print(j/7);
	}
	
	/*
	 * 字节型
	 * */
	static void test3(){
		char i='c';
		char j=56;
		System.out.println(i);
		System.out.println((int)i);//值的显式转换
		System.out.println(i/3); //值的隐式转换
		
		System.out.println("j=" + j);
		System.out.println("j=" + (int)j);
		System.out.println(j==56);//true
	}
	
	/**
	 * 文档注释：
	 * 作者：jimmy
	 * date: 2016-10-29
	 * 字符型
	 * */
	static void test4(){
		String str="this is a book of his!";

		//行注释
		System.out.println(str);
	}
	/*
	 * 块注释
	 * */
	
	
	static void test5(){
		int For=1; //定义一个变量名称为For的变量 
		int Do=2; //定义一个变量名称为Do的变量 
		int t=For+Do; 
		System.out.println("变量和为"+t); 
	}
	
	
}
