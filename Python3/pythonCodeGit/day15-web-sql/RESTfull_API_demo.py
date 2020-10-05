from flask import Flask,request,jsonify

#http://www.pythondoc.com/flask-restful/first.html
# HTTP methods like GET, POST, PUT, DELETE.

app = Flask(__name__)

tasks = [
    {
        'id': 1,
        'title': u'Buy groceries',
        'description': u'Milk, Cheese, Pizza, Fruit, Tylenol',
        'done': False
    },
    {
        'id': 2,
        'title': u'Learn Python',
        'description': u'Need to find a good Python tutorial on the web',
        'done': False
    }
]

@app.route('/todo/api/v1.0/tasks', methods=['GET'])
def get_tasks():
    return jsonify({'tasks': tasks})

#通过执行 app.py，启动 web service。

#1. 浏览器查看
# http://127.0.0.1:5000/todo/api/v1.0/tasks

#2. 打开一个新的控制台窗口，运行以下命令:
# curl -i http://localhost:5000/todo/api/v1.0/tasks
# 使用curl能更灵活的使用4个请求方法
#  一个 GET 请求表示客户端获取一个用户的信息。
#  一个 POST 请求表示客户端新增一个用户信息。
#  一个 PUT 请求表示更新用户信息，比如可能是更新邮箱地址。
#  一个 DELETE 请求表示删除用户账号。




##############
# 使用get方法
##############
from flask import abort

@app.route('/todo/api/v1.0/tasks/<int:task_id>', methods=['GET'])
def get_task(task_id):
    task0 = filter(lambda t: t['id'] == task_id, tasks)
    task = list(task0)
    if len(task) == 0:
        abort(404) #报错不是jason格式的，不理想
    return jsonify({'task': task[0]}) #用 jsonify 打包成 JSON 格式并将其发送作为响应
# http://localhost:5000/todo/api/v1.0/tasks/2
# curl -i http://localhost:5000/todo/api/v1.0/tasks/2



##############
# json格式的报错
##############
from flask import make_response

@app.errorhandler(404)
def not_found(error):
    return make_response(jsonify({'error': 'Not found'}), 404)
#




##############
# post方式
##############
from flask import request

@app.route('/todo/api/v1.0/tasks', methods=['POST'])
def create_task():
    if not request.json or not 'title' in request.json:
        abort(400)
    task = {
        'id': tasks[-1]['id'] + 1,
        'title': request.json['title'],
        'description': request.json.get('description', ""),
        'done': False
    }
    tasks.append(task)
    return jsonify({'task': task}), 201
#使用如下的 curl 命令来测试这个新的函数:
# $ curl -i -H "Content-Type: application/json" -X POST -d '{"title":"Read a book"}' http://localhost:5000/todo/api/v1.0/tasks
# 查看效果
# curl -i http://localhost:5000/todo/api/v1.0/tasks





##############
# put 方式
##############
@app.route('/todo/api/v1.0/tasks/<int:task_id>', methods=['PUT'])
def update_task(task_id):
    task0 = filter(lambda t: t['id'] == task_id, tasks)
    task=list(task0)
    if len(task) == 0:
        abort(404)
    if not request.json:
        abort(400)
    if 'title' in request.json and type(request.json['title']) != unicode:
        abort(400)
    if 'description' in request.json and type(request.json['description']) is not unicode:
        abort(400)
    if 'done' in request.json and type(request.json['done']) is not bool:
        abort(400)
    task[0]['title'] = request.json.get('title', task[0]['title'])
    task[0]['description'] = request.json.get('description', task[0]['description'])
    task[0]['done'] = request.json.get('done', task[0]['done'])
    return jsonify({'task': task[0]})
#
# curl -i -H "Content-Type: application/json" -X PUT -d '{"done":true}' http://localhost:5000/todo/api/v1.0/tasks/2
# 查看效果
# curl -i http://localhost:5000/todo/api/v1.0/tasks







