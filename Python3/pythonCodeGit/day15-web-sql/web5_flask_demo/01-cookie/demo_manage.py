from flask import Flask, session,jsonify,make_response,request
import os

app=Flask(__name__)
#app.config['SECRET_KEY']='123456' ## 一串随机字符串作为session的加密盐值
app.config['SECRET_KEY']='1'
app.config['PERMANENT_SESSION_LIFETIME']=20 #20s有效期 10天有效期，可以设置 10*24*365

#操作session方法与操作字典相同

@app.route('/')
def index():
    #设置是否永久有效（必须放在请求上下文中），默认False，浏览器关闭失效
    #设置为True，有效期由 app.config['PERMANENT_SESSION_LIFETIME']决定
    #app.config[PERMANENT_SESSION_LIFETIME]默认为31天
    session.permanent=True
    session['username']='Jim'
    session['psw']='123456'

    #for cookie:
    res=make_response('hello, session test ~ cookie 已设置')
    #设置cookie，顺便指定有效期，默认为none，浏览器关闭就失效
    #max_age: 一个整数，单位为s，即多少秒后过期
    # expires: datetime类型，即指定日期后过期
    res.set_cookie('name','I am another cookie002', max_age=30)
    res.set_cookie('book','js the good part', max_age=30)

    return res
#
# 读取session
@app.route('/get')
def get():
    #session['username']    # 方法一，如果内容不存在，将会报异常
    username=session.get('username','')     # 方法二，如果内容不存在，将返回None。推荐使用
    #return session.get('username','no session username')

    #for cookie:
    cookie=request.cookies.get('name','no cookie00_')
    book=request.cookies.get('book','no book')

    return jsonify({
        'session':[username,session.get('psw', 'nothing') ], 
        'cookie':[cookie,book]
    })
#
#删除 session
@app.route('/delete/')
def delete():
    session.pop('username') #字典pop方法删除session指定键
    #session.clear() #删除session所有值

    #for cookie 
    res=make_response('deleted!')
    res.delete_cookie('book')

    return res


#启动后端程序
if __name__ == '__main__':
    app.run(debug=True, port=10001) 
#
# http://127.0.0.1:10001/  #设置session
# http://127.0.0.1:10001/get 超过20s不访问，pawsession就会失败。
#   - 一直刷新，30s后cookie就自动到期销毁了 
# 