#for
a=1;
b=2;
#print(a>b) #False

c=False

if c:
	print('Y')
else:
	print('N')
	
	#对于单个字符的编码，Python提供了ord()函数获取字符的整数表示，chr()函数把编码转换为对应的字符：
ord('A')
#65
ord('中')
#20013
chr(66)
#'B'
chr(25991)
#'文'