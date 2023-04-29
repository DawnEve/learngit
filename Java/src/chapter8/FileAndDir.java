package chapter8;

import java.io.File;

public class FileAndDir {
	public static void main(String[] args) {
//		demo1();
//		demo2();
		demo3();
	}

	// 删除文件或目录，目录必须空
	private static void demo3() {
		File folder=new File("src/dustbin/temp");
		if(folder.list().length==0) {
			folder.delete();
			System.out.println("delete now.");
		}else {
			System.out.println("Not empty");
			deleteR(folder);
		}
	}
	// 删除文件夹，递归式
	private static void deleteR(File fd) {
		File[] files=fd.listFiles(); //只要文件
		if(files != null) {
			for(File f: files) {
				if(f.isDirectory()) {
					deleteR(f);
				}else {
					System.out.println(f+ "\t" +f.isDirectory());
					f.delete();
				}
			}
		}
		System.out.println(fd+ "\t" +fd.isDirectory());
		fd.delete();		
	}

	// 读取目录，及其中的文件 和 文件夹
	private static void demo2() {
		String dirname="src/dustbin";
		File f1=new File(dirname);
		if(f1.isDirectory()) {
			System.out.println("目录:"+dirname);
			String s[]=f1.list();
			for(int i=0; i<s.length; i++) {
				File f=new File(dirname+"/"+s[i]);
				if(f.isDirectory())
					System.out.println("  "+s[i]+" 是一个目录");
				else
					System.out.println("  "+s[i]+" 是一个文件");
			}
		}else {
			System.out.println(dirname+"不是一个目录");
		}
		
	}

	//创建目录
	private static void demo1() {
		String dirname="src/dustbin/temp";
		File d=new File(dirname);
		if(!d.exists()) { //如果不存在，则新建目录
			d.mkdir();
			System.out.println("Created!");
		}
		System.out.println("done");
	}

}
