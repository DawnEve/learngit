# https://blog.csdn.net/cui_yonghua/article/details/90667226

# Director 指挥者
class Director(object):
    def __init__(self):
        self.builder = None

    def construct_building(self):
        self.builder.new_building()
        self.builder.build_floor()
        self.builder.build_size()

    def get_building(self):
        return self.builder.building


#构建一个使用Builder接口的对象。它主要是用于创建一个复杂的对象。
# 它主要有两个作用，一是：隔离了客户与对象的生产过程，二是：负责控制产品对象的生产过程。
# Abstract Builder
class Builder(object):
    def __init__(self):
        self.building = None

    def new_building(self):
        self.building = Building() #先创建产品，然后设置产品的属性
# Concrete Builder, 继承抽象类
class BuilderHouse(Builder):
    def build_floor(self):
        self.building.floor = 'One'

    def build_size(self):
        self.building.size = 'Big'

class BuilderFlat(Builder):
    def build_floor(self):
        self.building.floor = 'More than One'
        
    def build_size(self):
        self.building.size = 'Small'

# Product
class Building(object):
    def __init__(self):
        self.floor = None
        self.size = None

    def __repr__(self):
        return 'Floor: %s | Size: %s' % (self.floor, self.size)


# Client
if __name__ == "__main__":
    director = Director() #导演者，只负责调度
    
    # 具体的建造者1
    director.builder = BuilderHouse()
    director.construct_building()
    building = director.get_building()
    print(building)
    
    # 具体的建造者2
    director.builder = BuilderFlat()
    director.construct_building()
    building = director.get_building()
    print(building)

#################
# 新增 建造类: 继承 Builder的BuilderPlayground类
class BuilderPlayground(Builder):
    def build_floor(self):
        self.building.floor = 'One or two'
        
    def build_size(self):
        self.building.size = 'Very large'

print("="*20)       
director = Director()

director.builder = BuilderPlayground()
director.construct_building()
building = director.get_building()
print(building)
