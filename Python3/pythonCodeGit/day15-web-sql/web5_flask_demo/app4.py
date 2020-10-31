# 导入blueprints
# 蓝图就是把一部分功能打包成一个python包。
# * 特别适合重复使用的模块，比如用户、权限等的打包。
# * 或者同一个系统内，使用两种不同的url策略。这样不同的url，加载同一个蓝图，节省了一个模块的开发。

from flask import Flask
from flask import request

#Flask通过Python的装饰器在内部自动地把URL和函数给关联起来
#装饰器见day4

app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
def home():
    return '<h1>Home4: blueprint</h1>'

#
# 导入蓝图。具体实现（控制器、模板等文件）可以在其他文件夹中。
from blueprints import maintain

#2选1，url_prefix 是可选参数，默认是空
app.register_blueprint(maintain.bp) #访问： xx:5000/ping
app.register_blueprint(maintain.bp, url_prefix="/maintain") #访问： xx:5000/maintain/ping

app.logger.info('Load blueprints/maintain')


if __name__ == '__main__':
    app.run(debug=True)