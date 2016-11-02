package chapter3;

/**
 * 访问级别
 * 
 * 
 */
public class GetMe {
	public static void main(String[] args){
		RacingCycle2 b=new RacingCycle2();
		System.out.println(b.color);
		System.out.println(b.size);
		System.out.println(b.speed);
		b.say();
	}
	 

}



class Bike2{ 
	public String color="black"; //自行车的颜色 
	public int size=28; //自行车的大小，即型号 
	
	//无参构造器
	public Bike2(){
		System.out.println("I'm Bike2 - 无参构造器");
	}
	
	
	//1参构造器
	public Bike2(int wheel){
		System.out.println("I'm Bike2 - 1参构造器: "+wheel);
	}
	
	public void say(){
		System.out.println("My color is "+this.color);
	}
}

//这是一个类，表述的是一个公路赛车，它继承于自行车 
class RacingCycle2 extends Bike2{ 
	public int size=50; //会覆盖父类
	public String speed="100"; //公路赛车的速度 
	
	//子类的无参构造器默认是调用的父类的无参构造器。
	public RacingCycle2(){
		super(5);
		//也可以在子类构造器里显式使用super方法调用父类构造器，
		//super方法里写几个参数就可以表示调用的是父类的哪一个构造器。
		
		System.out.println("I'm RacingCycle2 - 无参构造器");
	}
	
	//一般情况下，定义了一个有参的构造器，就应该定义一个无参的构造器。
	@Override 
	public void say(){//方法的覆盖
		System.out.println("I'm My color is Really "+this.color);
	}
}



