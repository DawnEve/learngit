package chapter3;

public class AbstractDemo {
	public static void main(String[] args){
		//抽象类和抽象方法
		Cat c=new Cat("Tomcat");
		c.say();
		c.cry();
	}
	

}

//抽象动物
abstract class Animal{
	String name;
	public Animal(String name){
		this.name=name;
	}
	
	public void say(){
		System.out.println("this is "+this.name);
	}
	
	abstract public void cry(); //抽象方法
}


//实例化 猫 
class Cat extends Animal{
	public Cat(String name) {
		super(name);
	}

	@Override
	public void cry() {
		System.out.print("Cat Cry: miaomiao");
	}
}