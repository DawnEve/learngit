package chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdIO {
	public static void main(String[] args) throws IOException {
//		demo1();
//		demo2();
		demo3();
	}

	// 输出到控制台
	private static void demo3() {
		int b='A';
		System.out.write(b);
		System.out.write('\n');
	}

	//从命令行 读取字符串
	private static void demo2() throws IOException {
		//分两步写
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		
		String str;
		System.out.println("输入一行文字，输入一行\"end\"结束");
		do {
			str=br.readLine();
			System.out.println(str);
		}while(!str.equals("end"));
	}

	//从命令行 读取字符
	private static void demo1() throws IOException {
		// 把System.in 包装在一个 BufferedReader中创建一个字符流
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("输入字符，按下q键退出");
		char c;
		do {
			c=(char) br.read();
			System.out.println(c);
		}while(c!='q');
	}
}
