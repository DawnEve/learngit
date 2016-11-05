package chapter3.reflect.Generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericsMethodDemo {
	public static void main(String[] args){
//		demo1();
		demo2();
//		demo3("findingsea", 123, 11.11, true);
	}
	
	/**
	 * 带继承的泛型方法
	 * <? extends Xx>   <? super Xx>
	 * 小结一下就是：上界add方法受限，下界get方法受限。
	 * http://blog.csdn.net/daniel_h1986/article/details/5708605
	 */
	private static void demo2(){
		List<ITBook> ls=new ArrayList<ITBook>();
//		ls.add(new Book("some"));
		ls.add(new ITBook("ITBook--"));
		ls.add(new JavaBook("Java"));
		ls.add(new JspBook("Jsp"));
		printBookExtends(ls);
		printBookSuper(ls);
	}
	private static void printBookExtends(List<? extends ITBook> t) {
		//传入值必须必限定低级，可以为<? extends Book>
		
		//t.add(new JspBook("IT2"));//编译失败
		//由于无法确定?类型到底有多低级，基类无法转换为子类，所以编译失败
		
		ITBook b=t.get(0);
		System.out.print(b);
		
		System.out.println(t.toString());
	}

	private static void printBookSuper(List<? super JavaBook> t) {
		//传入值必须必限定高级，可以为<? extends ITBook> JavaBook JspBook
		//为什么是JavaBook也行？传入的JspBook更低级
		
		t.add(new JspBook("Jsp2"));//为什么没有超过JavaBook级别，依旧通过了呢？
		//java多态在编译的时候会被移除，就固定了。
		//因为能放入某一类的容器一定可以放入其子类，多态的概念。
		
		//JavaBook b=t.get(0);//编译失败
		//因为无法确定类比JavaBook高级多少
		Object b=t.get(0);//使用最高级就好了
		System.out.print(b);
		
		System.out.println(t.toString());
	}
	
	
	/**
	 * 泛型方法
	 */
	public static void demo1(){
		List<Book> list=new ArrayList<Book>();
		list.add( new Book("book1") );
		list.add( new Book("book2") );
		list.add( new Book("book3") );
		
		Book b=getFirst(list);
		System.out.println(b.toString());
		System.out.println(getLast(list));
	}
	
	//泛型方法1 getFirst
	public static <T> T getFirst(List<T> list){
		return list.get(0);
	}
	//泛型方法2 getLast
	public static <T> T getLast(List<T> list){
		return list.get(list.size()-1);
	}
	
	/**
	 * 泛型可以和可变参数非常完美的结合。
	 * 一个基本的原则是：无论何时，只要你能做到，你就应该尽量使用泛型方法。
	 * @param args
	 */
	public static <T> void demo3(T... args) {//这个使用了...符号接收数组//TODO??
        for (T t : args) {
            System.out.println(t);
        }
    }
}





class ReadableThing{
	
}
//1
class Book extends ReadableThing{
	public String name="no name";
	public Book(){
		super();
	}
	public Book(String name){
		this.name=name;
	}
	
	@Override
	public String toString(){
		return this.name;
	}
}
//2
class ITBook extends Book{
	public ITBook(String string) {
		super(string);
	}
}
//3
class JavaBook extends ITBook{
	public JavaBook(String string) {
		super(string);
	}
}
//4
class JspBook extends JavaBook{
	public JspBook(String string) {
		super(string);
	}
}