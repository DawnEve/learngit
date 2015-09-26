#获取对象类型: type()
def p(s):
	print(s)

class Animal():
	pass

a=Animal();
L=[1,2,3]
T=(1,2,3)

p( type(123) ) #<class 'int'>
p( type('str') ) #<class 'str'>
p( type(None) ) #<class 'NoneType'>
p( type(abs) ) #<class 'builtin_function_or_method'>
p( type(p) ) #自定义函数<class 'function'>
p( type(True) ) #<class 'bool'>
p( type(a) ) #<class '__main__.Animal'>
p( type(Animal) ) #<class 'type'>
p( type(L) ) #<class 'list'>
p( type(T) ) #<class 'tuple'>

#判断类型是否相等
p( type(123)==type(456) ) #True


b=isinstance([1, 2, 3], (list, tuple));p(b)#True


#判断是否是函数？
import types
b=(type(p)==types.FunctionTypep); p(b) #<class 'type'>



dir(obj) #获取所有方法



#一个正确的用法的例子如下：
def readImage(fp):
    if hasattr(fp, 'read'):
        return readData(fp)
    return None

