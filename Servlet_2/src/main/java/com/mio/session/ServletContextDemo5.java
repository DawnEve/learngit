package com.mio.session;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns ="/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 http://localhost:8080/Servlet_2/servletContextDemo5?user=wangcai
	 http://localhost:8080/Servlet_2/servletContextDemo5
	 * */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		//1.获取url参数
		String user=req.getParameter("user");

		//2.获取ServletContext对象
		ServletContext context = req.getServletContext();
		
		if(null==user || user.equals("")) {
			//3.记录日志
			context.log("No msg received:", 
					new IllegalStateException("Missing parameter 'user'"));
		}else {
			System.out.println("visit with user para");
			context.log("visit with user:"+user);
		}
		context.log("Normal visit:"+user);
		
		resp.getWriter().append("<h2>"+user+"</h2>");
		//看到文件了，但是没有找到 日志记录
		System.out.println("log at  <Tomcat-installation-directory>/logs/"); 
	}
}
