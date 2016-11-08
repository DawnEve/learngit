package chapter5;

public class ThreadDemo2 {
	public static void main(String[] args){
//		demo1();
		demo2();
	}

	private static void demo2() {
		System.out.println("主线程："+Thread.currentThread().toString());
		
		(new Th2()).start();
		new Th2().start();
	}

	private static void demo1() {
		System.out.println("主线程："+Thread.currentThread().toString());
		Th1 t1=new Th1();
		t1.start();//启动线程
	}
}


class Th1 extends Thread{
	public void run(){
		System.out.println("  |-继承Thread的线程类Th1："+Thread.currentThread().toString());
	}
}

class Th2 extends Thread{
	public void run(){
		System.out.println("通过继承Thread定义的线程类Th2："+Thread.currentThread().toString());
		for(int i=0;i<5;i++){
			//System.out.println("继承Thread定义的线程3："+Thread.currentThread().toString() + i);
			new Th1().start();
		}
	}
}