# pip install aiohttp
import asyncio
from aiohttp import web

# '采用flask风格路由修饰器'
routers = web.RouteTableDef()

@routers.get("/")
async def index(request):
    await asyncio.sleep(0)
    print("==> /")
    return web.Response(body="<h1>Index2 首页</h1>",
                        charset='utf-8', #解决中文乱码
                        content_type='text/html') #不加会下载该文本文件

@routers.get("/hello/{name}")
async def hello(request):
    await asyncio.sleep(0)
    print("==> /hello/{name}")
    text = '<h1>内容 hello2, %s!</h1>' % request.match_info['name']
    return web.Response(body=text.encode('utf-8'), 
                        charset='utf-8', #解决中文乱码
                        content_type='text/html')

@routers.get('/json/')
async def json2(request):
    await asyncio.sleep(0.01)
    return web.json_response({
        'name': 'index',
        "status": "ok",
        "auther": "汉字"
    })

app=web.Application()
app.add_routes(routers)
#print(help(web.run_app))
#print(help(web.Response))
# web.run_app(app)
web.run_app(app, host="127.0.0.1", port=8002)
