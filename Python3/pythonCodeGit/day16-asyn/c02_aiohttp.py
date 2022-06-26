# pip install aiohttp
import asyncio
from aiohttp import web
import json

async def index(request):
    await asyncio.sleep(0)
    return web.Response(body=b'<h1>Index</h1>', content_type='text/html')

async def hello(request):
    await asyncio.sleep(0)
    text = '<h1>hello, %s!</h1>' % request.match_info['name']
    return web.Response(body=text.encode('utf-8'), content_type='text/html')

async def json_fn(request):
    await asyncio.sleep(0)
    obj={"apple":10, "orange":6, "book":59}
    return web.Response(body=json.dumps(obj), content_type='application/json')
    # application/json
    
async def init(loop):
    app = web.Application(loop=loop)
    # 加路由
    app.router.add_route('GET', '/', index)
    app.router.add_route('GET', '/hello/{name}', hello)
    app.router.add_route('GET', '/json/', json_fn)
    #
    server = await loop.create_server(app.make_handler(), '127.0.0.1', 8002)
    print('Server started at http://127.0.0.1:8002 ...')
    return server

loop = asyncio.get_event_loop()
loop.run_until_complete(init(loop))
loop.run_forever()