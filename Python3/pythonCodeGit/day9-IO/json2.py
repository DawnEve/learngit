"""
JSON表示的对象就是标准的JavaScript语言的对象，JSON和Python内置的数据类型对应如下：

JSON类型    Python类型
{}    dict
[]    list
"string"    str
1234.56    int或float
true/false    True/False
null    None
"""
import json
#json.dumps() #对数据进行编码
#json.loads() #对数据进行 解 码
#处理文件，则不要s： json.dump(data,f); json.load(f)

#d=dict(name='Jim',age=12,country='中国')
d={'name':"jim", 'age':12, 'country':'中国'} #定义方式和json类似，但是key必须加引号
print('d=', d)

#序列化字典
ds=json.dumps(d)
print('ds=', ds)


#定义类
class Student(object):
    def __init__(self, name, age, country):
        self.name = name
        self.age = age
        self.country = country
s=Student("Tim",15,'美国')
print('s=', s)

def stu2dict(s):
    return {
        "name":s.name,
        "age":s.age,
        "country":s.country,
    }
def dict2stu(d):
    #return Student(d.name,d.age,d.country) #python中的dict不能像js中的json这样用
    return Student(d['name'], d['age'], d['country'])

#序列化对象
# ss=json.dumps(s) #报错 Student object at 0x009AC950> is not JSON serializable
# ss=json.dumps(s, default=lambda obj:obj.__dict__)
print('\ns的类型：',type(s)) #<class '__main__.Student'>
ss=json.dumps(s, default=stu2dict) #序列化
print('ss=', ss)
print('ss的类型：',type(ss)) #<class 'str'>


#反序列化对象
s2=json.loads(ss, object_hook=dict2stu) #反序列化
print('\n反序列化对象:',s2)
print(type(s2)) # <class '__main__.Student'>
print('s2.country =', s2.country)



#
#读写文件
import os
os.chdir('c:/Tools/') #定义临时文件地点
print("\nbefore: ", d)
#写入
with open('json.txt','w') as f:
    json.dump(d,f) #dict按编码过的json写入文件
    #{"name": "jim", "age": 12, "country": "\u4e2d\u56fd"}

#读取
with open('json.txt','r') as f:
    data2=json.load(f)
print("after: ", data2)
