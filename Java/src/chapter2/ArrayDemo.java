package chapter2;

public class ArrayDemo {
	public static void main(String[] args){
		test4();
	}

	//一维数组
	private static void test1() {
		int arr[] = new int[10];
		for(int i=0;i<10;i++){ //遍历、赋值
			arr[i] = i;
		}
		print_arr(arr);
	}
	
	//打印一维数组
	private static void print_arr(int[] arr) {
		int len=arr.length; 
		System.out.print("[");
		for(int i=0;i<len;i++){
			System.out.print(arr[i]);
			//System.out.println(len-i);
			if(len-i>1){
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
	
	//打印一维数组，最后带逗号...
	private static void print_arr2(int[] arr) {
		System.out.print("[");
		for(int x: arr){
			System.out.print(x + ", ");
		}
		System.out.println("]");
	}
	
	
	/**
	 * 数组的复制
	 */
	//数组的复制：数组是按地址传递的
	static void test2(){
		int[] arr1={1,2,3};
		int[] arr2=new int[3];
		
		//赋值
		arr2=arr1;//数组是按地址传递的
		
		arr2[0]=100; //修改arr2，则arr1也改变
		
		print_arr(arr1);
		print_arr(arr2);
	}
	
	//数组的复制：需要对元素一一复制
	static void test3(){
		int[] arr1={1,2,3};
		int[] arr2=new int[3];
		
		//赋值
		for(int i=0;i<arr1.length;i++){
			arr2[i]=arr1[i];
		}
				
		arr2[0]=100; //修改arr2，则arr1就不会改变了
		
		print_arr(arr1);
		print_arr(arr2);
	}
	/**
	 * 求数组的最值
	 */
	static void test4(){
		int[] arr1=new int[]{1,2,-5,9};
		System.out.println(getMax(arr1));
		System.out.println(getMin(arr1));
	}

	private static int getMin(int[] arr) {
		int num=arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i]<num)
				num=arr[i];
		}
		return num;
	}

	private static int getMax(int[] arr) {
		int num=arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i]>num)
				num=arr[i];
		}
		return num;
	}
	
	
	
	

}
