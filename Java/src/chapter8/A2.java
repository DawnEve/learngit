package chapter8;

import java.io.FileInputStream;
import java.io.IOException;

public class A2 {
	public static void main(String[] args) throws IOException {
//		demo1();
		demo2();
	}

	// 读取整个文件
	private static void demo2() throws IOException {
		FileInputStream fis=new FileInputStream("src//dustbin//A2.txt");
		int temp;
		while( (temp=fis.read()) != -1 ) {
			System.out.print((char) temp);
		}
	}

	//读取文件 的一个字符
	private static void demo1() throws IOException {
		//1. 创建连接
		FileInputStream fis=new FileInputStream("src/dustbin/A2.txt");
		
		//2. 读取内容
		int read = fis.read();
		System.out.println(read); //116
		
		//如果不想看到数字，想看到字符呢？强转
		System.out.println((char)read); //t
		
		//3. 关闭资源
		fis.close();
	}

}
