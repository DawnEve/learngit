import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Hello3 extends HttpServlet {

	/** 
	 * 输出到网页，获取get方式传递过来的变量
	 */
	private static final long serialVersionUID = 1L;
	private String message="";
	
	public void init() throws ServletException
	{
		// 执行必需的初始化
		message = "Hello World, today";
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException, IOException
	{
		// 设置响应内容类型
		res.setContentType("text/html");
		
		//接收get过来的变量
		String usr=req.getParameter("username");
		String pass=req.getParameter("password");
		
		// 实际的逻辑是在这里
		PrintWriter out = res.getWriter();
		out.println("<h1>" + message + "</h1>" + usr+":"+pass);
	}

}
