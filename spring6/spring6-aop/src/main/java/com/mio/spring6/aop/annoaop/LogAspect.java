package com.mio.spring6.aop.annoaop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//切面类
@Aspect //这是个切面类
@Component  //Spring 扫描该文件，并实例化放到容器中
public class LogAspect {
	
	//设置切入点和通知类型
	// 通知类型，为每个类型创建一个方法
	// 前置通知 @ Before(value = "切入点表达式 配置切入点")
	
	/* 【切入点表达式】的语法: execution(权限修饰符public 返回值类型int 全类名.方法名(参数类型列表))
	 * 权限修饰符+返回值类型，用*表示任意
	 * 包名: *表示包名任意，*... 表示包名任意同时包的层次深度任意
	 * 类名: *表示任意类；类名的一部分可以用*代替，如 *Service 表示匹配Service结尾的类或接口
	 * 方法名: *表示任意方法名；方法名的一部分可以用*替代，如 get* 表示匹配get开头的方法
	 * 参数列表: .. 使用两个点表示任意参数列表；注意int和Integer是不匹配的；
	 * 注意：如果想明确指定一个函数的返回值类型，比如同时明确指定权限修饰符:
	 * 如: execution(public int ..Service.(.., int) 正确
	 * 如: execution(int ..Service.(.., int) 错误
	 */
	@Before(value = "execution(public int com.mio.spring6.aop.annoaop.CalculatorImpl.add(int,int))")
	public void beforeMethod() {
		System.out.println("\n[Logger][前置通知]");
	}
	
	// 返回通知: 可以获取返回值。注解中可用returning=定义变量名，函数参数中使用该变量名，函数内可以使用该变量。
	@AfterReturning(value = "execution(* com.mio.spring6.aop.annoaop.CalculatorImpl.*(..))", 
			returning = "myResult")
	public void afterReturningMethod(Object myResult) {
		System.out.println("[Logger][返回通知] 返回结果:"+myResult);		
	}
	
	// 异常通知：目标方法出现异常，则执行，这时不会执行返回通知。不异常不执行。
	// 注解中可用 throwing=定义异常变量，函数参数中接收该变量，函数内可以使用该变量。
	@AfterThrowing(value = "execution(* com.mio.spring6.aop.annoaop.CalculatorImpl.*(..))",
			throwing = "ex")
	public void afterThrowingMethod(Throwable ex) {
		System.out.println("[Logger][异常通知] 异常:"+ex);
	}
	
	// 后置通知：在返回之后执行
	/* joinPoint 参数，可以获得 切入点 位置的信息
	 * */
	@After(value = "com.mio.spring6.aop.annoaop.LogAspect.pointCut2()")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName(); //获取要增强的方法名
		//获取要增强的方法的参数
		Object[] args = joinPoint.getArgs();
		System.out.println("[Logger][后置通知] 方法名称:"+ methodName+", 参数列表: "+Arrays.toString(args)+"\n");
	}
	
	
	// 环绕通知: 使用子接口 ProceedingJoinPoint，是继承自 JoinPoint 的。增强后能调用 .proceed() 方法
	@Around(value = "pointCut2()")
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
	
	
	//重用切入点表达式
	@Pointcut(value="execution(public int com.mio.spring6.aop.annoaop.CalculatorImpl.*(..))")
	public void pointCut2() {}
}
