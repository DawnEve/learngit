# Singleton
# https://www.cnblogs.com/huchong/p/8244279.html

class Player(object):
    # 定义类属性记录单例对象引用
    instance = None
    
    def __new__(self, *args, **kwargs):
        # 1. 判断类属性是否已经被赋值
        if self.instance is None:
            #self.instance =Player() #报错  
            #RecursionError: maximum recursion depth exceeded while calling a Python object
            
            self.instance = super().__new__(self) #看不懂？ //todo
        
        # 2. 返回类属性的单例引用
        return self.instance
    
    def silence(self):
        print("Do you want to silence?")

p1=Player()
p2=Player()
print(p1)
print(p2)

p1.silence()