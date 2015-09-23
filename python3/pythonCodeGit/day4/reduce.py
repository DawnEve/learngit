#reduce:
#reduce(f, [x1, x2, x3, x4]) = f(f(f(x1, x2), x3), x4)

from functools import reduce
def fn(x, y):
    return x * 10 + y

s=reduce(fn, [1, 3, 5, 7, 9])

print(s)