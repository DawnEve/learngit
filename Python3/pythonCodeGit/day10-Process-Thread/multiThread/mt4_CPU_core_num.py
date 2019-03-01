import threading, multiprocessing

print('CPU个数：',multiprocessing.cpu_count()) #4

def loop():
    x = 1
    while True:
        x = x ^ 1

for i in range(multiprocessing.cpu_count()):
    t = threading.Thread(target=loop)
    t.start()

#Python虽然不能利用多线程实现多核任务，但可以通过多进程实现多核任务。多个Python进程有各自独立的GIL锁，互不影响。
#线程的并发在Python中就是一个美丽的梦。