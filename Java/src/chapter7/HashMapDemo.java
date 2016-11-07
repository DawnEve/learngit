package chapter7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
		demo1();

	}

	//HashMap类可为基本操作（get和put）提供稳定的性能
	private static void demo1() {
		HashMap<Integer, Person> hm=new HashMap<Integer, Person>();
		for (int i = 0; i < 20; i++) {
			//添加元素
			hm.put(i, new Person(i));
		}
		
		System.out.println("total="+hm.size());
		System.out.println("获取尝试："+hm.get(0).age);
		
		//获取keys
		Set<Integer> keys=hm.keySet();
		System.out.println("keys="+keys);
		//遍历
		for(Iterator<Integer> it=keys.iterator(); it.hasNext();){
			Integer key=it.next();
			Person p=hm.get(key);//获取元素，依赖key
			System.out.println("age="+p.age+"(hashCode="+p.hashCode()+")"+p.toString());
		}
	}

}
