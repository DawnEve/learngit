from collections import namedtuple

#namedtuple是一个函数，它用来创建一个自定义的tuple对象，并且规定了tuple元素的个数，
#并可以用属性而不是索引来引用tuple的某个元素。

Point = namedtuple('Point', ['x', 'y'])
p = Point(1, 2)
print(p.x) #1
print(p.y) #2

#可以验证创建的Point对象是tuple的一种子类：
print(isinstance(p, Point)) #True
print(isinstance(p, tuple)) #True

print(type(p)) #<class '__main__.Point'>


#类似的，如果要用坐标和半径表示一个圆，也可以用namedtuple定义：
# namedtuple('名称', [属性list]):
Circle = namedtuple('Circle', ['x', 'y', 'r'])
c2=Circle(10,20,5) #<class '__main__.Circle'>
print(type(c2))

