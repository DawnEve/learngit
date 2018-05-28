#function
def areaOfCircle(r):
	PI=3.1415926
	return PI*r*r
	
#calc
s1=areaOfCircle(1);
s2=areaOfCircle(2);
s3=areaOfCircle(3);

#print
print(s1)
print(s2)
print(s3)

# 没有return语句则返回none
def noReturn():
	pass;

#返回值可以判断 ==None
print(noReturn())
if None==noReturn():
	print("1111")