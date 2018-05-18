################
# v0.0.1 计算每个symbol中的APA个数
################

import re

#把文档读入到dict中，symbol为key
#fr=open(r'D:/Temp/hg19/all_matrix_APACounts-Filter0-addSymol.txt', 'r')
fr=open(r'D:/Temp/hg19/all_matrix_APACounts-Filter0-addSymol-Filter1Symbol.txt', 'r')

fe=open(r'D:/Temp/hg19/all_matrix_APACounts-Filter0-addSymol-Filter1Symbol-ManyAPA.txt', 'a')


##########
#记录到文件
##########
def writeFe(s):
    pass
    #fe.write(s)

symbolDict={}
i=0
for lineR in fr.readlines():
    i+=1
    if i==1:
        writeFe(lineR)
        continue;
    
    line=lineR.strip()
    
    arr=re.split(r'\t', line)
    symbol=arr[4]
    if symbol not in symbolDict:
        symbolDict[symbol]=[arr]
    else:
        symbolDict[symbol].append(arr)


##########
# 统计较多APA位点的基因
##########
sum=0
lens=[]
tooManyAPA={}
for k,v in symbolDict.items():
    #超过50个APA位点的都是什么基因？
    if len(v)>=50:
        tooManyAPA[k]=len(v)
        writeFe(k+" ("+str(len(v))+') \n')
        for item in v:
            writeFe('\t'.join(item)+'\n')
    
    sum+=len(v)
    lens.append(len(v))
    #print(k, len(v))
print('sum=',sum) #164895
print(lens)

print('超过50个APA位点的基因 ',len(tooManyAPA),'个: ',tooManyAPA)






'''
'''
#可视化这些基因的APA位点个数图
import matplotlib.pyplot as plt
plt.hist(lens, 1000)   #####bins=30
plt.show()



#close files
fr.close()
fe.close()

print('==end==')
