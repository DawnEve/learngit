package chapter8;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class F1 {
	public static void main(String[] args) throws IOException {
//		demo1(); //字节 打印流
//		demo2(); //字符 打印流
		demo3(); //打印流和控制台输出的关系？
	}

	private static void demo3() throws IOException {
		System.out.println(System.out); //java.io.PrintStream@6bf2d08e
		
		//可以把常规的控制台输出拆分成2句话:
		PrintStream ps = System.out; //系统启动时自动创建，指向标准输出流
		ps.println("hello, 世界"); //println 三个功能：写出数据，自动环行，自动刷新
		//ps.close(); //该流不能关闭，否则接下来的输出语句失效
		
		//手动创建 指向标志输出的流
//		PrintStream ps2=new PrintStream(new FileOutputStream("/dev/stdout"), true); //linux
		// win 下的标准输出怎么写？ //todo
		PrintStream ps2=new PrintStream(new FileOutputStream("stdout"), true);
		ps2.println("the 3rd line");
	}

	//字符 打印流
	private static void demo2() throws IOException {
		PrintWriter pw=new PrintWriter(new FileWriter("dustbin//a2.txt"), true);
		pw.println("陌上花开，可迟迟归矣。"); //不关流，也能保存，因为设置了 autoFlush=true
		pw.print(false); // 打印字面量
		pw.printf("-%s:%d", "Tom", 20);
		pw.close();
	}

	// 字节 打印流
	private static void demo1() throws IOException {
		PrintStream ps = new PrintStream(new FileOutputStream("dustbin//a.txt"), true);
		ps.println(97);
		ps.print(false);
		ps.printf("-%s:%d", "Tom", 20);
		ps.close();
	}
}

