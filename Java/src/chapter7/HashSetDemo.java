package chapter7;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
	public static void main(String[] args) {
		demo1();
	}

	/**
	 * 不保证任何顺序的集合
	 */
	private static void demo1() {
		HashSet<Person> hs=new HashSet<Person>();
		for (int i = 0; i <20; i++) {
			hs.add(new Person(i));
		}
		hs.add(new Person(200));
		hs.add(new Person(300));
		hs.add(new Person(100));
		int i=0;
		for (Iterator<Person> it = hs.iterator(); it.hasNext();) {
			Person p = (Person) it.next();
			System.out.print(i++ + ": ");
			System.out.println(p.age+"["+p.hashCode()+"]"+", "+p.toString());
		}
	}

}
