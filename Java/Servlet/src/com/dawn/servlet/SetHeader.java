package com.dawn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 设置header信息。
 * 
 * */
public class SetHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置刷新自动加载时间为 10 秒
	    response.setIntHeader("Refresh", 10);
	      
		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");
		
		//使用默认时区和语言环境获得一个日历
		Calendar cale=Calendar.getInstance();
		//将Calendar类型转换成Date类型  
		Date tasktime=cale.getTime();
		//设置日期输出的格式 
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//格式化输出
		String nowTime=df.format(tasktime);
		
		PrintWriter out = response.getWriter();
		String title = "HTTP Header 设置实例-自动刷新";
		out.println("<h1>"+title+"</h1>");
		out.print("当前时间是："+nowTime);
		
		out.println("<a href='http://localhost:8080/mywebsite/getHeader'>getHeader</a>");
		
		//设置404状态。 好像被废除了。
		//response.setStatus(504, "not found now....");
	}

}
