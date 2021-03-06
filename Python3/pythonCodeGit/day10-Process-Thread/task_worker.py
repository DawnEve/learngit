# task_worker.py run on win7 

import time, sys, queue
from multiprocessing.managers import BaseManager

# 创建类似的QueueManager:
class QueueManager(BaseManager):
    pass

# 由于这个QueueManager只从网络上获取Queue，所以注册时只提供名字:
QueueManager.register('get_task_queue')
QueueManager.register('get_result_queue')

# 连接到服务器，也就是运行task_master.py的机器:
server_addr = '192.168.2.120'
print('Connect to server %s...' % server_addr)
# 端口和验证码注意保持与task_master.py设置的完全一致:
m = QueueManager(address=(server_addr, 5000), authkey=b'abc')
# 从网络连接:
m.connect()
# 获取Queue的对象:
task = m.get_task_queue()
result = m.get_result_queue()


# 从task队列取任务,并把结果写入result队列:
for i in range(10):
    try:
        # 获取参数n
        n = task.get(timeout=2)

        # 进行本机计算
        print('run task with %d ...' % (n))
        r = '%d * %d = %d' % (n, n, n*n)
        time.sleep(3)        

        #计算结果压入result中
        result.put('完成：'+r) 
    except Queue.Empty:
        print('task queue is empty.')


# 处理结束:
print('worker exit.')

