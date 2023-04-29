package com.mio.param;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/getPara")
public class GetPara extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public GetPara() {
        super();
        System.out.println("1.this is construct method.数据库打开");
    }
	
    // 该函数用于初始化该servlet， 类似于我们的类的构造函数
 	// 该函数只是会被调用一次， 当用户第一次访问该servlet的时候被调用
 	@Override
 	public void init(ServletConfig arg0) throws ServletException {
 		System.out.println("2.init it !");
 	}
 	
 	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {		
		System.out.println(req); //org.apache.catalina.connector.RequestFacade@6cea9668
		System.out.println("3.this is a doGet method.");

		//设置内容类型
		res.setContentType("text/html;charst=utf-8"); 
		res.setCharacterEncoding("UTF-8"); //这一句保证输出中文不乱码
		
		//获取变量
		String usr=req.getParameter("username");
		String pass=req.getParameter("password");
		//打印结果
		PrintWriter out=res.getWriter();
		out.println("<h1>usr:"+usr+", pass:"+pass+"</h1>");
		
		//获取汉字参数
		// http://localhost:8080/Servlet_2/getPara?username=xiaoming&password=123&token=02旺财
		String _token=req.getParameter("token");
		if(null != _token) {
			System.out.println(_token);
			//解决乱码问题
			out.println("<p>_token:"+_token+"</p>"); //网页正常
			out.append("好的2");
		}
	}
	
	@Override
	public void destroy() {
		System.out.println("4.destory it数据库关闭");
	}
}

// http://localhost:8080/Servlet_2/GetPara?username=xiaoming&password=123