package com.mio.spring6.validator.one;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

public class TestPerson {
	public static void main(String[] args) {
		//1 创建 person 对象
		Person person = new Person();
		/*尝试设置，消除错误提示
		 */
		person.setName("Tom");
		person.setAge(250);
		
		//2 创建 person对应 databinder
		DataBinder binder = new DataBinder(person);
		
		//3 设置校验器
		binder.setValidator(new PersonValidator());
		
		//4 调用方法执行校验
		binder.validate();
		
		//5 输出校验结果
		BindingResult bindingResult = binder.getBindingResult();
		System.out.println(bindingResult.getAllErrors());
	}

}
