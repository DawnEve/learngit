package chapter3.Constructor;

//全局只能有一份，叫单例模式

public class ConstructorDemo {
	public static void main(String[] args){
//		demo1();
		demo2();
	}

	//父类构造函数会不会被调用？
	private static void demo2() {
		//Dog dog=new Dog();
		Dog dog=new Dog("wangcai");
	}

	private static void demo1() {
		Bike b=Bike.getInstance();
		Bike b2=Bike.getInstance();
		
		System.out.println(b.equals(b2));//true
		b.showSize();
		b2.setSize(100);//修改的确实是一个对象
		b.showSize();
	}
}

class Animal{
	private String name;
	public Animal() {
		System.out.println("Animal()");
	}
	public Animal(String name) {
		this.name=name;
		System.out.println("Animal(String)");
	}
};

class Dog extends Animal{
	public Dog() {
		super(); //调用父类构造器必须在最前面
		System.out.println("Dog()");
	} //自动调用父类的构造函数
	public Dog(String name) {
		super("Dog_"+name); //如果不写，默认调用父类的无参构造器
		System.out.println("Dog(String)");
	}
}



//=============

class Machine{
	{
		System.out.println("1-----------A string in Machine-----------");
	}

	public Machine(){
		super();
		System.out.println("2Construcor at Machine");
	}
}

class Bike extends Machine{
	public int size=28;
	private static Bike bike=null;
	{
		System.out.println("3-----------A string in Bike-----------");
	}
	private Bike(){
		super();
	}
	private Bike(int size){
		this.size=size;
		System.out.println("4>>Bike constructor");
	}
	public static Bike getInstance(){
		if(bike==null){
			bike=new Bike(15);
			return bike;
		}
		return bike;
	}
	public void showSize(){
		System.out.println("size = "+this.size);
	}
	public void setSize(int size){
		this.size=size;
	}
}


