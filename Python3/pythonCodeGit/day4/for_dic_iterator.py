d={'a':1,'b':2,'c':3}
#迭代键值对
for k in d:
    print(k,':',d[k])
	
#另一种迭代键值对
for key , value in d.items(): #py3没有iteritems了，items就是迭代器
    print (key,value )

#仅迭代值
for v in d.values():
	print('仅迭代值：',v);#顺序不定

	
#引入包判断是否可以迭代
from collections import Iterable
a1=isinstance('abc', Iterable) # str是否可迭代True
a2=isinstance([1,2,3], Iterable) # list是否可迭代True
a3=isinstance(123, Iterable) # 整数是否可迭代

print(a1);
print(a2);
print(a3);