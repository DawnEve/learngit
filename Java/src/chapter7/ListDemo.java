package chapter7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;



public class ListDemo {
	//List的使用及其实现类（如ArrayList、LinkedList）的使用
	public static void main(String[] args) {
//		demo1();
//		demo2();
//		demo3();
		demo4();
//		demo10();
	}

	//链表
	private static void demo4() {
//		LinkedList<String> list=new LinkedList<String>();
		LinkedList<String> list=new LinkedList<>(); //等号右边的尖括号中内容可省略
		list.add("aa");
		list.add("bb");
		list.addFirst("a01"); //头部添加
		list.addLast("zz"); //末尾添加
		System.out.println(list);
		
		list.removeFirst();// 头部移除元素
		System.out.println(list);
		
		list.removeLast(); //尾部移除元素
		System.out.println(list);
		System.out.println(list.getLast()); //获取尾部元素 
		System.out.println(list.getFirst()); //获取头部元素 
		
		//迭代元素 for
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i)+", ");
		}
		System.out.println();
		// for each
		for(String str: list) {
			System.out.print(str+", ");
		}
	}

	//LinkedLis适合用在插入、删除多，元素随机访问少的场合
	private static void demo10() {
		LinkedList<Person> ll=new LinkedList<Person>();
		for (int i = 0; i < 3; i++) {
			ll.add(new Person(i));
		}
		//显示列表
		System.out.println(ll);
		System.out.println(((Person)ll.get(2)).age);
		
		System.out.println("容量是："+ll.size());
	}

	
	// 排序
	private static void demo3() {
		ArrayList<String> alist=new ArrayList<String>();
		alist.add("ZZ");
		alist.add("TX");
		alist.add("GG");
		alist.add("AP");
		Collections.sort(alist); //排序
		for(String ele: alist) {
			System.out.print(ele+", ");
		}
	}
	
	//ArrayList
	private static void demo2() {
		ArrayList<Integer> list=new ArrayList<Integer>();
		for (int i = -3; i <5; i++) {
			list.add(i);//添加元素
		}
		System.out.println(list);
		list.remove(4);
		System.out.println(list);
		list.remove(Integer.valueOf(4));
//		list.remove(4);
		System.out.println(list);
		
		//清空
		list.clear();
		System.out.println(list);
		
	}

	//遍历 ArrayList
	private static void demo1() {
		//定义ArrayList
		ArrayList<Integer> list=new ArrayList<Integer>();
		for (int i = 10; i <15; i++) {
			list.add(i);//添加元素
		}
		
		//直接输出
		System.out.println("size="+list.size()+", list = "+list);
		System.out.println("获取第2个： "+list.get(2));
		System.out.println("是否包含0： "+list.contains(11));//true
		System.out.println("是否包含15： "+list.contains(15));//false
		
		//遍历1 foreach
		for(int x: list) {
			System.out.print(x+", ");
		}
		System.out.println();
		
		//遍历2 for, 链表变数组
		Integer[] arr2=new Integer[list.size()];
		list.toArray(arr2);
		for(int i=0; i<arr2.length; i++) {
			System.out.print(arr2[i]+", ");
		}
		System.out.println();
		
		//遍历3 迭代器
		Iterator<Integer> it1=list.iterator();
		while(it1.hasNext()) {
			System.out.print(it1.next()+", ");
		}
		System.out.println();
		
		//编列4 迭代器的 for 写法		
		for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
			int i = (int) it.next();
			System.out.print(i+", ");
		}
	}
}
