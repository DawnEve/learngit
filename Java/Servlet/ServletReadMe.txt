Servlet Note

15:48 2016/11/14

refer:
http://www.runoob.com/servlet/servlet-life-cycle.html

如何在Eclipse+Tomcat环境下部署Servlet？(转） 
http://blog.sina.com.cn/s/blog_5224e7d30100bxj6.html
http://blog.csdn.net/gz_jmark/article/details/17594833

Servlet练习
-------------------------
类名		描述
-------------------------
Hello3 输出到网页，获取get方式传递过来的变量
Hello4 session操作
Hello5 session操作 判断与跳转
Hello6 session操作 db判断 (1)防止注入（先判断用户名，再判断密码）(2)注意及时关闭资源
Hello7	db分页，特别经典！
	todo:如果太多，怎么显示分页按钮呢？模仿网易博客吧

ReadSession 遍历session

Cookie1 cookie的读写: cookie时间总是不准确，超前24小时左右。但是时间5和10s还是有区别的。
	ame	tomcat	localhost	/mywebsite	2017-01-01T17:03:09.672Z	10				
	pass	123	localhost	/	2017-01-01T17:03:14.672Z	7	
win7 chrome的cookie保存位置：C:\Users\Administrator\AppData\Local\Google\Chrome\User Data\Default\Cache

-------------------------
Lesson 5.写了一个login Servlet模块
1.一个6个class文件，

界面： Login	LoginCl	Wel
模型： UserBean UserBeanCl	ConnDB


2.三个有url链接，所以写到web.xml中的三个：
F:\xampp\tomcat\webapps\mywebsite\WEB-INF\web.xml 
	  	<servlet>
		<!--给servlet取个名字，任意的-->
		<servlet-name>login</servlet-name>
		<!--指定servlet的路径，就是（包名字+类名）-->
		<servlet-class>login.Login</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>login</servlet-name>
		<url-pattern>/login</url-pattern>
	</servlet-mapping>
	
	  	<servlet>
		<!--给servlet取个名字，任意的-->
		<servlet-name>logincl</servlet-name>
		<!--指定servlet的路径，就是（包名字+类名）-->
		<servlet-class>login.LoginCl</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>logincl</servlet-name>
		<url-pattern>/logincl</url-pattern>
	</servlet-mapping>
	
	  	<servlet>
		<!--给servlet取个名字，任意的-->
		<servlet-name>wel</servlet-name>
		<!--指定servlet的路径，就是（包名字+类名）-->
		<servlet-class>login.Wel</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>wel</servlet-name>
		<url-pattern>/wel</url-pattern>
	</servlet-mapping>
3.url分别是：
http://localhost:8080/mywebsite/login
http://localhost:8080/mywebsite/wel?page=2

中间是一个快速跳转页面：
http://localhost:8080/mywebsite/logincl


-------------------------
Lesson 6.ServletContext

常用语句：
res.setContentType("text/html;charSet=utf8");//设定输出编码

(1)服务器端共享数据块： ServeletContextDemo.java
(2)文件读写


-------------------------
Lesson 7.完善界面

-------------------------
Lesson 8.tomcat虚拟目录
JSP（全称Java Server Pages）

-------------------------
1.汉字转码
注意：如果表单提交的数据中有中文数据则需要转码：
String name =new String(request.getParameter("name").getBytes("ISO8859-1"),"UTF-8");

http://localhost:8080/mywebsite/getDemo

com.dawn.servlet.GetDemo.java 获取参数，获取汉字参数。
http://localhost:8080/mywebsite/getDemo?token=sfd&keyword=baidu百度250


2.获取header信息
通过枚举，获取key，再通过循环，获取value。
upgrade-insecure-requests: 1是什么意思？
http://localhost:8080/mywebsite/getHeader
	http://www.cnblogs.com/hustskyking/p/upgrade-insecure-requests.html
	解释说是一项草案：
	页面一旦发现存在http响应头，会在加载 http 资源时自动替换成 https 请求。

3.设置header信息
4.Servlet 过滤器是可用于 Servlet 编程的 Java 类，可以实现以下目的：
	在客户端的请求访问后端资源之前，拦截这些请求。
	在服务器的响应发送回客户端之前，处理这些响应。

根据规范建议的各种类型的过滤器：
	身份验证过滤器（Authentication Filters）。
	数据压缩过滤器（Data compression Filters）。
	加密过滤器（Encryption Filters）。
	触发资源访问事件过滤器。
	图像转换过滤器（Image Conversion Filters）。
	日志记录和审核过滤器（Logging and Auditing Filters）。
	MIME-TYPE 链过滤器（MIME-TYPE Chain Filters）。
	标记化过滤器（Tokenizing Filters）。
	XSL/T 过滤器（XSL/T Filters），转换 XML 内容。
	
	
	
5.文件上传和jar包位置：
问题：
1).为什么这两个包需要存在2份？
一份是Servlet/WebContent/WEB-INF/lib下，一份是Servlet/WEB-INF/lib/下。
前者是eclipse生成用，后者是tomcat运行用。
能否少一份，以便减少git文件体积。只能减少前者了。
删除Servlet/WebContent/WEB-INF/lib/下的2个jar包，UploadServlet.java报错，右击该java文件，选择build path,
configure build path, libraries, add JARs,选择Servlet/WEB-INF/lib/下的2个jar包确定即可。

2).jar包存放的位置？
jar包如果是项目运行必须的，则2个地方至少放一个。
一个tomcat级别的lib文件夹：\tomcat\lib\
一个是具体项目级别的lib文件夹：\项目名\WEB-INF\lib\
tomcat级别的所有项目都可用，而项目级别的只有该项目可用该jar包。

其他位置则可能是编辑器IDE的要求。可以简化。














