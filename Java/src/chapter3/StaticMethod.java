package chapter3;

public class StaticMethod {
	static int count=0;
	{
		count=100; //可以在静态语句块中初始化
	}
    public static void main(String[] args) {
    	StaticMethod a1=new StaticMethod();
		System.out.println(a1.count);
		
		//类变量 全局只有一份
		StaticMethod a2=new StaticMethod();
		a2.inc();
		System.out.println(a2.count);
	}
	
	public void inc(){
		count++;
	}
}

