package chapter3;

public class Para2 {
	int i=500;//成员变量
	public static void main(String[] args){
		int i=6; //局部变量
		System.out.println("局部变量i="+i);
		
		Para2 p=new Para2();
		System.out.println("成员变量i="+p.i);
	}
	
	
	
	
}
