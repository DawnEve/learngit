package chapter3;

public class AbstractDemo {
	public static void main(String[] args){
		//抽象类和抽象方法
		Animal2 c=new Cat2("Tomcat");
		c.say();
		c.cry();
	}
	

}

//抽象动物
abstract class Animal2{
	String name;
	public Animal2(String name){
		this.name=name;
	}
	
	public void say(){
		System.out.println("this is "+this.name);
	}
	
	abstract public void cry(); //抽象方法
}


//实例化 猫 
class Cat2 extends Animal2{
	public Cat2(String name) {
		super(name);
	}

	@Override
	public void cry() {
		System.out.print("Cat Cry: miaomiao");
	}
}