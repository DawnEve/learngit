
#字符串截取
str2='UliOtQ9wJKLSavDT8fQPjl6rDRg2RsTDqpgh3kPEo9ooWCH4G0hRBKDTrachemysCNY4pP6azhPU9uPbDZa9nGs5a86izP4LVhvel8K60l3M7fcOYKL89MhKN0F9sii21C8v39eM54drfuK1BtmaritimusVx9QJ17iwbAaBF5ks.'
#55 63 146 154
print(str2[55:64])

print(str2[146:155])

#字符串翻转
print( ''.join(reversed("博古通今！")) )

print( reversed("博古通今！") ) #不能打印。直接返回的是可迭代对象。
print( list(reversed("博古通今！")) )#先转化为list就可以了