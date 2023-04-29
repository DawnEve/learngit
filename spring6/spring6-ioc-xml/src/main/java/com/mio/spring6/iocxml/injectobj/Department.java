package com.mio.spring6.iocxml.injectobj;

import java.util.List;

public class Department {
	private String dname;

	//一个部门有很多员工
	private List<Employee> empList;
	
	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	
	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public void info() {
		System.out.println("Department: "+dname);
		for(Employee emp: empList) {
			System.out.println("\t"+emp.getEname());
		}
	}
}
