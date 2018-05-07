#不定参数，可以通过数组传入
def calc(tuple):
	sum=0
	for n in tuple:
		sum=sum+n
	return sum
	
r=calc([1,2,3]);
print('input arr: ',r)


#也可以设定参数为可变参数：前面加上*即可
def calc2(*numbers):
	sum=0
	for n in numbers:
		sum=sum+n
	return sum

r2=calc2(1,2,3,4,5);
print('input multi-para: ', r2)
print('input 0-para: ',calc2())#没有输入，则正常输出0

print("\n=========")
#如果已经有list或tuple，想使用calc2怎么办？
n=[1,2,3];
r3=calc2(n[0],n[1],n[2])#这样也行，但太写死了.增加一个元素就要再改
print('bad input:', r3);


################
#good调用方法:
#*nums表示把nums这个list的所有元素作为可变参数传进去。这种写法相当有用，而且很常见。
#print("before append: ", calc2(n)) #报错
print('before append:',calc2(*n));

n.append(100)
print("after append: ", calc2(*n)) #106