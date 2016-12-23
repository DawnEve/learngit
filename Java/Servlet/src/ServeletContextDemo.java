import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServeletContextDemo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException, IOException
	{
		res.setContentType("text/html;charSet=utf8");//设定输出编码
		
		//1.获得
		ServletContext sc=this.getServletContext();
		//2.赋值
		sc.setAttribute("title", "this is a website 哈哈");
		
		//3.获取
		String info=(String) sc.getAttribute("title");
		
		System.out.println(info);
		PrintWriter out=res.getWriter();
		out.println(info);
	}

}
