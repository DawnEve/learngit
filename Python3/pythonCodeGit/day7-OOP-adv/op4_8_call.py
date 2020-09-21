class Meta(type):
    #2. 生成类对象
    def __new__(cls, name, bases, dct):
        print("calling Meta's __new__", cls)
        return type.__new__(cls, name, bases, dct)
    #4.类对象调用触发元类的__call__ 方法
    def __call__(cls, *args, **kwargs):
        print("calling Meta's __call__", cls)
        #5.类对象，从自己的对象角度看也是一个类，可以直接调用自己的静态方法 __new__ 生成自己对象
        i = cls.__new__(cls)
        #6.类对象生成的对象初始化
        i.__init__(*args, **kwargs)
        return i
 
class A(metaclass=Meta): # 1. 类对象的创建使用 元类的__new__
    def __new__(cls, *args, **kwargs):
        print("calling A's __new__")
        return object.__new__(cls)
 
    def __init__(self, *args, **kwargs):
        print("calling A's __init__")
#3.类对象调用 
a=A()
# calling Meta's __new__ <class '__main__.Meta'>
# calling Meta's __call__ <class '__main__.A'>
# calling A's __new__
# calling A's __init__
print('\n',type(a))
print(A.__dict__)
