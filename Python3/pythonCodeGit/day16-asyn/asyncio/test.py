import asyncio

async def outer():
    print('in outer')
    print('waiting for result1')
    result1 = await phase1()
    
    print('==waiting for result2')
    result2 = await phase2(result1)
    
    return (result1,result2)

async def phase1():
    await asyncio.sleep(0.2)
    print('in phase1')
    return 'result1'

async def phase2(arg):
    await asyncio.sleep(0.1)
    print('==in phase2')
    return '==result2 derived from {}'.format(arg)

loop = asyncio.get_event_loop()
tasks = [outer(), outer()]
return_value = loop.run_until_complete(asyncio.wait(tasks))
print(return_value)
loop.close()
