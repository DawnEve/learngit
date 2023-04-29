package chapter4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//异常的捕获

public class ExceptionDemo {
	static public void main(String[] args){
		//System.out.println(args);//[Ljava.lang.String;@2a139a55
//		demo1();
//		demo2(new int[]{1,2,3},5);
		System.out.println(demo3());
	}


	// 多重捕获
	private static int demo3() {
		String fileName="src/dustbin/file10.txt";
		byte x;
		try {
			FileInputStream file = new FileInputStream(fileName);
			x=(byte) file.read();
		}catch (FileNotFoundException  e) {
			e.printStackTrace();
			return -1;
		}catch (IOException  e) {
			e.printStackTrace();
			return -1;
		}
		return x; //116 - t
	}


	//例子: 下标越界。加上 finally 语句
	static void demo2(int[] arr, int at){
		try{
			System.out.println(arr[at]);
		}catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
			System.out.println(arr[arr.length - 1]);
		}finally{
			System.out.println("A text at the end of try...catch...finally.");
		}
	}
	
	// 捕获报错: 下表越界
	private static void demo1() {
		try {
			int a[]=new int[2];
			System.out.println("Access a[3]="+a[3]);
		}catch (ArrayIndexOutOfBoundsException  e) {
			System.out.println("Exception thrown: " + e);
		}
		System.out.println("out of the block");
	}
}
