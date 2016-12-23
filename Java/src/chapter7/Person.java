package chapter7;

/**
 * 为了使用 SortedSet ,需要实现 Comparable 接口。
 * @author admin
 *
 */
public class Person implements Comparable<Person>{
	public int age=0;
	Person(int age){
		this.age=age;
	}
	@Override
	public int compareTo(Person o) {
		return this.age - o.age;//也就是相同年龄，就认为是同一个对象
//		return o.age - this.age;
	}
}
