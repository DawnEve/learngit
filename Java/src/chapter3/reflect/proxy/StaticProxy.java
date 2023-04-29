package chapter3.reflect.proxy;

public class StaticProxy {
	public static void main(String[] args) {
//		demo1();
		demo2();
	}

	//都是同一个接口，类型都用该接口类型
	private static void demo2() {
		//1.被代理对象
		ClothFactory nike=new NikeClothFactory();
		//2.代理对象
		ClothFactory proxy_nike = new ProxyClothFactory(nike);
		//3.使用代理调用 被代理类的方法
		proxy_nike.produceCloth();
	}

	private static void demo1() {
		//1.被代理对象
		NikeClothFactory nike=new NikeClothFactory();
		//2.代理对象
		ProxyClothFactory proxy_nike = new ProxyClothFactory(nike);
		//3.使用代理调用 被代理类的方法
		proxy_nike.produceCloth();
	}
	
}



// 静态代理例子：代理类和被代理类在编译期间就已经确定了，写死了
//定义接口
interface ClothFactory{
	void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory{
	private ClothFactory factory; //用被代理的对象进行初始化

	public ProxyClothFactory(ClothFactory factory) {
		super();
		this.factory = factory;
	}

	@Override
	public void produceCloth() {
		System.out.println("代理工厂 开始的准备工作");
		factory.produceCloth();
		System.out.println("代理工厂 首尾工作");
	}
}


// 被代理类
class NikeClothFactory implements ClothFactory{

	@Override
	public void produceCloth() {
		System.out.println("Nike工厂生产一批衣服");
	}
	
}