package com.mio.spring6.validator.two;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@Service
public class MyValidation1 {

	@Autowired
	private Validator validator;
	
	public boolean validatorByUser1(User user) {
		Set<ConstraintViolation<User>> validate = validator.validate(user);
		//System.out.println(validate);
		return validate.isEmpty();
		
	}
}
