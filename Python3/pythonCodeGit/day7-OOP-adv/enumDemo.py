# 枚举类 # https://www.liaoxuefeng.com/wiki/1016959663602400/1017595944503424
# 枚举的好处： 确保变量合法，便于维护，提高可读性。
# 故该使用枚举类型的场合请使用枚举类型，不要使用无意义的字符表示一些有具体意义的类别

from enum import Enum
MyMonth = Enum('Month', ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 
                       'Aug', 'Sep', 'Oct', 'Nov', 'Dec'] )

print(MyMonth) #<enum 'Month'>
print(MyMonth.Jan) #Month.Jan
print(MyMonth(1)) #Month.Jan 从1开始计数
print(MyMonth['Jan'])



print('=='*10,'part1')
from enum import Enum
Month = Enum('Month', ('Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 
                       'Aug', 'Sep', 'Oct', 'Nov', 'Dec'))

for name, member in Month.__members__.items():
    print(name, '=>', member, ',', member.value)
    #value属性则是自动赋给成员的int常量，默认从1开始计数。
#
# Jan => Month.Jan , 1
# Feb => Month.Feb , 2
# Mar => Month.Mar , 3


print('=='*10,'part2')
#如果需要更精确地控制枚举类型，可以从Enum派生出自定义类：
from enum import Enum, unique
@unique
class Weekday(Enum):
    Sun = 0 # Sun的value被设定为0
    Mon = 1
    Tue = 2
    Wed = 3
    Thu = 4
    Fri = 5
    Sat = 6
# 访问方式
print("1> ", Weekday.Mon) #Weekday.Mon
print("2> ", Weekday['Tue']) #Weekday.Tue
print("3> ", Weekday.Mon.value) #1
print("4> ", Weekday(4)) #Weekday.Thu
# 可见，既可以用成员名称引用枚举常量，又可以直接根据value的值获得枚举常量。

print()
day1=Weekday.Mon
print(day1)
print(day1 == Weekday.Mon)
print(day1 == Weekday.Tue)



print('=='*10,'part3')
# 把Student的gender属性改造为枚举类型，可以避免使用字符串：
class Gender(Enum):
    Male = 0
    Female = 1

class Student(object):
    def __init__(self, name, gender):
        self.name = name
        self.gender = gender
# 测试:
bart = Student('Bart', Gender.Male)
print('>> ', bart.gender, Gender.Male)
if bart.gender == Gender.Male:
    print('测试通过!')
else:
    print('测试失败!')
