package com.mio.spring6.iocxml.injectobj;

public class Employer {
	//该员工属于哪个部门
	private Department dept;
	
	private String ename;
	private int age;
	
	public void work() {
		System.out.println(ename + " Employer work... "+ "age: "+age);
		dept.info();
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
