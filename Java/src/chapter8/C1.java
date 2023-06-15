package chapter8;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class C1 {
	public static void main(String[] args) throws IOException {
//		demo1(); //字节缓冲流，拷贝数据
//		demo2(); //字节缓冲流，一次操作多个字节
		
		demo3(); //字符缓冲流
	}

	// 字符缓冲流，拷贝数据
	private static void demo3() throws IOException {
		//1 打开资源
		BufferedReader br=new BufferedReader(new FileReader("src//dustbin//B1.txt"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("src//dustbin//B1-back.txt"));
		//2 拷贝
		/*
		int b;
		while((b=br.read()) != -1) {
			bw.write(b);
		}
		*/
		// 整行读取
		//String line = br.readLine();
		//System.out.println(line);
		String line=null;
		while((line=br.readLine()) != null) {
			bw.write(line);//只有这一行，则没有换行符
			bw.newLine(); //该方法是 BufferedWriter 特有的。
			//缺点：不好判断最后一行后是否有换行
		}
		
		//3 关闭资源
		bw.close();
		br.close();
	}

	// 一次操作多个字节
	private static void demo2() throws IOException {
		//1 打开文件，关联底层流
		BufferedInputStream bis=new BufferedInputStream(
				new FileInputStream("src//dustbin//B1.txt"));
		BufferedOutputStream bos=new BufferedOutputStream(
				new FileOutputStream("src//dustbin//B1-back.txt"));
		//2 开始复制: 逐个字节复制
		byte[] bytes=new byte[1025];
		int len;
		while((len=bis.read(bytes)) != -1) {
			bos.write(bytes, 0, len);
		}
		//3 释放资源
		bos.close();
		bis.close();
	}

	// 拷贝数据
	private static void demo1() throws IOException {
		//1 打开文件，关联底层流
		BufferedInputStream bis=new BufferedInputStream(
				new FileInputStream("src//dustbin//B1.txt"));
		BufferedOutputStream bos=new BufferedOutputStream(
				new FileOutputStream("src//dustbin//B1-back.txt"));
		//2 开始复制: 逐个字节复制
		int b;
		while((b=bis.read()) != -1) {
			bos.write(b);
		}
		//3 释放资源
		bos.close();
		bis.close();
	}

}
