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