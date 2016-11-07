package chapter8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderDemo {
	public static void main(String[] args) throws IOException, InterruptedException {
//		fileReaderDemo();//读取
//		fileReaderDemo2();//复制
		bufferedReaderDemo();//复制
	}
	
	/**
	 * 最普通的显示
	 * @throws IOException
	 * @throws InterruptedException
	 */
	static void fileReaderDemo() throws IOException, InterruptedException{
		FileReader fr=new FileReader("dustbin//bb.txt");
		//System.out.print(fr.getEncoding());//UTF8
		char[] cbuf=new char[64];
		int length=0;
		while((length=fr.read(cbuf))>0){
			Thread.sleep(500);
			String str=new String(cbuf,0,length);
			System.out.print(str);
		}
		
		fr.close();
	}
	
	/**
	 * 最普通的复制文件
	 * @throws IOException
	 * @throws InterruptedException
	 */
	static void fileReaderDemo2() throws IOException, InterruptedException{
		FileReader fr=new FileReader("dustbin//bb.txt");
		FileWriter fw=new FileWriter("dustbin//bb_backup.txt");
		//System.out.print(fr.getEncoding());//UTF8
		char[] cbuf=new char[64];
		int length=0;
		while((length=fr.read(cbuf))>0){
			Thread.sleep(500);
			fw.write(cbuf,0,length);
//			fw.flush();//有了这句话是时刻刷新，从缓冲区向文件中保存
		}
		
		fr.close();
		fw.close();
	}
	
	
	/**
	 * 最普通的复制文件
	 * @throws IOException
	 * @throws InterruptedException
	 */
	static void bufferedReaderDemo() throws IOException, InterruptedException{
		//读写文件
		FileReader fr=new FileReader("dustbin//bb.txt");
		FileWriter fw=new FileWriter("dustbin//bb_backup2.txt");
		//加缓冲区
		BufferedReader br=new BufferedReader(fr);
		BufferedWriter bw=new BufferedWriter(fw);
		
		//System.out.print(fr.getEncoding());//UTF8
		char[] cbuf=new char[64];
		int length=0;
		while((length=br.read(cbuf))>0){
			bw.write(cbuf,0,length);
//			fw.flush();//有了这句话是时刻刷新，从缓冲区向文件中保存
		}
		//关闭
		br.close();
		bw.close();
		fr.close();
		fw.close();
	}
}
