package com.mio.spring6.validator.four;

import jakarta.validation.constraints.Min;

public class User {
	
	@CannotBlank
	private String name;
	
	@Min(0)
	private int age;
	
	@Override
	public String toString() {
		return String.format("User[name:%s, age:%d]", name, age);
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
