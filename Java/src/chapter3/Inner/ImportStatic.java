package chapter3.Inner;
import static chapter2.Dog.say;
//or import static chapter2.Dog.*;
import static java.lang.System.out;

public class ImportStatic {
	//引用另一个包中类中的静态方法。import static 包.类.静态方法
	public static void main(String[] args){
		say();
		out.print("good");
		System.out.print(123);
	}
}
