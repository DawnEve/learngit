import os
"""
name: 用python3合并文件夹下所有文本文件的内容  
version: v1.0
auth: JimmyMall@live.com

目的：申请软件著作权需要4000行代码，最好去掉空行和注释。

实现过程：
(1)从外向内依次取出来文件。[ok]
(2)判断是特定后缀的文件。[ok]
(3)然后合并到一个文本中。[ok]
(4)合并时去掉空行 [ok]
(5)去掉注释  not ok

refer:
list dir and filenames
http://www.jbxue.com/article/12968.html

my blog: http://agetouch.blog.163.com/blog/static/2285350902016923179276/
"""

#返回文件深度
def dirDeepth(s):
    return s.count('\\')

#判断是否为某些文件类型
import re
def isCertainFile(filename,types=['py']):
    #1.如果不是文件，则直接返回False
    if not (os.path.isfile(filename)):
        return False
    #2.截断获取filename最后一个.后面的部分
    suffix=re.split(r'\.', filename)
    #3.判断后缀名是否在types中
    return (suffix[-1] in types)


#把文件名和文件内容都追加到一个新的文件中
def append2File(abspath,fw=''):
    fr=open(abspath,'r',encoding='utf-8')
    if fw=='':
        fw=open('d://R_code/total.txt','a',encoding='utf-8')
    
    fw.write("\n\n" + '='*20+"\n")
    fw.write(abspath+'\n')
    fw.write('='*20+"\n")
    for line in fr:
        #如果是空行，则跳过
        if line.strip()!='':
            #如果是注释，则删掉？
            fw.write(line)
    fr.close()
    #fw.close()
 
def mergeAllFileIn(dirname,types=['py','txt']):
    fw=open('d://R_code/total.txt','a',encoding='utf-8')
    #列举文件内容
    for dirpath, dirnames, filenames in os.walk(dirname):
        i=dirDeepth(dirpath) #获取文件深度
        print ('|-'+'-'*i + dirpath)
        for filename in filenames:
            abspath=os.path.join(dirpath,filename)
            #正则匹配：如果是py、txt文件，则打印
            if isCertainFile(abspath, types):
                print(' '+ '-'*i + abspath)
                #写入文件,第一个该目录，第二该文件的内容
                append2File(abspath,fw)

dirname='F:\gitHub\learngit\Python3'
mergeAllFileIn(dirname)


