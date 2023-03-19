package com.mio.param;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getHeader")
public class GetHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		// 向浏览器写内容
		PrintWriter out=res.getWriter();
		String title="Http header 请求实例";
		out.println("<h1>"+title+"</h1>");
		
		//获取请求头
		Enumeration<String> headerNames = req.getHeaderNames();
		out.printf("<p><b> 键: 值</b></p>");
		while(headerNames.hasMoreElements()) {
			String key=headerNames.nextElement();
			String val=req.getHeader(key);
			out.printf("<p><b>%s</b>: %s</p>", key, val);
		}
		
		//作用：后台判断浏览器类型
		String agent=req.getHeader("user-agent");
		if(agent.contains("Chrome")) {
			System.out.println("google ...");
		}else if(agent.contains("Firefox")) {
			System.out.println("Firefox ...");
		}
		
		//作用：从哪里开
		String Referer=req.getHeader("Referer");
		String referer=req.getHeader("referer");
		System.out.println("Referer: "+Referer + ", referer: "+referer);
		// 防盗链
		if(referer != null) {
			if(referer.contains("Header")) {
				// 正常访问
				System.out.println("不做限制");
			}else {
				// 防盗链
				System.out.println("外站不能播放");
			}
		}
	}
}
