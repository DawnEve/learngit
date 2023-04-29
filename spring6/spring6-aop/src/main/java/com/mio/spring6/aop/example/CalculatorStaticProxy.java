package com.mio.spring6.aop.example;

public class CalculatorStaticProxy implements Calculator {
	//被代理对象
	private Calculator calculator;
	//通过构造传入该参数
	public CalculatorStaticProxy(Calculator calculator) {
//		super();
		this.calculator = calculator;
	}

	@Override
	public int add(int i, int j) {
		//输出日志1
		System.out.println("[日志] add 方法开始了，参数是: "+i+", "+j);
		
		//调用目标对象的方法实现核心业务
		int result=calculator.add(i, j);
		
		//输出日志2
		System.out.println("[日志] add 方法结束了，结果是: "+result);
		return result;
	}

	@Override
	public int sub(int i, int j) {
		return 0;
	}

	@Override
	public int mul(int i, int j) {
		return 0;
	}

	@Override
	public int div(int i, int j) {
		return 0;
	}

}
