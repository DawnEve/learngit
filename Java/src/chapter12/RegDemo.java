package chapter12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegDemo {

	public static void main(String[] args) {
		demo1();
//		demo2();
//		demo3();
//		demo4();
//		demo5();
//		demo6();
	}

	//matches 和 lookingAt 方法 
	private static void demo6() {
		//matches 要求完全匹配； lookingAt 要求部分匹配，但是必须从开头算起
		String str="this is a book";
		String regex=".*is";
		
		Pattern pt=Pattern.compile(regex);
		Matcher m=pt.matcher(str);
		
		System.out.println(m.matches()); //完全匹配吗？false
		System.out.println(m.lookingAt()); //是否从开头匹配？ true
	}

	// 查找出现次数进行计数的例子: 匹配局部
	private static void demo5() {
		String input="cat cat cat cattie cat";
		String regex = "\\bcat\\b"; //两边包着空格的cat
		
		//匹配
		Pattern pt = Pattern.compile(regex);
		Matcher mt = pt.matcher(input); // 获取 matcher 对象
		System.out.println(mt);
		
		//没有捕获组
		if(mt.find())
			System.out.println("groupCount = "+mt.groupCount());
		else 
			System.out.println("Not found");
		
		//输出匹配
		int count = 0;
		while(mt.find()) {
			count++;
			System.out.print("Match number "+count);
			System.out.print(", start(): "+mt.start());
			System.out.print(", end(): "+mt.end());
			System.out.println(":" + input.substring(mt.start(), mt.end()));
		}
	}

	// 字符匹配
	private static void demo4() {
		String str = "tieba.baidu.com"; //字符串
	    String reg = "(tie\\w+)\\.(b.+)\\.\\w+"; //正则表达式
	    //编译 正则表达式
//	    Pattern pattern = Pattern.compile(reg); 
	    Pattern pattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE); //忽略大小写
	    // 匹配
	    Matcher matcher=pattern.matcher(str);
	    
	    //结果
	    System.out.println(matcher);
	    System.out.println(matcher.groupCount()+"个匹配项"); //对应正则中的 两个圆括号
	    	    
	    if(matcher.find()) {
	    	System.out.println("raw:"+matcher.group(0));
	    	for(int i=1; i<=matcher.groupCount(); i++) {
	    		System.out.println(i+" > match: " +matcher.group(i));
	    	}
	    }
	    
	    System.out.println(matcher.find()); //false

	}

	//示例: 验证是否是邮箱？
	private static void demo3() {
		// 要验证的字符串
		String str="";
//		str = "@xx.net.cn";//false
//		str = "x@a.cn";//true
//		str = "service@xx.net.cn";//true
		str = "service.4@xx.net.cn";//true
//		str="123456@qq.com";//true
		
		// 邮箱验证规则
	    String regEx = "[a-zA-Z_\\.0-9]{1,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
	    
	    // 编译正则表达式
	    Pattern pattern = Pattern.compile(regEx);
	    // 忽略大小写的写法
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    
	    Matcher matcher = pattern.matcher(str); //匹配
	    
	    // 字符串是否与正则表达式相匹配
	    boolean rs = matcher.matches(); //完全匹配
	    System.out.println(str + ": "+ rs);
	}

	// 捕获组: 带括号的正则表达式
	private static void demo2() {
		String line="This order was placed for QT3000! OK?";
		String pattern="(\\D*)(\\d+)(.*)";
		
		// 创建 Pattern对象
		Pattern reg=Pattern.compile(pattern);
		// 创建 matcher 对象
		Matcher m = reg.matcher(line);
		
		System.out.println(m);
		System.out.println("line length="+ line.length());
		System.out.println(m.toString());
		System.out.println(m.groupCount()); //共3个捕获组
		if(m.find()) {
			System.out.println("  >"+m.group(0)); //原文
			//三个捕获组
			for(int i=1; i<=m.groupCount(); i++) {
				System.out.printf(" %d> [%d, %d]%s\n", i, 
						m.start(i), m.end(i),
						m.group(i));
			}
//			System.out.println(" 1>"+m.group(1)); 
//			System.out.println(" 2>"+m.group(2));
//			System.out.println(" 3>"+m.group(3));
			System.out.println("  > " + m.group().toString());
			System.out.println("  > " + m.toString());
			System.out.println("  > " + m.group().split(", "));//这个输出怎么回事？ //todo
		}else {
			System.out.println("Not found");
		}		
	}

	// 简单查找：字符串content 中是否有 字串pattern，要完全匹配才是true
	private static void demo1() {
		String content="this is a book or bike";
		String regex=".*book.*";
		
		//方法1  直接匹配
		boolean isMatch=Pattern.matches(regex, content); 
		System.out.println(isMatch); //true
		
		//方法2 两步法
		Pattern pt=Pattern.compile(regex); //编译正则
		Matcher m=pt.matcher(content); //创建匹配对象
		
		System.out.println(m.matches()); //true
	}
}