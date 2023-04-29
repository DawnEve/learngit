package chapter8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class FileInputStreamDemo {
	public static void main(String[] args) throws IOException {
//		demo1();
//		demo2();
//		demo3();
		demo4();
	}

	// 实例2: 可读写中文，解决乱码
	private static void demo4() throws IOException {
		//1. 写入文件，包含中文
		//打开文件
		File f=new File("src/dustbin/file4.txt");
		FileOutputStream fos=new FileOutputStream(f); //字节流
		
		//字节流转字符流，可指定编码
		OutputStreamWriter writer=new OutputStreamWriter(fos, "UTF-8");
		
		//输入
		writer.append("中文输入");
		writer.append("\r\n");//换行
		writer.append("English line");
		
		//关闭文件
		writer.close();//关闭写入流：缓冲区写入文件
		fos.close(); //关闭输出流
		
		//2. 读取文件
		FileInputStream fis=new FileInputStream(f); //字节流
		InputStreamReader reader=new InputStreamReader(fis, "UTF-8"); //转字符流，可指定编码
		
		StringBuffer sb=new StringBuffer(); //缓冲
		while(reader.ready()) {
			sb.append( (char)reader.read() ); //读取的是字节? 这不是字符流吗? //todo
		}
		
		System.out.println(sb.toString());
		reader.close();
		fis.close();
	}

	
	// 写入文件3，再读取并打印：写入二进制、读取二进制
	private static void demo3() throws IOException {
		//1. 写入文件
		byte bWrite[]= {11,21,3,40,5};
		OutputStream os=new FileOutputStream("src/dustbin/file3.txt");
		for(int i=0; i<bWrite.length; i++) {
			os.write(bWrite[i]); //write the byte
		}
		os.close();
		
		//2. 读取，并打印到屏幕
		InputStream is=new FileInputStream("src/dustbin/file3.txt");
		int size=is.available();
		System.out.println(size);
		
		for(int i=0; i<size; i++) {
			int x=is.read();
			System.out.println(x+" "+ (char)x); //数字正确读出，有些ascii不可打印
		}
		is.close();
	}

	// 写文件
	private static void demo2() throws IOException {
		// 方法1 打开文件
		OutputStream os=new FileOutputStream("src/dustbin/file2.txt");
		// 方法2
		File f=new File("src/dustbin/file2.txt");
		//OutputStream os=new FileOutputStream(f);
		
		//开始写入
		char[] arr= {'t', 'h', 'i', 's', ' ', 'i', 's', ' ','a', '.'};
		for(char x : arr) {
			os.write(x);
		}
		
		os.close();
		System.out.println("Done");
	}

	// 多种构造方法，读文件
	private static void demo1() throws IOException {
		// 方法1: 文件名字符串.
		//注意：路径是相对于src的！
		//InputStream is=new FileInputStream("src/dustbin/file1.txt");
		
		// 方法2: 
		File f=new File("src/dustbin/file1.txt");
		InputStream is=new FileInputStream(f);
		
		// 打印到屏幕
		int a;
		while( (a=is.read())!=-1 ) {
			System.out.print((char)a);
		}
		is.close();
	}
}
