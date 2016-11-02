package chapter3;

public class OverrideDemo {
	public static void main(String[] args){
		Person p=new Person("Tom3");
		System.out.println(p.toString());
		
		Person p2=new Person("Tom3");//class Person: name=Tom3
		Person p3=p;
		System.out.println(p.equals(p2));//false
		System.out.println(p.equals(p3));//true
	}

}


class Person{
	private String name="";
	
	public Person(String name){
		this.name=name;
	}
	
	@Override
	public String toString(){
		return "class Person: name="+this.name;
	}
	
	@Override
	public boolean equals(Object obj){
		return this==obj;
	}
}