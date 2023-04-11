package com.mio.service.impl;

import com.mio.dao.UserDao;
import com.mio.service.UserService;

import mio.com.anno.Bean;
import mio.com.anno.Di;

//添加自定义注解
@Bean
public class UserServiceImpl implements UserService {
	
	@Di
	private UserDao userDao;

	@Override
	public void add() {
		System.out.println("service ...");
	}

}
