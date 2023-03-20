package com.mio.param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/getPara")
public class GetPara extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println(req); //org.apache.catalina.connector.RequestFacade@6cea9668
		
		//设置内容类型
		res.setContentType("text/html"); 
		//获取变量
		String usr=req.getParameter("username");
		String pass=req.getParameter("password");
		//打印结果
		PrintWriter out=res.getWriter();
		out.println("<h1>usr:"+usr+", pass:"+pass+"</h1>");
	}
}

// http://localhost:8080/Servlet_2/GetPara?username=xiaoming&password=123