#数据封装、继承和多态只是面向对象程序设计中最基础的3个概念。在Python中，面向对象还有很多高级特性，允许我们写出非常强大的功能。

#我们会讨论多重继承、定制类、元类等概念。
#http://www.liaoxuefeng.com/wiki/0014316089557264a6b348958f449949df42a6d3a2e542c000/00143186739713011a09b63dcbd42cc87f907a778b3ac73000

class Student(object):
    pass
	
#实例
s = Student()

#给实例绑定一个属性：
s.name = 'Michael' # 动态给实例绑定一个属性
print(s.name)

#给实例绑定一个方法：
def set_age(self, age): # 定义一个函数作为实例方法
    self.age = age

from types import MethodType
s.set_age = MethodType(set_age, s) # 给实例绑定一个方法
s.set_age(25) # 调用实例方法
print(s.age) # 测试结果
#但是，给一个实例绑定的方法，对另一个实例是不起作用的：


#为了给所有实例都绑定方法，可以给class绑定方法：
def set_score(self, score):
    self.score = score

Student.set_score = MethodType(set_score, Student)
#给class绑定方法后，所有实例均可调用：

#通常情况下，上面的set_score方法可以直接定义在class中，但动态绑定允许我们在程序运行的过程中动态给class加上功能，这在静态语言中很难实现。

#如果我们想要限制实例的属性怎么办？比如，只允许对Student实例添加name和age属性。
class Student(object):
    __slots__ = ('name', 'age') # 用tuple定义允许绑定的属性名称

s = Student() # 创建新的实例
s.name = 'Michael' # 绑定属性'name'
s.age = 25 # 绑定属性'age'
s.score = 99 # 绑定属性'score'


#使用__slots__要注意，__slots__定义的属性仅对当前类实例起作用，对继承的子类是不起作用的：

#除非在子类中也定义__slots__，这样，子类实例允许定义的属性就是自身的__slots__加上父类的__slots__。