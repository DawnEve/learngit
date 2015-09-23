#闭包
def lazy_sum(*args):
    def sum():
        ax = 0
        for n in args:
            ax = ax + n
        return ax
    return sum

#返回的是函数
f=lazy_sum(1,2,3,4,5)
print(f) #<function lazy_sum.<locals>.sum at 0x017141E0>

s=f()
print('Result: ',s) #15


#每次调用都会返回一个新的函数，即使传入相同的参数：
f1 = lazy_sum(1, 3, 5, 7, 9)
f2 = lazy_sum(1, 3, 5, 7, 9)
print('2个函数是否相等：', f1==f2 )


