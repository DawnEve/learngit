
# if basic format
age=1
#age=10
#age=100

if age>18:
	print('adult');
elif age>6:
	print('you cannot drink!');
else:
	print('kid');

	
# is 是比较同一性
a=b=[1,2,3]
c=[1,2,3]

print("a == b: ", a == b)
print("a == c: ", a == c)

print("a is b: ", a is b)
print("a is c: ", a is c)

#字符串、list都是按照位置进行比较的
print('1023'>'20') #False
print('20'>'10000') #True

print('list1:', [1,2]>[0,100]) #True
print('list2:', [1,2]>[1,100]) #False
print('list3:', [1,2]==[1,2]) #True
print('list4:', ['1','2']>['1','100']) #True

#布尔运算 and, or, not, 
num=8
if num>=5 and num<=10:
	print('num的值介于5和10之间')
else:
	print('num的值not介于5和10之间')
#短路逻辑:
# x and y 如果 x为假直接返回假，y不会执行
# x or y 如果 x为真直接返回真，y不会执行

# 或者 py专用的写法：连写
num=75
if 5 <= num <= 10:
	print('num的值介于5和10之间')
else:
	print('num的值not介于5和10之间')
