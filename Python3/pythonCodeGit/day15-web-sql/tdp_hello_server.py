# 导入socket库:
import socket

s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM) #SOCK_DGRAM指定了这个Socket的类型是UDP。
# 绑定端口:
s.bind(('127.0.0.1', 9999))


print('Bind UDP on 9999...')
while True:
    # 接收数据:
    #绑定端口和TCP一样，但是不需要调用listen()方法，而是直接接收来自任何客户端的数据：
    data, addr = s.recvfrom(1024)
    print('Received from %s:%s.' % (data, addr))
    s.sendto(b'Hello, %s!' % data, addr)

#可以使用浏览器访问 127.0.0.1:9999
# Waiting for connection...
# Accept new connection from 127.0.0.1:64953...
# Accept new connection from 127.0.0.1:64954...
# Connection from 127.0.0.1:64953 closed.

# ftp://127.0.0.1:9999
# Waiting for connection...
# Accept new connection from 127.0.0.1:64977...
# Connection from 127.0.0.1:64977 closed.

# Bind UDP on 9999...
# Received from 127.0.0.1:51881.
# Received from 127.0.0.1:51881.
# Received from 127.0.0.1:51881.