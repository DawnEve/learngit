package com.mio.session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns ="/servletContextDemo4")
public class ServletContextDemo4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().append("this is demo4<br>"); //转发后，没有原来的显示了？
		
		//1. 通过request获取ServletContext对象
		ServletContext context = req.getServletContext();
		//2. 获取请求派发器
		RequestDispatcher dispatcher = context.getRequestDispatcher("/servletContextDemo3");
		//3. 派发
		dispatcher.forward(req, resp);
	}

}
