package chapter20.C1;

import java.util.Arrays;

public class A2_BinarySearch {
	public static void main(String[] args) {
		int[] arr1= {10,2,-30,4, 50};
		Arrays.sort(arr1);
		printArr(arr1);
		//System.out.printf("xx");
		//二分查找
		int value=550;
		int index=BinarySearch(value, arr1, 0, arr1.length-1);
		System.out.printf("\nIndex of %d is %d\n", value, index);
	}
	
	private static int BinarySearch(int value, int[] arr, int lo, int hi) {
		if(value < arr[lo] || value >arr[hi]) {
			return -1;
		}
		int mid=(lo+hi)/2;
		if      (value > arr[mid]) return BinarySearch(value, arr, mid+1, hi);
		else if (value < arr[mid]) return BinarySearch(value, arr, lo, mid-1);
		else                       return mid;
	}

	// print array
	static void printArr(int[] arr) {
		int i=0;
		System.out.print("[");
		for(i=0; i<arr.length; i++) {
			if(i!=arr.length-1)
				System.out.print(arr[i]+", ");
			else 
				System.out.print(arr[i]+"]");
		}
	}
}
