package chapter2;

public class ArrayUtil {
	public static void main(String[] args){
		String week=getWeek(3); //星期的转换
		System.out.print(week);
	}

	//星期转换
	private static String getWeek(int i) {
		String[] weeks={"", "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday", "Sunday"};
		return weeks[i];
	}


}
