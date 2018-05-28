mdict={
    "Name":'27班',
    "id":'a001',
}
print(mdict) #1

print("Name:%s\
 Number:%s\
 String:%s"%(mdict['Name'],3,3*'-'))

#以列表返回可遍历的键值对元组数组
print('items方法: ', mdict.items()) # dict_items([('Name', '27班'), ('id', 'a001')])

for p in mdict.items():
    #print(len(p), p) 
    print(' - ',p[0],'=', p[1])

#返回字典所有的键、值
print('keys: ', mdict.keys())  # dict_keys(['Name', 'id'])
print('values:', mdict.values()) # values: dict_values(['27班', 'a001'])


#删除元素
del mdict['Name']; # 删除键是'Name'的条目
print('mdict:',mdict) #2


#判断键是否在字典中
print('id' in mdict)#True

mdict.clear();     # 清空词典所有条目
print(mdict) #3
del mdict        # 删除词典

