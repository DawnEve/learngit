package chapter2;

public class TwoDArray {

	public static void main(String[] args){
		test2();
	}
	
	//二维数组是按照地址传递的，可以看到打印出来的地址
	static void test1(){
	    int[][] arr=new int[3][2];//define
	    //set 3 one-d array, each has 2 element;
        arr[0][1]=12;

        System.out.println(arr); // print the whole 2d-array
        System.out.println(arr[0]);//print the 1st array in the 2d-array;
        System.out.println(arr[1]);//print the 2st array in the 2d-array;
        System.out.println(arr[2]);//print the 3st array in the 2d-array;

        System.out.println(arr[0][1]);//element at 1row 2column 
	}
	
	
	//分别初始化三维数组的每一个低纬
	static void test2(){
		int[][] arr=new int[3][2];//define
	    //set 3 one-d array, each has 2 element;
		arr[0]=new int[2];
		arr[1]=new int[]{11,12,13};
		arr[2]=new int[4];
		
		int sum=sum2d(arr);
		System.out.print(sum);
	}

	//对二维数组求和
	private static int sum2d(int[][] arr) {
		int sum=0;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				sum += arr[i][j];
			}
		}
		return sum;
	}
	
	
	
}
