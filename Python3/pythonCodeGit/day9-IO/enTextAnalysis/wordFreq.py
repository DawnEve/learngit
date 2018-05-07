# 英文词频分析工具
#功能：
# 统计单词频数
# 输出频数为指定数字的单词
# 输出cet4外的单词
# 输出cet6外的单词
# v0.0.2 输出最长的句子

import re


# 英文时间格式
import time
#from numpy.core.defchararray import isnumeric
#from idlelib.iomenu import encoding
mydate = time.strftime("%b. %d, %Y")


# 打开文件
f=open(r'D:\Temp\sample.txt', 'r', encoding='UTF-8') ;
txt=f.read()



#定义字典
mydict={}
i=0

#print(txt)

#1.使用非字母分割成数组
linearr=re.split(r'[^a-zA-Z]+', txt)

#print('原始',len(linearr),linearr)


#################
#清理：去掉短元素；全部小写
#################
def cleanArr(arr):
    #print('fn begin:',len(arr),arr)
    i=len(arr)-1
      
    while(i>=0):
        #全部小写
        arr[i]=arr[i].lower()
        
        #去掉空格元素、等少于2个字符的元素
        if(len(arr[i])<2):
            #print(i,'=',arr[i])
            del arr[i]
        i-=1
    return arr;

linearr2=cleanArr(linearr)

print('清理后：',len(linearr2),linearr2)

#显示日期和单词数
print(mydate, '|',len(linearr2), 'words') 
#删除空格元素前 2000 words,清理后 1870 words



#################
#输入数组，返回元素频数
#################
def getFreq(arr):
    mydict={}
    #2.用字典进行词频统计
    l=len(arr);
    
    for j in range(l):
        k=arr[j]

        if k in mydict:
            mydict[k]+=1
        else:
            mydict[k]=1
    return mydict;


#返回指定词频的单词
def getWordByFreq(n,dic):
    #print("频数为",n,"的单词如下：")
    arr=[]
    for i in dic.keys():
        if(n==dic[i]):
            arr.append(i)
            #print(i)
    return arr

#获得单词频数
mydict=getFreq(linearr2)


#获得频数的频数
values=list(mydict.values())
#print('values',sorted(values))
mydict2=getFreq(values)
#print('mydic2:',mydict2)

#对dict进行排序
mydict3=sorted(mydict2.items(), key=lambda item:item[0])
print('词频的频数:',mydict3)




###########################
#输出频数为n的单词
###########################
freq=4; #设置频数
print()
print("频数为",freq,"的单词：")
wordlist=getWordByFreq(freq,mydict)
print(len(wordlist),'words: ',wordlist)

'''
i=0;
for w in wordlist:
    i+=1
    if(i%10==0):
        myend="\n" 
    else:
        myend="\t"
    #https://www.cnblogs.com/hwd9654/p/5707920.html
    print(w, end=myend)
'''







print()
###########################
#输出cet4之外的单词
###########################

#从文本读入为数组，一行为一个元素，忽略空行和开头为#的行
def getArrFromTxt(fpath):
    f=open(fpath,'r', encoding='UTF-8')
    word=[]
    for w in f.readlines():
        w=w.strip()
        if w=='' or w[0]=='#':
            continue
        word.append(w)
    f.close()
    return word;

#list去重
def getUniqList(mylist):
    ml=[]
    #overlaps=[]
    for i in mylist:
        if i not in ml:
            ml.append(i)
        #else:
            #overlaps.append(i)
    #print('overlaps>2:',len(overlaps),overlaps)
    return ml;


#读入cet4单词列表
fpath=r'G:\learngit\Python3\pythonCodeGit\day9-IO\enTextAnalysis\cet4-3.txt';
cet4=getArrFromTxt(fpath)
#print('CET4: ', len(cet4), cet4)
cet4=getUniqList(cet4)
#print('CET4 uniq: ', len(cet4), cet4)

#读入cet6单词列表
cet6=getArrFromTxt(r'G:\learngit\Python3\pythonCodeGit\day9-IO\enTextAnalysis\cet6C2.txt');
#print('CET6: ', len(cet6), cet6)
cet6=getUniqList(cet6)
#print('CET6 uniq: ', len(cet6), cet6)

#描述cet4和cet6个数：
print('cet4:',len(cet4), ' words, cet6:', len(cet6),' words.')


# A - B
def ArrMinus(arr1,arr2):
    tmp=[]
    for i in arr1:
        if i not in arr2:
            tmp.append(i)
    return tmp


#唯一化
linearrUniq=getUniqList(linearr2)

# cet4之外的词汇
outsideCET4=ArrMinus(linearrUniq,cet4)
#输出
print('超出cet4的词汇',len(outsideCET4),outsideCET4)


# cet6之外的词汇
outsideCET6=ArrMinus(outsideCET4,cet6)
#输出
print('超出cet6的词汇',len(outsideCET6),outsideCET6);


##############
#输出最长的句子
sentences=re.split(r'[.|?|!|;]+',txt)
tmp=""
for s in sentences:
    if len(s)>len(tmp):
        tmp=s
print('最长句子有 ',len(re.split(r'[^a-zA-Z0-9]+',tmp)),'words. \n',tmp)

#关闭文件
f.close()

print("\nThe end")
