# py的构造函数是__init__方法。可以0或者多个参数。
# 如果有多个__init__方法，后面的覆盖前面的，只有最后一个作为构造方法。
# 其他的__init__方法也不能被调用。建议一个类只定义一个构造函数。

class Dog(object):
    name="Xiaoqiang"
    age=1;
    def __init__(self):
        print(self)
    def __init__(self,name,age):
        print(self, name,age)
    def __init__(self,name):
        self.name=name
        print(self, name)

#dog=Dog()
dog=Dog('Wangcai')
print(dog.name)
print(dog.age)
#dog.__init__("Wangcai2", 2)
