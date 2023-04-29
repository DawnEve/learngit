package com.mio.spring6.iocxml.factorybean;

import org.springframework.beans.factory.FactoryBean;

//在配置文件中配置 MyFactoryBean，返回的确实其中返回的对象
public class MyFactoryBean implements FactoryBean<User> {

	@Override
	public User getObject() throws Exception {
		return new User();
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}

}
