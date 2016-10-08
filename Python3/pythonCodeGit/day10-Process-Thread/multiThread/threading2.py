#启动一个线程就是把一个函数传入并创建Thread实例，然后调用start()开始执行：

# import time, threading
import time, threading, os

# 新线程执行的代码:
def loop():
    print('thread %s is running...' % threading.current_thread().name)
    n = 0
    while n < 5:
        n = n + 1
        print('    thread %s (%s)>>> %s' % (threading.current_thread().name,os.getpid(), n))
        time.sleep(1)
    print('thread %s ended.' % threading.current_thread().name)


print('thread %s is running...' % threading.current_thread().name)
# t = threading.Thread(target=loop, name='LoopThread')
t = threading.Thread(target=loop)
t.start()
t.join()
print('thread %s ended.' % threading.current_thread().name)