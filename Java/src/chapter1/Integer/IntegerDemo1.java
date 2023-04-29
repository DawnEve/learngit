package chapter1.Integer;

public class IntegerDemo1 {
	/*
	 * 基本数据类型 包装类。
	 * 为了方便操作基本数据类型，将其封装成了对象，在对象中定义了属性和行为
	 * 丰富了该数据的操作。
	 * 用于描述该对象的类就称为基本数据对象包装类。（8种基本数据类型）
	 * 
	 * byte Byte
	 * short Short
	 * int Integer
	 * long Long
	 * float Float
	 * double Double
	 * char Character
	 * boolean Boolean
	 * 
	 * 该包装对象主要用基本类型和字符串之间的转换。
	 */
	public static void main(String[] args) {
//		demo1();
//		demo2();
//		demo3();
		demo4();
	}

	/*
	 * 在JavaSE5中，为了减少开发人员的工作，Java提供了自动拆装箱功能
	 * 自动装箱： 将基本数据类型自动转化为对应的包装类
	 * 	  自动装箱都是通过包装类的valueOf方法实现的:  Integer.valueOf(5)
	 * 自动拆箱： 将包装类自动转化成对应的基本数据类型
	 * 	  自动拆箱都是通过包装类对象xxxValue方法实现的(如 intValue): num3.intValue()
	 */
	private static void demo4() {
		//jdk1.5之后可以简化书写
		int num=4;
		Integer num2=4; //num2=new Integer(4);自动装箱 简化书写
		Integer num3=new Integer(4);
		
		//先将包装类进行 拆箱 成基本数据类型
		System.out.println(num==num2); //true
		System.out.println(num==num3); //true 对象自动拆箱
		System.out.println(num==num3.intValue()); //true 手动拆箱
		System.out.println();
		
		num=num+5;
		num2+=5; //自动拆箱，计算
		// 字面量，没有方法。装箱 后才能调用方法。
		//System.out.println(num.equals(num)); //Cannot invoke equals(int) on the primitive type int
		System.out.println(new Integer(num).equals(num2)); //true 装箱 才有方法
		System.out.println(Integer.valueOf(num).equals(num2)); //true 装箱 才有方法
		
		System.out.println(num2.equals(num)); //true
		System.out.println(num3.equals(num2)); //false
		num3+=5;
		System.out.println(num3.equals(num2)); //true
	}

	/* 包装类不相等，要比较包装类的值
	 * ==是比较引用，也就是hash值。
	 * Integer的equals方法是比较值；
	 * Integer的compareTo方法是返回1，-1,0；
	 */
	private static void demo3() {
		System.out.println(123==123); //true
		
		Integer a1=new Integer("12");
		Integer a2=new Integer("12");
		System.out.println(a1==a2); //false 直接比较，不是同一个对象
		System.out.println(a1.equals(a2)); //true 比较对象的值
		
		System.out.println(a1.compareTo(a2)); //0 比较对象的值
	}

	/* 进制转换：
	 *十进制->其他进制
	 *其他进制-->十进制
	 *	Integer.parseInt("3c", 16)//16-->10
	 * */
	private static void demo2() {
		//转为其他进制
		System.out.println(Integer.toBinaryString(60)); //111100  10进制 to 2进制
		System.out.println(Integer.toOctalString(60)); //74 10->8
		System.out.println(Integer.toHexString(60)); //3c 10->16
		System.out.println(Integer.toString(60)); //60 字符串
		
		//转为10进制
		System.out.println();
		System.out.println(Integer.parseInt("110", 2)); //6  2->10
		System.out.println(Integer.parseInt("110", 10)); //110  10->10
		System.out.println(Integer.parseInt("3c", 16)); //60  16->10
	}
	
	
	/*
	 * 基本类型-->字符串
	 * 		1.基本类型数据值+"";
	 * 		2.用String类中的静态方法valueOf(基本数据型值)
	 * 		3.用Integer类静态方法intValue(基本数据类型); //todo ?? 可能错误
	 * 字符串-->基本类型
	 * 		1.使用包装类中的静态方法 xxx parseXxx（"xxx类型的字符串");
	 * 			int parseInt("Intstring")
	 * 			long parseLong("longstring")
	 * 			...(只有Character类型没有parse方法)
	 * 		2.如果字符串被Interger进行对象的封装，
	 * 			可以使用另一个非静态的方法，intValue(); 将一个Integer对象转成基本数据类型。
	 */
	private static void demo1() {
		//to String
		int num=25;
		System.out.println(num+"this"); //25this
		System.out.println(String.valueOf(60)+5); //605 已转为字符
		// 字符串变二进制
		System.out.println(Integer.toBinaryString(-1)+5); //111111111111111111111111111111115
		
		//String to int
		System.out.println(Integer.MAX_VALUE); //最大值 静态方法
		System.out.println(Integer.parseInt("123")); //方法1
		Integer i=new Integer("1122"); //方法2
		System.out.println(i+9); //1131
		System.out.println(new Float(3.25).intValue()+9); //12
	}
}
