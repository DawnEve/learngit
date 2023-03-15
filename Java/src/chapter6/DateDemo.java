package chapter6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
	public static void main(String[] args) {
//		demo1();
//		demo2();
//		demo3();
//		demo4();
		demo5();
	}
	
	//休眠3秒
	private static void demo5() {
		System.out.println(new Date());
		try {
			Thread.sleep(1000*3);//休眠
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(new Date());
	}

	//解析字符串为时间
	private static void demo4() {
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
		//String input=args.length==0 ? "2023-3-15" : args[0]; //main方法的参数 args
		String input="2023-3-15";
		System.out.println(input + " -> ");
		
		Date t;
		try {
			t=ft.parse(input); //解析
			System.out.println(t);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	//需要再看 printf
	private static void demo3() {
		Date d1 = new Date();
		System.out.printf("%tY-%tm-%td %tH:%tM:%tS %tZ", d1, d1, d1, d1, d1, d1, d1);		
	}

	// 日期的格式化 SimpleDateFormat
	private static void demo2() {
		Date d1=new Date();
		SimpleDateFormat ft=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		System.out.println("当前时间:"+ ft.format(d1)); //2023/03/15 11:16:29
		// HH是24小时，hh是12小时
		SimpleDateFormat ft2=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss E");
		System.out.println("当前时间:"+ ft2.format(d1)); //2023/03/15 11:16:29  星期三
		//z时区
		SimpleDateFormat ft3=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss E z");
		System.out.println("当前时间:"+ ft3.format(d1)); //2023/03/15 11:16:29  星期三 CST
		
	}

	// 日期的初始化与比较
	private static void demo1() {
		//构造函数1: 获取当前时间
		Date d1=new Date(); //Wed Mar 15 10:56:09 CST 2023
		System.out.println(d1); //Wed Mar 15 10:59:52 CST 2023
		
		//构造函数2: 可接收一个参数，从 1970 年 1 月 1 日起的毫秒数。
		//使用js >new Date().getTime() //1678849135858
		Date d2=new Date(1678849135858L);
		System.out.println(d2); //Wed Mar 15 10:58:55 CST 2023
		
		//方法3: 废弃了
		//Date d3=new Date(23, 3, 15); //该构造函数被放弃了
		Date d3=new Date();
		
		
		//判断两个日期的先后
		System.out.println(1+" "+d1.after(d2)); //true
		System.out.println(1+" "+d1.compareTo(d2)); //1
		
		//获取时间的毫秒数，然后比较毫秒数
		System.out.println(d2.getTime()); //1678849135858
		
		//转为字符串
		System.out.println(d2.toString()); //Wed Mar 15 10:58:55 CST 2023
	}

}
