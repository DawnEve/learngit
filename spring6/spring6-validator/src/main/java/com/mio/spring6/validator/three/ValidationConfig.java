package com.mio.spring6.validator.three;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@Configuration
@ComponentScan("com.mio.spring6.validator.three")
public class ValidationConfig {
	
	@Bean
	public MethodValidationPostProcessor validationPostProcessor() {
		return new MethodValidationPostProcessor();
	}
}
