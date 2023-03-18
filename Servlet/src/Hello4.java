import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Hello4 extends HttpServlet {

	/** 
	 * session操作
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
		res.setContentType("text/html;charSet=utf8");
		//关于session部分
		HttpSession hs=req.getSession(true);
		
		//设置session时间.默认是30min。
		hs.setMaxInactiveInterval(10);//10s 
		
		//设置session内容
		hs.setAttribute("pass","ok");
		hs.setAttribute("name","天天");
		
		//读取session内容
		String str=(String)hs.getAttribute("name");
		System.out.println(str);
		
		//获取sessionid
		String id=hs.getId();
		System.out.println(id);//A10F4CC8AD14A3BB7D09B0143E10FAA7
		
		
		// 设置响应内容类型
		res.setContentType("text/html");
		
		// 实际的逻辑是在这里
		PrintWriter out = res.getWriter();
		out.println("<h1>" + str + "</h1> sessionid="+id);
	}

}
