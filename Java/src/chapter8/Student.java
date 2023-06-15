package chapter8;
import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int age;
	private transient String address;
	
	Student(String name, int age){
		this.name=name;
		this.age=age;
	}
	
	Student(String name, int age, String address){
		this.name=name;
		this.age=age;
		this.address=address;
	}
	
	@Override
	public String toString() {
		return String.format("class Student[name:%s, age:%d, address:%s]",
				this.name, this.age, this.address);
	}
}
