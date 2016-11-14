package chapter8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadByLine {

	/**
	 * 按行读取文件
	 * BufferedReader的方法readLine()
	 * 
	 * http://simplehumn.iteye.com/blog/812064
	 * @param args
	 */
	public static void main(String[] args) {
		readFileByLines("dustbin/bb.txt");

	}
	public static void readFileByLines(String fileName) {
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			System.out.println("以行为单位读取文件内容，一次读一行");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			//一次读一行，读入null时文件结束
			while ((tempString = reader.readLine()) != null) {
				//把当前行号显示出来
				System.out.println("line " + line + ": " + tempString);
				line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}

}
