package chapter7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;



public class ListDemo {
	//List的使用及其实现类（如ArrayList、LinkedList）的使用
	public static void main(String[] args) {
//		demo1();
//		demo2();
		demo3();
	}
	
	//LinkedLis适合用在插入、删除多，元素随机访问少的场合
	private static void demo3() {
		LinkedList<Person> ll=new LinkedList<Person>();
		for (int i = 0; i < 3; i++) {
			ll.add(new Person(i));
		}
		//显示列表
		System.out.println(ll);
		System.out.println(((Person)ll.get(2)).age);
		
		System.out.println("容量是："+ll.size());
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
		System.out.println("是否包含5： "+list.contains(15));//false
		//遍历
		for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
			int i = (int) it.next();
			System.out.println(i);
		}
	}
}
