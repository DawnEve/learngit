package chapter2;

public class ArrayAsPara {
	public static void main(String[] args) {
//		demo1();
		demo2();
	}

	
	// 如果不想修改原数组，需要复制后修改
	private static void demo2() {
		int arr[]= {1,2,3};
		int arr2[]=doubleArr(arr); //倍增数组，不改变原始数组
		printArr(arr);
		printArr(arr2);
	}
	// 返回数组的函数
	private static int[] doubleArr(int[] arr) {
		int len=arr.length;
		int[] arr2=new int[len]; //声明新数组
		for(int i=0; i<len; i++) {
			arr2[i]=arr[i]*2;
		}
		return arr2;
	}


	private static void demo1() {
		int arr[] = {1,3,5,7};
		printArr(arr); //[1, 3, 5, 7]
		chanage(arr, 1, 1000); //确实被修改了
		printArr(arr); //[1, 1000, 5, 7]
	}
	// 数组是按地址传递的。这个地址被修改了，原来的值也被修改了
	private static void chanage(int[] arr, int index, int value) {
		arr[index]=value;
	}


	static void printArr(int[] arr) {
		System.out.print("[");
		int len=arr.length;
		for(int i=0; i<len; i++) {
			System.out.print(arr[i]);
			if(i<len-1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}

}
