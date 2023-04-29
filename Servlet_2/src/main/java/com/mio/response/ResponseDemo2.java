package com.mio.response;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responseDemo2")
public class ResponseDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// 重定向到 demo1
		// resp.sendRedirect("responseDemo1"); //不能写成 "/responseDemo1"，否则会忽略项目名导致找不到路径
		//发送错误信息
		System.out.println("not found");
		resp.sendError(404, "not found on this server!~~"); //一个格式化404页面，参数2是显示的信息
	}
}