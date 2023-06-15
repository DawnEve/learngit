package chapter8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class D2 {
	public static void main(String[] args) throws Exception {
		demo1(); //利用字节流读取文件，一次读取一行，不能乱码
	}

	// 利用字节流读取文件，一次读取一行，不能乱码
	private static void demo1() throws IOException {
		/*
		 * 字节流读取文件: FileInputStream
		 * 一次读取一行 readLine，只有 BufferedReader 才有该方法
		 * 两个之间的桥梁: InputSstreamReader
		 * */
		String src="src//dustbin//GBK.txt";
		InputStreamReader isr=
				new InputStreamReader(new FileInputStream(src), "GBK");
		BufferedReader br=new BufferedReader(isr);
		String line;
		while((line=br.readLine()) != null) {
			System.out.println("> " + line);
		}
		
		br.close();
		isr.close();
	}
}
