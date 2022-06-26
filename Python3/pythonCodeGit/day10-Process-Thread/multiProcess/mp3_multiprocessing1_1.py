# 多进程实现方式1: 开启若干子进程
from multiprocessing import  Process
import time,random

def fun1(name,i):
    x=random.random()*3 #一个耗时任务
    time.sleep(x)
    print('test %d: 测试%s多进程，本进程耗时 %3.2f s' % (i, name, round(x,2) ) )

if __name__ == '__main__':
    process_list = []
    start=time.time()
    for i in range(5):  #开启5个子进程执行fun1函数
        p = Process(target=fun1,args=('Python',i, )) #实例化进程对象
        p.start()
        process_list.append(p)

    for pr in process_list:
        pr.join()

    print('结束测试', time.time()-start)