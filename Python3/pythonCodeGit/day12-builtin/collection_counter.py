from collections import Counter

#字符计数器
c = Counter()
for ch in 'programming':
     c[ch] = c[ch] + 1
print(c) 
#Counter({'m': 2, 'g': 2, 'r': 2, 'a': 1, 'p': 1, 'n': 1, 'o': 1, 'i': 1})
print(type(c)) #<class 'collections.Counter'>

#也可以直接使用
#https://docs.python.org/3/library/collections.html?highlight=counter#collections.Counter
c3=Counter('programming')
print('c3 => ',c3)
print(c3==c) #True




#配合正则表达式，做单词计数器
sentence="This is a book and that is a table,   one red book is on that chair. and so on"

#分割单词
import re
wordarr=re.split(r"[\s,.]+",sentence)
# print(wordarr)

c2=Counter()
for word in wordarr:
    c2[word] += 1
print('word count: ',c2)