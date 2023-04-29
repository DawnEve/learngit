package com.mio.spring6.iocxml.injectmap;

import java.util.List;
import java.util.Map;

public class Student {
	private String sid;
	private String sname;
	//创建map属性
	private Map<String, Teacher> teacherMap;
	private List<Lesson> lessonList;
	
	//方便输出
	public void run() {
		System.out.println("Stu: "+sid+", "+sname);
		System.out.println(teacherMap);
		System.out.println(lessonList);
	}
	
	
	
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Map<String, Teacher> getTeacherMap() {
		return teacherMap;
	}
	public void setTeacherMap(Map<String, Teacher> teacherMap) {
		this.teacherMap = teacherMap;
	}

	public List<Lesson> getLessonList() {
		return lessonList;
	}
	public void setLessonList(List<Lesson> lessonList) {
		this.lessonList = lessonList;
	}
}
