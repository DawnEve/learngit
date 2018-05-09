#Python对匿名函数的支持有限，只有一些简单的情况下可以使用匿名函数。
# 可以有0,1或多个参数。不能访问参数列表外或全局命名空间的参数。
# 只能有一个表达式，必须有返回值，返回值就是该表达式的结果。不能写return语句。

# 格式示例 lambda x,y: x+y
r=list(map(lambda x: x * x, [1, 2, 3, 4, 5, 6, 7, 8, 9]))
print(r)

#返回匿名函数
def build(x, y):
    return lambda: x * x + y * y

print('函数：',build)

fn=build(3,4)
print(type(fn),'===type of===\n',fn) #依旧是函数，返回的匿名函数
print(fn()) #再次执行该匿名函数，可以访问外函数的变量,计算出结果

#匿名函数调用
c=lambda x,y=3:x*y 
print('c=lambda x,y=3:x*y', c(300))

#####################
#用于单行过滤
nums=[1,2,3,4,5]

def func(x):
    return x>3
f_list=filter(func,nums)
print('超过3的元素有2：', [item for item in f_list])
#print('超过3的元素有1：', list(f_list)) #这两种冲突？只有一个有效

#使用匿名函数一行解决：
print('超过3的元素有3：', [item for item in filter(lambda x:x>3, nums)])