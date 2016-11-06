package chapter2;

import java.util.Arrays;

public class SortByClass {
	public static void main(String[] args){
		int[] arr=new int[]{100,1,23,-45,67,9};
		print(arr);
		Arrays.sort(arr);
		print(arr);
	}
	
	static void print(int[] arr){
		for(int i: arr){
			System.out.print(i+", ");
		}
		System.out.println();
	}
}
