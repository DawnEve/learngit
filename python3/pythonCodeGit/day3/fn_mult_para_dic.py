#传入字典参数并打印
def myPrintDic(d):
	print(d)
	
d={'Jim':10, 'Tom':15, 'Mark':15, 'Jobs':20 }
myPrintDic(d);


#按照字典传入多个参数
def add(a,b):
	print('按照字典传入多个参数:',a+b);

#一般传参
add(1,2);
add(a=2,b=4);

#先构建字典，再传入
d2={'a':20, 'b':40}
add(**d2);