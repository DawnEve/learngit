package chapter8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class C3 {
	public static void main(String[] args) throws IOException {
//		demo1(); //对文件排序，按照每行前的序号: 使用按行读取
//		demo2(); //同上，使用自动排序容器 TreeMap
		demo3(); //记录软件使用次数
	}

	// 记录软件使用次数：运行次数记录到文件
	private static void demo3() throws IOException {
		// 字节二进制形式
		File file=new File("src//dustbin//count.txt");
		int count=1;
		if(file.exists()) {
			BufferedReader bis=new BufferedReader(new FileReader(file));
			count = Integer.parseInt( bis.readLine() ); //一次读取一行，转为整数
			bis.close();
		}
		//判断是否3次以内
		if(count <=3) {
			System.out.println("第" + count + "次运行！");
		}else {
			System.out.println("本软件只能免费使用3次，请注册会员后继续使用！"+count);
			System.exit(0);
		}
		//写入文件
		BufferedWriter bos=new BufferedWriter(new FileWriter(file) );
		bos.write(count+1 + "");
		bos.close();
	}

	// 对文件排序，按照每行前的序号: 使用按行读取。使用自动排序容器 TreeMap
	private static void demo2() throws IOException {
		//1 打开文件
		BufferedReader bis=
				new BufferedReader(new FileReader("src//dustbin//C3.txt"));
		//2 读取文件
		//放到会自动排序的容器中 TreeMap
		TreeMap<Integer, String> tmap=new TreeMap<>();
		String line;
		while((line=bis.readLine()) != null) {
			String[] arr=line.split("\\.");
//			tmap.put(Integer.parseInt(arr[0]), arr[1]);
			tmap.put(Integer.parseInt(arr[0]), line);
		}
		System.out.println(tmap);
		
		//3. 输出，写入文件
		BufferedWriter bos=
				new BufferedWriter(new FileWriter("src//dustbin//C3-back.txt"));
		Set<Entry<Integer, String>> entrySet = tmap.entrySet();
		Iterator<Entry<Integer, String>> iterator = entrySet.iterator();
		while(iterator.hasNext()) {
			Entry<Integer, String> entry = iterator.next();
//			String ele=entry.getKey()+"."+entry.getValue();
			String ele = entry.getValue();
			
			System.out.println(ele);
			bos.write(ele);
			if(iterator.hasNext()) {
				bos.newLine();
			}
		}
		//关闭流
		bis.close();
		bos.close();
	}
	
	
	
	// 对文件排序，按照每行前的序号: 使用按行读取
	private static void demo1() throws IOException {
		//1 打开文件
		BufferedReader bis=
				new BufferedReader(new FileReader("src//dustbin//C3.txt"));
		//2 读取文件
		//放到数组中
		ArrayList<String> list=new ArrayList<>();
		String line;
		while((line=bis.readLine()) != null) {
			list.add(line);
		}
		//3. 自定义排序方法
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				//按照.切割得到数组，获取.前部分，转为整数
				int i1=Integer.parseInt(o1.split("\\.")[0]);
				int i2=Integer.parseInt(o2.split("\\.")[0]);
				return i1-i2;
			}
		});
		//4. 输出，写入文件
		BufferedWriter bos=
				new BufferedWriter(new FileWriter("src//dustbin//C3-back.txt"));
		for(int i=0; i<list.size(); i++) {
			String ele=list.get(i);
			System.out.println(ele);
			bos.write(ele);
			if(i!= list.size()-1) {
				bos.newLine();
			}
		}
		//关闭流
		bis.close();
		bos.close();
	}
}
