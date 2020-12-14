#获取对象类型: type()
def p(*s):
	print(s)

class Animal():
	name="旺财"
	pass

a=Animal();
L=[1,2,3]
T=(1,2,3)

p('1>', type(123) ) #<class 'int'>
p( type('str') ) #<class 'str'>
p( type(None) ) #<class 'NoneType'>
p( type(abs) ) #<class 'builtin_function_or_method'>
p( type(p) ) #自定义函数<class 'function'>
p('2>', type(True) ) #<class 'bool'>
p( type(a) ) #<class '__main__.Animal'>
p( type(Animal) ) #<class 'type'>
p( type(L) ) #<class 'list'>
p( type(T) ) #<class 'tuple'>

#判断类型是否相等
p('3>', type(123)==type(456) ) #True


b=isinstance([1, 2, 3], (list, tuple));
p('4>', b)#True


#判断是否是函数？
import types
b=(type(p)==types.FunctionType); p(b) #<class 'type'>



print('5>', dir("") ) #获取所有方法


print('6>', dir(a) )
print(Animal.__dict__)
print(a.__dict__)
print(hasattr(a, 'name')) #实例自己的__dict__找不到，就找类的


#一个正确的用法的例子如下：
def readImage(fp):
    if hasattr(fp, 'read'):
        return readData(fp)
    return None
print('hasattr(obj, attr) :', readImage(""))
