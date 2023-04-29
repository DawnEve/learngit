package com.mio.spring6.validator.one;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator{

	//用来表示该校验用在哪个类型上
	@Override
	public boolean supports(Class<?> clazz) {
		return Person.class.equals(clazz);
	}

	//校验规则
	@Override
	public void validate(Object target, Errors errors) {
		//name不能为空: 1 错误； 2 校验的属性； 3 错误码； 4 默认错误提示信息
		ValidationUtils.rejectIfEmpty(errors, "name", "name.empty", "name is null");
		
		//age 不能小于0，不能大于200
		Person p=(Person) target;
		if(p.getAge()<0) {
			errors.rejectValue("age", "age.value.error", "age<0"); //1 校验的属性； 2 错误码； 3 默认错误提示信息
		}else if(p.getAge()>200) {
			errors.rejectValue("age", "age.value.error.toolarge", "age>200");
		}
	}
}
