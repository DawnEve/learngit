package chapter1;

/**
 * 基本数据类型
 * */
public class VarMax {
	public static void main(String[] args) {
//		demo1();
//		demo2();
		demo3();
	}
	
	//最值+1会溢出，变成-最值
	private static void demo3() {
		System.out.println('你'); //unicode 国际标准编码表
		System.out.println('你'+0); //20320
		
		int x=0;
		int x2=Integer.MAX_VALUE;
		x=x2+1;
		System.out.println(x2);//2147483647
		System.out.println(x); //-2147483648
	}

	// 类型转换
	private static void demo2() {
		byte a=124;
		byte b=100;
		//byte c=a+b; //报错 Type mismatch: cannot convert from int to byte
		byte c= (byte)(a+b); //只有int和double才能相加而类型不变！否则必须强制类型转换
		System.out.println(c); //-32
		
	}

	// int 的极值
	private static void demo1() {
		int i=Integer.MAX_VALUE;
		System.out.println(i); //2147483647
		System.out.println(Integer.MIN_VALUE); //-2147483648
		
		//几个二进制位（bit）
		System.out.println(Integer.SIZE); //32
		System.out.println(Byte.SIZE); //8 bits
		
		System.out.println(Byte.BYTES); //1 byte
	}

}
