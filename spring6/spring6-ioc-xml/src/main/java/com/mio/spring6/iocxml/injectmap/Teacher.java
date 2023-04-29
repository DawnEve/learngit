package com.mio.spring6.iocxml.injectmap;

public class Teacher {
	private String tid;
	private String tname;
	
	@Override
	public String toString() {
		return String.format("Teacher[id:%s, name:%s]", tid, tname);
	}
	
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
}
