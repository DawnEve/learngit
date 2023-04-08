package com.mio.spring6.iocannotation.autowired.dao;

import org.springframework.stereotype.Repository;

@Repository(value="userRedisDaoImpl2")
public class UserRedisDaoImpl implements UserDao {

	@Override
	public void add() {
		System.out.println("dao redis ...");
	}
	//看引用该对象的类： UserServiceImpl
}
