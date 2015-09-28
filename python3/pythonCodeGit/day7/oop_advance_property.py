class Student(object):
    def get_score(self):
         return self._score

    def set_score(self, value):
        if not isinstance(value, int):
            raise ValueError('score must be an integer!')
        if value < 0 or value > 100:
            raise ValueError('score must between 0 ~ 100!')
        self._score = value
#这样不安全,可以任意赋值
#s=Student()
#s.score=990;#也不报错
#print(s.score)

s=Student()
s.set_score(91);
print(s._score)#ok
print(s.get_score())#ok


#Python内置的@property装饰器就是负责把一个方法变成属性调用的：
class Student(object):
    @property
    def score(self): #注意这里方法名已经更改为变量名
        return self._score

    @score.setter
    def score(self, value):#注意这里方法名已经更改为变量名
        if not isinstance(value, int):
            raise ValueError('score must be an integer!')
        if value < 0 or value > 100:
            raise ValueError('score must between 0 ~ 100!')
        self._score = value

s = Student()
s.score = 60
print(s.score)
#s.score = 600 #就会报错！带有过滤器
# 注意到这个神奇的@property，我们在对实例属性操作的时候，就知道该属性很可能不是直接暴露的，而是通过getter和setter方法来实现的


#还可以定义只读属性，只定义getter方法，不定义setter方法就是一个只读属性：

class Student4(object):
    @property
    def birth(self):
        return self._birth

    @birth.setter
    def birth(self, value):
        self._birth = value

    @property
    def age(self):
        return 2015 - self._birth
#上面的birth是可读写属性，而age就是一个只读属性，因为age可以根据birth和当前时间计算出来。

    
	# @property本身又创建了另一个装饰器@score.setter，
	# 负责把一个setter方法变成属性赋值
	# 我们就拥有一个可控的属性操作：