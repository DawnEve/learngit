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
		
	}

}

//外部类
class OutterClass {
	private int i = 3;
	
	//内部类
	class InnerClass {
		//内部类能访问外部类的所有成员，包括私有成员
		public void displayPrivate() {
			System.out.println(i);
		}
	}
}

