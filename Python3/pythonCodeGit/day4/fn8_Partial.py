#偏函数（Partial function） 和数学上的偏函数不是一个概念。
# 需要依赖 functools 包的partial函数实现。
#偏函数比自定义函数代码更简洁。功能和默认参数功能差不多。

#简化参数，要么使用默认参数
def int2(x, base=2):
    return int(x, base)
print( int2('1000000') )

#或者使用偏函数
import functools
int2a = functools.partial(int, base=2)
print( int2a('1000000') )

#当函数的参数个数太多，需要简化时，使用functools.partial可以创建一个新的函数，
#这个新函数可以固定住原函数的部分参数，从而在调用时更简单。

#例2：使用偏函数固定参数
from functools import partial #更简洁的引入方式。
def mod(n,m):
    return n%m;

mod_by_100=partial(mod,100) #则相当于n=100提前输入了
print('自定义函数求100%9=', mod(100,9))
print('偏函数求100%9=', mod_by_100(9))

mod_to_7=partial(mod,m=7) #则相当于m=7提前输入了
print('偏函数求51%7=', mod_to_7(51))