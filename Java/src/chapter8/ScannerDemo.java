package chapter8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerDemo {
	public static void main(String[] args) {
//		demo1();
//		demo2();
//		demo3();
//		demo4();
		demo5();
	}

	// 从文件读
	private static void demo5() {
		try(Scanner scanner = new Scanner(new File("src/dustbin/file1.txt"))) {
			while(scanner.hasNextLine()){
				System.out.print( scanner.nextLine()+"\n" );
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Done");		
	}

	//输入多个数，求总和和平均值
	private static void demo4() {
		Scanner scan = new Scanner(System.in);
		System.out.println("输入数字并回车(输入非数字回车结束输入):");
		double sum=0;
		int m=0;
		
		while(scan.hasNextDouble()) {
			double x=scan.nextDouble();
			m++;
			sum+=x;
		}
		scan.close();
		
		System.out.println("total:"+ sum);
		System.out.println("average:"+ sum/m );
	}

	//读入整数
	private static void demo3() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input an int or float:");
		int i=0;
		float f=0.0f;
		if(scan.hasNextInt()) {
			i=scan.nextInt();
			System.out.println("int:"+ i);
		}else if(scan.hasNextFloat()){
			f=scan.nextFloat();
			System.out.println("float:"+f);
		}else {
			System.out.println("Input Error: not int/float");
		}
		scan.close();
	}

	//读取一行
	private static void demo2() {
		//1.创建
		Scanner scan = new Scanner(System.in);
		
		System.out.println("从键盘输入:");
		//2.判断是否有输入
		if(scan.hasNextLine()) {
			//3.读取
			String str=scan.nextLine();
			System.out.println("输入的数据为: "+str);
		}
		//4.关闭
		scan.close();
	}

	//接收一个字符出
	private static void demo1() {
		//1.创建
		Scanner scan = new Scanner(System.in);
		
		System.out.println("从键盘输入:");
		//2.判断是否有输入
		if(scan.hasNext()) {
			//3.读取
			String str=scan.next();
			System.out.println("输入的数据为: "+str);
		}
		//4.关闭
		scan.close();
	}

}
