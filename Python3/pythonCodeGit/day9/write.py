#myfile2 = open(r"C:\\Tools\\test.txt", "w") #写入
myfile2 = open(r"C:\\Tools\\test.txt", "a") #追加
myfile2.write("This is a sample string \n")
myfile2.close()