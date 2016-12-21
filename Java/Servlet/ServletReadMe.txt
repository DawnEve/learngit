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
写了一个login Servlet模块
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

