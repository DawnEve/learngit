package chapter8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class B2 {
	public static void main(String[] args) throws IOException {
//		demo1(); //copy dir
//		demo2(); //异或
//		demo3_encode(); //加密图片文件，使用异或
//		demo4_decode(); //解密图片文件，使用异或
//		demo5_order(); //排序文件中的数字
		demo5_order2(); //使用流
	}

	// 排序文件中的-分割的数字: 1-5-3-6-2-0-80-8
	// 使用流实现分割、排序，使用替换转为字符串并保存
	private static void demo5_order2() throws IOException {
		//1.读取文件
		FileReader fr=new FileReader("src//dustbin//temp//B//B3.txt");
		StringBuilder sb=new StringBuilder();
		char[] chars=new char[5];
		int len;
		while((len=fr.read(chars)) != -1) {
			sb.append(new String(chars, 0, len));
		}
		fr.close();
		System.out.println(sb.toString());
		
		//2. 使用流实现 排序
		Integer[] arr = Arrays.stream(sb.toString().split("-"))
				.map(Integer::parseInt)
				.sorted()
				.toArray(Integer[]::new);
		System.out.println(Arrays.toString(arr));
		//3. 保存结果
		String s = Arrays.toString(arr).replace(", ", "-");
		String result = s.substring(1, s.length()-1);
		FileWriter fw=new FileWriter("src//dustbin//temp//B//B3-sort2.txt");
		fw.write(result);
		fw.close();		
	}

	// 排序文件中的-分割的数字: 1-5-3-6-2-0-80-8
	private static void demo5_order() throws IOException {
		//1.读取文件
		FileReader fr=new FileReader("src//dustbin//temp//B//B3.txt");
		StringBuilder sb=new StringBuilder();
		char[] chars=new char[5];
		int len;
		while((len=fr.read(chars)) != -1) {
			sb.append(new String(chars, 0, len));
		}
		fr.close();
		System.out.println(sb.toString());
		
		//2. 排序
		String[] arrStr = sb.toString().split("-"); //按照-切分
		//转为数字
		int[] arrInt=new int[arrStr.length];
		for(int i=0; i<arrStr.length; i++) {
			arrInt[i] = Integer.parseInt(arrStr[i]);
		}
		//排序
		Arrays.sort(arrInt);
		//sort(arrInt);
		System.out.println(Arrays.toString(arrInt));
		
		//3. 写出数据
		FileWriter fw = new FileWriter("src//dustbin//temp//B//B3-sort.txt");
		for(int i=0; i<arrInt.length; i++) {
			if(i != arrInt.length-1) {
				fw.write(""+arrInt[i] + "-");
			}else {
				fw.write(""+arrInt[i] + "");
			}
		}
		fw.close();
	}

	//对整数数组排序
	private static void sort(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=i; j<arr.length; j++) {
				if(arr[i]>arr[j]) {
					int tmp=arr[i];
					arr[i] = arr[j];
					arr[j]=tmp;
				}
			}
		}
	}

	//解密文件，和加密一样，再次逐字节和某个整数取异或。除了文件名，和demo3没有任何变化。
	private static void demo4_decode() throws IOException {
		FileInputStream fis=new FileInputStream("src//dustbin//secret.png");
		FileOutputStream fos=new FileOutputStream("src//dustbin//secret2.png");
		
		byte[] bytes=new byte[1024];
		int len;
		// 加密参数
		int secretNumber=100;
		while((len=fis.read(bytes)) != -1) {
			// fos.write(bytes, 0, len);
			//逐个字节加密
			for(int i=0; i<len; i++) {
				bytes[i] = (byte) (bytes[i] ^ secretNumber);
			}
			fos.write( bytes, 0, len);
		}
		fos.close();
		fis.close();
		System.out.println("decode: done!");
	}

	// 使用异或加密，对图片
	private static void demo3_encode() throws IOException {
		FileInputStream fis=new FileInputStream("src//dustbin//刘亦菲.png");
		FileOutputStream fos=new FileOutputStream("src//dustbin//secret.png");
		
		byte[] bytes=new byte[1024];
		int len;
		// 加密参数
		int secretNumber=100;
		while((len=fis.read(bytes)) != -1) {
			// fos.write(bytes, 0, len);
			//逐个字节加密
			for(int i=0; i<len; i++) {
				bytes[i] = (byte) (bytes[i] ^ secretNumber);
			}
			fos.write( bytes, 0, len);
		}
		fos.close();
		fis.close();
		System.out.println("encode: done!");
	}

	// 文件加密
	private static void demo2() {
		//异或，先变二进制，然后按照二进制逐位求异或
		System.out.println(100 ^ 10); //110
		System.out.println(Integer.toBinaryString(100)); //1100100
		System.out.println(Integer.toBinaryString(10));  //1010
		/*
		 * 1100100
		 *    1010
		 * 1101110 异或结果
		 */
		System.out.println( 0b1101110); //110
		
		//该过程可逆，如果a^b=c结果再和b做一次异或，则还原位a
		//a^b^b=a; 
		//证明: a^b=b^a, //todo
		/*
		 * 1101110
		 *    1010
		 * 1100100 异或结果
		 */
		System.out.println( 0b1100100); //100
		System.out.println( 100^10^10); //100
	}
	

	// 拷贝文件夹，考虑子文件夹
	private static void demo1() throws IOException {
		//1.源文件夹
		File src=new File("src//dustbin//temp");
		//2.目的文件夹
		File dest=new File("src//dustbin//temp2");
		//3.调用方法开始拷贝
		copydir(src, dest);
	}
	
	/*
	 * 作用：执行文件夹拷贝
	 * 
	 * @param src 数据源
	 * @param dest 目的地
	 */
	private static void copydir(File src, File dest) throws IOException {
		dest.mkdirs(); //如果不存在，则新建；存在，则创建失败，但是不报错。
		//1 进入数据源，获取列表
		File[] listFiles = src.listFiles();
		//2 遍历列表
		for(File file: listFiles) {
			System.out.println("file from: "+file);
			System.out.println(">>file to: "+ file.getName() );
			if(file.isFile()) {
				//3 如果是文件，拷贝：字节流
				FileInputStream fis=new FileInputStream(file);
				FileOutputStream fos = new FileOutputStream(
							new File(dest, file.getName())
						);
				
				byte[] bytes=new byte[1024*5];
				int len;
				while((len=fis.read(bytes)) != -1) {
					fos.write(bytes,0,len);
				}
				
				fos.close();
				fis.close();
				
			}else {
				//4 如果是文件夹，则新建文件夹，递归调用本方法
				copydir(file, new File(dest, file.getName()));
			}
		}
	}

}
