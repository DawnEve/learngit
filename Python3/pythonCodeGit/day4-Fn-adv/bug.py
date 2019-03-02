#简化描述:又没事了。。。
def factor(n):
	global m
	m=m+1
	if n==1:
		return 1
	else:
		return factor(n-1)*n

m=2;
print('outer:',m)
result=factor(10)
print('outer2:',m)
print('result:', result)
