package com.dawn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageHitCounter extends HttpServlet{ 
	private static final long serialVersionUID = 1L;
	
	private int hitCount; 
    
	public void init() {
		// 重置点击计数器
		hitCount = 0;
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");
		hitCount++;
		PrintWriter out=res.getWriter();
		String str="本页面的点击次数()："+hitCount;
		out.println(str);
		System.out.println(str);
		
	}
	
	public void destroy() { 
		// 这一步是可选的，但是如果需要，您可以把 hitCount 的值写入到数据库
	} 
}
