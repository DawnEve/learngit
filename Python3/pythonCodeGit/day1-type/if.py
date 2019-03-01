#if语句

a=110;

if a>0:
	if a>100:
		print(">100")
	elif a>10:
		print('>10')
	else:
		print('>1')
elif a<0:
	print('<0')
else:
	print('=0')


# 数据类型
mytype=type("this is a book")
mytype2=type(50.3)
print(mytype,' ',mytype2)



#使用if判断数据类型
if type("string") is str:
	print("Yes，a string")
else:
	print("No, not a string")

#但是type()不靠谱，比如
class A():
	pass

class B(A):
	pass

a=A()
b=B()
b2=B()

print('type(a): ',type(a))
print(type(a) is type(b)) #False 不识别子类。
print(type(b2) is type(b)) #True

#也可以使用isinstance
print("isinstance: ",isinstance(a,A)) #True
print("isinstance: ",isinstance(b,A)) #True 子类对象当做父类对象

# type的话出来的则是一串字符串，精确到子类，所以可以用来做精确判断，例如判断是不是这个类，而不是这个类的子类，isinstance只能判断是不是这个类或者这个类的子类。
# 判断两个对象是否来自同一个类，可以用type(a)==type(b)来判断。

