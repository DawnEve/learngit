#一个函数就可以接收另一个函数作为参数，这种函数就称之为高阶函数。
#一个最简单的高阶函数：
def add(x, y, f):
    return f(x) + f(y)
	
def f(i):
	return i*i;
	
def f2(i):
	return i/2;
	
a1=add(1,4,f)
a2=add(1,4,f2)

print(a1);
print(a2);