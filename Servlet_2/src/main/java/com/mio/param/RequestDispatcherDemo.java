package com.mio.param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestDispatcherDemo")
public class RequestDispatcherDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("demo1 被访问了");
		
		// 转递数据给 下一个 servlet
		req.setAttribute("msg", "张三说hello");
		
		//转发给demo2
		/*
		//1. 获取转发器对象: 参数是要转发的目标地址
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/requestDispatcherDemo2");
		//2. 转发
		requestDispatcher.forward(req, res);
		*/
		// 推荐合成一行
		req.getRequestDispatcher("/requestDispatcherDemo2").forward(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.doGet(req, res);
	}
}
