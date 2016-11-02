package chapter3.Inner;
import static chapter2.Dog.say;
//or import static chapter2.Dog.*;

public class ImportStatic {
	//引用另一个包中类中的静态方法。import static 包.类.静态方法
	public static void main(String[] args){
		say();
	}
}
