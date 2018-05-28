import re 
# 用正则表达式切分字符串比用固定的字符更灵活

r='a b   c'.split(' ')
print('1: ',r) 
#['a', 'b', '', '', 'c']
#无法识别连续的空格，用正则表达式试试：


r=re.split(r'\s+', 'a b   c')
print('2: ',r)
# ['a', 'b', 'c']
#无论多少个空格都可以正常分割。


#加入,试试：
r=re.split(r'[\s\,]+', 'a,b, c  d ,e fg')
print('3: ',r)

#再加入;试试：
r=re.split(r'[\s\,\;]+', 'a,b;; c  d')
print('4: ',r)

#用一切非字母元素分割
r=re.split(r'[^a-zA-Z]+', 'a,b;; -c  d+e|f__g')
print('5: ',r)
r=re.split(r'[^\w]+', 'a,b;; -c  d2+e|f__(g)h')
print('6: ','为什么去不掉下划线f__g',r) #因为\w是字母、数字和下划线

r= re.split(r'[\W_]+', 'a,b;; -c  d2+e|f__(g)h')
print('7: ',r) #去掉了下划线

