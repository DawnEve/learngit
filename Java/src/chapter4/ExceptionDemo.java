package chapter4;

//异常的捕获

public class ExceptionDemo {
	static public void main(String[] args){
		//System.out.println(args);//[Ljava.lang.String;@2a139a55
		main(new int[]{1,2,3},5);
	}
	
	//例子下标越界例子
	static void main(int[] arr, int at){
		try{
			System.out.println(arr[at]);
		}catch(ArrayIndexOutOfBoundsException e){
			//e.printStackTrace();
			System.out.println(arr[arr.length - 1]);
		}finally{
			System.out.println("A text at the end of try...catch...finally.");
		}
	}
}
