# Python对协程的支持是通过generator实现的。
# 在generator中，我们不但可以通过for循环来迭代，还可以不断调用next()函数获取由yield语句返回的下一个值。
# 但是Python的yield不但可以返回一个值，它还可以接收调用者发出的参数。
#
#传统的生产者-消费者模型是一个线程写消息，一个线程取消息，通过锁机制控制队列和等待，但一不小心就可能死锁。
#如果改用协程，生产者生产消息后，直接通过yield跳转到消费者开始执行，待消费者执行完毕后，切换回生产者继续生产，效率极高

# 对基于生成器的协程的支持 已弃用并计划在 Python 3.10 中移除。

#消费者
def consumer():
    print("[CONSUMER] 启动")
    r = ''
    while True:
        n = yield r
        if not n:
            print('='*30) #这个if没有被执行过
            return
        print('[CONSUMER] Consuming %s...' % n)
        r = '200 OK '+str(n)

#生产者
def produce(c):
    print("-->[生产者] 启动")
    c.send(None)
    n = 0
    while n < 5:
        n = n + 1
        print('-->[生产者PRODUCER] Producing %s...' % n)
        r = c.send(n)
        print('-->[生产者PRODUCER] Consumer return: %s' % r)
    c.close()

c = consumer()
produce(c)