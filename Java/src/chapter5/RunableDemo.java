package chapter5;

public class RunableDemo {
	public static void main(String[] args){
//		demo1();
		demo2();
	}

	//启动多个线程
	private static void demo2() {
		System.out.println(Thread.currentThread().toString());//Thread[main,5,main]
		//当前线程名字,优先级,调用线程
				
		MyRun mr1=new MyRun();
		MyRun mr2=new MyRun();
		Thread t1=new Thread(mr1);//必须通过Thread类执行多线程，否则仅仅是主线程的一部分
		Thread t2=new Thread(mr2);
		t1.start();//启动线程
		
		try {
			Thread.sleep(135);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		t2.setPriority(Thread.MAX_PRIORITY);//设置权限优先级1-10
		t2.setPriority(Thread.MIN_PRIORITY);//设置权限优先级1-10
		t2.start();//启动线程
	}

	//启动一个线程
	private static void demo1() {
		MyRun mr=new MyRun();
		Thread t=new Thread(mr);//必须通过Thread类执行多线程，否则仅仅是主线程的一部分
		t.start();//启动线程
	}
}


class MyRun implements Runnable{
	static int count=0;//怎么保证这些数字的顺序
	int count2=0;
	
	public void run(){
		MyRun.count++;
		System.out.println("通过实现Runnable接口定义的线程: "+MyRun.count);
		
		
//		Thread thread=Thread.currentThread();
		this.count2++;
		for(int i=0;i<5;i++){
			//可见线程都执行到这里了，并且互不影响
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			System.out.print(thread.toString());//两条语句会有先后 
			System.out.println(Thread.currentThread().toString()+" :[count2="+this.count2+",count="+MyRun.count+"] i="+i);
		}
	}
}
