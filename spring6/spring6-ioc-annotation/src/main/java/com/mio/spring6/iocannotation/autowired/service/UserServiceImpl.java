package com.mio.spring6.iocannotation.autowired.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mio.spring6.iocannotation.autowired.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	//方式1：属性注入
	@Autowired  //根据类型找到对应对象，完成注入
	private UserDao userDao;

	@Override
	public void add() {
		System.out.println("service.add() ...");
		userDao.add();
	}
}
