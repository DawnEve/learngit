package chapter3;

public class Computer {
	public static void main(String[] args){
		Computer c=new Computer();
		//USB u=new USB();
		USB u=new Upan();
		c.start(u); 
	}
	public void start(USB u){
		System.out.print("Computer start > ");
		u.run();
	}
}


//父类
class USB{
	public void run(){
		System.out.println("USB run...");
	}
}

//具体的USB设备，继承USB
class Upan extends USB{
	public void run(){
		System.out.println("Upan run...");
	}
}
