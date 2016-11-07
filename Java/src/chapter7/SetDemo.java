package chapter7;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		demo1();
	}

	//自动排序
	private static void demo1() {
		SortedSet<Person> set=new TreeSet<Person>();
		set.add(new Person(3));
		set.add(new Person(1));
		set.add(new Person(2));
		set.add(new Person(1));//重复的地方无法计算
		for (Iterator<Person> it = set.iterator(); it.hasNext();) {
			Person person = (Person) it.next();
			System.out.println(person.age+"("+person.hashCode()+")");
		}
		System.out.println(set);
	}
}
