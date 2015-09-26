#基类
class Animal(object):
    def run(self):
        print('Animal is running...')
    def eat(self):
        print('Animal is eating...')
		
#子类继承是通过类后的括号实现的。
class Dog(Animal):
	#子类的run()覆盖了父类的run()，
    def run(self):
        print('Dog is running...')

    def eat(self):
        print('Eating meat...')

#子类定义
class Cat(Animal):
    pass

#定义一个函数：
def run_twice(animal):
    animal.run()
    animal.run()

#这就是著名的“开闭”原则：
#对扩展开放：允许新增Animal子类；
#对修改封闭：不需要修改依赖Animal类型的run_twice()等函数。	

dog=Dog();
dog.run()
print('dog<Dog>:', isinstance(dog, Dog) )
print('dog<Animal>:', isinstance(dog, Animal) )
print('dog<Cat>:', isinstance(dog, Cat) )

#使用函数
print()
run_twice(Animal())
run_twice(dog)


#对于静态语言（例如Java）来说，如果需要传入Animal类型，则传入的对象必须是Animal类型或者它的子类，否则，将无法调用run()方法。

#对于Python这样的动态语言来说，则不一定需要传入Animal类型。我们只需要保证传入的对象有一个run()方法就可以了.
#比如钟表的run()方法
class Watch():
	def run(self):
		print('The watch is ticking!');
w=Watch();
print()
run_twice(w)

#这就是动态语言的“鸭子类型”，它并不要求严格的继承体系，一个对象只要“看起来像鸭子，走起路来像鸭子”，那它就可以被看做是鸭子。