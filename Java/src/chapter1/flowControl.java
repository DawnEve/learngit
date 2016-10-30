package chapter1;

public class flowControl {
	/**
	 * if
	 * switch
	 * while, do...while
	 * for
	 * @param args
	 */
	public static void main(String[] args){
//		test1(80);
//		test3();
		test8();
	}

	//if
	static void test1(int score){
		if(score>=60){
			System.out.print("ok");
		}else{
			System.out.print("Not ok");
		}
	}
	
	//switch
	static void test2(){
		int i=60;
		switch(i){
			case 1:
				System.out.print("周一");
				break;
			case 2:
				System.out.print("周二");
				break;
			case 3:
			case 4:
			case 5:
				System.out.print("后半周"+i);
				break;
			case 6:
			case 7:
				System.out.print("周末"+i);
				break;
			default:
				System.out.print("非法数据");
		}
	}
	
	//while
	static void test3(){
		//计算从1-100的和
		int i=1;
		int sum=0;
		while(i<=100){
			sum += i;
			i++;
		}
		System.out.println(sum);
	}
	
	//do...while
	static void test4(){
		//计算从1-100的和
		int i=1;
		int sum=0;
		do{
			sum += i;
			i++;
		}while(i<=100);//先循环，再判断，即至少走一遍循环体！
		System.out.println(sum);
	}

	//for
	static void test5(){
		int sum=0;
		for(int i=1;i<=100;i++){
			sum += i;
		}
		System.out.println(sum);
	}

	//for例子： 数字金字塔
	static void test6(){
		int num=9;
		for(int i=0;i<num;i++){
			//输出空格
			for(int temp=0;temp<num-i;temp++){
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
		for(int i=0;i<10;i++){
			if(i==7) break;//结束for循环
			System.out.print(i+", ");
		}
		
		System.out.println();
		
		//continue是跳过本次循环
		for(int i=0;i<10;i++){
			if(i==7) continue;//结束本次循环
			System.out.print(i+", ");
		}
	}
	
	//continue例子：求1-100之间奇数和
	static void test8(){
		//方法1
		int sum=0;
		for(int i=1;i<100;i += 2){//从for循环保证是奇数
			sum +=i;
		}
		System.out.println(sum+", ");//2500
		
		//方法2
		int sum2=0;
		for(int i=1;i<100;i++){
			if(0==i%2)continue; //如果是2的倍数，则跳过去，只累加奇数
			sum2 +=i;
		}
		System.out.println(sum2+", ");//2500
	}

}
