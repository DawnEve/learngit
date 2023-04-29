package chapter3;

public class FinalizeMethod {
	public static void main(String[] args) {
		Dog2 d1=new Dog2(1);
		Dog2 d2=new Dog2(2);
		Dog2 d3=new Dog2(3);
		
		d2=d3=null;
		System.out.println("invoke gc");
		System.gc(); //调用垃圾收集器
	}
}

class Dog2{
	private int id;
	public Dog2(int id) {
		this.id=id;
		System.out.println("Dog Object "+id+ "is created.");
	}
	
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println(">> Dog Object "+id+" is disposed.");
	}
}