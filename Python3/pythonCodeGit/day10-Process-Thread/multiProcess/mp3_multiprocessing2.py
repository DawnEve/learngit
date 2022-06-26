from multiprocessing import  Process
import time,random

class MyProcess(Process): #继承Process类
    def __init__(self,name,i):
        super(MyProcess,self).__init__()
        self.name = name
        self.i=i

    def run(self):
        x=random.random()*3 #一个耗时任务
        time.sleep(x)
        print('test %d: 测试%s多进程，本进程耗时 %3.2f s' % (self.i, self.name, x ) )


if __name__ == '__main__':
    process_list = []
    start=time.time()
    for i in range(5):  #开启5个子进程执行fun1函数
        p = MyProcess('Python', i) #实例化进程对象
        p.start()
        process_list.append(p)

    for pr in process_list:
        pr.join()

    print('结束测试', time.time()-start)