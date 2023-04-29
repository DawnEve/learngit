package chapter6;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarDemo {
	public static void main(String[] args) {
//		demo1();
		demo2();
	}
	
	//获取时:分:秒 AM
	private static void demo2() {
		// 获取当前的时间
		Calendar calendar = new GregorianCalendar();
		String am_pm;
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		if(calendar.get(Calendar.AM_PM) == 0)
			am_pm = "AM";
		else
			am_pm = "PM";
		
		String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
		System.out.println(CT);
	}

	// Calendar 对象
	private static void demo1() {
		//使用默认时区和语言环境获得一个日历
		Calendar cale=Calendar.getInstance();
		//将Calendar类型转换成Date类型  
		Date tasktime=cale.getTime();
		//设置日期输出的格式 
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//格式化输出
		String nowTime=df.format(tasktime);
		System.out.print("当前时间是："+nowTime); //当前时间是：2023-03-19 20:16:59
	}

}
