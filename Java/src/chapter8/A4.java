package chapter8;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class A4 {
	public static void main(String[] args) throws UnsupportedEncodingException {
//		demo1();
//		demo2();//jdk7 写法
//		demo3(); //jdk9 写法；不支持
		
//		demo4();//编码方式: utf8 的二进制
//		print_byte((byte)'A');
		
//		demo5();//汉字的其他编码方式
		demo6(); //汉字的编码与解码
		
	}

	// 汉字的编码与解码
	private static void demo6() throws UnsupportedEncodingException {
		String str1 = "is你";
		//编码
		byte[] bytes1 = str1.getBytes();
		System.out.println(Arrays.toString(bytes1));
		
		byte[] bytes2 = str1.getBytes("GBK");
		System.out.println(Arrays.toString(bytes2));
		
		//解码
		System.out.println(new String(bytes1));
		System.out.println(new String(bytes2)); //乱码
		System.out.println(new String(bytes2, "GBK"));
	}

	// 汉字的编码，utf-8编码用3字节，gbk用2字节
	private static void demo5() throws UnsupportedEncodingException {
		String str1 = "is你";
		byte[] bytes = str1.getBytes("GBK");
		System.out.println(bytes.length); //4 汉字 gbk是2字节
		System.out.println(Arrays.toString(bytes)); //[105, 115, -60, -29]
		
		for(byte ele: bytes) {
			print_byte(ele);
		}
	}

	//编码方式: utf8 的二进制
	private static void demo4() {
		String str1="is你";
		byte[] bytes = str1.getBytes();
		System.out.println(bytes.length); //utf-8编码，ascii码1字节，汉字3字节
		
		//打印字节 对应的数字
		System.out.println(Arrays.toString(bytes));
		System.out.println(Integer.toBinaryString(0xff) + "<<");
		
		//打印字节 二进制。只保留低8位
		for(byte ele: bytes) {
			// System.out.println(Integer.toBinaryString(ele));
//			System.out.println(Integer.toBinaryString(ele & 0xFF));
			print_byte(ele); //手动实现
		}
	}

	// 打印二进制为数组形式，保留前面的0
	private static void print_byte(byte ele) {
		//System.out.println(Integer.toBinaryString(ele));
		
		StringBuffer sb=new StringBuffer();
		
		for(int i=7; i>=0; i--) {
			sb.append( (ele & (1<<i)) >0?"1":"0" );
		}
		System.out.println( sb.toString() );
	}

	// 基本写法
	private static void demo1() {
		//使用 try catch 捕获异常
		FileInputStream fis=null;
		
		try {
			fis = new FileInputStream("src//dustbin//A2.txt");
			int read = fis.read();
			System.out.println((char)read);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {//一定会执行，除非try中执行了 exit 退出jvm虚拟机
			if(fis != null) { //防止空指针异常
				try {
					fis.close(); //java.lang.NullPointerException
				} catch (IOException e) {
					e.printStackTrace();
				} //还可能继续报错
			}
		}
		
		System.out.println("end 1");
	}
	
	
	// jdk7写法，多个流时，try()后括号十分拥挤
	private static void demo2() {		
		try(FileInputStream fis=new FileInputStream("src//dustbin//A2.txt")) {
			int read = fis.read();
			System.out.println((char)read);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("end 2");
	}
	
	// jdk9写法，多个流时，try()后只写流变量，使用分号隔开
	/*
	private static void demo3() {
		FileInputStream fis=new FileInputStream("src//dustbin//A2.txt");
		try(fis) {
			int read = fis.read();
			System.out.println((char)read);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("end 2");
	}
	*/

}
