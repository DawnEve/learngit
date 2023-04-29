package com.mio.spring6.jdbc;

public class Emp {
	private Integer id;
	private String name;
	private Integer age;
	private String gender;
	
	@Override
	public String toString() {
		return String.format("Emp[id:%d, name:%s, age:%d, gender:%s]", id, name, age, gender);
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
