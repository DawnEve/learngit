package com.mio.hi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello1
 */
@WebServlet("/Hello2")
public class Hello1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String message;
    
    public Hello1() {
        super();
    }
    
	public void init() throws ServletException {
		// 执行必需的初始化
		message = "Hello World, form Tomcat9";
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置响应内容类型
		response.setContentType("text/html");
		
		// 实际的逻辑是在这里
		PrintWriter out = response.getWriter();
		out.println("<h1>" + message + "</h1>");

		// 可以简化为一行
		response.getWriter().append("Served at: ").
			append(request.getContextPath());		
	}
	
	
	public void destroy() {
		// 什么也不做
	}
}
