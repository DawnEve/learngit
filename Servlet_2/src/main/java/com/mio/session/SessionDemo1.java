package com.mio.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionDemo1")
public class SessionDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String message;
	
    public SessionDemo1() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	// 执行必需的初始化
    	message = "Hello World, today";
    }

    //设置 http://localhost:8080/Servlet_2/sessionDemo1?action=set&name=wangcai //可修改name值，然后从其他连接查看
    //读取 http://localhost:8080/Servlet_2/sessionDemo1?action=get

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取 session 对象
		HttpSession hs = req.getSession(true);
		
		//根据参数确定是否设置 session
		String action=req.getParameter("action");
		System.out.println("action:"+action);
		if(action!=null && action.equals("set")) {
			//设置session内容
			hs.setAttribute("name", req.getParameter("name"));
			hs.setAttribute("pass", "123");
			
			hs.setAttribute("gender", "M");
			//删除键值对
			hs.removeAttribute("gender");
			
			// 设置session时间，默认是30min； 
			//怎么看这个的作用呢？设置页面访问后，查看，然后等待10s，再次查看，标题为null了
			hs.setMaxInactiveInterval(10); //10s			
		}
		
		//读取session内容
		String str=(String) hs.getAttribute("name");
		System.out.println(str);
		
		//获取 sessionid
		String id=hs.getId();
		System.out.println("sessionid="+id); //FE3CA7D4F577396CFD8E0C70BD80491F
		
		//Part II
		//设置输出内容的类型
		resp.setContentType("text/html;charset=UTF-8");
		// 输出
		resp.getWriter().printf("<h1>name:%s, pass:%s</h1>", str, hs.getAttribute("pass"));
		resp.getWriter().append("sessionid="+id+
				"<p style='color:red'> to set pass, run url: ?action=set&name=haha</p>" );
	}
}
