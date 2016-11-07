package chapter8;

import java.io.File;
import java.io.IOException;
/**
 * 递归列出文件结构
 * http://www.cnblogs.com/LYLtim/archive/2012/01/16/2324040.html
 * @author admin
 */
public class ListFileTreeDemo {
	public static void main(String[] args) throws IOException {
//		demo1();//显示分隔符
//		demo2();//创建和删除文件
//		demo3();//列出文件
//		demo4();//列出文件绝对目录
		
		demo5();//递归列出文件结构
	}

	private static void demo5() {
		File file=new File("f://github/learngit/java/");
		System.out.println(file.getName());
		list(file,0);
	}

	/**
	 *  递归列出所有文件和文件夹
	 * @param file
	 * @param level
	 */
	private static void list(File file,int level) {
		File[] childs =file.listFiles();//列出文件
		for (int i = 0; i < childs.length; i++) {
			String path="";
			File f=childs[i];
//			path="("+f.getAbsolutePath() + (f.isDirectory()? File.separator:"") +")";//是否显示完整路径
			
			for (int j = 0; j < level; j++){
                System.out.print(" ┃");
			}
			
			if (i == childs.length - 1){
				System.out.println(" ┗" + childs[i].getName() + path);
			}else{
				System.out.println(" ┣" + childs[i].getName() + path);
			}
			
			if (childs[i].isDirectory()){
				list(childs[i], level + 1);
			}
		}
	}

	private static void demo4() {
		File file=new File("f://gitHub");
		File[] fileList=file.listFiles();//列出文件
		for(File f:fileList){
			String sep=f.isDirectory()? File.separator:"";
			System.out.println(f.getAbsolutePath() + sep);
		}
	}

	private static void demo3() {
		File file=new File("f://gitHub");
		String[] fileList=file.list();//列出文件
		for(String f:fileList){
			System.out.println(f);
		}
	}

	private static void demo2() throws IOException {
		File file=new File("dustbin"+File.separator+"dd.txt");
		System.out.println(file.getAbsolutePath());
		if(!file.exists()){
			file.createNewFile();
		}else{
			file.delete();
		}
	}

	private static void demo1() {
		System.out.println(File.separator);// \
		System.out.println(File.pathSeparator);// ;
		
		System.out.println(File.pathSeparatorChar);// ;
	}

}
