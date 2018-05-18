import re 

#一次编译
re_telephone = re.compile(r'^(\d{3})-(\d{3,8})$')




#多次调用1
print(re_telephone.match('010-12345').groups())
#('010', '12345')

#多次调用2
print(re_telephone.match('010-8086').groups())
#('010', '8086')
