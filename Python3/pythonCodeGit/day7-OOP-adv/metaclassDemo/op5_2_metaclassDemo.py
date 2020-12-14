#metaclass
# metaclass是Python面向对象里最难理解，也是最难使用的魔术代码。
# 正常情况下，你不会碰到需要使用metaclass的情况，所以，以下内容看不懂也没关系，因为基本上你不会用到。

# metaclass是类的模板，所以必须从`type`类型派生：
class ListMetaclass(type):
    def __new__(cls, name, bases, attrs):
        attrs['add'] = lambda self, value: self.append(value)
        return type.__new__(cls, name, bases, attrs)
# __new__()方法接收到的参数依次是：
#     1.当前准备创建的类的对象；
#     2.类的名字；
#     3.类继承的父类集合；
#     4.类的方法集合。



# 有了ListMetaclass，我们在定义类的时候还要指示
# 使用ListMetaclass来定制类，传入关键字参数metaclass：
class MyList(list, metaclass=ListMetaclass):
    pass

# 测试一下MyList是否可以调用add()方法：
L = MyList()
L.add(1)
L.add(2)
print(L) #[1, 2]
#而普通的list没有add()方法

#==========================================
#动态修改有什么意义？直接在MyList定义中写上add()方法不是更简单吗？正常情况下，确实应该直接写，通过metaclass修改纯属变态。

#但是，总会遇到需要通过metaclass修改类定义的。ORM就是一个典型的例子。

#ORM全称“Object Relational Mapping”，即对象-关系映射，就是把关系数据库的一行映射为一个对象，
# 也就是一个类对应一个表，这样，写代码更简单，不用直接操作SQL语句。