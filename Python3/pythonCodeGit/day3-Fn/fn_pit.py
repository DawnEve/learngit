# 大坑1: 传入的空会累积多个END

def addEnd(L=[]):
	L.append('END')
	return L
	
a1=addEnd([1,2,3])
print(a1);

b1=addEnd();
b2=addEnd();
b3=addEnd();

print(b1);
print(b2);
print(b3);