package com.mio.spring6.aop.xmlaop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

//切面类
@Component
public class LogAspect {
	//设置切入点和通知类型
	//前置通知
	public void beforeMethod() {
		System.out.println("\n[Logger][前置通知]");
	}
	
	// 返回通知: 可以获取返回值。注解中可用returning=定义变量名，函数参数中使用该变量名，函数内可以使用该变量。
	public void afterReturningMethod(Object myResult) {
		System.out.println("[Logger][返回通知] 返回结果:"+myResult);		
	}
	
	// 异常通知：目标方法出现异常，则执行，这时不会执行返回通知。不异常不执行。
	// 注解中可用 throwing=定义异常变量，函数参数中接收该变量，函数内可以使用该变量。
	public void afterThrowingMethod(Throwable ex) {
		System.out.println("[Logger][异常通知] 异常:"+ex);
	}
	
	// 后置通知：在返回之后执行
	/* joinPoint 参数，可以获得 切入点 位置的信息
	 * */
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName(); //获取要增强的方法名
		//获取要增强的方法的参数
		Object[] args = joinPoint.getArgs();
		System.out.println("[Logger][后置通知] 方法名称:"+ methodName+", 参数列表: "+Arrays.toString(args)+"\n");
	}
	
	
	// 环绕通知: 使用子接口 ProceedingJoinPoint，是继承自 JoinPoint 的。增强后能调用 .proceed() 方法
	public Object aroundMethod(ProceedingJoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName(); //获取要增强的方法名
		//获取要增强的方法的参数
		Object[] args = joinPoint.getArgs();
		String argsString =Arrays.toString(args);
		
		Object result=null;
		try {
			System.out.println("\t~"+methodName+"[Logger][环绕通知] {目标方法执行前 执行}");
			//调用目标方法
			result = joinPoint.proceed();
			System.out.println("\t~"+methodName+"[Logger][环绕通知] {目标方法返回值后 执行}, result="+result);
		} catch (Throwable e) {
			System.out.println("\t~"+methodName+"[Logger][环绕通知] {异常时 执行}, 异常信息: "+e);
			e.printStackTrace();
		}finally {
			System.out.println("\t~"+methodName+"[Logger][环绕通知] {目标方法执行后 执行}");
		}
		
		return result;
	}
}
