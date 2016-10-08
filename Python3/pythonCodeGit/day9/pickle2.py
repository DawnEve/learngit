#python数据持久存储：pickle模块的基本使用
#http://www.cnblogs.com/pzxbc/archive/2012/03/18/2404715.html
#相当于二进制序列化

import pickle
mylist = ["This", "is", 4, 13327]
# Open the file C:\\Tools\\binary.dat for writing. The letter r before the
# filename string is used to prevent backslash escaping.
myfile = open(r"C:\\Tools\\binary.dat", "wb")
pickle.dump(mylist, myfile)
myfile.close()

#二进制读取
myfileR = open(r"C:\\Tools\\binary.dat",'rb')
re=pickle.load(myfileR)
print(re)
print(re==mylist) #True
myfileR.close()

