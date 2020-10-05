# python 的装饰器语法糖符号@

#1. 传入函数名，该函数执行前后分别执行一句话，最后返回一个函数
def printdebug(func):
    def __decorator():
        print('enter the login3')
        func()
        print('exit the login3')
    return __decorator  #function as return value
#

#2. 定义被装饰函数
@printdebug
def login():
    print('in login')
#3. 执行装饰后的函数
login()
##
print('-'*10)
print('function name: ',login.__name__) #__decorator
# 这里返回的是装饰器函数的返回值，我们期望返回函数名自己，怎么办？




################
print('\n使用 functools.wraps');
print('=='*10)

from functools import wraps

def printdebug2(func):
    @wraps(func)
    def __decorator():
        print('enter the login3-')
        func()
        print('exit the login3-')
    return __decorator  #function as return value
#2. 定义被装饰函数
@printdebug2
def login():
    print('in login')
#3. 执行装饰后的函数
login()
print('-'*10)
print('function name: ',login.__name__) #login 返回的是被装饰函数名本身

