package chapter8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class G2 {
	public static void main(String[] args) throws IOException {
//		demo1(); //压缩文件
		demo2(); //压缩文件夹
	}
		
	// 压缩一个文件夹
	private static void demo2() throws IOException {
		//1. 要压缩的文件夹
		File src = new File("dustbin//box//");
		//2. 目的地: 上一个文件夹的根目录
		File destParent = src.getParentFile();
		//System.out.println(destParent);
		//3.创建压缩包的路径
		File dest=new File(destParent, src.getName() + ".zip");
		//System.out.println(dest); //myio/box.zip
		
		//4.压缩流
		ZipOutputStream zos =new ZipOutputStream(new FileOutputStream(dest));
		//5.获取src中的每个文件，作为 ZipEntry对象，放到压缩包中
		System.out.println("src.getName=" + src.getName()); 
		// src.getName() 丢弃前面的路径，只留下最后一个文件夹或文件名
		toZip2(src, zos, src.getName()); //递归
		//6.释放资源
		zos.close();
		System.out.println("End");
	}

	/*
	 * 作用: 获取 src 里面的每一个文件，变成 ZipEntry 对象，放入压缩包当中
	 * 参数1: 数据源
	 * 参数2: 压缩流
	 * 参数3: 压缩包内部的路径
	 **/
	private static void toZip2(File src, ZipOutputStream zos, String name) throws IOException {
		//1.进入 src 文件夹，得到文件or目录列表
		File[] files=src.listFiles();
		//2.遍历数组
		for(File file: files) {
			if(file.isFile()) {
				//3. 判断-文件
//				ZipEntry entry=new ZipEntry(file.toString());
				//最难得部分: 压缩包中的路径名怎么写？
				ZipEntry entry=new ZipEntry(name + "/" + file.getName()); 
				zos.putNextEntry(entry);
				//读取文件，写入压缩包
				FileInputStream fis = new FileInputStream(file);
				int b;
				while((b=fis.read()) != -1) {
					zos.write(b);
				}
				fis.close();
				zos.closeEntry(); //当前文件写入完毕，而不是这个流关闭				
			}else {
				//4. 文件夹?递归
				toZip2(file, zos, name+"/"+file.getName());
			}
		}
	}

	
	

	// 压缩单个文件
	private static void demo1() throws IOException {
		File src=new File("dustbin//a2.txt");
		File dest=new File("dustbin//");
		toZip(src, dest);
	}

	/*
	 * 压缩文件
	 * 文件
	 * 目的地
	 * */
	private static void toZip(File src, File dest) throws IOException {
		//1. 创建压缩流关联压缩包
		ZipOutputStream zos = 
				new ZipOutputStream(new FileOutputStream(new File(dest, "a2.zip")));
		//2. 创建ZipEntry对象，表示压缩包里面的每一个文件和文件夹
		ZipEntry entry=new ZipEntry("a3.txt"); //在压缩包中的名字，可以修改
		//3. 把ZipEntry对象写入压缩文件，只是文件结构
		zos.putNextEntry(entry);
		//4.把src文件中的数据写入压缩包中，这是文件内容
		FileInputStream fis = new FileInputStream(src);
		int b;
		while((b=fis.read()) != -1) {
			zos.write(b);
		}
		
		//5. 关闭文件
		fis.close();
		zos.closeEntry();
		
		zos.close();
	}
}
