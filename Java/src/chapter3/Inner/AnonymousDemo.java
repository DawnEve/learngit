package chapter3.Inner;

public class AnonymousDemo {
	public static void main(String[] args) {
//		demo1();
		demo2();
	}

	// 匿名类：实现一个接口
	private static void demo2() {
		// 方法1
		Flyable f1=new Flyable() {
			public void fly() {
				System.out.println("匿名内部类-实现接口 Flyable");
			}
		};
		f1.fly();
		// 方法2：直接不要名字
		new Flyable() {
			public void fly() {
				System.out.println("匿名内部类2");
			}
		}.fly();
	}

	// 匿名类：继承一个父类
	private static void demo1() {
		//正常调用
		Person p1=new Person();
		p1.say();
		
		//创建匿名子列，改写方法后调用
		Person p2=new Person() {
			public void say() {
				System.out.println("重写父类方法");
			}
		};
		p2.say();
	}

}

interface Flyable{
	void fly();
}

class Person{
	public void say() {
		System.out.println("父类方法");
	}
}