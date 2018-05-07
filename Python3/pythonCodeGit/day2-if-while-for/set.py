#set要使用list作为输入，不能有重复。就是数学中的集合
s1 = set([1, 2, 3]) 
s2 = set([2, 3, 4])
a1=s1 & s2 # 交集
a2=s1 | s2 # 并集

print(a1);
print(a2);