#for and range
sum=0
for x in range(101):
	sum=sum+x
print(sum)

sum=0
for x in list(range(101)):
	sum=sum+x
print(sum)


#对字符串遍历
for l in "the list":
	print('当前字母：', l)

#对list遍历
arr=['orange','tulip','apple','lily']
for a in arr:
	print('current item:',a)

#对字典遍历
print('\n===第1种遍历dict')
mydict={"id":1,  "name":'Tom',  "score":80, 'birthday':'19901001'}
for i in mydict:
	print(i,'=',mydict[i])

#对字典的遍历2
print('\n===第2种遍历dict')
for k,v in mydict.items():
	print(k,'=',v)