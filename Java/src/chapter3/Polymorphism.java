package chapter3;
/**
 * 经典笔试题（混合重载和重写）：
 * http://www.jb51.net/article/34413.htm
 * @author admin
 *
 */
public class Polymorphism {
	public static void main(String[] args){
		A a1 = new A();
        A a2 = new B();//以左边的类型为准
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println("1:"+a1.show(b));//aa
        System.out.println("2:"+a1.show(c));//aa
        System.out.println("3:"+a1.show(d));//ad
        System.out.println("4:"+a2.show(b));//bb//aa
        System.out.println("5:"+a2.show(c));//bb//
        System.out.println("6:"+a2.show(d));//ba//
        System.out.println("7:"+b.show(b));//bb
        System.out.println("8:"+b.show(c));//bb
        System.out.println("9:"+b.show(d));//ba//
	}
}

class A {
    public String show(D obj){
    	return ("A and D");
    }
    public String show(A obj){
    	return ("A and A");
    }
}
class B extends A{
    public String show(B obj){
        return ("B and B");
    }
    @Override 
    public String show(A obj){
        return ("B and A");
    } 
}
class C extends B{} 
class D extends B{} 


/*
方法调用的优先问题 ，优先级由高到低依次为：？
	this.show(O)、super.show(O)、this.show((super)O)、super.show((super)O)。
(1)使用父类类型的引用指向子类的对象；
(2)引用只能调用父类中定义的方法和变量；
(3)子类中重写了父类的一个方法，那么在调用该方法时，将会调用子类的这个方法。
	动态连接、动态调用。
(4)变量不能被重写（覆盖）。重写只针对方法，如果子类“重写”了父类的变量，那么编译时会报错。
* */
