/**
 * 练习使用object对象的方法
 * @author admin
 */
public class Err {
	public static void main(String[] args) {
//		demo1();
		demo2();
		
	}

	private static void demo2() {
		Object o=new Object();
		Object o2=new Object();
		int i=135;
		System.out.println(i);
		System.out.println(o);//java.lang.Object@2a139a55
		System.out.println(o2);//java.lang.Object@15db9742
		System.out.println(o==o2);//false
		System.out.println(o2.getClass()==o.getClass());//true
		System.out.println(o.getClass());     //class java.lang.Object
		System.out.println(o2.getClass().getName());//java.lang.Object
	}

	private static void demo1() {
		Demo d=new Demo();
		System.out.println(d);//Demo@2a139a55
		System.out.println(d.getClass());//class Demo
		System.out.println(d.getClass()==Demo.class);//true
		System.out.println("============");
		System.out.println(d.getClass().getName());//Demo
		System.out.println(d.hashCode());//705927765
		System.out.println(Integer.toHexString(d.hashCode()));//2a139a55
		
		//默认的toString方法
		String str=d.getClass().getName()+"@"+ Integer.toHexString( d.hashCode() );
		System.out.println("默认的toString方法:"+str);//Demo@2a139a55
		
		System.out.println("--------");
		Demo d1=null;
		try {
			d1 = d.getClass().newInstance();
			System.out.println(d1);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

}

/**
 * 测试使用
 * @author admin
 */
class Demo{
	void say(){
		System.out.println("i am a demo instance.");
	}
	
	// 重写toString方法，探讨toString方法的本质。
	@Override
	public String toString(){
		String str=this.getClass().getName()+"[==@==]"+ Integer.toHexString( this.hashCode() );
		return str;
	}
}