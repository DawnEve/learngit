import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Cookie1 extends HttpServlet{ 

	/** 
	 * cookie封装： http://www.cnblogs.com/muzongyan/archive/2010/08/30/1812552.html
	 * 
	 * http://localhost:8080/mywebsite/cookie1?option=get 获取cookie
	 * http://localhost:8080/mywebsite/cookie1 删除cookie name
	 * http://localhost:8080/mywebsite/cookie1?option=set 设置cookie name pass
	 */
	private static final long serialVersionUID = 1L;
	static{
		TimeZone.getTimeZone("Asia/Shanghai");//
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException, IOException
	{
		String option=req.getParameter("option");
		if(option==null){
			System.out.println("没有参数");
			
			//清空cookie name
			Cookie cookie = new Cookie("name", null);
			cookie.setMaxAge(0);
			//删除指定路径上的Cookie，不设置该路径，默认为删除当前路径Cookie；
			//cookie.setPath("/");
			res.addCookie(cookie);
			
			return;
		}
		if(option.equals("set")){
			mySet(req,res);
		}
		if(option.equals("get")){
			myGet(req,res);
		}
		
	}
	
	//设置cookie
	static void mySet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException, IOException
	{
		//分别设定cookie，和生命周期
		Cookie cookie=new Cookie("name","tomcat");
		//如果设置为负值的话，则为浏览器进程Cookie(内存中保存)，关闭浏览器就失效
		cookie.setMaxAge(5);//5s
		res.addCookie(cookie);

		Cookie cookie2=new Cookie("pass","123");
		cookie2.setMaxAge(10);//10s
		//设置路径，这个路径即该工程下都可以访问该cookie 
		//如果不设置路径，那么只有设置该cookie路径及其子路径可以访问
		cookie2.setPath("/");
		res.addCookie(cookie2);
		
//		Cookie c = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
		Cookie c = new Cookie("lastAccessTime", new Date().toString());
		//c.setMaxAge(0);//0s不保存
		c.setMaxAge(-1);//浏览器关闭前有效
		res.addCookie(c);
		
		System.out.println("cookie设定完成！");
	}
	
	//读取cookie
	static void myGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException, IOException
	{
		Cookie[] cookies = req.getCookies();//这样便可以获取一个cookie数组
		if (null==cookies) {
            System.out.println("没有cookie=========");
        } else {
        	PrintWriter out=res.getWriter();
			for(Cookie cookie : cookies){
			    String str=cookie.getName()+"="+cookie.getValue();
			    System.out.println(str);
			    out.println(str);
			}
        }
		
		System.out.println("cookie读取完成");
	}

	
}
