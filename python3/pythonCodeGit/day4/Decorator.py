def now():
    print('2015-3-25')

f = now
f()
print('now: ', now )
print('now.__name__: ', now.__name__ )
print('f: ', f )
print('f.__name__: ', f.__name__ )

#OOP的装饰模式需要通过继承和组合来实现，而Python除了能支持OOP的decorator外，直接从语法层次支持decorator。Python的decorator可以用函数实现，也可以用类实现。
print('=========装饰器=========')
def log(text):
    def decorator(func):
        def wrapper(*args, **kw):
            print('%s %s():' % (text, func.__name__))
            return func(*args, **kw)
		#wrapper.__name__ = func.__name__;  #怎么纠正函数名字？
        return wrapper
    return decorator
	
@log('execute')
def now():
    print('2015-3-25')
now()
print('now.__name__: ', now.__name__ ) #wrapper.__name__ = func.__name__