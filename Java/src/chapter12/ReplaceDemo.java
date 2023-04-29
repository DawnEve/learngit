package chapter12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceDemo {

	public static void main(String[] args) {
//		demo1();
		demo2();

	}

	// appendReplacement 和 appendTail 方法
	private static void demo2() {
		String str="this is a dog. It's a black dog.";
		String regex="dog";
		String newWord="cat";
		
		Pattern p=Pattern.compile(regex); //编译正则
		Matcher m=p.matcher(str); //获取匹配对象
		
		StringBuffer sb = new StringBuffer();
		while(m.find()) {
			m.appendReplacement(sb, newWord); //把m中匹配的替换成 newWord后放到sb中
			System.out.println(" > "+sb);
		}
		m.appendTail(sb); //把尾部加到sb
		System.out.println(sb.toString());
		System.out.println(str); //原文不变
	}

	//replaceFirst 和 replaceAll 方法
	private static void demo1() {
		String str="this is a dog. It's a black dog.";
		String regex="dog";
		String newWord="cat";
		
		Pattern p=Pattern.compile(regex); //编译正则
		Matcher m=p.matcher(str); //获取匹配对象
		
		//全部替换
		String str2=m.replaceAll(newWord);
		System.out.println(str2);

		//替换 第一个出现的
		String str3=m.replaceFirst(newWord);
		System.out.println(str3);
	}

}
