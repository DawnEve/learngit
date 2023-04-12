package com.mio.spring6.aop.xmlaop;

import org.springframework.stereotype.Component;

//基本实现类
@Component
public class CalculatorImpl implements Calculator {

	@Override
	public int add(int i, int j) {
		int result=i+j;
		System.out.println("方法内结果 add result="+result);
		return result;
	}

	@Override
	public int sub(int i, int j) {
		int result=i-j;
		System.out.println("方法内结果 sub result="+result);
		return result;
	}

	@Override
	public int mul(int i, int j) {
		int result=i*j;
		System.out.println("方法内结果 mul result="+result);
		return result;
	}

	@Override
	public int div(int i, int j) {
		int result=i/j;
		System.out.println("方法内结果 div result="+result);
		return result;
	}

}
