package com.mio.spring6.validator.four;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Service
@Validated //表示校验方法
public class MyService {
	//参数加2个注解
	public String testMethod(@NotNull @Valid User user) {
		return user.toString();
	}
}
