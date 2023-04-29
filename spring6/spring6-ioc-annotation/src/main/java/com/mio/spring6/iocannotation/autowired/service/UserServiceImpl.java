package com.mio.spring6.iocannotation.autowired.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mio.spring6.iocannotation.autowired.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	//方式1：属性注入
//	@Autowired  //根据类型找到对应对象，完成注入
//	private UserDao userDao;
	
	//方式2：set注入: 定义set方法，并在set方法上添加@Autowired注解
//	private UserDao userDao;
//	@Autowired
//	public void setUserDao(UserDao userDao) {
//		this.userDao = userDao;
//	}
	
	//方式6: @Autowired + @Qualifier 注解联合；
	@Autowired
	@Qualifier(value="userRedisDaoImpl2")
	private UserDao userDao;



	@Override
	public void add() {
		System.out.println("service.add() ...3");
		userDao.add();
	}
}
