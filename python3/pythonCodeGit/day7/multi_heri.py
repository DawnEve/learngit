﻿class Animal(object):
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
#	定义功能
#################################
#能跑
class Runnable(object):
    def run(self):
        print('Running...')
#能飞
class Flyable(object):
    def fly(self):
        print('Flying...')
		
class Dog(Mammal, Runnable):
    pass


# 各种动物:
class Dog(Mammal, Runnable):
	def __init__(self):
		print('Dog');

class Bat(Mammal):
	def __init__(self):
		print('Bat');

class Parrot(Bird):
	def __init__(self):
		print('Parrot');

class Ostrich(Bird):
    pass

a=Dog();

#由于Python允许使用多重继承，因此，MixIn就是一种常见的设计。
#只允许单一继承的语言（如Java）不能使用MixIn的设计。