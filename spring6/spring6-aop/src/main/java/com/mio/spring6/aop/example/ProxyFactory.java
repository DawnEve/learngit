package com.mio.spring6.aop.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

//动态代理
public class ProxyFactory {
	//目标对象
	private Object target;
	//通过构造传入目标对象
	public ProxyFactory(Object target) {
//		super();
		this.target = target;
	}

	//返回代理对象：同时在方法执行前后添加日志
	public Object getProxy() {
		/* Proxy.newProxyInstance() 的三个参数
		 * ClassLoader loader, 加载动态生成代理类的类加载器
		 * Class<?>[] interfaces, 目标对象实现的所有接口的class类型数组
		 * InvocationHandler h 代理对象调用目标对象方法的过程
		 * */
		ClassLoader classLoader=target.getClass().getClassLoader();
		Class<?>[] interfaces = target.getClass().getInterfaces();
		//参数3有多种写法，这里使用匿名类
		InvocationHandler invocationHandler = new InvocationHandler() {
			/* invoke()方法的三个参数
			 * Object proxy, 代理对象
			 * Method method, 需要重写目标对象的方法
			 * Object[] args 就是method方法的参数
			 * */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//方法调用前 日志
				System.out.println("[动态代理日志] "+method.getName()+" 方法开始了，参数是: "+Arrays.toString(args));
				
				//调用目标类的方法，这俩只是同名，并不一样。
				Object result = method.invoke(target, args);
				
				//方法调用后 日志
				System.out.println("[动态代理日志] "+method.getName()+" 方法结束了，结果是: "+result);
				
				return result;
			}
		};
		return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
	}
}
