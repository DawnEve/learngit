package chapter8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadCrashedNPP {
	public static void main(String[] args) throws IOException {
		demo1();
	}

	// 拯救npp损坏的文件，拯救失败
	private static void demo1() throws IOException {
		// reading file
		String fileName="src/dustbin/java04-Spring.txt";
		InputStreamReader isr =new InputStreamReader(new FileInputStream(fileName), "Unicode");
		BufferedReader reader = new BufferedReader(isr);
		String line="";
		while( (line=reader.readLine())!=null) {
			System.err.println(line+"\n");
		}
		
		reader.close();
		
		System.out.println("\nend2");
	}
	
}
