package com.mio.spring6.iocannotation.autowired.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mio.spring6.iocannotation.autowired.service.UserService;

@Controller
public class UserController {
	//注入 service
	//方式1：属性注入
	@Autowired  //根据类型找到对应对象，完成注入
	private UserService userService;
	
	public void add() {
		System.out.println("controller...");
		userService.add();
	}
}
