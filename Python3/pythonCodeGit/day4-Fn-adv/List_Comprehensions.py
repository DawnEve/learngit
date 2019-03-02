print('列表生成式');

L = [x * x for x in range(10)]
print(L);

#可以加条件排除一部分
L2 = [x * x for x in range(10) if x%2==0]
print(L2);