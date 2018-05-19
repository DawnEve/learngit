# 英文词频分析工具
#功能：
# 统计单词频数
# 输出频数为指定数字的单词
# 输出cet4外的单词
# 输出cet6外的单词
# v0.0.2 输出最长的句子
# done: 扩充cet4-6复数词: plural() ving ved adjer
# done: 支持单词写到一行，支持任意非字母分隔符。
# doing: 使用缓存词库判断单词是否被修改了。hash判断文本是否修改，决定是否重新生成缓存

'''
别人做的词形还原程序：
https://blog.csdn.net/potato012345/article/details/78091939
https://github.com/Zhangtd/MorTransformation
'''

import re


# 英文时间格式
import time
#from numpy.core.defchararray import isnumeric
#from idlelib.iomenu import encoding
mydate = time.strftime("%b %d, %Y")
time_start=time.time();

# 打开文件
f=open(r'D:\Temp\sample.txt', 'r', encoding='UTF-8') ;
txt=f.read()


##############
#输出最长的句子
sentences=re.split(r'[.|?|!|;\n]+',txt)
tmp=""
for s in sentences:
    if len(s)>len(tmp):
        tmp=s
print('最长句子有 ',len(re.split(r'[^a-zA-Z0-9]+',tmp)),'words. \n',tmp)


##############
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
        
        #去掉空格元素、<=2个字符的元素
        if(len(arr[i])<=2):
            #print(i,'=',arr[i])
            del arr[i]
        i-=1
    return arr;

linearr2=cleanArr(linearr)

#print('清理后：',len(linearr2),linearr2)

#显示日期和单词数
print('\n',mydate, '|',len(linearr2), 'words') 
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







#######################################################################
# 耗时步骤：词语的遍历变换。
# 在dustbin文件夹中保存缓存文件，
#    如果不存在就创建缓存，
#    如果存在，判断hash。
#        如果没修改，则使用缓存，
#        如果使用了，则重新生成缓存。
#######################################################################

print()
###########################
#输出cet4之外的单词
###########################

#求单词复数形式:名词复数、动词三单。
def plural(word):
    if word[-2:] in ["ey", 'ay','an']: #journeys way pan
        return word+'s'
    if word.endswith('y'):  
        return word[:-1]+'ies'  
    elif word[-1] in 'sx' or word[-2:] in ['sh','ch']:  
        return word+'es'  
    elif word.endswith('an'):  
        return word[:-2]+'en'  
    else:  
        return word+'s'

# 动词进行时 ving https://wenku.baidu.com/view/c55f48bc26fff705cc170aef.html
def ving(word):
    #内函数，re.sub需要的
    def fn(matched):
        tmp=matched.groups()
        return tmp[0]+tmp[1]+"ing"
    #
    #如果是元音+辅音结尾，则双写辅音加ing： cut cutting, overlapping, span spanning
    if re.match(r'.*[aeiou]{1}(t|p|n)$', word):
        return re.sub(r'(.*[aeiou]{1}(t|p|n)$)',fn,word)
    '''
    word="cut"
    if word[-2:] in ('ut', 'ap'):
        print( 'origin: ', word+word[-1]+"ing\n" )
    #
    if word.endswith('ut'):
        return word+"ting"
    if word.endswith('ap'):
        return word+"ping"
    #span spanning
    if word.endswith('an'):
        return word+"ning"
    '''
    if word.endswith('ee'):
        return word+"ing"
    if word.endswith('e'):
        return word[:-1]+'ing';
    else:
        return word+'ing'

# 动词过去式
def ved(word):
    #admit
    if word[-2:] == 'it':
        return word+'ted'
    #drop dropped, map mapped, 
    if word[-2:] in ['ap','op']:
        return word+'ped'

    #employ employed, play played
    if word[-2:] in ['oy','ay']:
        return word+'ed'
    
    if word.endswith('y'):
        return word[:-1]+'ied'
    elif word.endswith('e'):
        return word+'d'
    else:
        return word+'ed'
# 形容词比较级 adjer
def adjer(word):
    #easy easier
    if word[-1:] =='y':
        return word[:-1]+"ier"
    elif word.endswith('e'):
        return word+'r'
    return word+"er"

#从文本读入为数组，一行为一个元素，忽略空行和开头为#的行
#支持一行写多个单词，可以用非字母隔开：空格 / ,等
def getArrFromTxt(fpath):
    import re;
    f=open(fpath,'r', encoding='UTF-8')
    word=[]
    for lineR in f.readlines():
        line=lineR.strip()
        if line=='' or line[0]=='#':
            continue
        arr=re.split(r'[^A-Za-z]+',line)
        for eachword in arr:
            if len(eachword)<=1: #1个字符级以下的单词过滤掉。go还是需要的
                continue;
            if eachword not in word:
                word.append(eachword)
    f.close()
    return word;

#扩充词汇表：名词复数； ving；
def extendWords(wordlist):
    newlist=[]
    for w in wordlist:
        #本身加入字典
        if w not in newlist:
            newlist.append(w);
        #复数加入字典
        ws=plural(w);
        if ws not in newlist:
            newlist.append(ws)
        #ving加入字典
        wing=ving(w);
        if wing not in newlist:
            newlist.append(wing)
        #v-ed加入字典
        wed=ved(w);
        if wed not in newlist:
            newlist.append(wed)
        #adj er
        wer=adjer(w);
        if wer not in newlist:
            newlist.append(wer)
    #仅保留唯一值
    return getUniqList(newlist);

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


###############################
#读入cet4单词列表
fpath4=r'G:\learngit\Python3\pythonCodeGit\day9-IO\enTextAnalysis\cet4-3.txt';
cet4R=getArrFromTxt(fpath4)
cet4=extendWords(cet4R)


#读入cet6单词列表
fpath6=r'G:\learngit\Python3\pythonCodeGit\day9-IO\enTextAnalysis\cet6C2.txt'
cet6R=getArrFromTxt(fpath6);
cet6=extendWords(cet6R)

#读入cetOver单词列表
fpathO=r'G:\learngit\Python3\pythonCodeGit\day9-IO\enTextAnalysis\cetOver.txt'
cetOR=getArrFromTxt(fpathO)
cetO=extendWords(cetOR)




#描述cet4和cet6个数：
print('原始词汇 cet4/6/O:',len(cet4R),  len(cet6R), len(cetOR),' words.')
print('扩充后的 cet4/6/O:',len(cet4), len(cet6), len(cetO),' words.\n')


# A - B
def ArrMinus(arr1,arr2):
    tmp=[]
    for i in arr1:
        if i not in arr2:
            tmp.append(i)
    tmp.sort()#排序
    return tmp


#唯一化
linearrUniq=getUniqList(linearr2)


####################################################
# cet4之外的词汇
outsideCET4=ArrMinus(linearrUniq,cet4)
#输出
print('超出cet4的词汇',len(outsideCET4),outsideCET4)


# cet6之外的词汇
outsideCET6=ArrMinus(outsideCET4,cet6)
#输出
print('超出cet6的词汇',len(outsideCET6),outsideCET6);

# cetO之外的词汇
outsideCETO=ArrMinus(outsideCET6,cetO)
#输出
print('超出cetO的词汇',len(outsideCETO),outsideCETO);


#关闭文件
f.close()

print("\nThe end", time.time()-time_start) #The end 10.206275939941406