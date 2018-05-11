# 类属性
class Student(object):
	name='Stu';
	score=10;

	#初始化调用的就是__init__函数
	def __init__(self, name):
		self.name = name

s = Student('Bob')
s2 = Student('Jim')
s.score = 90
s2.score=85

print( dir(s) );

print('实例属性删除前：',s.score,s2.score)
del s.score
print('实例属性删除后：',s.score,s2.score)
#相同名称的实例属性将屏蔽掉类属性，但是当你删除实例属性后，再使用相同的名称，访问到的将是类属性。

#类属性被其实例共享
Student.num=100;
print(s.num)
print(s2.num)


# 私有变量：如何使属性变得不可直接修改呢？
#属性名前面加俩个下划线 __name
class Teacher(object):
	def __init__(self,name,age):
		self.__name=name
		self.age=age
	def say(self):
		print('姓名：%s, age:%s' % (self.__name, self.age))

t=Teacher("Mr.Wang", 25)
t.say()
print('dict1: ',t.__dict__)
#修改属性
#print(t.__name) #'Teacher' object has no attribute '__name'
t.__name="XiaoZhang" #新增了一个属性，什么鬼？不是重名了吗？
t.age=30
print('dict2: ',t.__dict__)
t.say()
#如果我非要改呢？还是可以改的。所以说py的封装不彻底。
t._Teacher__name="XiaoZhang"
print('dict3: ',t.__dict__)
t.say()
