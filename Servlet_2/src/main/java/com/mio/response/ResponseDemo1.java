package com.mio.response;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//页面自动刷新:10s
		resp.setIntHeader("Refresh", 10);
		//设置响应内容类型，防止中文乱码
		resp.setContentType("text/html;charset=UTF-8");
		
		//使用默认时区，获取时间字符串
		String now = new Date().toString();
		//浏览器输出 时间
		resp.getWriter().
			append("ResponseDemo1 10秒刷新<br> Served at: ").
			append(req.getRequestURI()).append("<h2>"+now+"</h2>");
		
		//设置404状态
		//resp.setStatus(404, "not found now..."); //2参数的已被废除
		resp.setStatus(404); //只能有一个参数
		
		//设置头信息
		resp.addHeader("author", "Tom");
	}
}