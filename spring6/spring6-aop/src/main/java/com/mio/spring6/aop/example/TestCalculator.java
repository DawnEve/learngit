package com.mio.spring6.aop.example;

import org.junit.jupiter.api.Test;

public class TestCalculator {
	@Test
	public void test01() {
		Calculator calc=new CalculatorImpl();
		int result = calc.add(140, 10);
		System.out.println(result);
	}
	
	@Test
	public void test02() {
		Calculator calc=new CalculatorLogImpl();
		int result = calc.add(140, 10);
		System.out.println(result);
	}
	
	@Test
	public void test03() {
		Calculator calc=new CalculatorImpl();
		Calculator calcProxy=new CalculatorStaticProxy(calc);
		calcProxy.add(200, 300);
	}
	
	@Test
	public void test04() {
		//动态代理
		//1 创建目标对象
		Calculator calc=new CalculatorImpl();
		//2 通过动态代理 获取代理类
		ProxyFactory proxyFactory = new ProxyFactory(calc);
		Calculator proxy = (Calculator) proxyFactory.getProxy();
		//3 调用目标方法
		proxy.mul(5, 25);
		System.out.println();
		
		
		//注意: 动态代理 目标类要实现接口，否则无法创建动态代理
		//4 another test: 通过动态代理获取其代理 
//		Book book = new BookImpl("Java 宝典");
//		ProxyFactory proxyFactory2 = new ProxyFactory(book);
//		Book proxy2 = (Book) proxyFactory2.getProxy();
		
		//对方法中的 内部类 动态代理
		interface Book {
			public void run();
		}
		
		class BookImpl implements Book {
			private String name;
			public BookImpl(String name) {
				this.name=name;
			}
			public void run() {
				System.out.println("Book.run()..."+name);
			}
		}
		//System.out.println(proxy2);
		//简写为一行
		Book proxy2=(Book) new ProxyFactory(new BookImpl("Java 宝典3")).getProxy();
		proxy2.run();
		System.out.println();
		
		
		//5 没有接口的类的动态代理？
		/* 不能！JDK的动态代理必须有接口。
		 * https://www.cnblogs.com/WeidLang/p/9857495.html
		 */
		class Bird{
			public void fly() {
				System.out.println("bird.fly()...");
			}
		}
		//Bird proxy3=(Bird) new ProxyFactory(new Bird()).getProxy(); //getProxy函数报错
		//System.out.println(proxy3);
		//proxy3.fly();
	}

}
