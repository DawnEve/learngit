package chapter3.Inner;

/**
①生成内部类对象，必须要先有外围类对象，具体的做法请见代码；
②内部类能访问外围类的私有成员
 * @author admin
 */
public class InnerDemo {

	public static void main(String[] args) {
		OutterClass oc=new OutterClass();
		OutterClass.InnerClass ic=oc.new InnerClass();//内部类的实例化
		ic.displayPrivate();
		
		oc.sayInner();
	}
}


//外部类
class OutterClass {
	private int i = 3;
	
	//内部类
	class InnerClass {
		int j=5;
		int i=300;
		//内部类能访问外部类的所有成员，包括私有成员
		public void displayPrivate() {
			System.out.println("内部类中的i="+i);//访问的是自己的i
			
			//想访问外部类中的i怎么办？
			/**
			 * 要想访问外部类成员变量，就需要首先创建一个外部类对象，然后使用该对象调用外部类成员变量。
			 */
			OutterClass oc=new OutterClass();
			System.out.println("外部类中的i="+oc.i);
		}
	}
	
	void sayInner(){
		InnerClass ic=new InnerClass();
		System.out.println(ic.j);
	}
}

