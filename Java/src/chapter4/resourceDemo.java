package chapter4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class resourceDemo {
	public static void main(String[] args) {
//		demo1();
//		demo2();
		demo3();
	}

	// try-with-resources 可处理多个资源，使用;分割
	private static void demo3() {
		// 打开2个资源，Scanner作为输入，读取文件;
		// 写入 文件 PringWriter 
		try(Scanner scanner=new Scanner(new File("src/dustbin/file1.txt"));
				PrintWriter writer=new PrintWriter(new File("src/dustbin/fileP.txt"))
				){
			while(scanner.hasNext()) {
				String str=scanner.nextLine();
				System.out.println(str);
				writer.print( str+"\n" ); //如何保证换行？
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done");
	}

	// 使用try...catch...finally则要繁琐很多，需要两次try catch
	private static void demo2() {
		String line, fileName="src/dustbin/file10.txt";
		
		BufferedReader br=null;
		try{
			System.out.println("> Enter try block");
			br=new BufferedReader(new FileReader(fileName));
			while( (line=br.readLine())!=null) {
				System.out.println("line=>"+line);
			}
		}catch (IOException e) {
			System.out.println("IOException in try block=>"+ e.getMessage());
		}finally {
			System.out.println("> Enter finally block");
			try {
				if(br != null) {
					br.close(); //关闭可能有异常，所以需要再次捕获
				}
			} catch (IOException e) {
				System.out.println("IOException in finally block=>" + e.getMessage());
			}
		}
	}

	// try-with-resource from JDK1.7
	private static void demo1() {
		String line, fileName="src/dustbin/file10.txt";
		try(BufferedReader br=new BufferedReader(new FileReader(fileName))){
			while( (line=br.readLine())!=null) {
				System.out.println("line=>"+line);
			}
		}catch (IOException e) {
			System.out.println("IOException in try block=>"+ e.getMessage());
		}
	}
}
