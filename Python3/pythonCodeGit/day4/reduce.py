#reduce把一个函数作用在一个序列[x1, x2, x3, ...]上，这个函数必须接收两个参数，
#reduce把结果继续和序列的下一个元素做累积计算，其效果就是：
#reduce(f, [x1, x2, x3, x4]) = f(f(f(x1, x2), x3), x4)

from functools import reduce

# 仅仅是求和
def fn(x, y):
    return x + y

s=reduce(fn, [1, 3, 5, 7, 9])
print('求和后：',s)



def fn2(x, y):
     return x * 10 + y
rs=reduce(fn2,[1,3,5,7,9])
print('转成数字拼接为：',rs)