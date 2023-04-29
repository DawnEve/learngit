package com.mio.spring6.iocxml.injectmap;

public class Lesson {
	private String lname;
	@Override
	public String toString() {
		return "Lesson [lname=" + lname + "]";
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

}
