# types.MethodType() 给运行中的类添加方法

import types 

# 定义一个函数，输入是一个对象
def getGrade(obj):
    if obj.score>90:
        return "A";
    if obj.score>80:
        return "B";
    else:
        return "C"

# 定义一个类
class Student():
    def __init__(self, score):
        self.score=score;

# 给实例添加一个方法
def test(score):
    s1=Student(score)
    s1.getGrade2=types.MethodType(getGrade, s1)
    print(score, s1.getGrade2() )

test(100)
test(85)
test(75)