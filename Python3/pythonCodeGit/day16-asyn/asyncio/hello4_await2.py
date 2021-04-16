import asyncio
import time, random


# 怎么引入自定义的函数呢？
# - 前面加  async
# - 中间引入至少一个断点，比如 await asyncio.sleep(0)，否则还是顺序执行。
async def phase1():
    x=2 #random.random()*10
    print("--> in phase1:", x)
    await asyncio.sleep(x) #遇到异步调用，才能断点，CPU才会断开并执行其他平行函数。
    return "result1"

async def phase2(i, arg):
    x=1# random.random()*2
    print(i, "====> in phase2:", x)
    #time.sleep(x)
    await asyncio.sleep(x)
    tmp="result2 derived from {}".format(arg)
    print(i, "====>", tmp)
    return tmp


# hello()任务由2个阶段，phase1, phase2
async def hello(n):
    print('='*20,"\nIn outer!",n)
    
    print("Waiting for result1")
    # r = await asyncio.sleep(1)
    rs1=await phase1()
    
    print("Waiting for result2")
    rs2=await phase2(n, rs1)
    
    return (n, rs1, rs2)


# 获取EventLoop:
loop = asyncio.get_event_loop()
# 执行coroutine
#loop.run_until_complete(hello())
tasks=[hello(1), hello(2), hello(3)]
start=time.time() #时间点1
return_value=loop.run_until_complete(asyncio.wait(tasks))
end=time.time() #时间点2
loop.close()
#

print("="*10, end-start, "seconds") 
# 每个任务3s，同步 则三个任务9s。 异步则取决于最长的时间。
print(return_value)
