import asyncio, time, random

async def outer(n):
    print(n,'in outer')
    print(n, 'waiting for result1')
    result1 = await phase1(n)
    
    print(n, '==waiting for result2')
    result2 = await phase2(result1,n)
    
    return (result1,result2, n)

async def phase1(n):
    x=random.random()*2
    await asyncio.sleep(x)
    print(n, 'in phase1, lasting ', x)
    return 'result1'

async def phase2(arg,n):
    x=random.random()*3
    await asyncio.sleep(x)
    print(n, '==in phase2, lasting ', x)
    return '==result2 derived from {}'.format(arg)

start=time.time()
loop = asyncio.get_event_loop()
tasks = [outer(1), outer(2), outer(3)]
return_value = loop.run_until_complete(asyncio.wait(tasks))
print(return_value)
loop.close()
print("==end==", time.time()-start)
