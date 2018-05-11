#私有方法:加上双下划綫的方法。只能在类内部使用。

class Dog(object):
    def __init__(self,name):
        self.name=name
    def __foo(self):
        print("private method __foo()")
        
    def say(self):
        print("dog.say()")
        self.__foo()

dog=Dog('Wangcai')
print("dict:", dog.__dict__)
dog.say()
#dog.__foo() #'Dog' object has no attribute '__foo'c