package chapter3;

public class Encapsulation {
	public static void main(String[] args) {
		Student stu1=new Student("lilei");
		System.out.println(stu1.getName());
		stu1.setName("wangcai");
		System.out.println(stu1.getName());
	}
}

class Student{
	private String name="";

	public Student() {}
	public Student(String name) {
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name=name;
	}
}