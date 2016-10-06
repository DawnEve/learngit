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

d=dict(name='Jim',age=12,country='中国')
print(d)

ds=json.dumps(d)
print(ds)

class Student(object):
    def __init__(self, name, age, country):
        self.name = name
        self.age = age
        self.country = country
        
s=Student("Tim",15,'美国')
print(s)

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
print('s的类型：',type(s)) #<class '__main__.Student'>
ss=json.dumps(s, default=stu2dict) #序列化
print(ss)
print('ss的类型：',type(ss)) #<class 'str'>


#反序列化对象
s2=json.loads(ss, object_hook=dict2stu) #反序列化
print('反序列化对象:',s2)
print(type(s2)) # <class '__main__.Student'>
    
