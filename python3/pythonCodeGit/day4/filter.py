#和map()类似，filter()也接收一个函数和一个序列。和map()不同的时，filter()把传入的函数依次作用于每个元素，然后根据返回值是True还是False决定保留还是丢弃该元素。

#保留奇数
def is_odd(n):
    return n % 2 == 1
	
L=list(filter(is_odd, [1, 2, 4, 5, 6, 9, 10, 15]))
print(L) # 结果: [1, 5, 9, 15]


#删除空值
def not_empty(s):
    return s and s.strip()

L2=list(filter(not_empty, ['A', '', 'B', None, 'C', '  ']))
print(L2)# 结果: ['A', 'B', 'C']



