from flask import Blueprint,session

sess=Blueprint('sess',__name__)

#设置
@sess.rout('/set/')
def set():
    #设置是否永久有效（必须放在请求上下文中），默认False，浏览器关闭失效
    #设置为True，有效期由 app.config['PERMANENT_SESSION_LIFETIME']决定
    #app.config[PERMANENT_SESSION_LIFETIME]默认为31天
    session.permanent=True
    session['name']='who are you'
    return "session was set"

#获取session
@sess.route('/get/')
def get():
    return session.get('name','who are you?(default)')

#删除
@sess.route("/del/")
def delete():
    #删除指定的session，第二个参数设置为None，即使删除不存在的键也不报错
    #session.pop('name',None)
    #清空所有的session
    session.clear()
    return "session is deleted"
