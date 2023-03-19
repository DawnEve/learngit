package com.mio.param;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestDemo")
public class RequestDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//设置流的编码，防止post时中文乱码
		//http://localhost:8080/Servlet_2/login2.html
		req.setCharacterEncoding("utf-8");
		
		// 需要数据类型: 
		res.setContentType("text/html;charset=UTF-8");
		// 向浏览器写内容
		PrintWriter out=res.getWriter();
		out.println("<h1>通用参数</h1>");
		
		//http://localhost:8080/Servlet_2/requestDemo?username=zs3&hobby=ball&hobby=run2
		//1.获取参数
		String str=req.getParameter("username");
		out.printf("<p>username=%s</p>", str);
		
		//2. 获取复选框参数 req.getParameterValues("hobby")
		String[] str2=req.getParameterValues("hobby");
		for(String ele: str2) {
			out.printf("<p style='color:red'>%s</p>", ele);
		}
		
		//3. 获取参数名 迭代器 req.getParameterNames()
		Enumeration<String> iter = req.getParameterNames();
		while(iter.hasMoreElements()) {
			String key=iter.nextElement();
			String value=req.getParameter(key); //怎么处理复选框？
			out.printf("<p style='color:blue'>%s: %s</p>", key, value );
		}
		
		//4. 获取字典
		Map<String, String[]> map = req.getParameterMap(); //这里键值对，值是数组，就是为了兼容复选框
		//遍历
		Set<String> keyset = map.keySet();
		for(String key: keyset) {
			// 根据键获取值
			String[] values = map.get(key);
			out.printf("<p style='font-size:30px;'>%s: ", key);
			for(String value: values) {
				out.printf("%s, ", value);
			}
			out.printf("</p>");
		}
		

		
		
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.doGet(req, res);
	}
}
