#以Queue为例，在父进程中创建两个子进程，一个往Queue里写数据，一个从Queue里读数据。

from multiprocessing import Process, Queue, Pipe
import os, time, random

# 写数据进程执行的代码:
def write(q):
    print('[->File] Process to write: %s' % os.getpid())
    for value in ['A', 'B', 'C','d']:
        print('Put %s to queue...' % value)
        q.put(value)
        ns=random.random()
        print('>(Sleep for %0.4f s)'% ns)
        time.sleep(ns)

# 读数据进程执行的代码:
def read(q):
    print('[File->] Process to read: %s' % os.getpid())
    while True:
        value = q.get(True)
        print('    Get %s from queue.' % value)

if __name__=='__main__':
    # 父进程创建Queue，并传给各个子进程：
    q = Queue() #Pipe()
    q.put('I am')
    q.put('stay')
    q.put('here')
    pw = Process(target=write, args=(q,))
    pr = Process(target=read, args=(q,))
    # 启动子进程pw，写入:
    pw.start()
    # 启动子进程pr，读取:
    pr.start()
    # 等待pw结束:
    pw.join()
    # pr进程里是死循环，无法等待其结束，只能强行终止:
    pr.terminate()
    
print("==========End line of Process", os.getpid())



