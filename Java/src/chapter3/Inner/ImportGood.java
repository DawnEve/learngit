package chapter3.Inner; //包就是windows的路径。
import chapter2.*; //引入顺序是按照绝对地址引用的

public class ImportGood {
	public static void main(String[] args){
		//来自chapter2的类dog 
		Dog d=new Dog();
		System.out.println(d.getName());
		
		Dog d2=new Dog("Facai");
		System.out.println(d2.getName());
		
		System.out.println(Dog.count);
	}
}
