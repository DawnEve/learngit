# server.py
# 从wsgiref模块导入:
from wsgiref.simple_server import make_server
# 导入我们自己编写的application函数:
from hello import application

# 创建一个服务器，IP地址为空，端口是8000，处理函数是application:
httpd = make_server('', 8000, application)
print('Serving HTTP on port 8000...')
# 开始监听HTTP请求:
httpd.serve_forever()

#注意：如果8000端口已被其他程序占用，启动将失败，请修改成其他端口。
#启动成功后，打开浏览器，输入http://localhost:8000/，就可以看到结果了：