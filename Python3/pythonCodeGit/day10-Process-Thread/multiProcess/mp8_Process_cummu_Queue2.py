## 从文件（1-20，每行一个数字）读取一行，作为参数传给进程们，进程之间用queue通信。
## 一个进程写，众多线程读。

# on linux only.

import time,multiprocessing,os,random
from multiprocessing import Queue
from multiprocessing import Process

print('='*10, "Begin of main process", os.getpid(), "[child pid by parent ppid]")


# 这里需要并发执行的任务
def worker(txt):
    print('    =====>>',txt,"-start. [pid=", os.getpid(), ']', sep="")
    #一个很耗时的计算
    time.sleep(1+random.random() * 1)
    rs=int(txt)+10000

    #输出到管道
    q.put(rs)

    #打印结果
    print('    <<',txt," ",rs," end at time=", time.ctime(),' [pid=', os.getpid(), ' by ',os.getppid(),']', "queue size:", q.qsize(),sep="")



#保存的线程1个
def worker_out():
    while True:
        time.sleep(0.5+random.random() * 0.5) #保存需要花时间
        print(q.get(), " saved. ", '[',os.getpid(), ' by ',os.getppid(),']', "queue size:", q.qsize(),sep='')



# 主进程
if __name__ == '__main__':
    q=Queue(6) #会超标，但是不会超出太多
    q.put(-200)

    # 声明进程池对象
    pool = multiprocessing.Pool(processes = 5)

    #文件读取，分配任务给进程
    fr=open("/home/wangjl/num.txt",'r')

    # 向进程池中提交任务
    for lineR in fr.readlines():
        line=lineR.strip()
        #print("start new process", line) #任务是一次发送完的
        pool.apply_async( worker,args=(line,) )
    fr.close() #关闭文件

    #分完任务，开始启动保存进程
    pOut = Process(target=worker_out)
    pOut.start()

    #print(q.get())
    pool.close()
    pool.join()


    #保存结果
    while not q.empty():
        #print( q.get() ) #输出，或者保存到文件
        time.sleep(1)

    pOut.terminate();

print('='*10, "End of main process", os.getpid())
