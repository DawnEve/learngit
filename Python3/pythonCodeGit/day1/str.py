dict={
    "Name":'27班',
    "id":'a001',
}
print(dict) #1

print("Name:%s\
 Number:%s\
 String:%s"%(dict['Name'],3,3*'-'))

del dict['Name']; # 删除键是'Name'的条目
print(dict) #2
dict.clear();     # 清空词典所有条目

print(dict) #3
del dict ;        # 删除词典