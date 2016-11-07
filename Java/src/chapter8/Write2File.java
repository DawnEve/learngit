package chapter8;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class Write2File {

	public static void main(String[] args) throws IOException {
//		demo1();
//		demo2();
		demo3("12345\r\nhello jimmy4\r\n");
	}

	/**
	 * 字节流
	 * 向文件中写入字符串
	 * @throws IOException
	 */
	private static void demo1() throws IOException {
		String word=new String("Hello, world!");
		
		FileWriter fw=new FileWriter("dustbin/cc_2.txt");
		fw.write(word);
		fw.close();
		System.out.println("end");
	}
	
	
	/**
	 * 字节流
	 * 向文件中写入字符串,逐个写入
	 * @throws IOException
	 */
	private static void demo2() throws IOException {
		String word="Hello, world!";
		byte[] b=word.getBytes();
		
		//FileWriter fw=new FileWriter("dustbin/cc_3.txt");//能使用文本的
		OutputStream fw=new FileOutputStream("dustbin/cc_3.txt");//都能够使用字节
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i]);
			fw.write(b[i]);
		}
		fw.close();
	}
	
	
	/**
	 * 字节流 追加
	 * 向文件中追加字符串
	 * @throws IOException
	 */
	private static void demo3(String word) throws IOException {
		byte[] b=word.getBytes();
		
		//FileWriter fw=new FileWriter("dustbin/cc_3.txt",true);//能使用文本的
		OutputStream fw=new FileOutputStream("dustbin/cc_3.txt",true);//true表示追加
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i]);
			fw.write(b[i]);
		}
		fw.close();
	}
	
	

}
