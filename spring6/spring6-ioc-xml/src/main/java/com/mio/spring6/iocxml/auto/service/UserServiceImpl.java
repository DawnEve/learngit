package com.mio.spring6.iocxml.auto.service;

import com.mio.spring6.iocxml.auto.dao.UserDao;
//import com.mio.spring6.iocxml.auto.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addUserService() {
		System.out.println("UserService 方法执行了");
		//调dao
//		UserDao userDao=new UserDaoImpl();
		userDao.addUserDao();
	}
}
