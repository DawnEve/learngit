package chapter12;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class WordCounter {

	public static void main(String[] args) {
		String str = "The quick   brown fox jumps over a lazy dog.a cunning fox jumps over the high box!";
		wordCounter(str);
	}
	/**
	 * 统计单词频数
	 */
	//分割单词，使用空格、,.?!-等英文标点分割。
	private static void wordCounter(String str) {
	    // 要验证的字符串
	    str=str.trim();//去掉两端空白
	    // 正则表达式规则
//	    String regEx = "[\\s',?.!\\-]*";//按照字母统计
	    String regEx = "[\\s',?.!\\-]+";//至少1个空格
	    
	    //方案1
//	    Pattern re=Pattern.compile(regEx,Pattern.CASE_INSENSITIVE);
//	    String[] arr=re.split(str);
	    
	    //方案2
	    str=str.toLowerCase();
	    String[] arr=str.split(regEx);//分割字符串
//	    String[] arr=str.split(regEx,6);//分割字符串.数字表示正则匹配次数。怎么不区分大小写
	    
	    //创建一个map
	    HashMap<String,Integer> map=new HashMap<String,Integer>();
	    
	    for (int i = 0; i < arr.length; i++) {
	    	String s=arr[i];
	    	if(map.containsKey(s)){
	    		map.put(s, map.get(s) +1);
	    	}else{
	    		map.put(s, 1);
	    	}
		}
	    
	    //输出单词统计结果
	    Set<String> keys=map.keySet();
	    for (String key : keys) {
	    	System.out.println("count("+key+")="+map.get(key));
		}
	    
	}
	
	
	//去除数组中重复的记录  
	//http://simplehumn.iteye.com/blog/812064
	public static String[] array_unique(String[] a) {  
	    // array_unique  
	    List<String> list = new LinkedList<String>();  
	    for(int i = 0; i < a.length; i++) {  
	        if(!list.contains(a[i])) {  
	            list.add(a[i]);  
	        }  
	    }  
	    return (String[])list.toArray(new String[list.size()]);  
	}
}
