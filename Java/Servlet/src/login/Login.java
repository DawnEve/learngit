package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException, IOException
	{
		res.setContentType("text/html;charSet=utf8");
		PrintWriter out=res.getWriter();
		out.println("<h1>用户登录</h1>");
		out.println("<form action='logincl' methond=get>");
		out.println("用户名：<input type='text' name=username><br/>");
		out.println("密码：<input type='text' name=passwd><br/>");
		out.println("<input type='checkbox' name=keep>两周免登陆<br/>");
		out.println("<input type='submit' value='提交'>");
		
		out.println("</form>");
	}
}
