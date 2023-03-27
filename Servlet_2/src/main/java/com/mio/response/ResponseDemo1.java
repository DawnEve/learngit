package com.mio.response;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//页面自动刷新:10s
		resp.setIntHeader("Refresh", 10);
		//设置响应内容类型，防止中文乱码
		resp.setContentType("text/html;charset=UTF-8");
		
		//使用默认时区，获取时间字符串
		String now = new Date().toString();
		//浏览器输出 时间
		resp.getWriter().
			append("ResponseDemo1 10秒刷新<br> Served at: ").
			append(req.getRequestURI()).append("<h2>"+now+"</h2>");
		resp.getWriter().append(getDateTime());
		
		//设置404状态
		//resp.setStatus(404, "not found now..."); //2参数的已被废除
		resp.setStatus(404); //只能有一个参数
		
		//设置头信息
		resp.addHeader("author", "Tom");
	}
	
	//获取当前 时间格式 2023-03-27 20:32:59
	static String getDateTime() {
		//使用默认时区和语言环境获得一个日历
		Calendar cale=Calendar.getInstance();
		//将Calendar类型转换成Date类型  
		Date tasktime=cale.getTime();
		//设置日期输出的格式 
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//格式化输出
		String nowTime=df.format(tasktime);
		return nowTime;
	}
}