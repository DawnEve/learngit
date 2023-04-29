package chapter1;

public class flowControl {
	public static void main(String[] args) {
//		test1(500);//if
//		test2(8); //switch
//		test3(); //while
//		test4(); //do...while
//		test5(); //for
//		test6(); //for example
//		test7(); // break, continue
//		test8(); //求奇数的和
		test9(); //行号
	}
	


	//if
	static void test1(int score) {
		if(score>=60) {
			System.out.print("ok");
		}else {
			System.out.print("Not ok");
		}
	}
	
	//switch
	private static void test2(int i) {
		switch(i) {
			case 1:
				System.out.print("Monday");
				break;
			case 2:
				System.out.print("Tuesday");
				break;
			case 3:
			case 4:
			case 5:
				System.out.print("后半周");
				break;
			case 6:
			case 7:
				System.out.print("周末");
				break;
			default:
				System.out.print("非法数字");
		}
	}
	
	//while
	private static void test3() {
		int i=1, sum=0;
		while(i<=100) {
			sum+=i;
			i++;
		}
		System.out.print("sum="+sum);
	}
	
	//do while
	private static void test4() {
		int i=1, sum=0;
		do{
			sum+=i;
			i++;
		}while(i<=100); //先循环，再执行判断；至少执行一次
		System.out.print("sum="+sum);
	}
	
	//for
	private static void test5() {
		int sum=0;
		for(int i=0; i<=100; i++) {
			sum+=i;
		}
		System.out.print("for: sum="+sum);
	}
	
	//输出杨辉三角: 最顶上1，下一行两边是1，最中间是递增数字
	static void test6(){
		int num=9;
		for(int i=0;i<=num;i++){
			//输出空格
			for(int j=0;j<num-i;j++){
				System.out.print(" ");
			}
			
			//输出左边一半数字
			for(int j=0;j<i;j++){
				System.out.print(j+1);
			}
			
			//输出右边一半数字
			for(int j=i-1;j>0;j--){
				System.out.print(j);
			}
			
			//换行
			System.out.println();
		}
	}
	
	//break,continue
	static void test7(){
		for(int i=0; i<10; i++) {
			if(i==7) break; //结束for循环
			System.out.print(i+", ");
		}
		System.out.println();
		
		for(int i=0; i<10; i++) {
			if(i==7) continue; //结束本轮循环，下一个循环之继续
			System.out.print(i+", ");			
		}
	}
	
	//奇数的和:[1, 100]之间
	static void test8() {
		// method1
		int sum=0;
		for(int i=1; i<=100; i=i+2) {
			sum+=i;
		}
		System.out.println("sum=1+3+...+99="+sum);
		
		// method2
		int sum2=0;
		for(int i=1; i<100; i++) {
			if(0 == i%2) continue; //如果是偶数，跳过
			sum2+=i;
		}
		System.out.print("sum2=1+3+...+99="+sum2);
	}
	
	//按行号终止循环
	static void test9() {
		xiaoqiang: for(int i=1; i<=9; i++) {
			wangcai: for(int j=1; j<=i; j++) {
				System.out.print(i+"*"+j+"="+i*j+"\t");
				if(i==7 && j==2)
					break xiaoqiang;
			}
			System.out.println();
		}
	}
	
	
}