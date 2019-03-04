from flask import Flask,request
from flask import jsonify
from flask.templating import render_template

app = Flask(__name__)

#首页Controler
@app.route('/', methods=['GET'])
def home():
    return render_template("jQ_index.html");


#计算并返回
@app.route('/add', methods=['GET'])
def add_numbers():
    a=request.args.get('a',0,type=int) #获取表单参数
    b=request.args.get('b',0,type=int)
    return jsonify({'result': a+b});


#run app
if __name__ == '__main__':
    print("==> pls browse http://10.21.127.192:5000/")
    app.run(host="0.0.0.0", debug=True)