def addEnd(L=None):
	if L is None:
		L=[]
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
print(a1);