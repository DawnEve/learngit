package chapter3.reflect.bean;

//军队
abstract class Force{
	public int number=100;
	abstract public void fight();
}


/**
 * 人类力量
 * 测试类Person 
 * @author admin
 *
 */
public class Person extends Force {
	private String name="";
	public int age=10;
	String sex="F";
	
	public Person(){
		this.name="Default name";
	}
	public Person(String name){
		this.name=name;
	}
	
	public void say(){
		System.out.print("My name is "+this.name);
	}
	static void eat(){
		System.out.print("I am static eat()");
	}
	@Override
	public void fight() {
		System.out.println("Person fight");
		
	}
}