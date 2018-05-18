#!/usr/bin/python
# -*- coding: UTF-8 -*-
import re
phone = "2004-959-559 # 这是一个国外电话号码"

# 删除字符串中的 Python注释 
num = re.sub(r'#.*$', "", phone)
print("电话号码是: ", num)

# 删除非数字(-)的字符串 
num = re.sub(r'\D', "", phone)
print( "电话号码是 : ", num)


#################################
# 也可以替换部分是一个函数
# 将匹配的数字乘以 2
def double(matched):
    value = int(matched.group('value'))
    return str(value * 2)
 
s = 'A23G4HFD567'
print(s, '  数字加倍后1 ==> ', re.sub('(?P<value>\d+)', double, s))#不理解


# 自己的函数，函数的关键是1.要取出被捕获的值，2.然后怎么处理这个值并返回。
def double2(matched):
    print('  double2>>',matched.group())
    value = int(matched.group())
    #value = int(matched.group('value'))
    return str(value * 2)
print(s, '  数字加倍后 2==> ', re.sub(r'(\d+)', double2, s))#不理解




print()
#进一步，编写动词ing变换的规则 
#如果是元音+辅音结尾，则双写辅音加ing：  cut cutting, overlapping, span spanning
wl=['cut', 'overlap','book','span']
def fn(matched):
    tmp=matched.groups()
    return tmp[0]+tmp[1]+"ing"
for w in wl:
    if re.match(r'.*[aeiou]{1}(t|p|n)$', w):
        rs=re.sub(r'(.*[aeiou]{1}(t|p|n)$)',fn,w)
    else:
        #如果不符合，则输出动词原形
        rs='直接加ing:'+w+"ing"
    print(rs)

