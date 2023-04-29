package chapter7;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
		demo1();

	}

	//HashMap类可为基本操作（get和put）提供稳定的性能
	private static void demo1() {
		HashMap<Integer, Person> hm=new HashMap<Integer, Person>();
		for (int i = 0; i < 3; i++) {
			//添加元素
			hm.put(i, new Person(i));
		}
		
		System.out.println("total="+hm.size());
		System.out.println("获取尝试："+hm.get(0).age);
		
		//获取keys
		Set<Integer> keys=hm.keySet();
		System.out.println("keys="+keys);
		//获取values
		Collection<Person> values=hm.values();
		System.out.println("values="+values);
		
		//遍历1：普遍使用，二次取值
		System.out.print("\n1.二次取值: ");
		for(Integer key: hm.keySet()) {
			Person p1=hm.get(key);
			System.out.print("{key:"+key+", value:"+p1.age+"}, ");
		}
		// Set<Integer> keys=hm.keySet();
		System.out.print("\n1.二次取值2:");
		for(Iterator<Integer> it=keys.iterator(); it.hasNext();){
			Integer key=it.next();
			Person p=hm.get(key);//获取元素，依赖key
//			System.out.print("age="+p.age+"(hashCode="+p.hashCode()+")"+p.toString());
			System.out.printf("{key:%d, value:%d}, ", key, p.age);
		}
		
		//遍历2
		System.out.print("\n2.通过 Map.EntrySet 使用iterator遍历key和value：");
		Iterator<Map.Entry<Integer, Person>> it2=hm.entrySet().iterator();
		while(it2.hasNext()) {
			// 通过迭代器，获取一个键值对
			Map.Entry<Integer, Person> entry=it2.next();
			System.out.print("{key:"+entry.getKey()+", value:"+entry.getValue().age+"}, ");
		}
		
		//遍历3: for each + 迭代器。推荐，尤其是容量大时
		System.out.print("\n3.通过Map.entrySet遍历key和value:");
		for(Map.Entry<Integer, Person> entry: hm.entrySet()) {
			System.out.print("{key:"+entry.getKey()+", value:"+entry.getValue().age+"}, ");
		}
		
		//遍历4：不要key，只要value
		System.out.print("\n4.通过Map.values()遍历所有的value，但不能遍历key: ");
		for(Person p: hm.values()) {
			System.out.print("{value:"+p.age+"}, ");
		}
		
	}

}
