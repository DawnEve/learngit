## 并行统计bam文件的行数
## 

## 任务：从文件读取一行cell id，作为参数传给处理进程们。
## 一个进程写数据，一个进程池 众多线程读和处理数据。
## 读、写进程之间用queue通信。

#问题： 为什么不能在子进程中完整保存呢？因为没有flush文件。


# on linux only.

import os
os.chdir('/data4/wangjl/B116B117/01getAPA_matrix')
os.getcwd()

#2
import pysam
#fun: 统计多少行的函数，输入cb，返回行数
def getLineNumber(cb):
    fname='bamFiles_B117_batch/B117_'+cb+'_batch.bam';
    bf = pysam.AlignmentFile(fname, 'rb')
    LineNumber=0
    for line in bf:
       LineNumber+=1
    bf.close()
    return LineNumber
#test
#getLineNumber('AAACCTGAGGCCATAG-1') #1764


#3
import time,multiprocessing,os,random,re,sys
from multiprocessing import Queue
from multiprocessing import Process


path_cb_list="B117_CellBarCode_list.txt" # cell barcode路径

#start time
start=time.time()
print('='*10, "Begin of main process", os.getpid(), "[child pid by parent ppid]")


# 读和处理数据
def worker(cb):
    #一个很耗时的计算
    rs=cb+"\t"+str( getLineNumber(cb) ) #该函数在上一个cell定义的
    #结果输出到管道
    q.put(rs)





#保存的线程1个
def worker_out():
    i=0
    with open('oB117_.check', 'w') as f:
        while True:
            i+=1
            if i%1000==0:
                pass 
                #print(i) #调试用
            
            rs=q.get() #waite while q is empty
            #print(rs)
            f.write(rs+"\n") #写入文件
            f.flush() #刷新缓存，一次性输出到文件






# 主进程
if __name__ == '__main__':
    q=Queue(60) #会超标，但是不会超出太多
    
    # 声明进程池对象
    pool = multiprocessing.Pool(processes = 32)

    #文件读取，分配任务给进程
    fr=open(path_cb_list,'r')

    # 向进程池中提交任务
    i=0
    for lineR in fr.readlines():
        i+=1
        if i>10:
            pass;
            #break;

        line=lineR.strip()
        arr=re.split(' ',line)
        #print("start new process", line) #任务是一次发送完的
        pool.apply_async( worker,args=(arr[0],) )
    fr.close() #关闭文件

    #分完任务，开始启动保存进程
    pOut = Process(target=worker_out)
    pOut.start()

    #等待读进程结束
    pool.close()
    pool.join()

    #主线程查看队列，决定是否关掉写循环
    while not q.empty():
        time.sleep(1)#每一秒检查一次队列

    pOut.terminate(); #终止死循环
    
print(time.time()-start,'s', '='*10, "End of main process", os.getpid())
