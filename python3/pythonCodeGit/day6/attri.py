
class Student(object):
	name='Stu';
	score=0;
	def __init__(self, name):
		self.name = name

s = Student('Bob')
s2 = Student('Jim')
s.score = 90
print( dir(s) );
print('实例属性删除前：',s.score)
del s.score
print('实例属性删除后：',s.score)

#类属性被其实例共享
Student.num=100;
print(s.num)
print(s2.num)

#相同名称的实例属性将屏蔽掉类属性，但是当你删除实例属性后，再使用相同的名称，访问到的将是类属性。