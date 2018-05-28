#try 中的语句如果发生异常，就暂停并回到try控制，接着执行except字句。
#如果没有新的异常，则控制流通过整个try语句，而不会使程序挂起中断。
# finnally子句总会执行，不管try是否捕获异常。

try:
    print('try...')
    r = 10 / 0
    print('该句不会被执行result:', r) 
except ZeroDivisionError as e:
    print('except:', e)
finally:
    print('总会执行的 finally...')

print('END')

#反问：直接判断被除数是否为0不就行了，为什么用try呢？
#如果好几个除法，是否需要很多if判断呢？实际中的代码一般比较复杂，try语句更节省代码。
