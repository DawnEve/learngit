package chapter2;

public class ArraySort {
	public static void main(String[] args){
//		test1(); //排序
//		test2(); //数组中查找元素
		test3(); //打印26个英文字母
		
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
	
	//两种初始化方法，排序
	static void test1() {
		//直接初始化：用具体数组
		int[] arr1=new int[] {100,-5,20,4,56,78,200,47,345,1};
		int arr2[]=new int[8]; //这个长度不够，为什么不影响后面使用？
		
		System.out.print("排序前: arr1=");
		print_arr(arr1);
		
		//排序
//		arr2=sortSelection(arr1);
//		arr2=sortSelectionReverse(arr1);
//		arr2=sortBubble(arr1);
		arr2=sortBubbleReverse(arr1);
		
		System.out.print("排序后: arr1="); //数组是按照地址传递的！
		print_arr(arr1);
		
		System.out.print("排序后: arr2=");
		print_arr(arr2);
	}
	
	/**
	 * 选择排序：选择最大的放到前面
	 */
	static int[] sortSelection(int[] arr) {
		int len=arr.length;
		for(int i=0; i<len; i++) {
			for(int j=i; j<len; j++) {
				if(arr[i]<arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		return arr;
	}
	
	// 选择排序：选择最小的放到前面
	static int[] sortSelectionReverse(int[] arr) {
		int len=arr.length;
		for(int i=0; i<len; i++) {
			for(int j=i; j<len; j++) {
				if(arr[i] > arr[j]) {
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
	 * 相邻的比较，如果前面大，则交换位置。
	 * 每轮最大的跑到最后。 下一轮就不用比上一轮的最后一个了。
	 * @param arr
	 */
	//数组排序:冒泡法。
	static int[] sortBubble(int[] arr){
		int len=arr.length;
		for(int i=0; i<len-1; i++) {
			for(int j=0; j<len-i-1; j++) {
				if(arr[j] > arr[j+1]) { //从小到大
					int temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
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

	// 原始查找：遍历
	private static int find(int[] arr, int num) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==num)
				return i;
		}
		
		return -1;
	}
	
	// 二分法查找
	private static int findByHalf(int[] arr, int key) {
		//先排序:从小到大
		sortBubble(arr);
		print_arr(arr);
		
		int low=0, hi=arr.length-1;
		while(low<hi) {
			int mid=(low+hi)/2;
			if(arr[mid] == key) {
				return mid;
			}else if(arr[mid]>key) {
				hi=mid-1;
			}else {
				low=mid+1;
			}
		}
		return -1;
	}
	
	
	
	/**
	 * 利用数组打印26个英文字母
	 */
	static void test3(){
		char[] c; //定义
		c=new char[26]; //初始化 初始化时必须指定数组容量
		
		for(int i=0; i<26; i++) {
			c[i]=(char)(i+'a');
//			c[i]=(char)(i+'A');
		}
		
		//打印数组
		for(int i=0; i<26; i++){
			System.out.print(c[i]);
		}
		System.out.println();
		
		//打印数组2
		for(char c1:c){
			System.out.print(c1);
		}
	}
}