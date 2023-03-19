package chapter18;

public class BeanDemo {
	public static void main(String[] args) {
		Person p1=new Person();
		p1.setName("Tom");
		p1.setAge(10);
		p1.setChild(true);
		System.out.println(p1);
	}

}


class Person {
    private String name;
    private int age;
    private boolean isChild;

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isChild() {
		return isChild;
	}
	public void setChild(boolean isChild) {
		this.isChild = isChild;
	}
}