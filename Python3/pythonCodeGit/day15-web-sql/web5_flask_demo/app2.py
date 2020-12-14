#MVC
#Python处理URL的函数就是C：Controller，Controller负责业务逻辑，比如检查用户名是否存在，取出用户信息等等；
#包含变量{{ name }}的模板就是V：View，View负责显示逻辑，通过简单地替换一些变量，View最终输出的就是用户看到的HTML。
#MVC中的Model在哪？Model是用来传给View的，这样View在替换变量的时候，就可以从Model中取出相应的数据。
#上面的例子中，Model就是一个dict：
#{ 'name': 'Michael' }

from flask import Flask
from flask import jsonify 
from flask.templating import render_template

app2 = Flask(__name__)

#首页Controler
@app2.route('/<name>', methods=['GET', 'POST'])
def home(name):
    #return '<h1>Home</h1>'
    #print("name=", name)
    return render_template("home.html", name=name, page_list=[1,2,3,4,5]) #变量从url赋值，或者直接赋值
    # 模板文件放在 templates文件夹下，否则会报错


#page页Controler
@app2.route('/page/<page_number>')
def page(page_number):
    #从数据库获取内容，并输出给变量text
    text="text from mysql of "+page_number
    return render_template("page.html", body=text, page_number=page_number)


#json Controler
@app2.route('/api/content/<date>')
def content(date):
    status=True
    
    #从Mysql获取当天数据
    content="some content from Mysql-"+date
    
    if content=="":
        status=False;
    #返回json
    return jsonify({'status':status,'date':date, 'content':content})


#启动程序
if __name__ == '__main__':
    print("==> pls browse http://127.0.0.1:5000/Jimmy")
    app2.run()

#浏览器请求 GET /Jimmy