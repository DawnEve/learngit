package chapter8;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C2 {
	//测试：4种字节流的拷贝速度比较
	public static void main(String[] args) throws IOException {
		String src="src//dustbin//secret2.png";
		String des="src//dustbin//secret2-backup.png";
		long start = System.currentTimeMillis();
//		demo1(src, des); // 基本字节流，1次1个字节 929ms
//		demo2(src, des); // 基本字节流，1次1个字节数组 114ms
		
//		demo3(src, des); //缓冲字节流，1次1个字节 17ms
		demo4(src, des); //缓冲字节流，1次1个字节数组 5ms
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	
	// 4 缓冲字节流，一次一个字节数组
	private static void demo4(String src, String des) throws IOException {
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(src));
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(des));
		byte[] bytes=new byte[10];
		int len;
		while((len=bis.read(bytes)) != -1) {
			bos.write(bytes, 0, len);
		}
		bos.close();
		bis.close();		
	}

	// 3 缓冲字节流，一次一个字节
	private static void demo3(String src, String des) throws IOException {
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(src));
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(des));
		int b;
		while((b=bis.read()) != -1) {
			bos.write(b);
		}
		bos.close();
		bis.close();		
	}

	//2 基本字节流，一次读取一个字节数组
	private static void demo2(String src, String des) throws IOException {
		FileInputStream fis=new FileInputStream(src);
		FileOutputStream fos=new FileOutputStream(des);
		byte[] bytes=new byte[10];
		int len;
		while((len=fis.read(bytes)) != -1 ) {
			fos.write(bytes, 0, len);
		};
		fos.close();
		fis.close();
	}

	//1 基本字节流，一次一个字节
	private static void demo1(String src, String des) throws IOException {
		FileInputStream fis=new FileInputStream(src);
		FileOutputStream fos=new FileOutputStream(des);
		int b;
		while((b=fis.read()) != -1 ) {
			fos.write(b);
		};
		fos.close();
		fis.close();
	}

}