##############
# delete 方式
##############
@app.route('/todo/api/v1.0/tasks/<int:task_id>', methods=['DELETE'])
def delete_task(task_id):
    task0 = filter(lambda t: t['id'] == task_id, tasks)
    task=list(task0)
    if len(task) == 0:
        abort(404)
    tasks.remove(task[0])
    return jsonify({'result': True})
# 删除一条
# curl -i -H "Content-Type: application/json" -X DELETE http://localhost:5000/todo/api/v1.0/tasks/2
# 查看效果
# curl -i http://localhost:5000/todo/api/v1.0/tasks





##############
# 优化 web service 接口: 输出的id改为URI
##############

# 一个小的辅助函数生成一个 “公共” 版本任务发送到客户端:
from flask import url_for
def make_public_task(task):
    new_task = {}
    for field in task:
        if field == 'id':
            new_task['uri'] = url_for('get_task', task_id=task['id'], _external=True)
        else:
            new_task[field] = task[field]
    return new_task
# 我们将会把上述的方式应用到其它所有的函数上以确保客户端一直看到 URIs 而不是 ids。

@app.route('/todo/api/v2.0/tasks', methods=['GET'])
def get_tasks2():
    return jsonify({'tasks': list( map(make_public_task, tasks)) })
# curl -i http://localhost:5000/todo/api/v2.0/tasks






##############
# 加强 RESTful web service 的安全性
##############
# 确保我们的 web service 安全服务的最简单的方法是要求客户端提供一个用户名和密码。
# 在常规的 web 应用程序会提供一个登录的表单用来认证，并且服务器会创建一个会话为登录的用户以后的操作使用，
#  会话的 id 以 cookie 形式存储在客户端浏览器中。

# 然而 REST 的规则之一就是 “无状态”， 因此我们必须要求客户端在每一次请求中提供认证的信息。

# HTTP 协议提供了两种认证机制: Basic 和 Digest。
# $ flask/bin/pip install flask-httpauth

#from flask.ext.httpauth import HTTPBasicAuth
#error: https://blog.csdn.net/i_spirit/article/details/94642832
#出现该问题主要原因是新版的flask抛弃了flask.ext这种引入扩展的方法，更改为 flask_扩展名
#例如：
#以前：from flask.ext.script import Manager
#现在：from flask_script import Manager
from flask_httpauth import HTTPBasicAuth

auth = HTTPBasicAuth()


#get_password 函数是一个回调函数，Flask-HTTPAuth 使用它来获取给定用户的密码。
#在一个更复杂的系统中，这个函数是需要检查一个用户数据库，但是在我们的例子中只有单一的用户因此没有必要。
@auth.get_password
def get_password(username):
    if username == 'lang':
        return 'python'
    return None
#error_handler 回调函数是用于给客户端发送未授权错误代码。像我们处理其它的错误代码，
#这里我们定制一个包含 JSON 数据格式而不是 HTML 的响应。
@auth.error_handler
def unauthorized():
    #return make_response(jsonify({'error': 'Unauthorized access'}), 401)
    #让人不舒服的是当请求收到一个 401 的错误，网页浏览都会跳出一个丑陋的登录框
    return make_response(jsonify({'error': 'Unauthorized access'}), 403)


# 随着认证系统的建立，所剩下的就是把需要认证的函数添加 @auth.login_required 装饰器
@app.route('/todo/api/v3.0/tasks', methods=['GET'])
@auth.login_required
def get_tasks3():
    return jsonify({'tasks': tasks})
# http://localhost:5000/todo/api/v3.0/tasks
# 未授权  curl -i http://localhost:5000/todo/api/v3.0/tasks
# 授权后  curl -u lang:python -i http://localhost:5000/todo/api/v3.0/tasks

# 认证扩展给予我们很大的自由选择哪些函数需要保护，哪些函数需要公开。






##############
# 可能的改进
##############
#一个真正的 web service 需要一个真实的数据库进行支撑。我们现在使用的内存数据结构会有很多限制不应该被用于真正的应用。

#另外一个可以提高的领域就是处理多用户。如果系统支持多用户的话，不同的客户端可以发送不同的认证凭证获取相应用户的任务列表。








if __name__ == '__main__':
    app.run(debug=True)