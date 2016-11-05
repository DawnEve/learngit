package chapter3.Interface;

public class InterfaceDemo {
	public static void main(String[] args){
//		demo1();
//		demo2();
		//demo3(new Bat());
		demo3(new Bird());
	}

	//instanceof 判断是否是实现接口
	private static void demo3(Object obj) {
		if(obj instanceof Flyable){
			System.out.println("This is "+ obj);
			((Flyable) obj).fly();
		}
		if(obj instanceof Runable){
			System.out.println("This is "+ obj);
			((Runable) obj).run();
		}
	}


	//测试接口的调用
	private static void demo2() {
		Bird b=new Bird();
		b.fly();
		b.run();
		
		Animal a=new Animal();
		a.run();
		
		Bat bat=new Bat();
		bat.fly();
		bat.run();
		if(bat instanceof Flyable){
			System.out.println("bat instanceof Flyable");
		}
		
//		System.out.println(bat instanceof Bird);//TODO 为什么报错？
		//Incompatible conditional operand types Bat and Bird
		System.out.println(bat instanceof Bat);
		System.out.println(bat instanceof Animal);
	}

	
	
	private static void demo1() {
		//直接访问接口中的变量
		System.out.print(Flyable.speed);
//		System.out.print(speed);//没实现接口，不能直接使用
	}
}

//定义接口1
interface Flyable{
	int speed=120;//接口里的成员变量默认为public static final类型的
	public void run();
	public void fly();
}
//定义接口2
interface Runable{
	int speed=10;//接口里的成员变量默认为public static final类型的
	public void run();
}


//鸟实现飞翔这个接口
class Bird implements Flyable{
	@Override
	public void fly() {
		//实现接口后，接口变量相当于常量了。
		System.out.println("Bird can fly, speed: "+speed);
	}

	@Override
	public void run() {
		System.out.println("Bird can run, no speed.");
	}
}


//动物实现跑这个接口
class Animal implements Runable{
	@Override
	public void run() {
		//实现接口后，接口变量相当于常量了。
		System.out.println("Animal can run, speed: "+speed);
	}
}

//继承自Animal，同时实现多个接口
class Bat extends Animal implements Runable,Flyable{
	@Override
	public void fly() {
		//当变量有冲突时，需要指明是谁的变量
		System.out.println("Bat can fly, speed: "+Flyable.speed);
	}
	@Override
	public void run() {//这个方法在两个接口都有，重名，但并没有报错
		System.out.println("Bat can run, speed: "+Runable.speed);
	}
}

//继承说明

