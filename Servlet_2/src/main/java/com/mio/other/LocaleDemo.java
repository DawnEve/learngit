package com.mio.other;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/localeDemo")
public class LocaleDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取本地化对象
		Locale locale=req.getLocale();
		//语言
		String language=locale.getLanguage(); //语言
		String country=locale.getCountry(); //国家
		
		String date = DateFormat.getDateTimeInstance(
				DateFormat.FULL,
				DateFormat.SHORT,
				locale).format(new Date()); //本地化日期
		//输出
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out=resp.getWriter();
		out.println("language: "+language+"<br>");
		out.println("country: "+country+"<br>");
		out.println("date: "+date+"<br>");
	}
}
/*
language: zh
country: CN
date: 2023年3月20日 星期一 下午9:31
 * */