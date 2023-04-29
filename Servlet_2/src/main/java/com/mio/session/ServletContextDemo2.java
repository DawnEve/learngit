package com.mio.session;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. 通过request获取ServletContext对象
		ServletContext servletContext1 = req.getServletContext();

		//Part III 共享数据
		String uname=(String) servletContext1.getAttribute("uname");//获取属性
		System.out.println("demo2> ServletContext: uname="+uname);
		
		//同时设置 session 
		HttpSession hs = req.getSession();
		String uname2=(String) hs.getAttribute("uname2");
		System.out.println("demo2> Session: uname2="+uname2+"\n");
	}
}
