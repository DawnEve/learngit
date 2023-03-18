package com.dawn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取header信息。
 * 
 * */
public class GetHeader extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		String title = "HTTP Header 请求实例";
		out.println("<h1>"+title+"</h1>");
		
		//====================================
		//获取请求req.header
		Enumeration headerNames=request.getHeaderNames();
		out.print("<b><p> 键 : 值 </p></b>");
		while(headerNames.hasMoreElements()){
			String paraName=(String)headerNames.nextElement();
			String paraValues=request.getHeader(paraName);
			out.print("<p><b style='color:red'>"+paraName+"</b>: "+paraValues+"</p>");
		}
		
		
		//====================================
		//设置响应res.header
		//见SetHeader.java
		
		
		
		
	}

}
