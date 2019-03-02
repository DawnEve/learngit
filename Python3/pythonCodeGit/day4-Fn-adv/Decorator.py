def now():
    print('2015-3-25')

f = now
f()
print('now: ', now )
print('now.__name__: ', now.__name__ )
print('f: ', f )
print('f.__name__: ', f.__name__ )

#现在，假设我们要增强now()函数的功能，
#比如，在函数调用前后自动打印日志，但又不希望修改now()函数的定义，
#这种在代码运行期间动态增加功能的方式，称之为“装饰器”（Decorator）。

# OOP的装饰模式需要通过继承和组合来实现，而Python除了能支持OOP的decorator外，直接从语法层次支持decorator。
# Python的decorator可以用函数实现，也可以用类实现。

import functools
print('=========装饰器=========')
def log(text):
    def decorator(func):
        @functools.wraps(func)  #修改函数的__name__属性
        def wrapper(*args, **kw):
            print('%s %s():' % (text, func.__name__))
            return func(*args, **kw)
        #wrapper.__name__ = func.__name__;  #怎么纠正函数名字？
        return wrapper
    return decorator

# 我们要借助Python的@语法，把decorator置于函数的定义处：
@log('execute')
def now():
    print('2015-3-25')
    
now()
print('now.__name__: ', now.__name__ ) #now.__name__:  wrapper