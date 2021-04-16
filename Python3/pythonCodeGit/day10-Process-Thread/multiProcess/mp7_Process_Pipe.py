#管道Pipe和Queue的作用大致差不多，也是实现进程间的通信
from multiprocessing import Process, Pipe

def fun1(conn):
    print('--2子进程发送消息：')
    conn.send('--你好主进程 from sub')
    print('--3子进程接受消息：')
    print('--in1',conn.recv()) #有消息就接收了
    print('--in2',conn.recv())
    conn.close()

# 主进程和子进程可以相互发送消息
if __name__ == '__main__':
    print('0主进程begin, 并发送消息 main001')
    conn1, conn2 = Pipe() #关键点，pipe实例化生成一个双向管
    conn1.send("你好子进程  from main 001") #发送消息to 子进程
    p = Process(target=fun1, args=(conn2,)) #conn2传给子进程
    print('0子进程begin')
    p.start()
    
    print('1主进程接受消息：')
    print(4,conn1.recv())
    print('5主进程发送消息：')
    conn1.send("你好子进程 from main 002") #先发的先收到
    
    p.join()
    print('结束测试')