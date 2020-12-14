class Hello(object):
    def hello(self, name='world'):
        print('Hello, %s.' % name)


#=============================================
#过type()函数创建的类和直接写class是完全一样的
def fn(self, name='world'): # 先定义函数
    print('Hello, %s.' % name)

Hello2 = type('Hello', (object,), dict(hello=fn)) # 创建Hello class
# 要创建一个class对象，type()函数依次传入3个参数：
# 1. class的名称；
# 2. 继承的父类集合，注意Python支持多重继承，如果只有一个父类，别忘了tuple的单元素写法；
# 3. class的方法名称与函数绑定，这里我们把函数fn绑定到方法名hello上。

a=Hello()
b=Hello2();

print('1> ', type(Hello), type(Hello2)) #<class 'type'> 类本身都是type的实例？！
print("2> ", type(a), type(b))

# 对比成员组成
print(Hello.__dict__)
print(Hello2.__dict__)
#正常情况下，我们都用class Xxx...来定义类，但是，type()函数也允许我们动态创建出类来，也就是说，动态语言本身支持运行期动态创建类，

print('-'*20)
i=0
for k in Hello.__dict__:
    i+=1
    print('[%d]' % i, k, ":",Hello.__dict__[k], '|', Hello2.__dict__[k])