#操作系统包，处理环境变量等。

import os
print('1>',os.name) #nt
#print(os.uname) #nt
#注意uname()函数在Windows上不提供，也就是说，os模块的某些函数是跟操作系统相关的。

print('2>',os.environ)
# environ({'PYTHONIOENCODING': 'UTF-8', 
# 'PROGRAMW6432': 'C:\\Program Files', 
# ...
# 'USERDOMAIN': 'PEPTIDE', 
# 'PUBLIC': 'C:\\Users\\Public'})
#获取某个变量
print('3>', os.environ.get('PATH'))

# 查看当前目录的绝对路径:
print('4>', os.path.abspath('.')) #F:\gitHub\learngit\Python3\pythonCodeGit\day9

#创建目录
#os.mkdir('tempWJL')
# 删掉一个目录:
#os.rmdir('tempWJL')

#把两个路径合成一个时，不要直接拼字符串，而要通过os.path.join()函数，这样可以正确处理不同操作系统的路径分隔符。
dirName=os.path.join(os.path.abspath('.'),'abc');
print('5>', dirName)
#os.mkdir(dirName)

#同样的道理，要拆分路径时，也不要直接去拆字符串，而要通过os.path.split()函数，
#这样可以把一个路径拆分为两部分，后一部分总是最后级别的目录或文件名：
dirArr=os.path.split(dirName)
print('6>', dirArr)
print('7>', os.listdir())

#目录不存在就返回False
if(os.path.exists(dirName)):
    print("存在", dirName)
else:
    print("不存在", dirName)

#修改文件名
if(os.path.isfile("002.cache")):
    #os.rename('002.cache','001.cache')
    os.remove("002.cache") #删除文件

if(not os.path.isfile('001.cache')):#如果文件不存在返回False
    f001=open("001.cache","w");
    f001.write("some text here.");
    f001.close();print("重建文件001.cache")
rs=os.rename("001.cache", '002.cache')#把001改名为002，如果没有001则报错
#FileNotFoundError: [WinError 2] 系统找不到指定的文件。: '001.cache' -> '002.cache'
print("8>", rs)#没有返回值

    
dir(os)