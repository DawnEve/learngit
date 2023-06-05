package chapter8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class A3 {
	//统计运行时间
	public static void main(String[] args) throws IOException {
		long time1=System.currentTimeMillis();
//		copy_file();
		copy_file2();
		long time2=System.currentTimeMillis();//单位 毫秒
		System.out.println("time elapse: "+ (time2-time1) );
	}

	// 带缓存的读取，速度特别快
	private static void copy_file2() throws IOException {
		//1.打开文件
		FileInputStream fis=new FileInputStream("src//dustbin//A2.txt");
		FileOutputStream fos=new FileOutputStream("src//dustbin//A2-back.txt");
		
		//2.读写文件
		byte[] buffer=new byte[8]; //实际使用时，设置为 1024 的整数倍
		int len; //返回值是读取的长度
		while((len=fis.read(buffer)) != -1) {
			//接收三个参数:arr,offset,len
			String str=new String(buffer, 0, len); 
			System.out.println( ">[" + len + "]: " + str ); 
			fos.write(buffer, 0, len);
		}
		
		//3.关闭资源
		//一般的，先开的流最后关闭
		fos.close();
		fis.close();
		System.out.println("done! 2");
	}

	//逐字节拷贝，比较慢
	private static void copy_file() throws IOException {
		//1.打开文件
		FileInputStream fis=new FileInputStream("src//dustbin//A2.txt");
		FileOutputStream fos=new FileOutputStream("src//dustbin//A2-back.txt");
		
		//2.读写文件
		int buffer;
		while((buffer=fis.read()) != -1) {
			fos.write(buffer);
		}
		
		//3.关闭资源
		//一般的，先开的流最后关闭
		fos.close();
		fis.close();
		System.out.println("done!");
	}
}
