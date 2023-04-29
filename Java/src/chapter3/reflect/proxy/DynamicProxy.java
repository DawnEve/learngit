package chapter3.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {
	public static void main(String[] args) {
//		demo1();
//		demo2();
		demo3();
	}

	private static void demo3() {
		//使用上一节静态代理的例子，测试
		NikeClothFactory obj = new NikeClothFactory();
		ClothFactory proxy2=(ClothFactory) ProxyFactory.getProxyInstance(obj);
		proxy2.produceCloth();
	}

	private static void demo2() {
		//获取动态代理对象
		Flyable proxyInstance = (Flyable) ProxyFactory.getProxyInstance(new FlyMouse());
		//调用方法:通过代理类调用方法时，自动调用被代理类的同名方法
		System.out.println( proxyInstance.getName() );
		proxyInstance.fly(10);
	}

	private static void demo1() {
		Bird bird=new Bird();
		//获取动态代理对象
		Flyable proxyInstance = (Flyable) ProxyFactory.getProxyInstance(bird);
		//调用方法:通过代理类调用方法时，自动调用被代理类的同名方法
		System.out.println( proxyInstance.getName() );
		proxyInstance.fly(1000); //带参数的调用
	}

}

//定义接口
interface Flyable{
	String getName();
	void fly(int speed);
}

//被代理类
class Bird implements Flyable{

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
class FlyMouse implements Flyable{

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
class ProxyFactory{
	//1.返回一个代理类的对象
	public static Object getProxyInstance(Object obj) { //obj就是被代理对象
		//触发器负责调用方法
		MyInvocationHandler handler = new MyInvocationHandler(); //该类的实现见下文
		handler.bind(obj); //传入 被代理类的对象
		
		//3个参数：类加载器、接口、触发器，返回一个代理类的对象，解决问题1
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), 
				obj.getClass().getInterfaces(), 
				handler);
	}
}

class MyInvocationHandler implements InvocationHandler{
	private Object obj; //赋值时，需要使用被代理类的对象进行赋值
	public void bind(Object obj) { //这里赋值
		this.obj=obj;
	}
	
	//通过代理类的对象，调用方法时，会自动调用如下方法 invoke()
	//被代理类要执行的方法的功能，声明在 invoke() 中
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//极为重要！代理类对象调用的方法，也在这里调用 被代理类对象的同名方法
		//注意3个参数的来源 A.invoke(B, C); A是要调用的方法，B是被代理类的对象(bind(传入))，C是参数
		Object returnValue = method.invoke(obj, args);
		//被代理对象调用的返回值，作为 invoke 方法的返回值
		return returnValue;
	}
}