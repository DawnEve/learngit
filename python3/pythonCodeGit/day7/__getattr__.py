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
        raise AttributeError('\'Student\' object has no attribute \'%s\'' % attr)
			
s=Student()
print( s.name )
print( s.score )
print( s.age() ) #只是调用方式要变为：
#print( s.sex )