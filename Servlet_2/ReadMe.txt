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


3. 


