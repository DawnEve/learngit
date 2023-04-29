package com.mio.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionDemo2")
public class SessionDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取 session 对象
		HttpSession hs = req.getSession(true);
		
		//判断是否合法登录
		String value = (String) hs.getAttribute("pass");
		System.out.println("value="+value);
		// 需要先访问 sessionDemo1?action=set&name=wangcai，在其中会设置 session的 pass 参数
		// session中没有 pass 参数，会自动跳转，导致无法阅读后续网页内容
		if(null == value) {
			//非法登录
			resp.sendRedirect("sessionDemo1?info=error"); //重定向到某个url
			return;
		}

		//设置输出内容的类型
		resp.setContentType("text/html;charset=UTF-8");
		// 输出
		resp.getWriter().append("您有权限查看 保密内容 <p><b>页面10s不刷新则pass失效</b></p>");
	}
}
