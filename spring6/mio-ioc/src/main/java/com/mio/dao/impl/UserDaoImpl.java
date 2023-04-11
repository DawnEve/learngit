package com.mio.dao.impl;

import com.mio.dao.UserDao;

import mio.com.anno.Bean;

@Bean
public class UserDaoImpl implements UserDao {

	@Override
	public void add() {
		System.out.println("dao ...");
	}

}
