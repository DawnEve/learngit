package chapter3;

public class Oop1 {
	public static void main(String[] args){
		Bike b=new Bike();
		System.out.println(b.getWheel());
		System.out.println(b.getColor());
		
		//继承后也能共享变量和方法
		RacingCycle b2=new RacingCycle("Green");
		System.out.println(b2.getWheel());
		System.out.println(b2.getColor());
	}

}


/**
 * 自行车类
 * @author admin
 *
 */
class Bike{
	private int wheel=4;//成员变量
	protected String color="grey";
	
	public int getWheel(){
		return this.wheel;
	}
	public String getColor(){
		return this.color;
	}
}

/**
 * 继承Bike类的赛车类 
 * @author admin
 *
 */
class RacingCycle extends Bike{
	//构造器必须与类同名
	public RacingCycle(){
		this.color="red"; 
	}
	
	//每个类可以有一个以上的构造器
	//构造器可以有0个、1个或1个以上的参数
	public RacingCycle(String color){
		this.color=color; 
		//构造器没有返回值
		//构造器总是伴随着new操作一起调用
	}
	
}
