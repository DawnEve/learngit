package chapter3.Inner;

public class StaticInnerDemo {

	public static void main(String[] args) {
		// 静态 成员，不需实例化，可直接调用
		System.out.println(Outer.Inner.i);
		Outer.Inner.say(1);
		System.out.println();
		
		// 实例化外部类
		Outer o=new Outer();
		o.say(2);
		
		// 直接 实例化内部类
		Outer.Inner ic=new Outer.Inner();
		ic.say(3); // 调用静态方法不需要实例化，不过也能运行
		
		//匿名内部类：需要继承父类或实现接口
		new Outer(){
			//在匿名内部类中可以重写父类中的方法，也可以定义自己的方法。
			@Override
			void say(int index){
				System.out.println(index+"I am new say()");
			}
		}.say(4);
	}
}


class Outer{
	static int j=10;
	
	static class Inner{
		static int i=-1;
		int x=-11; //静态类中的非静态方法？
		static void say(int index){
			System.out.println(index + "内部类： i=" + i +" | j= "+ j);
		}
	}
	
	void say(int index){
		//Inner in=new Inner();
		Inner.say(index);
	}
}