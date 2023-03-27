package chapter3.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy2 {
	public static void main(String[] args) {
		demo1();
//		demo2();
//		demo3();
	}

	private static void demo3() {
		//使用上一节静态代理的例子，测试
		NikeClothFactory obj = new NikeClothFactory();
		ClothFactory proxy2=(ClothFactory) ProxyFactory2.getProxyInstance(obj);
		proxy2.produceCloth();
	}

	private static void demo2() {
		//获取动态代理对象
		Flyable2 proxyInstance = (Flyable2) ProxyFactory2.getProxyInstance(new FlyMouse2());
		//调用方法:通过代理类调用方法时，自动调用被代理类的同名方法
		System.out.println( proxyInstance.getName() );
		proxyInstance.fly(10);
	}

	private static void demo1() {
		Bird2 bird=new Bird2();
		//获取动态代理对象
		Flyable2 proxyInstance = (Flyable2) ProxyFactory2.getProxyInstance(bird);
		//调用方法:通过代理类调用方法时，自动调用被代理类的同名方法
		System.out.println( proxyInstance.getName() );
		proxyInstance.fly(1000); //带参数的调用
	}

}

//定义接口
interface Flyable2{
	String getName();
	void fly(int speed);
}

//被代理类
class Bird2 implements Flyable2{

	@Override
	public String getName() {
		return "I am a bird";
	}

	@Override
	public void fly(int speed) {
		System.out.println("Bird can fly at speed: "+speed);
	}
}

//被代理类2
class FlyMouse2 implements Flyable2{

	@Override
	public String getName() {
		return "I am a FlyMouse";
	}

	@Override
	public void fly(int speed) {
		System.out.println("FlyMouse can fly at speed: "+speed);
	}
}

/*实现动态代理类，需要解决的问题？
*问题1.如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象？
*问题2.通过代理类的对象调用方法时，怎么动态的调用被代理类的同名方法？
*/
class ProxyFactory2{
	//1.返回一个代理类的对象
	public static Object getProxyInstance(Object obj) { //obj就是被代理对象
		//触发器负责调用方法
		MyInvocationHandler2 handler = new MyInvocationHandler2(); //该类的实现见下文
		handler.bind(obj); //传入 被代理类的对象
		
		//3个参数：类加载器、接口、触发器，返回一个代理类的对象，解决问题1
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), 
				obj.getClass().getInterfaces(), 
				handler);
	}
}



//切面方法
class MyUtil{
	static void method1() {
		System.out.println("\n======前处理步骤~~======");
	}
	static void method2() {
		System.out.println("======后处理步骤！~~======");
	}
}


class MyInvocationHandler2 implements InvocationHandler{
	private Object obj; //赋值时，需要使用被代理类的对象进行赋值
	public void bind(Object obj) { //这里赋值
		this.obj=obj;
	}
	
	//通过代理类的对象，调用方法时，会自动调用如下方法 invoke()
	//被代理类要执行的方法的功能，声明在 invoke() 中
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		MyUtil util=new MyUtil();
		util.method1();
		
		//极为重要！代理类对象调用的方法，也在这里调用 被代理类对象的同名方法
		//注意3个参数的来源 A.invoke(B, C); A是要调用的方法，B是被代理类的对象(bind(传入))，C是参数
		Object returnValue = method.invoke(obj, args);
		//被代理对象调用的返回值，作为 invoke 方法的返回值
		
		util.method2();
		return returnValue;
	}
}