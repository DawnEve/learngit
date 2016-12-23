package chapter5;

/**
 * 错的启动多线程的例子
 * @author admin
 *
 */
public class ThreadDemo {
	public static void main(String[] args){
		demo();//启动的单个线程
//		demo1();
//		demo2();
	}

	//直接调用run，就是作为主线程的一部分。
	private static void demo() {
		System.out.println("主线程："+Thread.currentThread().toString());//Thread[main,5,main]
		new T1().run();//Thread[main,5,main]
		new T1().run();
		new T1().run();
		
	}

	private static void demo2() {
		System.out.println("主线程："+Thread.currentThread().toString());
		
		//为什么没有打印出偶数线程？
		new Thread(new T2()).start();
		new Thread(new T2()).start();
		
		//因为继承Thread的线程直接start启动，不需要在new一个Thread。 
		//(new T2()).start();//这个是对的

	}

	private static void demo1() {
		System.out.println("主线程："+Thread.currentThread().toString());
		T1 t1=new T1();
//		Thread t=new Thread(t1);//Runnable必须通过Thread类执行多线程，否则仅仅是主线程的一部分
		t1.start();//启动线程
	}
}


class T1 extends Thread{
	public void run(){
		System.out.println("  |-继承Thread的线程1："+Thread.currentThread().toString());
	}
}

class T2 extends Thread{
	public void run(){
		System.out.println("通过继承Thread定义的线程2："+Thread.currentThread().toString());
		for(int i=0;i<5;i++){
			//System.out.println("继承Thread定义的线程3："+Thread.currentThread().toString() + i);
			new Thread(new T1()).start();
			//new T1().start();
		}
	}
}