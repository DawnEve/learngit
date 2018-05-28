# 求 阶乘n!的值
def factor(n):
	if n>=1:
		return n*factor(n-1);
	elif n==0:
		return 1;
	
num=10
print('递归调用: ',num,'! =', factor(num) )

#print( factor(1000) ) #栈溢出错误 maximum recursion depth exceeded in comparison


# 尾递归 可以避免栈溢出。就是return语句中只是函数，不包括函数间的计算
def fact(n):
	return fact_iter(n,1);

def fact_iter(num, product):
	if num==1:
		return product;
	return fact_iter(num-1, num*product);
#print( fact(1000) ) #一样报错。maximum recursion depth exceeded in comparison
