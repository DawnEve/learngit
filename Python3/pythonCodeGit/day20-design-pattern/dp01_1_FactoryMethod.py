# 工厂方法 模式，比 简单工厂 模式 更符合“开-闭”原则。

#1. 抽象工厂类
class Factory(object):
    def getProduct(self): #必须要有某个方法
        return Product()

#2. 抽象产品类
class Product(object):
    pass

#3. 具体产品
class ProductA(Product):
    def say(self):
        print("Product A")

class ProductB(Product):
    def say(self):
        print("Product B")

#4. 具体工厂
class FactoryA(Factory):
    def getProduct(self):
        return ProductA()
class FactoryB(Factory):
    def getProduct(self):
        return ProductB()

def getProduct(factoryName):
     return factoryName().getProduct()
 
getProduct(FactoryA).say()
getProduct(FactoryB).say()
###########
#facA=FactoryA() #A工厂
#facA.getProduct().say() #A工厂生产产品A Product A
#FactoryB().getProduct().say() #Product A

##########
print("="*20)
# 新增产品3，需要2个类，产品3 和工厂3
class Product3(Product):
    def say(self):
        print("Product 3")
class Factory3(Factory):
    def getProduct(self):
        return Product3()
#Factory3().getProduct().say() #Product 3

getProduct(Factory3).say()
