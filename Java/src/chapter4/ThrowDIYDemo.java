package chapter4;
/**
 * 自定义异常
 * @author admin
 */
public class ThrowDIYDemo {
//	public static void main(String[] args) throws MyException {
	public static void main(String[] args){
		//抛出异常
		int[] a={1,2,3};
		try {
			readArray(a); //这里不得不处理了，否则就中断。
		} catch (MyException e) {
			//e.printStackTrace();
			e.say(e.toString());//异常的可调用方法
			System.out.println("4. 异常信息是： "+e.getMessage());
		}finally{
			System.out.println("5.--- end ---");
		}
	}
	
	//使用自定义异常
	public static void readArray(int[] arr) throws MyException{
		try{
			System.out.println(arr[arr.length+1]);
		}catch(Exception e){
			//处理不了，就抛出给上层处理
			throw new MyException("遇到 数组下标越界 异常");
		}
	}
}

/**
 * 自定义异常
 * @author admin
 *
 */
class MyException extends Exception{
	String msg="";

	private static final long serialVersionUID = 1L;
	public MyException(){}
	public MyException(String s){
		super(s);
		this.msg=s; 
		System.out.println("1. my own exception...happened");
	}
	
	//自定义异常可以自定义方法
	public void say(String word){
		System.out.println("2. 异常信息Say："+this.msg);
		System.out.println("3 "+word);
	}
}