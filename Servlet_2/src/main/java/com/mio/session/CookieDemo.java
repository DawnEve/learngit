package com.mio.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieDemo")
public class CookieDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/** 
	 * cookie封装： http://www.cnblogs.com/muzongyan/archive/2010/08/30/1812552.html
	 * 
	 * http://localhost:8080/mywebsite/cookie1?option=get 获取cookie
	 * http://localhost:8080/mywebsite/cookie1 删除cookie name
	 * http://localhost:8080/mywebsite/cookie1?option=set 设置cookie name pass
	 */
	static{
		TimeZone.getTimeZone("Asia/Shanghai");//
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置输出内容格式
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().append("Served at: ").append(req.getContextPath());
		
		//获取url参数 option
		String option=req.getParameter("option");
		if(option==null) {
			System.out.println("没有参数");
			
			//清空cookie name
			Cookie cookie=new Cookie("name", null);
			cookie.setMaxAge(0);
			//删除指定路径上的Cookie，不设置该路径，默认为删除当前路径Cookie；
			cookie.setPath("/");
			resp.addCookie(cookie);
			System.out.println("remove cookie...");
			
			return;
		}else if(option.equals("set")) {
			mySet(req, resp);
			System.out.println("set cookie...2");
		}else if(option.equals("get")) {
			myGet(req, resp);
		}
	}

	//读取cookie
	private void myGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Cookie[] cookies=req.getCookies(); //获取一个cookie数组
		if(null==cookies) {
			System.out.println("没有cookie===");
		}else {
			PrintWriter out=resp.getWriter();
			for(Cookie cookie: cookies){
				String str=cookie.getName()+"="+cookie.getValue();
				System.out.println(str);
				out.append("<p>"+str+"<p>");
			}
		}
		
		System.out.println("Cookie read done!\n");
		
	}

	// 设置 cookie
	private void mySet(HttpServletRequest req, HttpServletResponse resp) {
		//分别设定cookie，和生命周期
		Cookie name=new Cookie("name", "tomcat");
		//如果设置为负值的话，则为浏览器进程Cookie(内存中保存)，关闭浏览器就失效
		name.setMaxAge(5);
		resp.addCookie(name);
		
		Cookie pass=new Cookie("pass", "123");
		pass.setMaxAge(10);
		//设置路径，这个路径即该工程下都可以访问该cookie 
		//如果不设置路径，那么只有设置该cookie路径及其子路径可以访问
		pass.setPath("/");
		resp.addCookie(pass);
		
		//cookie中不能有空格 https://www.bbsmax.com/A/xl5617OoJr/
		String str= new Date().toString().replace(" ", "-");
		System.out.println("===> "+str);
		Cookie c=new Cookie("lastAccessTime",str);
		
		c.setMaxAge(-1); //浏览器关闭前有效
		resp.addCookie(c);
		
		System.out.println("Cookie set done!\n");
	}
}
