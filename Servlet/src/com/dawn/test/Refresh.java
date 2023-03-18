package com.dawn.test;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.*;
import javax.servlet.http.*;


public class Refresh extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 设置刷新自动加载的事件间隔为 5 秒
		response.setIntHeader("Refresh", 5);
		
		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");
		
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
		
		PrintWriter out = response.getWriter();
		String title = "使用 Servlet 自动刷新页面";
		String docType = "<!DOCTYPE html> \n";
		out.println(docType +
				"<html>\n" +
				"<head><title>" + title + "</title></head>\n"+
				"<body bgcolor=\"#f0f0f0\">\n" +
				"<h1 align=\"center\">" + title + "</h1>\n" +
				"<p>当前时间是：" + CT + "</p>\n");
		
		System.out.println(CT);
	}
}
