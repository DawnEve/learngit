#
from flask import Flask,Blueprint,request,make_response

app = Flask(__name__)

#创建实例
cookie=Blueprint('cookie', __name__)

#获取cookie
@cookie.route('/get/')
def get():
    return request.cookies.get('name','I am cookie001')

#设置cookie
@cookie.route('/set/')
def set():
    res=make_response('cookie 已设置')
    #设置cookie，顺便指定有效期，默认为none，浏览器关闭就失效
    #max_age: 一个整数，单位为s，即多少秒后过期
    # expires: datetime类型，即指定日期后过期
    res.set_cookie('name','I am another cookie002', max_age=30)
    return res

#删除cookie
@cookie.route('/del/')
def delete():
    res=make_response('cookie 已删除')
    res.delete_cookie('name')
    return res

#
#启动后端程序
if __name__ == '__main__':
    app.run(debug=True, port=10001) 