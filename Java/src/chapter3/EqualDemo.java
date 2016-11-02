package chapter3;

public class EqualDemo {
	/**
	 * 对象相等的判断用equals()方法
	 * @param args
	 */
	public static void main(String[] args){
		EqualDemo e1=new EqualDemo();
		EqualDemo e2=new EqualDemo();
		EqualDemo e3=e1;
		
		if(e1.equals(e3)){
			System.out.print("Equal");
		}else{
			System.out.print("Not Equal");
		}
	}
	
}
