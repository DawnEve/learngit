import re 

#默认是贪婪匹配
result=re.match(r'^(\d+)(0*)$', '102300').groups()
print(result) 
#('102300', '')

#非贪婪匹配就是量词后面加上?
result=re.match(r'^(\d+?)(0*)$', '102300').groups() #('1023', '00')
result=re.match(r'^(\d+?)(0*)', '102300').groups() #('1', '0')
print(result) 


#非贪婪匹配就是量词后面加上?
# result=re.match(r'^(\d+)(\d*)$', '102300').groups() #('102300', '')
result=re.match(r'^(\d+?)(\d*)$', '102300').groups() #('1', '02300')


print(result) 

