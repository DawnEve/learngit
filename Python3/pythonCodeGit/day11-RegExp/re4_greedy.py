import re 

# py默认是贪婪匹配
result=re.match(r'^(\d+)(0*)$', '102300').groups()
print('1>',result) #('102300', '')

#非贪婪匹配就是量词后面加上?
result=re.match(r'^(\d+?)(0*)$', '102300').groups() #('1023', '00')
print('2-1>',result)

result=re.match(r'^(\d+?)(0*)', '102300').groups() #('1', '0')
print('2-2>',result) 


#非贪婪匹配就是量词后面加上?
# result=re.match(r'^(\d+)(\d*)$', '102300').groups() #('102300', '')
result=re.match(r'^(\d+?)(\d*)$', '102300').groups() #('1', '02300')
print('3>',result) 

