package chapter8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class CodingDemo {

	public static void main(String[] args) throws IOException {
//		demo1();
//		demo2();
		demo3();

	}

	/**
	 * 内存中操作字符编码格式
	 * @throws UnsupportedEncodingException
	 */
	private static void demo3() throws UnsupportedEncodingException {
		String s = "这是一段中文字符串"; 
		byte[] b = s.getBytes("UTF-8");
		System.out.println(b.toString());//byte格式
		
		String n = new String(b,"UTF-8");//byte[]变成字符
		System.out.println(n);
	}

	private static void demo2() throws IOException {
		String file = "dustbin/stream.txt"; 
		String charset = "UTF-8"; 
		// 读取字节转换成字符
		FileInputStream inputStream = new FileInputStream(file); 
		InputStreamReader reader = new InputStreamReader(inputStream, charset); 
		StringBuffer buffer = new StringBuffer(); 
		char[] buf = new char[64]; 
		int count = 0; 
		try { 
			while ((count = reader.read(buf)) != -1) { 
				buffer.append(buf, 0, count); 
			} 
		} finally { 
			reader.close(); 
		}
		
		System.out.println(buffer);
	}

	/**
	 * 保存文本，设置编码格式
	 * 文本->字节流->文件
	 * http://www.ibm.com/developerworks/cn/java/j-lo-chinesecoding/
	 * @throws IOException
	 */
	private static void demo1() throws IOException {
		String file = "dustbin/stream.txt"; 
		String charset = "UTF-8"; 
		// 写字符换转成字节流
		FileOutputStream outputStream = new FileOutputStream(file); 
//		FileOutputStream outputStream = new FileOutputStream(file,true);//true表示追加
		OutputStreamWriter writer = new OutputStreamWriter(outputStream, charset); 
		writer.write("这是要保存的中文字符"); 
		writer.close(); 
	}
	
	

}
