package chapter12;

import java.util.regex.Pattern;

public class SplitDemo {

	public static void main(String[] args) {
		demo1();
	}

	//分割单词，使用空格、,.?!-等英文标点分割。
	private static void demo1() {
		// 要验证的字符串
	    String str = "  this is a         little	book, it's intresting. really?  Yes! ou-mega";
	    // 正则表达式规则
	    String regex = "[\\s',?.!\\-]+";//至少1个空格
	    
	    str=str.trim();//去掉两端空白
	    //System.out.println("["+str+"]");
	    
	    //方案1 调用字符串的split方法，传入正则字符串
	    String[] arr=str.split(regex); //分割字符串为 数组
	    for(String ele: arr)
	    	System.out.print(ele+" | ");
	    System.out.println();
	    
	    // 方案2 调用编译后的正则的split方法
	    Pattern pattern = Pattern.compile(regex);
	    String[] arr2=pattern.split(str);
	    for(int i=0; i<arr.length; i++) {
	    	System.out.print(arr2[i]+" | ");
	    }
	}

}
