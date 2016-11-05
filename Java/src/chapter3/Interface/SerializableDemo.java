package chapter3.Interface;

import java.io.Serializable;

public class SerializableDemo {

	public static void main(String[] args) {
		demo1();
	}

	private static void demo1() {
		Dog dog=new Dog();
		Dog dog2=new Dog("wangcai");
		System.out.println(dog.hashCode());
		System.out.println(dog2.hashCode());
		
	}
}

//将需要序列化的类实现Serializable接口就可以了，Serializable接口中没有任何方法，
//可以理解为一个标记，即表明这个类可以序列化。
class Dog implements Serializable{
	String name="a dog";

	/**
	 * 这个太复杂
	 */
	//private static final long serialVersionUID = 8315548920843476255L;

	/**
	 * 默认用这个足够了
	 */
	private static final long serialVersionUID = 1L;
	public Dog(){
		super();
	}
	public Dog(String name){
		this.name=name;
	}
	
}