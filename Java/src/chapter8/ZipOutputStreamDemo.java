package chapter8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamDemo {

	public static void main(String[] args) throws IOException {
//		demo1();//压缩一个文件
		demo2();//压缩多个文件？？失败
	}

	//并没有压缩到一个文件，而是合并到一个文件了
	private static void demo2()throws IOException {
		File file1=new File("dustbin/bb.txt");
		File file2=new File("dustbin/bb_backup2.txt");
		File zipfile=new File("dustbin/bb2.zip");
		
		InputStream input1=new FileInputStream(file1);
		InputStream input2=new FileInputStream(file2);
		 // 合并流
        SequenceInputStream input = new SequenceInputStream(input1, input2);
        
		ZipOutputStream zipOut=new ZipOutputStream(new FileOutputStream(zipfile));
		
		//必须先设置entry
		zipOut.putNextEntry(new ZipEntry(file1.getName()));
		//设置注释
		zipOut.setComment("my note here");
		int temp=0;
		while((temp=input.read())!=-1){
			zipOut.write(temp);
		}
		
		input1.close();
		input2.close();
		input.close();
		zipOut.close();
	}

	/**
	 * 压缩一个文件
	 * @throws IOException
	 */
	private static void demo1() throws IOException {
		File file=new File("dustbin/bb.txt");
		File zipfile=new File("dustbin/bb.zip");
		
		InputStream input=new FileInputStream(file);
		ZipOutputStream zipOut=new ZipOutputStream(new FileOutputStream(zipfile));
		
		//必须先设置entry
		zipOut.putNextEntry(new ZipEntry(file.getName()));
		//设置注释
		zipOut.setComment("my note here");
		int temp=0;
		while((temp=input.read())!=-1){
			zipOut.write(temp);
		}
		
		input.close();
		zipOut.close();
	}

}
