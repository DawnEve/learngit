package chapter8;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		demo1();
//		fileOutputStreamDemo();
//		fileOutputStreamDemo2();//带缓冲的
//		bufferedInputStreamDemo();
	}

	//获取文件细节 
	private static void demo1() {
		File f=new File("dustbin/aa.jpg");
		System.out.println(f.getName());//aa.jpg
		
		System.out.println(f.exists());//true
		System.out.println(f.isFile());//true
		System.out.println(f.isDirectory());//false
		
		System.out.println(f.exists());//是否存在该文件 true
		System.out.println(f.getAbsolutePath());//F:\gitHub\learngit\Java
	}

	/**
	 * 备份二进制文件
	 * 缺点：一次读了所有内容，如果文件太大，消耗内存巨大！
	 * @throws IOException
	 */
	private static void fileOutputStreamDemo() throws IOException {
		File f=new File("dustbin/aa.jpg");
		//读取文件
		FileInputStream fis=new FileInputStream(f);//文件源头
		//System.out.println(fis.available());//26822=27k 文件大小
		FileOutputStream fos=new FileOutputStream("dustbin/aa_backup.jpg");//备份到
		
		byte[] b=new byte[fis.available()];
		fis.read(b);//字节文件读到数组
		fos.write(b);//字节写入新文件
		
		//关闭文件
		fis.close();
		fos.close();
		
		System.out.println("文件已经被更名复制！");
	}
	
	/**
	 * 使用buffer参数读写
	 * 
	 * @throws IOException
	 */
	private static void fileOutputStreamDemo2() throws IOException {
		//读取文件
		FileInputStream fis=new FileInputStream("dustbin/aa.jpg");//文件源头
		//System.out.println(fis.available());//26822=27k 文件大小
		FileOutputStream fos=new FileOutputStream("dustbin/aa_backup2.jpg");//备份到
		
		byte[] buffer=new byte[512];//一次取出的字节数大小,缓冲区大小  
		int length=0;//length的目的在于防止最后一次读取的字节小于buffer长度，  
		while((length=fis.read(buffer))!=-1){
//			fis.read(buffer);//字节文件读到数组
			fos.write(buffer,0,length);//否则会自动被填充0  
		}
		
		//关闭文件
		fis.close();
		fos.close();
		
		System.out.println("文件已经被更名复制！");
	}
	
	//使用缓冲流
	private static void bufferedInputStreamDemo() throws IOException {
		//引入文件
		FileInputStream fis=new FileInputStream("dustbin/aa.jpg");
		FileOutputStream fos=new FileOutputStream("dustbin/aa_backup3.jpg");
		//缓冲包裹
		BufferedInputStream bis=new BufferedInputStream(fis);
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		//缓冲读写
		byte[] buffer=new byte[1024];
		int length=0;
		while((length=bis.read(buffer))!=-1){
			bos.write(buffer,0,length);
		}
		//关闭
		bis.close();
		bos.close();
		fis.close();
		fos.close();
		
		System.out.println("文件已经被更名复制！");
	}

}
