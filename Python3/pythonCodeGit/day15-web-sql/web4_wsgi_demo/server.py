# server.py
# 从wsgiref模块导入:
from wsgiref.simple_server import make_server
# 导入我们自己编写的application函数:
from hello import application

# 创建一个服务器，IP地址为空，端口是8000，处理函数是application:
httpd = make_server('', 8000, application)
print('Serving HTTP on port 8000... \nbrowse http://localhost:8000/ or http://localhost:8000/George')
# 开始监听HTTP请求:
httpd.serve_forever()

#注意：如果8000端口已被其他程序占用，启动将失败，请修改成其他端口。
#启动成功后，打开浏览器，输入http://localhost:8000/，就可以看到结果了.

#无论多么复杂的Web应用程序，入口都是一个WSGI处理函数。
#HTTP请求的所有输入信息都可以通过environ获得，
#HTTP响应的输出都可以通过start_response()加上函数返回值作为Body。

#复杂的Web应用程序，光靠一个WSGI函数来处理还是太底层了，我们需要在WSGI之上再抽象出Web框架，进一步简化Web开发。