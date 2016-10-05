#普通文本文件读写
#myfile2 = open(r"C:\\Tools\\test.txt", "w") #写入
myfile2 = open(r"C:\\Tools\\test.txt", "a") #追加
myfile2.write("This is a sample string \n")
myfile2.close()

myfile3 = open(r"C:\\Tools\\test.txt") #读取
print(myfile3.read())
myfile3.close()