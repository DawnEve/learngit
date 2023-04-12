package com.mio.spring6.aop.example;

//带日志功能的实现类
public class CalculatorLogImpl implements Calculator {

	@Override
	public int add(int i, int j) {
		System.out.println("[日志] add 方法开始了，参数是: "+i+", "+j);
		int result=i+j;
		System.out.println("方法内结果 add result="+result);
		System.out.println("[日志] add 方法结束了，参数是: "+i+", "+j);
		return result;
	}

	@Override
	public int sub(int i, int j) {
		System.out.println("[日志] sub 方法开始了，参数是: "+i+", "+j);
		int result=i-j;
		System.out.println("方法内结果 sub result="+result);
		System.out.println("[日志] sub 方法结束了，参数是: "+i+", "+j);
		return result;
	}

	@Override
	public int mul(int i, int j) {
		System.out.println("[日志] mul 方法开始了，参数是: "+i+", "+j);
		int result=i*j;
		System.out.println("方法内结果 mul result="+result);
		System.out.println("[日志] mul 方法结束了，参数是: "+i+", "+j);
		return result;
	}

	@Override
	public int div(int i, int j) {
		System.out.println("[日志] div 方法开始了，参数是: "+i+", "+j);
		int result=i/j;
		System.out.println("方法内结果 div result="+result);
		System.out.println("[日志] div 方法结束了，参数是: "+i+", "+j);
		return result;
	}
}
