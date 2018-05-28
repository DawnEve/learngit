class Hello(object):
    def hello(self, name='world'):
        print('Hello, %s.' % name)

		
#=============================================
#过type()函数创建的类和直接写class是完全一样的
def fn(self, name='world'): # 先定义函数
    print('Hello, %s.' % name)

Hello2 = type('Hello', (object,), dict(hello2=fn)) # 创建Hello class


#正常情况下，我们都用class Xxx...来定义类，但是，type()函数也允许我们动态创建出类来，也就是说，动态语言本身支持运行期动态创建类，