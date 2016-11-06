package chapter3.Inner;

public class StaticInnerDemo {

	public static void main(String[] args) {
		Outer o=new Outer();
		Outer.Inner.say();
		System.out.println(Outer.Inner.i);
		
		o.say();
		
		//匿名内部类：需要继承父类或实现接口
		new Outer(){
			//在匿名内部类中可以重写父类中的方法，也可以定义自己的方法。
			@Override
			void say(){
				System.out.println("I am new say()");
			}
		}.say();
	}
}


class Outer{
	static int j=10;
	
	static class Inner{
		static int i=0;
		static void say(){
			System.out.println("内部类： i=" + i +" | j= "+ j);
		}
	}
	
	void say(){
		Inner in=new Inner();
		in.say();
	}
}