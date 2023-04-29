package com.mio.hi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servletDemo")
public class ServletDemo implements Servlet {
	static public int counter=0;//访问计数器

	// 用于得到servlet配置文件 与生命周期无关
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return "Servlet info here...";
	}

	// 该函数用于初始化该servlet， 类似于我们的类的构造函数
	// 该函数只是会被调用一次， 当用户第一次访问该servlet的时候被调用
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("> init it !");
	}

	// service 函数用于处理业务逻辑
	// 程序员应当把业务逻辑代码写在这里
	// 该函数在用户每次访问servlet的时候都会被调用
	// ServletRequest 对象用于获得客户端信息，
	//ServletResponse 对象用于向客户端返回信息	（客户端可以理解为浏览器）
	// servelt jsp b/s
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		counter++;
		System.out.println("> Service start, visitor "+counter);
		
		PrintWriter pw=res.getWriter();
		pw.println("Hello world, Servlet. visitor "+counter);
	}

	// 销毁servlet实例（释放内存）
	// 1 reload 该servlet(webApp)
	// 2 关闭Tomcat 或者说 关机之后 都会调用这个函数
	@Override
	public void destroy() {
		System.out.println("> destory it");
	}
}
