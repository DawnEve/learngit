c=0
print('outer1',c);

def fn1():
	#不要和全局变量重名，可以直接使用全局变量；
	#c = c + 100 #为什么不能增量呢？
	c=100
	print('fn1 inner:',c)
	
def fn2():
	#如果接下来定义全局变量同名变量，则此处无法提前读取全局变量，提示本地变量定义之前使用
	#UnboundLocalError: local variable 'c' referenced before assignment
	#要么不要和全局变量重名，可以直接使用全局变量,如fn1
	#要么和全局变量重名，定义完本地后再使用该变量,如fn2
	#print('fn2-1:',c) 
	c=2
	print('fn2-2:',c)

def fn10():
	global c #加了global就读写全局变量了
	c=5+4
	print('inner:', c)

fn1()
print('===outer after fn1:',c);

fn2()
print('===outer after fn2:',c);

fn10()
print('===outer after fn10:',c);