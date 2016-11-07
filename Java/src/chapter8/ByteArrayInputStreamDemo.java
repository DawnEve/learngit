package chapter8;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayInputStreamDemo {

	public static void main(String[] args) throws IOException {
//		demo1();
//		demo2();
		demo3();

	}

	/**
	 * 写入文件
	 * @throws IOException 
	 */
	private static void demo3() throws IOException {
		//==============
		String str="GOODDAY好的";
	    ByteArrayInputStream input=new ByteArrayInputStream(str.getBytes());
	    ByteArrayOutputStream output=new ByteArrayOutputStream();
	    
	    
	    int temp=0;
	    while((temp=input.read())!=-1){
	    	char ch=(char)temp;
	    	System.out.print(ch);
	    	output.write(Character.toLowerCase(ch));
	    }
	    String outStr=output.toString();
	    input.close();
	    output.close();
	    System.out.println();
	    System.out.println(outStr);//输出到终端显示
	    
	    //可以写入文件
	    FileOutputStream fos=new FileOutputStream("dustbin/c1.txt");
//	    byte[] buffer=outStr.getBytes();
	    byte[] buffer=outStr.getBytes("utf8");//设置写入的编码
//	    byte[] buffer=outStr.getBytes("gbk");//设置写入的编码
	    
	    fos.write(buffer);
	    fos.close();
	}

	private static void demo2() throws IOException {
		String str="GOODDAY";
	    ByteArrayInputStream input=new ByteArrayInputStream(str.getBytes());
	    ByteArrayOutputStream output=new ByteArrayOutputStream();
	    int temp=0;
	    while((temp=input.read())!=-1){
	    	char ch=(char)temp;
	    	System.out.print(ch);
	    	output.write(Character.toLowerCase(ch));
	    }
	    String outStr=output.toString();
	    input.close();
	    output.close();
	    System.out.println();
	    System.out.println(outStr);
	}

	/**
	 * 不推荐： 太憋屈了，一个字符一个字符的转换
	 * @throws IOException
	 */
	private static void demo1() throws IOException {
		String str="I AM A MAN";
		ByteArrayInputStream input=new ByteArrayInputStream(str.getBytes());
		ByteArrayOutputStream output=new ByteArrayOutputStream();
		//开始循环
		int len=0;
		//可能不适合这样用循环
		byte[] buffer=new byte[1];//1024
		while((len=input.read(buffer))>0){
			char ch=(char)buffer[0];
			output.write(Character.toLowerCase(ch));
		}
		String outStr=output.toString();
		input.close();
		output.close();
		System.out.print(outStr);
	}

}
