package com.mio.session;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 4种初始化方法；2个主要用途
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. 通过request获取ServletContext对象
		ServletContext servletContext1 = req.getServletContext();
		System.out.println(servletContext1);
		//org.apache.catalina.core.ApplicationContextFacade@14e5f2f5
		
		//2.通过session获取ServletContext对象
		ServletContext servletContext2 = req.getSession().getServletContext();
		System.out.println(servletContext2);
		
		//3.通过getServletConfig获取ServletContext对象
		ServletContext servletContext3 = this.getServletConfig().getServletContext();
		System.out.println(servletContext3);
		
		//4.直接获取ServletContext对象
		ServletContext servletContext4 = this.getServletContext();
		System.out.println(servletContext4);
		System.out.println();
		
		
		
		//Part II ServletContext的两种常用方法
		//1.获取当前服务器的信息
		String serverInfo = req.getServletContext().getServerInfo();
		System.out.println("服务器信息："+serverInfo); //Apache Tomcat/9.0.73
		//2.获取当前项目的真实路径
		String realPath=req.getServletContext().getRealPath("/");
		System.out.println("项目的真实路径:"+realPath);
		//D:\ProgramFiles\apache-tomcat-9.0.73\webapps\Servlet_2\
		System.out.println(servletContext4.getRealPath("/"));
		
		
		//Part III 共享数据
		servletContext4.setAttribute("uname", "admin"); //设置属性
		String uname=(String) servletContext2.getAttribute("uname");//获取属性
		//servletContext1.removeAttribute("uname"); //删除属性
		System.out.println("ServletContext: uname="+uname);
		
		//同时设置 session 
		HttpSession hs = req.getSession();
		hs.setAttribute("uname2", "admin2");
		String uname2=(String) hs.getAttribute("uname2");
		System.out.println("Session: uname2="+uname2);
		
		//输出到网页
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().append("Set ServletContext & Session. <br>换电脑/浏览器 访问 demo2");
	}

}
