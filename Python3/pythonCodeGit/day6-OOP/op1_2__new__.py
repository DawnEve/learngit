class Book():
    def __init__(self, name):
        print('  2> self=',self)
        print("  2> This is init()")
        self.name=name
    def __new__(cls2, name): #参数个数要和init一致，即便函数内部用不到该参数。
        print(' 1> id(cls)=',id(cls2))
        print(" 1> This is new()")
        
        ret=object.__new__(cls2)
        print(" 1> ", ret)
        return ret; #这个obj就是init中的参数self
    

print('0> id(A)  = ', id(Book))

book=Book('Learn Python3')

"""
1. __new__至少要有一个参数cls，代表要实例化的类，此参数在实例化时由Python解释器自动提供
2.__new__必须要有返回值，返回实例化出来的实例，这点在自己实现__new__时要特别注意，
    可以return父类__new__出来的实例，
    或者直接是object的__new__出来的实例
3. __init__有一个参数self，就是这个__new__返回的实例，__init__在__new__的基础上
    可以完成一些其它初始化的动作，__init__不需要返回值
4. 我们可以将类比作制造商，__new__方法就是前期的原材料购买环节，__init__方法就是在有原材料的基础上，加工，初始化商品环节
"""
