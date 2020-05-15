class Fib(object):
    def __init__(self):
        self.a, self.b = 0, 1 # 初始化两个计数器a，b

    def __iter__(self):
        return self # 实例本身就是迭代对象，故返回自己

    def __next__(self):
        self.a, self.b = self.b, self.a + self.b # 计算下一个值
        if self.a > 100000: # 退出循环的条件
            raise StopIteration();
        return self.a # 返回下一个值

#完全打印
# f=Fib()
# #print('打印第一个元素：',f[1]) ###################{不支持索引}
# for n in f: #for循环中实现迭代对象__iter__，不断调用自身的__next__方法。
#     print(n)

#通过上面的方法，我们自己定义的类表现得和Python自带的list、tuple、dict没什么区别，这完全归功于动态语言的“鸭子类型”，不需要强制继承某个接口。
#http://www.liaoxuefeng.com/wiki/0014316089557264a6b348958f449949df42a6d3a2e542c000/0014319098638265527beb24f7840aa97de564ccc7f20f6000
#但和list不同，还不支持索引。


class Fib2(object):
    def __getitem__(self, n):
        a, b = 1, 1
        for x in range(n):
            a, b = b, a + b
        return a

# f2=Fib2();
# n=0
# while n<10:
# 	print('a(',n,')=',f2[n])
# 	n=n+1
# print( f2[10] )
# #print( f2[2:5] ) ###################{不支持切片}
# #原因是__getitem__()传入的参数可能是一个int，也可能是一个切片对象slice，所以要做判断：

#怎么支持切片呢？
class Fib3(object):
    def __getitem__(self, n):
        #判断类型1
        if isinstance(n, int): # n是索引
            a, b = 1, 1
            for x in range(n):
                a, b = b, a + b
            return a
        #判断类型2
        if isinstance(n, slice): # n是切片
            start = n.start
            stop = n.stop
            step=n.step
            if step==None:
                step=1;
            
            if start is None:
                start = 0
            a, b = 1, 1
            L = []
            for x in range(stop):
                if x >= start:
                    if (x-start)%step==0:
                        L.append(a)
                a, b = b, a + b
            return L
#assert 0,'pause.'
f3=Fib3();
n=0
while n<10:
	print('f3[%d]='% n,f3[n])
	n=n+1
print( f3[10] )
print('切片：', f3[1:20] )#可以切片

#对step参数作处理：
print('步长2：', f3[1:20:2] )
#没有对负数作处理
print('步长3：', f3[2:20:3] )

# 此外，如果把对象看成dict，__getitem__()的参数也可能是一个可以作key的object，例如str。

# 与之对应的是__setitem__()方法，把对象视作list或dict来对集合赋值。
# 最后，还有一个__delitem__()方法，用于删除某个元素。