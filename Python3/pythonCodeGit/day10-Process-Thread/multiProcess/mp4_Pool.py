from multiprocessing import Pool
import os, time, random

def long_time_task(name):
    print('Run task %s (%s)...' % (name, os.getpid()))
    start = time.time()
    time.sleep(1+random.random() * 2)
    end = time.time()
    print('    >Task %s(%s) runs %0.2f seconds.(from %s)' % (name,os.getpid(), (end - start),os.getppid()))

if __name__=='__main__':
    print('Parent process %s.' % os.getpid())
    p = Pool(4)
    for i in range(6):
        p.apply_async(long_time_task, args=(i,)) #由于Pool(4)设置池是4个，所以0123必须有一个停了才能跑下一个
    print('===Waiting for all subprocesses done...')
    p.close() #调用close()之后就不能继续添加新的Process了。
    p.join() #对Pool对象调用join()方法会等待所有子进程执行完毕，调用join()之前必须先调用close()
    print('===All subprocesses done.')