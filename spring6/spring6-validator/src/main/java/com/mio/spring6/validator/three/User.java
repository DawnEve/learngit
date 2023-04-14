package com.mio.spring6.validator.three;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class User {
	@NotNull
	private String name;
	
	@Min(0)
	@Max(200)
	private int age;
	
	@NotBlank(message = "手机号码不能为空")
	@Pattern(regexp="^1(3|4|5|7|8)\\d{9}$", message = "手机号码错误")
	private String phone;
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
