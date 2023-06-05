package chapter8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class A1 {
	// 写入文件
	
	public static void main(String[] args) throws IOException {
//		demo1();
//		demo2();
		demo3();
//		demo4();
	}
	
	
	// 追加内容
	private static void demo4() throws IOException {
		FileOutputStream fos=
				new FileOutputStream("src//dustbin//A1.txt", true);
		fos.write(new byte[] {'\n','n', 'e', 'w', 'l', 'i', 'n', 'e'});
		fos.close();
	}



	// 换行
	private static void demo3() throws IOException {
		FileOutputStream fos=new FileOutputStream("src//dustbin//A1.txt");
		//fos.write(new byte[] {'a', 'b', 'c', '\n', '1', '2', '3'});
		
		//写法2: 字符串合并，字符串转为字节数组
		String str1="abc", str2="123";
		byte[] arr= (str1+'\n'+str2).getBytes();
		System.out.println(Arrays.toString(arr)); //确实是字节数组
		//[97, 98, 99, 10, 49, 50, 51]
		fos.write(arr);
		
		fos.close();
	}


	// 一次写多个字符
	private static void demo2() throws IOException {
		//1 创建对象
		FileOutputStream fos=new FileOutputStream("src//dustbin//A1.txt");
		
		//2 写入数据
		//声明数组
		byte[] arr=new byte[] {'a', 'b', 'c', 'd', '5'};
		//fos.write(arr);
		fos.write(arr, 1, 3);
		
		//3 关闭资源
		fos.close();
		System.out.println("end 2");
	}
	

	private static void demo1() throws IOException {
		//1 创建对象
		FileOutputStream fos=new FileOutputStream("src//dustbin//A1.txt");
		
		//2 写入数据
		fos.write(97);
		fos.write('b');
		
		//3 关闭资源
		fos.close();
		System.out.println("end");
	}
	
	
}
