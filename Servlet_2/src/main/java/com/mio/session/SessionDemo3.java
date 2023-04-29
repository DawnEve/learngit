package com.mio.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionDemo3")
public class SessionDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取 session 对象
		HttpSession hs = req.getSession(true);
		//设置session时间.默认是30min。
		//hs.setMaxInactiveInterval(10);//10s
		
		//通过url设置动作
		//http://localhost:8080/Servlet_2/sessionDemo3?action=set
		String action=req.getParameter("action");
		System.out.println("action:" +action);
		if(null!=action && action.equals("set")) {
			System.out.println(">> set sessions:");
			//设置 session 键值对
			hs.setAttribute("user_id", "123");
			hs.setAttribute("user_name", "wangcai");
			hs.setAttribute("user_role", "admin");
			System.out.println("session set: done!");
		}
		
		//Part II 输出到网页
		//设置输出内容的类型
		resp.setContentType("text/html;charset=UTF-8");
		//获取 session 键 的 枚举类型
		Enumeration<String> enu = hs.getAttributeNames();
		// 输出流
		PrintWriter out=resp.getWriter();
		out.println("<b>session item, key: value, </b><br>");
		while(enu.hasMoreElements()){
			String key = enu.nextElement();
			String value = (String) hs.getAttribute(key);
			out.printf("<p>%s: %s,</p>", key, value);
		}
	}
}
