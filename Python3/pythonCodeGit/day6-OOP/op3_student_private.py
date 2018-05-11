#双下划线表示的是private,私有属性和私有方法
#但是私有的不彻底
class Student(): 
    def __init__(self, name, score):
        self.name = name
        self.__score = score #变量前加__就表示访问控制
    def print_score(self):
        print('%s: %s' % (self.name, self.__score))
    def get_score(self):
        return self.__score
    def set_score(self, score):
        self.__score = score
        self.__priMethod()
    def __priMethod(self):
        print( '——0——This is private methond99999' )
    def priMethod(self):
        print( '1————This is PUBLIC methond99999' )


bart = Student('Bart Simpson', 59)
lisa = Student('Lisa Simpson', 87)

print(bart.name)
#print(bart.__score)
print(bart.get_score())
bart.set_score(100)

print('\n',bart.get_score())
print(lisa)
#lisa.__priMethod() 私有方法
lisa.priMethod()

#总的来说就是，Python本身没有任何机制阻止你干坏事，一切全靠自觉。
print("\n",bart.__dict__)#查看
bart._Student__score=200; #修改
print('干坏事: 修改和直接获取私有变量',bart._Student__score)