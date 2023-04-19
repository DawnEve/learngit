package com.mio.spring6.validator.four;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CannotBlankValidation implements ConstraintValidator<CannotBlank, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		System.out.println("this is validator...");
		// 校验器规则：如果不为空，且包含空格，则不通过校验
		if(value != null && value.contains(" ")) {
			//获取默认提示信息
			String defaultConstraintMessageTemplate = context.getDefaultConstraintMessageTemplate();
			System.out.println(defaultConstraintMessageTemplate);
			//禁用默认提示信息
			context.disableDefaultConstraintViolation();
			//设置新的提示语
			context.buildConstraintViolationWithTemplate("can not contain blanks").addConstraintViolation();
			return false;
		}
		return true;
	}
}
