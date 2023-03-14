package chapter2;

public class Dog {
	private String name="Wangcai";
	public static int count=0;//静态变量, 默认是对包内可见，包外不可见的。
	
	public Dog() {}
	public Dog(String name) {
		this.name=name;
	}
	
	public String getName(){
		System.out.print(++count);
		return this.name;
	}
	
	public static void say(){
		System.out.print("I am ..."+Dog.count);
	}

	
}
