package com.mio.spring6.iocannotation.autowired.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mio.spring6.iocannotation.autowired.service.UserService;

@Controller
public class UserController {
	//注入 service
	//方式1：属性注入
	@Autowired  //根据类型找到对应对象，完成注入
//	private UserService userService;
	
	//方式2：set注入: 定义set方法，并在set方法上添加@Autowired注解
//	private UserService userService;
//	@Autowired
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}
	
	//方式3：构造方法上注入
//	private UserService userService;
//	@Autowired
//	public UserController(UserService userService) {
//		//super();
//		this.userService = userService;
//	}
	
	//方式4: 形参上注入
//	private UserService userService;
//	public UserController(@Autowired UserService userService) {
//		super();
//		this.userService = userService;
//	}
	
	//方式5: 只有一个有参数构造函数，注解可以省略
//	private UserService userService;
//	public UserController(UserService userService) {
//		//super();
//		System.out.println("有参构造函数 controller");
//		this.userService = userService;
//	}
//	public UserController() {
//		System.out.println("无参构造函数 controller");
//	}
	
	//方式6: @Autowired + @Qualifier 注解联合；例子见 UserRedisDaoImpl
	private UserService userService;
	
	


	public void add() {
		System.out.println("controller...6");
		userService.add();
	}
}
