from functools import reduce

def fn(x, y):
    return x * 10 + y

def char2num(s):
#     print(s)
    return {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}[s]

rs=reduce(fn, map(char2num, '13579'))
print(rs)

#以上可以整理成一个函数：Python允许函数嵌套
def str2int(s):
    def fn(x, y):
        return x * 10 + y
    def char2num(s):
        return {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}[s]
    return reduce(fn, map(char2num, s))

s=str2int('10086')
print(s) #10086
print(type(s)) #<class 'int'>


