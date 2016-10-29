import asyncio

# 让我们对比一下上一节的代码：
# 
# @asyncio.coroutine
# def hello():
#     print("Hello world!")
#     r = yield from asyncio.sleep(1)
#     print("Hello again!")
# 用新语法重新编写如下：

async def hello(n):
    print("Hello world!",n)
    r = await asyncio.sleep(1)
    print("Hello again!",n)
    
# 获取EventLoop:
loop = asyncio.get_event_loop()
# 执行coroutine
#loop.run_until_complete(hello())
tasks=[hello(1), hello(2), hello(3),hello(4)]
loop.run_until_complete(asyncio.wait(tasks))
loop.close()
