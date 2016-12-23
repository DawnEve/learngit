package chapter12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegDemo {

	public static void main(String[] args) {
//		demo1();
//		demo2();
		demo3();
	}
	
	
	//分割单词，使用空格、,.?!-等英文标点分割。
	private static void demo3() {
	    // 要验证的字符串
	    String str = "  i'm a         little	book, it's intresting. really?  Yes! ou-mega";
	    // 正则表达式规则
	    String regEx = "[\\s',?.!\\-]+";//至少1个空格
		
	    str=str.trim();//去掉两端空白
	    //System.out.println("["+str+"]");
	    
	    //方案1 调用字符串的split方法，传入正则字符串
	    String[] arr=str.split(regEx);//分割字符串
	    for (int i = 0; i < arr.length; i++) {
			System.out.print("["+arr[i]+"], ");
		}
	    
	    System.out.println();
	    
	    //方案2 调用编译后的正则的split方法
	    String[] arr2=Pattern.compile(regEx).split(str);
	    for (int i = 0; i < arr.length; i++) {
			System.out.print("["+arr2[i]+"], ");
		}
	}



	/**
	 * 字符匹配 
	 */
	private static void demo2() {
	    // 要验证的字符串
	    String str = "tieba.baidu.com";
	    // 正则表达式规则
//	    String regEx = "baike.*";
	    String regEx = "(tie\\w+)\\.(b.+)\\.\\w+";
	    
	    // 编译正则表达式
	    Pattern pattern = Pattern.compile(regEx);
	    
	    // 忽略大小写的写法
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
	    
	    // 查找字符串中是否有匹配正则表达式的字符/字符串
	    boolean rs = matcher.find();
	    System.out.println(rs);//true
	    //可以加一个if判断，
	    //System.out.println(matcher.find());//为什么调用两次find()会报错?
	    if(rs){
	    	System.out.println(matcher.group(0));//
	    	System.out.println(matcher.group(1));
	    	System.out.println(matcher.group(2));
	    }
	}

	
	
	//验证是否是邮箱？该正则不好
	private static void demo1() {
		// 要验证的字符串
		String str="";
	    //str = "service@xsoftlab.net";
//	    str = "service@xsoftlab.net.cn";
	    //str = "service.4@xsoftlab.net.cn";//false
	    str="123456@qq.com";//false
	    
	    // 邮箱验证规则
	    String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
	    
	    // 编译正则表达式
	    Pattern pattern = Pattern.compile(regEx);
	    // 忽略大小写的写法
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    
	    Matcher matcher = pattern.matcher(str);
	    
	    // 字符串是否与正则表达式相匹配
	    boolean rs = matcher.matches();
	    System.out.println(rs);
	}

	private static void demo() {
		// 按指定模式在字符串查找
		String line = "This order was placed for QT3000! OK?";
		String pattern = "(\\D*)(\\d+)(.*)";
		
		// 创建 Pattern 对象
		Pattern reg = Pattern.compile(pattern);
		// 现在创建 matcher 对象
		Matcher m = reg.matcher(line);
		if(m.find()){
			System.out.println(" >:"+m.group(0));
			System.out.println(m.toString());
			System.out.println(" >:"+m.group(1));
			System.out.println(m.toString());
			System.out.println(" >:"+m.group(2));
			System.out.println(" >:"+m.group(3));
//			System.out.println(m.group(4));
			System.out.println(m.toString());
			System.out.println(" All>:"+m.group().split(", "));
		}else {
			System.out.println("NO MATCH");
		}
	}

	
	
}
