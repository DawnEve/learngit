# 所有的错误类型都继承自BaseException，所以在使用except时需要注意的是，它不但捕获该类型的错误，还把其子类也“一网打尽”。比如：

def foo(r):
	PI=3.1415926
	return PI*r*r


try:
    foo()
except ValueError as e:
    print('ValueError')
    print(e);
except UnicodeError as e:
    print('UnicodeError')
except BaseException as e:#捕获所有错误。
    print('BaseException')
    print(e);
	
# Python所有的错误都是从BaseException类派生的，常见的错误类型和继承关系看这里：

# https://docs.python.org/3/library/exceptions.html#exception-hierarchy
