#map
print('map的用法')
def f(x):
    return x * x

#map()函数接收两个参数，一个是函数，一个是Iterable，
#map将传入的函数依次作用到序列的每个元素，并把结果作为新的Iterator返回。
r = map(f, [1, 2, 3, 4, 5, 6, 7, 8, 9])
print(r) #<map object at 0x00475A30>
#print(dir(r))

#print('tuple:',  tuple(r)  );
print('list:',   list(r)  );

#或者用函数实现
L = []
for n in [1, 2, 3, 4, 5, 6, 7, 8, 9]:
    L.append(f(n))
print(L)

#一行转换成字符
r=list(map(str, [1, 2, 3, 4, 5, 6, 7, 8, 9]))
print(r)
