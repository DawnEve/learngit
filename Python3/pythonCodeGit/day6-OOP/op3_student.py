#定义类
#class Student(object): #不写(object),直接(),也没有异常
class Student(): #不写(object),直接(),也没有异常
    def __init__(self, name, score):
        self.name = name
        self.score = score
	#和普通的函数相比，在类中定义的函数只有一点不同，就是第一个参数永远是实例变量self，并且，调用时，不用传递该参数。
    def print_score(self):
        print('%s: %s' % (self.name, self.score))
    
    #添加新方法
    def get_grade(self):
        if self.score >= 90:
            return 'A'
        elif self.score >= 60:
            return 'B'
        else:
            return 'C'

#实例化对象： 实例（Instance）
#创建实例是通过类名+()实现的：
bart = Student('Bart Simpson', 59)
lisa = Student('Lisa Simpson', 87)

print(bart)
print(lisa)

#调用对象的方法
bart.print_score()
lisa.print_score()
#调用另一个方法
print( bart.get_grade() )
print( lisa.get_grade() )

#给类绑定对象
bart.age=25
print(bart.age)
#print(lisa.age)#没定义就没有值
