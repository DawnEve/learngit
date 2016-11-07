package chapter8;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamDemo {

	/**
	 * DataOutputStream()将基本 Java 数据类型写入输出流中。
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
//		demo1();
		demo2();
	}

	private static void demo2() throws IOException {
//		File file = new File("d:" + File.separator +"hello.txt");
		File file = new File("dustbin/bb_4.txt");
		char[] ch = { 'A', 'B', 'C','d','1' };
		DataOutputStream out = null;
		out = new DataOutputStream(new FileOutputStream(file));
		
		for(char temp : ch){
			out.writeChar(temp);//为什么会字符左右两端都有空格？
//			out.write(temp);//字符两端没有空格
		}
		
		out.close();
	}

	private static void demo1() throws IOException {
		FileInputStream fis=new FileInputStream("dustbin/bb.txt");
		FileOutputStream fos=new FileOutputStream("dustbin/bb_backup3.txt");
		//使用数据流包装
		DataOutputStream dos=new DataOutputStream(fos);
		int len=0;
		byte[] buffer=new byte[512];
		while((len=fis.read(buffer))!=-1){
//			System.out.println(len+":"+buffer);
			for (int i = 0; i < len; i++) {
				char ch=(char)buffer[i];
//				System.out.print(ch);//显示乱码
				dos.write(ch);//文件本身不乱吗
			}
		}
		dos.close();
		fos.close();
		fis.close();
		
	}

}
