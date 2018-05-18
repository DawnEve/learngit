import re

m = re.match(r'^(\d{3})-(\d{3,8})$', '010-12345')
print('1: ', m)
#<_sre.SRE_Match object; span=(0, 9), match='010-12345'>

print('m :', m)
print('dir(m) :',dir(m))
print('2 :', m.groups()) #('010', '12345')

#注意到group(0)永远是原始字符串，group(1)、group(2)……表示第1、2、……个子串。
print(m.group(0)) #010-12345
print(m.group(1)) #010
print(m.group(2)) #12345
#print(m.group(3)) #010-12345 IndexError: no such group
print()

t = '19:05:30'
m = re.match(r'^(0[0-9]|1[0-9]|2[0-3]|[0-9])\:(0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]|[0-9])\:(0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]|[0-9])$', t)
print('3: ', m.groups())
#('19', '05', '30')
