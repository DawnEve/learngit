package com.mio.spring6.iocxml.injectobj;

import java.util.Arrays;

public class Employee {
	//该员工属于哪个部门
	private Department dept;
	
	private String ename;
	private int age;
	
	//爱好
	private String[] hobbies;
	
	public void work() {
		System.out.println(ename + " Employee work... "+ "age: "+age);
		dept.info();
		System.out.println(Arrays.toString(hobbies));
	}
	
	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	
	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
