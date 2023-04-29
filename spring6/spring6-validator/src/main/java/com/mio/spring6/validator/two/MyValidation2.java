package com.mio.spring6.validator.two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.Validator;

@Service
public class MyValidation2 {

	@Autowired
	private Validator validator;
	
	public boolean validatorByUser2(User user) {
		BindException bindException = new BindException(user, user.getName());
		validator.validate(user, bindException);
		System.out.println("错误信息:" + bindException.getAllErrors());
		return !bindException.hasErrors();
	}
}
