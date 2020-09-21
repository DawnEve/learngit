# 描述符
# 描述符本质就是一个新式类（Python3都是新式类）,在这个新式类中,至少实现了
# __get__(),__set__(),__delete__()中的一个。其作用是用来代理另外一个类的类属性

#描述符Str
class Str:
    def __get__(self, instance, owner):
        print('Str调用')
    def __set__(self, instance, value):
        print('Str设置...')
    def __delete__(self, instance):
        print('Str删除...')
 
#描述符Int
class Int:
    def __get__(self, instance, owner):
        print('Int调用')
    def __set__(self, instance, value):
        print('Int设置...')
    def __delete__(self, instance):
        print('Int删除...')
 
class People:
    name=Str()
    age=Int()
    def __init__(self,name,age): #name被Str类代理,age被Int类代理,
        self.name=name
        self.age=age
        self.value=age
 
 
p1=People('alex',18)
#Str设置...
# Int设置...
print(p1.__dict__) # {}
print(People.name) # Str调用，自动触发描述符__get__ 方法
print(People.__dict__)
# 'name': <__main__.Str object at 0x000001CC5EAD2208>, 'age': <__main__.Int object at 0x000001CC5EAD2240>

