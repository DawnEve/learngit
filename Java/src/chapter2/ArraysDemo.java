package chapter2;

import java.util.Arrays;

// Arrays 类方法
public class ArraysDemo {
	public static void main(String[] args) {
//		demo1();
//		demo2();
//		demo3();
		demo4();
	}

	//二分法必须先排序
	private static void demo4() {
		int[] arr= {-5,10,1};
		// 1.先排序
		Arrays.sort(arr);
		for(int x: arr) System.out.print(x+" ");
		System.out.println();
		
		// 2.查找
		int index=Arrays.binarySearch(arr, 3);
		//小于0表示没有找到；>=0表示找到
		System.out.println(  (index<0?"Not Found":"Found at "+index)  );
	}

	// 数组相等
	private static void demo3() {
		int[] arr1= {1,2,3};
		int[] arr2= {1,2,3};
		System.out.println(Arrays.equals(arr1, arr2)); //true
		
	}

	//排序
	private static void demo2() {
		int arr[] = {-5, 20, 1};
		Arrays.sort(arr); //升序
		for(int x: arr)
			System.out.println(x);
		//想降序 how?
		
	}

	// fill 方法 填充赋值
	private static void demo1() {
		int arr[] =new int[3];
		Arrays.fill(arr, 3); //每个元素都填充为固定值
		
		for(int x: arr) {
			System.out.println(x);
		}
		
	}
}
