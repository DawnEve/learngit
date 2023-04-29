package com.mio.param;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getRequestLine")
public class GetRequestLine extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//URL: http://localhost:8080/Servlet_2/getRequestLine?name=wangcai&age=5#foot
		//获取请求头 GET /Servlet_2/getHeader?name=wangcai HTTP/1.1 
		// GET
		String str1=req.getMethod(); //请求方法 method
		// /Servlet_2
		String str2=req.getContextPath(); //重要。获取虚拟目录
		// /getRequestLine
		String str3=req.getServletPath(); //获取Servelt 路径
		
		// /Servlet_2/getRequestLine
		String str4=req.getRequestURI(); //重要，权限控制很重要！
		// http://localhost:8080/Servlet_2/getRequestLine
		StringBuffer str5=req.getRequestURL(); //URL比URL长，多了协议+IP+端口号
		
		// name=wangcai&age=5
		String str6=req.getQueryString(); //参数列表
		// HTTP/1.1
		String str7=req.getProtocol(); //请求协议 父类
		// 0:0:0:0:0:0:0:1
		String str8=req.getRemoteAddr(); //获取客户机的地址 父类
		int str9 = req.getServerPort(); //端口号 8080
		
		System.out.println(str4);
	}
}
