package com.mio.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;


@WebFilter(urlPatterns="/filter/demo1", initParams = {
		@WebInitParam(name="username", value="admin"),
		@WebInitParam(name="passwd", value="123"),
}, dispatcherTypes = DispatcherType.REQUEST)

public class LogFilterDemo2 implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
		
		String name=filterConfig.getInitParameter("username");
		String passwd=filterConfig.getInitParameter("passwd");
		System.out.println("init: "+name+" "+passwd);
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		//1.发生在 servlet 之前
		System.out.println("LogFilter2 begin...");

		//2. 传给servlet。可以做判断
		String name=req.getParameter("name");
		if(name.equals("admin")) {
			chain.doFilter(req, res); //这一行把控制权交给 Servlet
		}else {
			//设置返回内容，不再传给Servlet处理
			res.setContentType("text/html;charset=UTF-8");
			//在页面输出响应信息
			PrintWriter out=res.getWriter();
			out.append("<b>name不正确，请求被拦截，不能访问资源</b>");
			System.out.println("被拦截: name 不正确");
		}
		
		//3. 发生在 Servlet 之后
		System.out.println("LogFilter2 End...\n");
	}
}
