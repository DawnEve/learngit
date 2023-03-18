import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Hello5 extends HttpServlet {

	/** 
	 * session操作 判断与跳转
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException, IOException
	{
		res.setContentType("text/html;charSet=utf8");
		//关于session部分
		HttpSession hs=req.getSession(true);
		
		//判断是否合格
		String val=(String) hs.getAttribute("pass");
		if(val==null){
			//非法登录
			res.sendRedirect("hello4?info=error");//重定向到某个url
			return;
		}

		// 实际的逻辑是在这里
		PrintWriter out = res.getWriter();
		out.println("<h1>" + "保密内容" + "</h1>");
	}
}
