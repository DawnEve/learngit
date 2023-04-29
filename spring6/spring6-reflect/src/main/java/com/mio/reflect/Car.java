package com.mio.reflect;

public class Car {
	private String name;
	private int age;
	private String color;
	//构造方法
	private Car(String name, int age, String color) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
	}
	public Car(String name, String color) {
		this(name, 0, color);
	}
	public Car() {
		super();
	}
	
	//私有方法
	private void run() {
		System.out.println("私有方法-run()");
	}
	
	@Override
	public String toString() {
		return String.format("Car[name:%s, age:%d, color:%s]", name, age, color);
	}
	
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}