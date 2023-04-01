package com.example1.demo3.relationaldataaccess;

public class Customer {
	private long id;
	private String first_name, last_name;
	
	public Customer(long id, String first_name, String last_name) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	@Override
	public String toString() {
		return String.format("Costomer[id=%d, first_name=%s, last_name=%s]", 
				id, first_name, last_name);
	}
	// getters & setters omitted for brevity(简洁)
}
