#普通文本文件读写
myfile3 = open(r"C:\\Tools\\test.txt",encoding='UTF-8') #读取

print('文件也是一种数据类型，和列表、字典类似: name=', myfile3.name,'\n  :', myfile3)
print(myfile3.read(10))
myfile3.close()
