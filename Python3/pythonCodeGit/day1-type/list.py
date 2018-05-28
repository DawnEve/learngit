
#嵌套来模仿二维数组
L=[
    ['Apple', 'Google', 'Microsoft'],
    ['Java', 'Python', 'Ruby', 'PHP'],
]

#调用元素
print(L[0][1]); #Google

#元素长度
print('Before append:', len(L)); 

#在末尾添加元素
L.append(['Adam', 'Bart', 'Lisa']) 

print('After append:', len(L));


#删除元素
print(L)
del L[2][-1] #删除序号是2的list中的最后一个元素
print(L)



print("about 分片赋值=======================")
#分片赋值
txt=list('good day')
print(txt)

#部分元素重新赋值
txt[-3:]=list("time")
print(txt)

#替换
txt[0:4]=list('bad') #4个替换成3个
print(txt)

#直接插入
txt[0:0]="realy"
print(txt)

#看来不能分片插入单词。想插入单词需要使用单个位点
del txt[0:4]
txt[0]='realy'
print(txt)




#count方法
mlist=list('this is an apple')
print(mlist)
print('the number of o is:',mlist.count('a')) #2

mylist=list("some")
print(mylist)

#copy方法
mlist=list('this is an apple')
my2=mylist
my3=mylist.copy()
mylist[1:]=' '
print(my2) #受影响。按地址传递
print(my3) #不受影响。直接复制一份出来。
