package com.dawn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetDemo
 * url: http://localhost:8080/mywebsite/getDemo
 * 
 */
//@WebServlet("/GetDemo")
public class GetDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * 获取参数，获取汉字参数。
     * @see HttpServlet#HttpServlet()
     */
    public GetDemo() {
        super();
        System.out.println("1.this is construct method.数据库打开");
        // TODO Auto-generated constructor stub
    }
    
    // 该函数用于初始化该servlet， 类似于我们的类的构造函数
 	// 该函数只是会被调用一次， 当用户第一次访问该servlet的时候被调用
 	@Override
 	public void init(ServletConfig arg0) throws ServletException {
 		System.out.println("2.init it !");
 	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html");//有这句话，后面的html标签才起作用
		response.setContentType("text/html;charset=UTF-8");//输出中文
		
		System.out.println("3.this is a doGet method.");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.println("<h1>hello, test Get Method.好的</h1>");
		
		//获取参数
		//http://localhost:8080/mywebsite/getDemo?token=sfd
		String token=request.getParameter("token");
		if(token!=null){
			//token="null";
			out.println("token="+token+"<br>");
		}
		
		//获取汉字参数
		//http://localhost:8080/mywebsite/getDemo?keyword=sfd事务
		String _keyword=request.getParameter("keyword");
		if(_keyword!=null){
			String keyword=new String(_keyword.getBytes("ISO8859-1"),"UTF-8");//转码
			out.println("_keyword="+_keyword+"<br>");//乱码
			out.println("keyword="+keyword+"<br>");//正常显示
		}
		
	}
	
	public void destroy() {
		System.out.println("4.destory it数据库关闭");
	}
}
