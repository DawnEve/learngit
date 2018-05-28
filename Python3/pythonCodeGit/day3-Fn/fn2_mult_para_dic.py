#传入字典参数并打印
def myPrintDic(d):
	print(d)
	
d={'Jim':10, 'Tom':15, 'Mark':15, 'Jobs':20 }
myPrintDic(d);


#按照字典传入多个参数
def add(a,b):
	print('按照字典传入多个参数:',a+b);
	print('a=',a,'b=',b)

#一般传参
add(1,2);
add(b=2,a=4);

#先构建字典，再传入
d2={'a':20, 'b':40}
add(**d2);

# 任何函数都可以按照 fn(*para, **para) 的形式调用，无论参数是如何定义的。
add(*[1,10]) #需要很严格按照定义传入参数，否则报错
#add(*[1,10,100]) #add() takes 2 positional arguments but 3 were given
#add(**{'name':'Tim', 'a':2, 'b':20})#add() got an unexpected keyword argument 'name'

#但是，如果定义时就指定**，则只要提供够用的参数就不报错，多余参数自动忽略
def minus(**para):
	print(len(para),para['a']-para['b'])
	
minus(**{'name':'Tim', 'a':2, 'b':20})