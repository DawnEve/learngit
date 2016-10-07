#多线程和多进程最大的不同在于，多进程中，同一个变量，各自有一份拷贝存在于每个进程中，互不影响，
#而多线程中，所有变量都由所有线程共享，所以，任何一个变量都可以被任何一个线程修改，
#因此，线程之间共享数据最大的危险在于多个线程同时改一个变量，把内容给改乱了。

#来看看多个线程同时操作一个变量怎么把内容给改乱了：
import time, threading

# 假定这是你的银行存款:
balance = 0

def change_it(n):
    # 先存后取，结果应该为0:
    global balance
    balance = balance + n
    balance = balance - n
    #print("balance = %s (after Thread %s)" % (balance, threading.current_thread().name))

def run_thread(n):
    for i in range(100000):
        change_it(n)

t1 = threading.Thread(target=run_thread, args=(5,),name='t1')
t2 = threading.Thread(target=run_thread, args=(8,),name='t2')
t1.start()
t2.start()
t1.join()
t2.join()

#多run几次（~10-20次）就会出现非零值
print(balance) #8 -5 5

