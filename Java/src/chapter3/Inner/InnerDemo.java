package chapter3.Inner;

/**
①生成内部类对象，必须要先有外围类对象，具体的做法请见代码；
②内部类能访问外围类的私有成员
 * @author admin
 */
public class InnerDemo {

	public static void main(String[] args) {
		OuterClass oc=new OuterClass();
		OuterClass.InnerClass ic = oc.new InnerClass(); //内部类的实例化
		ic.displayPrivate();
		
		oc.sayInner();
	}
}

// 外部类
class OuterClass{
	private int i = 3;
	
	// 内部类
	//The type OuterClass.InnerClass is not visible
	//private class InnerClass{ //私有内部类，不能被外部访问OC.IC外界不可见 
	class InnerClass{
		int i=300;
		private int j=5;
		// 内部类能访问外部类的所有成员，包括私有成员
		public void displayPrivate() {
			System.out.println(i); //先使用局部变量
			
			// 像访问外部类中的i怎么办？
			//要想访问外部类成员变量，就需要首先创建一个外部类对象，然后使用该对象调用外部类成员变量。
			OuterClass oc=new OuterClass();
			System.out.println("Outer i="+oc.i);
		}
	}
	
	//外部类 访问内部类的成员，即使是私有成员
	void sayInner() {
		InnerClass ic=new InnerClass();
		System.out.println("inner j=" + ic.j); //5
	}
}