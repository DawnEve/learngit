package chapter8;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class B1 {
	public static void main(String[] args) throws IOException {
//		demo1();// 读取文件
//		demo2(); //带参数read()方法
//		demo3(); //写入文件，逐个字符写入
//		demo4(); //写入字符串或字符数组
		demo5(); //续写
	}
	
	//续写文件: 创建连接时添加第二个参数 true
	private static void demo5() throws IOException {
		FileWriter fw=new FileWriter("src//dustbin//B2.txt", true);
		fw.write("新的函数");
		fw.close();		
	}

	// 写入文件：写入字符串或字符数组，或其部分
	private static void demo4() throws IOException {
		FileWriter fw=new FileWriter("src//dustbin//B2.txt");
		//写入字符串
		String str1="你好，java";
		fw.write(str1);
		//写入字符串的一部分
		fw.write("\n");
		fw.write(str1, 0, 2); //写入2个字符
		//写入字符数组
		char[] chars={'你', '好', 'A', 'I'};
		fw.write("\n");
		fw.write(chars);
		//写入字符数组 的一部分
		fw.write("\n");
		fw.write(chars, 2, 2);
		
		fw.close();
	}

	// 写入文件：逐个字符
	private static void demo3() throws IOException {
		//1.打开资源
		FileWriter fw=new FileWriter("src//dustbin//B2.txt");
		//2.写入内容
		fw.write(97); //参数是整数，写入的是a
		
		//写入汉字呢
		byte[] bytes = "我".getBytes("UTF-8");
		System.out.println( Arrays.toString(bytes) ); //汉字的二进制编码 [-26, -120, -111]
		
		int code=(int)'我'; //汉字对应的编码
		System.out.println( code ); //25105
		fw.write(code); //写入的是一个汉字
		//3.关闭资源
		fw.close(); //查看文件属性，确实是4字节：1个英文(1字节)，1个汉字(3字节)
	}

	// 读文本文件：带数组参数的 read(char[] buffer)
	private static void demo2() throws IOException {
		//1 创建连接
		FileReader fr=new FileReader("src//dustbin//B1.txt");
		//2 读取数据
		char[] buffer=new char[2];
		int len;
		while((len=fr.read(buffer)) != -1) {
			System.out.println( new String(buffer, 0, len));
		}
		//3 释放资源
		fr.close();
	}
	

	// 读文本文件：空参 read()
	private static void demo1() throws IOException {
		//1 创建连接
		FileReader fr=new FileReader("src//dustbin//B1.txt");
		//2 读取数据
		//int read = fr.read();
		//read()返回的是整数！前面加char强转才是字符
		//System.out.println(read);//28180 

		int tmp;
		while((tmp=fr.read()) != -1) {
			System.out.print((char)tmp);
		}		
		//3 释放资源
		fr.close();
	}

}
