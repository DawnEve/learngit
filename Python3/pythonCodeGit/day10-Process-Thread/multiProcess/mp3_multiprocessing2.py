#!/usr/bin/python3
# -*- coding: utf-8 -*-

from multiprocessing import Process
import os

# 子进程要执行的代码
def run_proc(name):
    print('Run child process %s (%s)...' % (name, os.getpid()))

if __name__=='__main__':
    print('Parent process %s.' % os.getpid())
    # 1.传入一个执行函数和函数的参数
    p = Process(target=run_proc, args=('test1',)) #multiprocessing模块提供了一个Process类来代表一个进程对象
    print('------Child process will start.')
    p.start() #2.用start()方法启动子进程
    p.join() #3.join()方法可以等待子进程结束后再继续往下运行，通常用于进程间的同步。
    print('------Child process end.')

print('I am always here:pid =',os.getpid())
print('I am always here:ppid =',os.getppid())

"""
Parent process 11424.
------Child process will start.
I am always here:pid = 16108
I am always here:ppid = 11424
Run child process test1 (16108)...
------Child process end.
I am always here:pid = 11424
I am always here:ppid = 16820
"""