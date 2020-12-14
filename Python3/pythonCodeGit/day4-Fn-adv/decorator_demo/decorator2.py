#1. 定义核心函数
def login():
    print('in login')
#2. 传入函数名，该函数执行前后分别执行一句话，最后返回一个函数
def printdebug(func):
    def __decorator():
        print('enter the login2')
        func()
        print('exit the login2')
    return __decorator  #function as return value
#3a. 调用外函数，传入被装饰函数，得到新函数
#debug_login = printdebug(login)  #function assign to variable
#4a. 使用新函数
#debug_login()  #execute the returned function

#
print('装饰前','=='*5)
login() #原函数

#3b.其实新函数和旧函数可以同名的
login=printdebug(login)
#4b.执行
print('装饰后','--'*5)
login() #装饰后