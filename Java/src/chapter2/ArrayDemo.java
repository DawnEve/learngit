package chapter2;

public class ArrayDemo {
	public static void main(String[] args){
		test4();
	}

	//一维数组
	private static void test1() {
		int arr[]=new int[10]; //定义一维数组
		for(int i=0; i<10; i++) { //遍历、赋值
			arr[i]=i;
		}
		print_arr(arr);
	}
	
	// 打印一维数组，最后带逗号
	private static void print_arr(int[] arr) {
		int len=arr.length;
		System.out.print("[");
		for(int i=0; i<len; i++) {
			System.out.print(arr[i]);
			if(len-i>1)
				System.out.print(", ");
		}
		System.out.print("]");
	}
	
	// 数组的复制：数组是按照地址传递的
	static void test2() {
		int[] arr1= {1,2,3}; //初始化时赋值，使用花括号
		int[] arr2=new int[3];
		
		print_arr(arr1);
		System.out.println();
		//赋值
		arr2=arr1; //数组是按地址传递的
		arr2[0]=100; //修改arr2, 则arr1也跟着改变
		
		print_arr(arr1);
		print_arr(arr2);
	}
	
	//数组的复制: 对元素一一复制
	static void test3() {
		int[] arr1= {1,2,3}; //初始化时赋值，使用花括号
		int[] arr2=new int[3];
		
		print_arr(arr1);
		System.out.println();
		//赋值
		//按元素复制
		for(int i=0; i<arr2.length; i++)
			arr2[i]=arr1[i];
		arr2[0]=100; //修改arr2, 则arr1不变
		
		print_arr(arr1);
		print_arr(arr2);
	}
	
	/**
	 * 求数组的最值
	 */
	static void test4() {
		int[] arr1=new int[] {1,2,-5,9};
		System.out.println(getMax(arr1));
		System.out.println(getMin(arr1));
	}

	private static int getMax(int[] arr) {
		int num=arr[0];
		for(int i=1; i<arr.length; i++) {
			if(arr[i]>num)
				num=arr[i];
		}
		return num;
	}
	
	private static int getMin(int[] arr) {
		int num=arr[0];
		for(int i=1; i<arr.length; i++) {
			if(arr[i]<num)
				num=arr[i];
		}
		return num;
	}

}
