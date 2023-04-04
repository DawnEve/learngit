package com.mio.spring6.iocxml.injectobj;

public class Department {
	private String dname;
	
	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public void info() {
		System.out.println("Department: "+dname);
	}
}
