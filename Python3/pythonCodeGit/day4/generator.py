print('生成器generator');

print('列表生成式');
L = [x * x for x in range(10)]
print(L)


#创建L和g的区别仅在于最外层的[]和()，L是一个list，而g是一个generator。
g = (x * x for x in range(10))
#打印
for n in g:
	print('生成器:',n)
