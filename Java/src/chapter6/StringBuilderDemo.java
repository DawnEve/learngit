package chapter6;

public class StringBuilderDemo {
	public static void main(String[] args) {
		System.out.println("index/capacity/length/contents");
//		StringBuilder sb=new StringBuilder(10); //初始化长度，默认16
		StringBuffer sb=new StringBuffer(10); //要求线程安全，则必须用 StringBuffer 类
		check(sb,1);
		sb.append("hello,");
		check(sb,2);
		sb.append(" this is tom!"); //容量自动增长
		check(sb,3);
		// 可以在中间插入
		sb.insert(5, " there");
		check(sb,4);
		//删除一段
		sb.delete(5, 11); //长度缩回去了，容量不变
		check(sb,5);
	}

	static void check(StringBuffer sb, int index) {
		System.out.println(index+" "+sb.capacity()+ " "+ sb.length()+" \""+sb+"\"");
	}
}
