package chapter3.Inner;

public class AnonymousDemo {
	public static void main(String[] args) {
		Read read=new Read();
		Book book=read.getOneBook();
		book.run();
		book.say();
		
		//直接实例化一个匿名类（是Book类的子类），并调用
		new Book(){
			void run(){};
		}.say();
		
		//判断确实是Book的子类的实例
		Boolean isSub=new Book(){
			void run(){};
		} instanceof Book;
		System.out.println("是否是Book的子类呢？"+isSub);
	}
}


abstract class Book{
	public void say() {
		System.out.println("Book say.");
	}
	abstract void run();
}

class Read{
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
