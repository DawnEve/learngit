#继承：
    #1.子类缺省构造函数时，直接执行父类构造函数；
    #  (1)子类有__init__时,基类的构造方法不会自动调用，需要时要在子类构造函数中专门调用
    #2.调用基类方法时要加上基类的类名前缀，并带上self参数。
    #  (1)而调用自身方法不需要加self参数。
    #  (2)子类不能调用父类的私有方法: Father.__fn(self)找不到。
    #3.在子类中找不到对应方法，才到基类中逐个查找。
    #4. py的继承是不严格的。“鸭子类型”。isinstance(dog, Dog) )
#多态
    #1. 


#基类
class Animal(object):
    def __init__(self):#1. 子类缺省构造函数时，直接执行父类构造函数。
        print("==============Animal init.==============")
    #类中定义的方法，第一个参数必须是self。其他和普通函数一致。
    def run(self):
        print('Animal is running...')
    def eat(self):
        print('Animal is eating...')
        #self.__private_eat(); #调用自身方法不需要加self参数。
    def __private_eat(self):
        print('Animal is __private_eat ing.')

#子类继承是通过类后的括号实现的。
class Dog(Animal):
	#子类的run()覆盖了父类的run()，
    def run(self):
        print('Dog is running...')

    def eat(self):
        print('Eating meat...')

#子类定义
class Cat(Animal):
    def __init__(self):
        print("Cat init.===")
    def run(self):
        print('Cat is running...')
#孙子类
class SmallCat(Cat):
    def __init__(self):
        Cat.__init__(self);#1(1). 子类有__init__时,基类的构造方法不会自动调用，需要时要在子类构造函数中专门调用
        print("SmallCat init.===")
    def animalEat(self):
        print("==small cat eat: ")
        Animal.eat(self);
        #Animal.__private_eat(self);#type object 'Animal' has no attribute '_SmallCat__private_eat'
        Animal._Animal__private_eat(self) # py OOP不严格，非要调用也行，不过不规范
################################
# 类定义结束
################################
dog=Dog(); dog.run();
print('dog<Dog>:', isinstance(dog, Dog) )
print('dog<Animal>:', isinstance(dog, Animal) )
print('dog<Cat>:', isinstance(dog, Cat) )
smallCat=SmallCat();print('smallCat<Animal>:', isinstance(smallCat, Animal) )


#定义一个函数：
def run_twice(animal):
    animal.run()
    animal.run()
#使用函数
print()
run_twice(Animal())
run_twice(dog)
run_twice(smallCat) #自动识别当前类的run方法，新增Animal子类不用对run_twice函数做修改就可使用，这就是多态。
#这就是著名的“开闭”原则：
#对扩展开放：允许新增Animal子类；
#对修改封闭：不需要修改依赖Animal类型的run_twice()等函数。    



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


print()
sc=SmallCat()
sc.animalEat()

print("\n找到私有方法的名字，'_Animal__private_eat':", "并调用")
print(Animal.__dict__) 
sc._Animal__private_eat()
