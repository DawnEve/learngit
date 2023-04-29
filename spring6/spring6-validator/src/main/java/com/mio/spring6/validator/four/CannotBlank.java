package com.mio.spring6.validator.four;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;

//模仿 @NotNull 注解实现
@Target({ FIELD }) //加到属性上
@Retention(RUNTIME) //运行时有效
@Documented //javadoc将提取该注解信息
@Constraint(validatedBy = { CannotBlankValidation.class })
public @interface CannotBlank {

	String message() default "不能包含空格"; //默认的错误提示信息

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

	/**
	 * Defines several {@code @NotBlank} constraints on the same element.
	 * 复数个同名注解时
	 *
	 * @see NotBlank
	 */
	@Target({ FIELD})
	@Retention(RUNTIME)
	@Documented
	public @interface List {
		CannotBlank[] value(); //注意修改这个名字，和类名一致
	}
}
