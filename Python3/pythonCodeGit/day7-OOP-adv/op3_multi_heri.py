class Animal(object):
	def __init__(self):
		print('Animal');

# 大类:
class Mammal(Animal):
	def __init__(self):
		print('Mammal');

class Bird(Animal):
	def __init__(self):
		print('Bird');

#################################
#	定义2功能
#################################
#能跑
class Runnable(object):
    def run(self):
        print('Running...')
#能飞
class Flyable(object):
    def fly(self):
        print('Flying...')
	
#################################
# 各种动物:
#################################
class Dog(Mammal, Runnable):
	def __init__(self):
		print('Dog');
	def eat(self):
		print('Dog likes eating bones')

class Bat(Mammal,Flyable):
	def __init__(self):
		print('Bat');

class Parrot(Bird,Flyable):
	def __init__(self):
		print('Parrot');

class Ostrich(Bird,Runnable):
	def __init__(self):
		print('鸵鸟');
#################################
o=Ostrich();
o.run() #Running...
print(isinstance(o, Bird)) #True
print(isinstance(o, Flyable)) #False

#由于Python允许使用多重继承，因此，MixIn就是一种常见的设计。
#只允许单一继承的语言（如Java）不能使用MixIn的设计。


## MRO是一个元祖，记录继承顺序。
print('\n',Dog.__mro__)

# super(Type, CurrentClass)返回CurrentClass的MRO中Type的下一个类的代理
class SmallDog(Dog):
	def bar(self):
		super(SmallDog, self).ww()
		
sd=SmallDog() #
sd.eat() #Dog likes eating bones