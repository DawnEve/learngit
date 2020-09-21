# 实例调用方法一般是： instance.method()的形式。
# 能不能实例直接调用呢？可以。只需要定义__call__方法，就可以直接 instance() 调用该方法。

class Student(object):
    def __init__(self, name):
        self.name = name
	
	#任何类，只需要定义一个__call__()方法，就可以直接对实例进行调用。请看示例：
    def __call__(self):
        print('My name is %s.' % self.name)
		
s=Student('Jim');
s();
#__call__()还可以定义参数。
#对实例进行直接调用就好比对一个函数进行调用一样，所以你完全可以把对象看成函数，把函数看成对象，因为这两者之间本来就没啥根本的区别。

#如果你把对象看成函数，那么函数本身其实也可以在运行期动态创建出来，因为类的实例都是运行期创建出来的，这么一来，我们就模糊了对象和函数的界限。

#那么，怎么判断一个变量是对象还是函数呢？
#其实，更多的时候，我们需要判断一个对象是否能被调用，能被调用的对象就是一个Callable对象，比如函数和我们上面定义的带有__call__()的类实例：

print( callable(Student))#True
print( callable(max))#True
print( callable('sth'))#False
