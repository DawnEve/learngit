package chapter3.Interface;

public class ComparableDemo {
	public static void main(String[] args) {
		Person p1=new Person(100);
		Person p2=new Person(20);
		Person p3=p1;
		
		System.out.println(p1.compareTo(p2));//80
		System.out.println(p1.compareTo(p3));//0
	}
}

//可以比较的接口，具体到比较哪个选项
class Person implements Comparable<Person>{
	int age=0;
	public Person(){
		super();
	}
	public Person(int age){
		this.age=age;
	}
	@Override
	public int compareTo(Person obj) {
		return this.age-obj.age;
		
		/*if(this.equals(obj)){
			return 1;
		}
		return 0;*/
	}
}