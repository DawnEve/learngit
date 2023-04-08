package com.mio.spring6.iocannotation.autowired.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public void add() {
		System.out.println("dao.add() ...");
	}

}
