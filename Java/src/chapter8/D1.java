package chapter8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

//转换流，后缀是字节流。
public class D1 {
	//转换文件编码
	public static void main(String[] args) throws IOException {
//		demo1(); //手动创建GBK文件，读取到内存，不能乱码(jdk11淘汰了该方案)
//		demo1n();//jdk11 替代方案
		
//		demo2(); //指定编码保存文件
//		demo3(); //综合练习：本地GBK文件，转存为 utf-8 格式
	}


	// 综合练习：本地GBK文件，转存为 utf-8 格式
	//jdk11支持参数2 FileWriter fw=new FileWriter("des", Charset.forName("UTF-8"));
	private static void demo3() throws IOException {
		//打开文件
		String src="src//dustbin//GBK.txt";
		String des="src//dustbin//UTF-8.txt";
		InputStreamReader isr=new InputStreamReader(new FileInputStream(src), "GBK");
		OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream(des), "UTF-8");
		
		
		//转码
		char[] chars=new char[24];
		int len;
		while((len=isr.read(chars)) != -1) {
			osw.write(chars, 0, len);
		}
		
		//关闭资源
		osw.close();
		isr.close();
	}

	// 指定编码写出文件，如 GBK (jdk11 淘汰)
	// jdk11 新增构造函数 FileWriter(file, charsetName);
	private static void demo2() throws IOException {
		OutputStreamWriter osw = new OutputStreamWriter(
				new FileOutputStream("src//dustbin//GBK2.txt"), "GBK");
		osw.write("良辰美景,good");
		osw.close();
	}

	// jdk11替代方案
	private static void demo1n() throws IOException {
		//第二个参数是 jdk11开始支持的
		//FileReader fr=new FileReader("src//dustbin//GBK.txt", Charset.forName("GBK"));
		// Charset.forName("GBK");
	}

	// 手动读取GBK文件，读取到内存，不能乱码(<jdk11)
	private static void demo1() throws IOException {
		InputStreamReader isr=
				new InputStreamReader(new FileInputStream("src//dustbin//GBK.txt"), "GBK");
		int ch;
		while((ch=isr.read()) != -1) {
			System.out.print((char)ch);
		}
		isr.close();
	}
	
	// 

}
