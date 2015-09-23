#调试函数
def d(x):
	print(x)

print('递归调用')
#
def factor(n):
	if n>1:
		return n*factor(n-1);
	elif n>=0:
		return 1;
	
print( factor(100) )