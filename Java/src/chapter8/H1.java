package chapter8;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class H1 {
	public static void main(String[] args) throws IOException {
//		demo1(); //复制文件
//		demo2(); //复制文件夹
//		demo3(); //删除文件夹
		demo4(); //清空文件夹
	}
	
	private static void demo4() throws IOException {
		File src=new File("myio//box2");
		FileUtils.cleanDirectory(src); //删除文件夹内的东西，文件夹保留
	}

	private static void demo3() throws IOException {
		File src=new File("myio//box2//box");
		FileUtils.deleteDirectory(src); //把整个文件夹都删除，包括文件夹及其内容
	}

	private static void demo2() throws IOException {
		File src=new File("myio//box/");
		File dest=new File("myio//box2/");
		
		//FileUtils.copyDirectory(src, dest); //复制文件夹 中的内容
		FileUtils.copyDirectoryToDirectory(src, dest); //拷贝文件夹 到另一个文件夹中
	}

	private static void demo1() throws IOException {
		File src=new File("myio//a2.txt");
		File dest=new File("myio//a2-copy.txt");
		
		FileUtils.copyFile(src, dest); //复制文件
	}

}

