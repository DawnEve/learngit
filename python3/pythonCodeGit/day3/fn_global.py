c=0
print('outer1',c);
def fn():
	global c
	c=5+4
	print('inner:', c)

fn()
print('outer2',c);