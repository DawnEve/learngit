#对于单个字符的编码，Python提供了ord()函数获取字符的整数表示，chr()函数把编码转换为对应的字符：
print(ord('A')) #65
print(ord('中')) #20013
print(chr(66)) #'B'
print(chr(25991)) #'文'
print()

#字符串格式化
print('hello %s, your score is %d.' %('Jim',99))

#数字带精度
print("PI=%.7f" % 3.14159265358978)

#字符串函数
print('find():', "book".find("oo") ) #查找子字符串

print('join():', "good".join("day") ) #用指定字符串连接成新字符串: dgoodagoody
b=", ".join("day") 
print('join()2:', b,type(b))

# 大小写
print("I'm a Chinese".lower())
print("I'm a Chinese".upper())

print('a cat'.replace('cat','big dog')) #替换字符串：a big dog
print("Tom, Jim, Robin".split(", ")) #分割字符串为list