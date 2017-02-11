package com.dawn.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LogFilter implements Filter{
	@Override
	public void init(FilterConfig config) throws ServletException {
		// 获取初始化参数，从web.xml文件获取配置信息
		String site = config.getInitParameter("Site"); 
		// 输出初始化参数
		String site2=site;
		try {
			site2 = new String(site.getBytes("ISO8859-1"),"UTF-8");//防止中文乱码
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("init: 网站名称=" + site2); 
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 输出站点名称
		System.out.println("站点网址：http://www.biomooc.com");
		
		// 把请求传回过滤链
		chain.doFilter(request,response);
	}


	@Override
	public void destroy() {
		/* 在 Filter 实例被 Web 容器从服务移除之前调用 */
		System.out.println("destroy logfilter.");
		
	}
}
