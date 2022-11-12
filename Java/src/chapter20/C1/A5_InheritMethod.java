package chapter20.C1;

class Year{
	private final int year;
	public Year(int y) {
		year=y;
	}
	
	public int getYear() {
		return year;
	}
	
	public String toString() { return "The year is "+getYear(); }
	public boolean equals(Object x) {
		if(this == x) return true;
		if(x == null) return false;
		if(x.getClass() != this.getClass()) return false;
		Year that=(Year) x;
		if(that.year != this.year) return false;
		return true;
	}
	
}


public class A5_InheritMethod {
	public static void main(String[] args) {
		Year y1=new Year(2021);
		Year y2=new Year(2022);
		Year y3=new Year(2022);

		System.out.print(y3 + "\n"); //toString() 自动调用
		
		// getClass() 是是那么类型
		// 调用 .getClass()
		Class<? extends Year> s1=y1.getClass(); //这个是泛型，以后再说
		System.out.print(s1 + "\n");
		System.out.print(y2.getClass() + "\n");
		// 是否相等
		System.out.print(y2.equals(y1) + "\n"); //false
		System.out.print(y2.equals(y3) + "\n"); //true
	}
}


