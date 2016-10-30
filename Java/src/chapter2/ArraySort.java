package chapter2;

public class ArraySort {
	public static void main(String[] args){
//		test1();
//		test2();//数组中查找元素
		test3();//打印26个英文字母
		
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

	static void test1(){
		//直接初始化:用具体数组
		int[] arr=new int[]{100,-5,20,4,56,78,200,47,345,1};
		int[] arr2=new int[8];
		
		System.out.print("排序之前：arr1=");
		print_arr(arr);
		
		//arr2=sortSelection(arr);
		//arr2=sortSelectionReverse(arr);
		//arr2=sortBubble(arr);
		arr2=sortBubbleReverse(arr);
		
		System.out.print("排序之后：arr1=");//数组是按照地址传递的！
		print_arr(arr);
		
		System.out.print("排序之后：arr2=");
		print_arr(arr2);
	}
	
	
	/**
	 * 选择排序
	 * 
	 * @param arr
	 */
	//数组排序:选择法
	static int[] sortSelection(int[] arr){
		int len=arr.length;
		for(int i=0; i<len; i++){
			for(int j=i; j<len; j++){
				if(arr[i] > arr[j]){
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		return arr;
	}
	//数组排序:选择法 从大到小
	static int[] sortSelectionReverse(int[] arr){
		int len=arr.length;
		for(int i=0; i<len; i++){
			for(int j=i; j<len; j++){
				if(arr[i] < arr[j]){
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		return arr;
	}
	
	/**
	 * 冒泡排序
	 * 
	 * @param arr
	 */
	//数组排序:冒泡法
	static int[] sortBubble(int[] arr){
		for(int i=0; i<arr.length-1; i++){
			for(int j=0; j<arr.length-i-1; j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		return arr;
	}
	
	//数组排序:冒泡法 从大到小
	static int[] sortBubbleReverse(int[] arr){
		for(int i=0; i<arr.length-1; i++){
			for(int j=0; j<arr.length-i-1; j++){
				if(arr[j]<arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		return arr;
	}
	
	
	
	
	/**
	 * 在数组中查找元素
	 * 
	 */
	static void test2(){
		int[] arr=new int[]{100,-5,20,4,56,78,200,47,345,1};
		int num=1000;
		
//		int position=find(arr, num);
		int position=findByHalf(arr, num);
		
		print_arr(arr);
		
		if(position>=0){
			System.out.print(num+"在数组中的下标：" + position);
		}else{
			System.out.print(num+"在数组中的下标：没找到元素("+num+")");
		}
	}

	//原始查找方法
	private static int find(int[] arr, int num) {
		for(int i=0; i<arr.length;i++){
			if(arr[i]==num){
				return i;
			}
		}
		return -1;
	}
	
	
	
	//二分法查找
	private static int findByHalf(int[] arr, int key) {
		//先对数组排序
		sortBubble(arr);
		
		int min=0;
		int max=arr.length-1;
		
		//接着进行二分法查找 
		while(max >= min){
			int half=(int) (Math.floor(max+min)/2);
			p(min+", "+max+", "+half + " = "+arr[half]+"("+key+")");
			if(key>arr[half]){
				min=half+1;
			}else if(key < arr[half]){
				max=half-1;
			}else{
				return half;
			}
		}
		
		return -1;
	}
	
	/**
	 * 利用数组打印26个英文字母
	 */
	static void test3(){
		char[] c;//定义
		c=new char[26];//初始化 初始化时必须制定数组容量
		
		for(int i=0;i<26;i++){
//			c[i]= (char)(i+ 'a');
			c[i]= (char)(i+ 'A');
		}
		
		//打印数组
		for(char c1: c)
			System.out.print(c1);
	}
	
	
	
	
	
	//for debug use
	static void p(int s){
		System.out.println(s);
	}
	static void p(String s){
		System.out.println(s);
	}
}
