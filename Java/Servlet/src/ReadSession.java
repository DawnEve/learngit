import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ReadSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException, IOException
	{
		res.setContentType("text/html;charSet=utf8");
		//关于session部分
		HttpSession hs=req.getSession(true);
		
		//设置session时间.默认是30min。
		//hs.setMaxInactiveInterval(10);//10s 
		//输出到控制台
		System.out.println(hs.getAttribute("pass"));
		System.out.println(hs.getAttribute("usr"));
		System.out.println(hs.getAttribute("usr_id"));
		System.out.println();
		
		
		//获取输出流,输出到网页
		PrintWriter out = res.getWriter();
		java.util.Enumeration   e   =   req.getSession().getAttributeNames(); 
		//遍历输出session内容
		//http://ssh-2009-126-com.iteye.com/blog/1111994
		while( e.hasMoreElements()){   
		    String sessionName=(String)e.nextElement();   
		    out.println("\nsession item name="+sessionName);  
		    out.println("\nsession item value="+req.getSession().getAttribute(sessionName)); 
		    out.println("<br>");
		}
	}
	
	
			

}
