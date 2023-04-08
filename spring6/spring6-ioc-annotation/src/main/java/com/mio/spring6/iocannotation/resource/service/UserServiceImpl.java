package com.mio.spring6.iocannotation.resource.service;

import org.springframework.stereotype.Service;

import com.mio.spring6.iocannotation.resource.dao.UserDao;

import jakarta.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

	//根据名称进行注入
	@Resource(name = "userRedisDaoImpl2")
	private UserDao userDao;
	
	@Override
	public void add() {
		System.out.println("service.add() ...");
		userDao.add();
	}
}
