#不定参数，可以通过数组传入
def calc(tuple):
	sum=0
	for n in tuple:
		sum=sum+n
	return sum
	
r=calc([1,2,3]);
print(r)

#也可以设定参数为可变参数：前面加上*即可
def calc2(*numbers):
	sum=0
	for n in numbers:
		sum=sum+n
	return sum
	
r2=calc2(1,2,3,4,5);
print(r2)
print(calc2())#没有输入，则正常输出0

#如果已经有list或tuple，想使用calc2怎么办？
n=[1,2,3];
r3=calc2(n[0],n[1],n[2])#这样也行，但太写死了.增加一个元素就要再改
print('r3=', r3);

#good调用方法:
#*nums表示把nums这个list的所有元素作为可变参数传进去。这种写法相当有用，而且很常见。
r4=calc2(*n);
print('r4=',r4);

