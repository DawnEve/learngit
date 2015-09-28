﻿#可以使用形如__xx__的属性，自定义类
#定义学生类
class Student():
	def __init__(self, name):
		self.name=name
	def __str__(self):
		return self.name 
	def getName(self):
		return self.name 
		
#定义班级类
class Classes():
	students=[];
	def __init__(self, name):
		self.name=name #班级名字
	def add(self,student):
		self.students.append(student);
	def __len__(self):#可以使用len(classes)函数
		return len(self.students);
	def __str__(self): #用于直接打印对象print(c)
		str=''
		for s in self.students:
			#pass
			n=s.getName()
			str=str+n+', '
		return self.name+'班 学生:' + str[0:-2];#去除最后的空格

# 直接显示变量调用的不是__str__()，而是__repr__()，
# 两者的区别是__str__()返回用户看到的字符串，
# 而__repr__()返回程序开发者看到的字符串，
# 也就是说，__repr__()是为调试服务的。
		
s=Student('Jim');
s2=Student('Tom');
s3=Student('LiLei');
print(s)

c=Classes('3(7)');
print(c)
c.add(s)
c.add(s2)
c.add(s3)
print(c)
print(len(c))

