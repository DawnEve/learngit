package com.mio.spring6.iocxml.auto.controller;

import com.mio.spring6.iocxml.auto.service.UserService;
//import com.mio.spring6.iocxml.auto.service.UserServiceImpl;

public class UserController {
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void addUser() {
		System.out.println("controller 方法执行了");
		//调动 service
//		UserService userService=new UserServiceImpl();
		userService.addUserService();
	}
}
