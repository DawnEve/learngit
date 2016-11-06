package chapter3.Inner;
/**
 * 匿名类
 * @author admin
 */
public class AnonymousDemo {
	public static void main(String[] args) {
//		demo1();
//		demo2();
		demo3();
		//ReadInner
	}

	
	private static void demo3() {
		Read r=new Read();
		Read.ReadInner ri=r.new ReadInner();
		
	}


	private static void demo1() {
		//测试内部类
		Read read=new Read();
		Book book=read.getOneBook();
		book.run();
		book.say();
	}


	private static void demo2() {
		//直接实例化一个匿名类（是Book类的子类），并调用其方法
		new Book(){
			@Override
			void run(){ System.out.println("New run---"); };
		}.run();
		
		//判断确实是Book的子类的实例
		Boolean isSub=new Book(){
			void run(){};
		} instanceof Book;
		System.out.println("是否是Book的子类呢？"+isSub);
	}
}




class Study{}

abstract class Book{
	public void say() {
		System.out.println("Book say.");
	}
	abstract void run();
}

class Read extends Study{
	//定义内部类
	class ReadInner{
		ReadInner(){
			System.out.println("ReadInner init ==========");
		}
	}
	
	//获取匿名类
	public Book getOneBook(){
		return new Book(){
			@Override
			public void say(){
				System.out.println("say: I am in Read->Book");
			}

			@Override
			void run() {
				System.out.println("Book in Read is running...");
			}
		};
	}
}
