1. 使用菜单新建文件
菜单 File-new-servlet，可自动生成文件结构

文件路径: Servlet_2/src/main/java/
包路径: com.mio.XX

com.mio.hi.
	Hello1.java 第一个测试，网页输出 html



2. 参数传递
com.mio.param.
	GetPara.java
	GetRequestLine.java 获取请求行(第一行)
	GetHeader.java 请求头(键值对)
	GetRequestBody.java 请求体（只有post提交时才有）
	RequestDemo.java 通用请求方法
		4个方法
		中文post乱码，首行加: req.setCharacterEncoding("utf-8");
	RequestDispatcherDemo: 通过 request 对象获取请求转发器对象
		转发给这个进行请求: RequestDispatcherDemo2
	GetServletContext: req.getServletContext() 获取上下文，有啥用？


3. http 响应
com.mio.response.
	ResponseDemo1.java;
	ResponseDemo2.java; //重定向到 demo1; 发送错误信息


4. Cookie & Session 会话机制
com.mio.session.
	CookieDemo.java


5. 实现一个过滤器
com.mio.filter.
	LogFilterDemo.java 记录日志的拦截器
	Demo1.java //测试地址
	Demo2.java //测试地址
	LogFilterDemo2.java 使用注解设置 init 参数，并读取


