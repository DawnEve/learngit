package com.mio.param;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getRequestBody")
public class GetRequestBody extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 需要数据类型: 
		res.setContentType("text/html;charset=UTF-8");
		// 向浏览器写内容
		PrintWriter out=res.getWriter();
		out.println("<h1>Http header post</h1>");
		
		//获取请求体
		BufferedReader br=req.getReader();
		//读取数据
		String line=null;
		while( (line=br.readLine())!=null ) {
			System.out.println(line);
		}
		System.out.println("post done");
	}
}
