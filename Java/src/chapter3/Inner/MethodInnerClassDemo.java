package chapter3.Inner;

public class MethodInnerClassDemo {
/**
 * 局部内部类只能在方法中调用，作用有限吧？
 * @param args
 */
	public static void main(String[] args) {
		Out out=new Out();//创建外部类对象
		out.demo1();//调用内部类中成员
	}
}

class Out{
	String name="OutName para";
	void demo1(){
		/**
		 * 局部内部类
		 */
		int i=1000;
		class Bike{
			int wheel=20;
			void say(){
				System.out.println("say from Bike");
				System.out.println(name);//访问外部类属性
				System.out.println(i);//访问外部类方法中的局部变量
			}
		}
		Bike bike=new Bike();
		System.out.println(bike.wheel);//访问内部类属性
		bike.say();//访问内部类方法
	}
}