package com.mio.spring6.iocxml.di;

public class Book {
	private String bname;
	private String author;
	//生成set方法
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	//构造器
	public Book() {}
	public Book(String bname, String author) {
		this.bname = bname;
		this.author = author;
	}
	
	@Override
	public String toString() {
		return String.format("Book[bname=%s, auther=%s]", bname, author);
	}
	
	public static void main(String[] args) {
		//原生做法:set注入
		Book book=new Book();
		book.setBname("Spring6");
		book.setAuthor("张三");
		System.out.println(book);
		
		//原生做法：构造器注入
		Book book2=new Book("java", "李四");
		System.out.println(book2);
	}
}
