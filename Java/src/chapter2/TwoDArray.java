package chapter2;

public class TwoDArray {
	public static void main(String[] args){
		test4();
	}
	
	
	//二维数组是按照地址传递的，可以看到打印出来的地址
	static void test1() {
		//set 3 one-d array, each has 2 elements;
		int[][] arr=new int[3][2]; //define
		arr[0][1]=12;
		
		System.out.println(arr); //[[I@70dea4e   打印的是2d数组的地址，2个[[开头
		System.out.println(arr[0]); //[I@5c647e05   打印的是1d数组的地址，1个[开头
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
		System.out.println(arr[0][1]); //打印元素: 第1行第2列
	}
	
	//分别初始化二维数组的每一个低纬
	static void test2(){
		int[][] arr=new int[3][2]; //define;
		// set 3 one-d array, each has 2 elements;
		arr[0]=new int[2];
		arr[1]=new int[] {11,12,13};
		arr[2]=new int[4];
		
		int sum=sum2d(arr);
		System.out.print(sum);
	}
	
	
	//对二维数组求和
	static int sum2d(int[][] arr) {
		int sum=0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				sum+=arr[i][j];
			}
		}
		return sum;
	}
	
	
	//二维数组的直接赋值
	static void test3() {
//		int[][] arr= {{1,2}, {3,4}, {5,6}};
		int[][] arr= new int[][] {{1,2}, {3,4}, {5,6}};
		System.out.print(sum2d(arr));
	}
	
	
	//Java语言中，由于把二维数组看作是数组的数组，数组空间不是连续分配的，所以不要求二维数组每一维的大小相同。
	static void test4() {
		int [][] arr=new int[3][];
		arr[0]=new int[2];
		arr[1]=new int[3];
		arr[2]=new int[] {21,22,23,24};
		
		System.out.println(arr);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i].length);
	}
}