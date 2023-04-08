package com.mio.spring6.iocannotation.resource.controller;

import org.springframework.stereotype.Controller;

import com.mio.spring6.iocannotation.resource.service.UserService;

import jakarta.annotation.Resource;

@Controller
public class UserController {
	//注入 service
//	@Resource //先按照名称byName匹配，没有名称则使用属性名字；找不到再按照类型匹配byType
//	private UserService userService;

	//根据类型注入: 没有指定名字；属性名userService3同名的bean没找到；按类型装配
	@Resource
	private UserService userService3;
	
	public void add() {
		System.out.println("controller...");
		userService3.add();
	}
}
