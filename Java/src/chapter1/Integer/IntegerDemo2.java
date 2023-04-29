package chapter1.Integer;

import java.util.Arrays;

/**
 *  按照思路逐步细化。
 * */
public class IntegerDemo2 {
	private static final String SPACE_SEPARATOR=" ";//增加复用性。
	/*
	 * 对字符串中的数字排序，从小到大。
	 * 思路：
	 * 1.将字符串变成字符串数组；
	 * 2.字符串数组变整数数组；
	 * 3.对整数数组排序；
	 * 4.将整数型数组变成字符串；
	 */
	public static void main(String[] args) {
		String numStr="12 345 60 21 40 0 2 -3";
		System.out.println(numStr);
		String s=sortStringNumber(numStr);
		System.out.println(s);
	}
	
	private static String sortStringNumber(String numStr) {
		//1.将字符串变成字符串数组
		String[] arrStr=numStr.split(SPACE_SEPARATOR);
		//2.字符串数组变整数数组
		int[] arrInt=stringArr2IntArr(arrStr);
		//3.对整数数组排序
		sortIntArr(arrInt);
//		sortIntArr2(arrInt);
		//4.将整数型数组变成字符串；
		String str=intArr2String(arrInt);
		return str;
	}

	
	/**
	 * 用途：整型数组-->字符串。StringBuffer 拼凑字符串，sb.append("xx");
	 * @param int[]
	 * @return String
	 **/	
	private static String intArr2String(int[] arr) {
		StringBuffer str=new StringBuffer();
		for(int i=0; i<arr.length; i++) {
			str.append( arr[i] );
			if(i<arr.length-1) {
				str.append(SPACE_SEPARATOR);
			}
		}
		return str.toString();
	}
	
	/**
	 * aim: int arr to a string
	 * @param arr[]
	 * @return String
	 */
	private static String intArr2String_v2(int[] arr) {
		String str="";
		for(int i=0; i<arr.length; i++) {
			str += String.valueOf(arr[i]);
			if(i<arr.length-1) {
				str+=SPACE_SEPARATOR;
			}
		}
		return str;
	}
	
	
	/**
	 * 用途：整型数组排序
	 * @param arr
	 **/
	private static void sortIntArr2(int[] arr) {
		Arrays.sort(arr); //这是Arrays中的静态方法。
	}
	
	/**
	 * aim: sort int arr
	 * @param arrInt
	 */
	private static void sortIntArr(int[] arr) {
		int len=arr.length, temp=0;
		for(int i=0; i<len; i++) {
			for(int j=i; j<len; j++) {
				if(arr[i] > arr[j]) {
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}		
	}
	
	
	
	
	/**
	 * 用途: 数组中 字符串 to 整数
	 * @param arrStr
	 * @return
	 */
	private static int[] stringArr2IntArr(String[] arrStr) {
		int[] arr=new int[arrStr.length];
		for(int i=0; i<arrStr.length; i++) {
			//两种实现，String to int
//			arr[i]=Integer.parseInt(arrStr[i]);
			arr[i]=Integer.valueOf(arrStr[i]); 
		}
		return arr;
	}

}
