package com.mio.session;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns ="/servletContextDemo3",
	initParams = {
			@WebInitParam(name="url", value="jdbc:mysql://localhost:3306/mybatis2"),
	})
public class ServletContextDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append("this is demo3<br>");
		
		//1. 通过request获取ServletContext对象
		ServletContext context = req.getServletContext();
		//2.获取数据
		String url = context.getInitParameter("url");
		//3.输出
		System.out.println(url);
		resp.getWriter().append(url); //获取xml中<context-param>参数，如何从注解获取？ //todo
	}

}
