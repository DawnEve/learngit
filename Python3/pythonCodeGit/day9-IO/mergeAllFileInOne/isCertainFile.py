import os
import re

#判断是否为某些文件类型

def isCertainFile(filename,types=['py']):
    #1.如果不是文件，则直接返回False
    if not (os.path.isfile(filename)):
        return False
    #2.截断获取filename最后一个.后面的部分
    suffix=re.split(r'\.', filename)
    #3.判断是否在types中
    return (suffix[-1] in types)

#测试
filename='F:\gitHub\learngit\Python3\.buildpath' # False
filename2='F:\gitHub\learngit\Python3\pythonCodeGit\day1\hash2.py' #True

rs=isCertainFile(filename,['py','txt'])
print(rs)