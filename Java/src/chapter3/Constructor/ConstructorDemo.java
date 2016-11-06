package chapter3.Constructor;

//全局只能有一份，叫单例模式

public class ConstructorDemo {
	public static void main(String[] args){
		Bike b=Bike.getInstance();
		Bike b2=Bike.getInstance();
		
		System.out.println(b.equals(b2));//true
		b.showSize();
		b2.setSize(100);//修改的确实是一个对象
		b.showSize();
	}
}


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


