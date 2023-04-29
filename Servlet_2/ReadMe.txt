0. 使用菜单新建文件
菜单 File-new-servlet，可自动生成文件结构

文件路径: Servlet_2/src/main/java/
包路径: com.mio.XX

参考 
http://www.runoob.com/servlet/servlet-life-cycle.html




1. 测试1
com.mio.hi.
	CurrentDate.java 当前时间戳
	ServletDemo.java 实现 Servlet 接口，实现访问计数器 //比较繁琐，用的不多
	Hello1.java //网页输出 html； 扩展 HttpServlet 类，常用
	



2. 参数传递 req, resp
com.mio.param.
	GetPara.java //输出到网页，获取get方式传递过来的变量
		res.setCharacterEncoding("UTF-8"); //这一句保证输出中文不乱码
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
	CookieDemo.java //cookie的读写: cookie时间总是不准确，超前24小时左右。但是时间5和10s还是有区别的。
		name	tomcat	localhost	/mywebsite	2017-01-01T17:03:09.672Z	10				
		pass	123	localhost	/	2017-01-01T17:03:14.672Z	7
		win7 chrome的cookie保存位置：C:\Users\admin\AppData\Local\Google\Chrome\User Data\Default\Cache\Cache_Data
	SessionDemo1.java //session操作 创建、增、删、查
	SessionDemo2.java //session操作 判断与跳转
	SessionDemo3.java //session操作 遍历 当前的 session
	
	ServletContextDemo1.java // 4种初始化方法；2个主要用途
	ServletContextDemo2.java // 测试获取值，配合demo1
	ServletContextDemo3.java // 获取配置的初始化参数 getInitParameter()
	ServletContextDemo4.java //请求转发
	ServletContextDemo5.java //记日志





5. 实现一个过滤器
com.mio.filter.
	LogFilterDemo.java 记录日志的拦截器
	Demo1.java //测试地址
	Demo2.java //测试地址
	LogFilterDemo2.java 使用注解设置 init 参数，并读取





6. IO
com.mio.io.
	VisitNumber.java //访问计数器，记录到文件中


7. 数据库 MySql
com.mio.mysql.
	DBDemo1.java // session操作 db判断 (1)防止注入（先判断用户名，再判断密码）(2)注意及时关闭资源






10. 其他
com.mio.other.
	LocaleDemo.java //国际化，获取本地和语言

	