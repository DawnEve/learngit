package chapter4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ThrowDemo {
	public static void main(String[] args) throws IOException {
//		demo1(-5);
		demo2();
	}

	// 方法声明种使用 throws 关键字
	private static void demo2() throws IOException {
		BufferedReader reader=new BufferedReader(new FileReader("src/dustbin/file1.txt"));
		String line=reader.readLine();
		while(line != null) {
			System.out.println(line);
			line=reader.readLine();
		}
		reader.close();		
	}

	// 抛出异常，代码中使用 throw
	private static void demo1(int i) {
		if(i<=0) {
			throw new IllegalArgumentException("Number must be positive!");
		}
	}

}
