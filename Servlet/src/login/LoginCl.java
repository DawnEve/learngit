package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

public class LoginCl extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException, IOException
	{
		res.setContentType("text/html;charSet=utf8");
		
		//接收用户名和密码
		String u=req.getParameter("username");
		String p=req.getParameter("passwd");
		
		//调用UserBeanCl, 1.实例化对象
		UserBeanCl ubc=new UserBeanCl();
		
		//2.使用UserBeanCl的方法
		if(ubc.checkUser(u, p)){
			//合法用户
			String keep=req.getParameter("keep");
			
			if(keep!=null){
				//将用户信息保存到cookie中
				Cookie name=new Cookie("myname",u);
				Cookie pass=new Cookie("mypasswd",p);
				
				//设置时间2周
				name.setMaxAge(14*24*3600);
				pass.setMaxAge(14*24*3600);
				
				//回写到客户端
				res.addCookie(name);
				res.addCookie(pass);
			}
			
			//将用户名和密码写入session中
			HttpSession hs=req.getSession(true);
			hs.setMaxInactiveInterval(30*60);
			hs.setAttribute("uname", u);
			
			//跳转到wel
			res.sendRedirect("wel");
			
		}else{
			//不合法用户
			res.sendRedirect("login");//重定向到某个url
			System.out.println("user or passwd error....");
			return;
		}
	}
}
