#普通文本文件读写
path3=r"C:\\Tools\\test.txt";
myfile3 = open(path3) #读取

print('文件也是一种数据类型，和列表、字典类似: name=', myfile3.name,'\n  :', myfile3)
print("1> ", myfile3.read(10))
myfile3.close()

n=10
#对文件进行迭代:按字符迭代
print();fr=open(path3)
c_str=fr.read(n)#重复0
while c_str:
    print("2> char:", c_str)
    c_str=fr.read(n)#重复1
fr.close()

#更精简的写法
print();fr=open(path3)
while True:
    c_str=fr.read(n)
    if not c_str:
        break;
    print("3>char:", c_str)
fr.close()