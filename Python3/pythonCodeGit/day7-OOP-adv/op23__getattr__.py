# 访问不存在的属性时，就会进入 __getattr__()，如果没有该方法则直接报错。

class Student(object):
    def __init__(self):
        self.name = 'Jim'

	#对于不存在的属性，使用如下定义
    def __getattr__(self, attr):
        if attr=='score':
            return 99
        elif attr=='age':
            return lambda: 25 #返回函数也是完全可以的：
        #要让class只响应特定的几个属性，我们就要按照约定，抛出AttributeError的错误：
        raise AttributeError('\'Student001\' object has no attribute \'%s\'' % attr)
        #也可以定义，找不到一律返回 None

s=Student()
print( s.name )
print('score=', s.score )
print('age()=', s.age() ) #只是调用方式要变为：
#print( s.sex )
#print('age()=', s.say() )



#有啥用？dict的子类，但是没法赋值？
class A(dict):
    name="lower-case-a"
    def __getattr__(self, name):
       return self[name]
a = A()
# Now a.somekey will give a['somekey']
print( a.name )
print(type(a))
