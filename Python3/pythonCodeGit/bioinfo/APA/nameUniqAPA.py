################
# v0.0.1 为每个APA位点命名唯一值-symbol_编号
################

import re

fr=open(r'D:/Temp/hg19/all_matrix_APACounts-Filter0-addSymol-Filter1Symbol-Pct.txt', 'r')
fw=open(r'D:/Temp/hg19/all_matrix_APACounts-Filter0-addSymol-Filter1Symbol-Pct-UniqAPA.txt', 'a')


#记录到文件
def write2file(linesPerSymbol):    
    lineNum=len(linesPerSymbol)#数组个数=行数

    #求百分比, 放大1e4, 并写入文件
    for j in range(lineNum):
        arr=linesPerSymbol[j]
        arr[4]=arr[4]+"_"+str(j+1)
        arr=arr[4:]
        #写入文件
        fw.write('\t'.join(arr)+"\n")


#开始逐行读入
geneDic={}
linesPerSymbol=[]
lines=fr.readlines()
i=0
for lineR in lines:
    i+=1
    
    if i>20:
        pass #break;
    if i%10000==0:
        print("processing line:",i)

    line=lineR.strip();
    arr=re.split(r'\t', line)
    
    if i==1:
        arr=arr[4:]
        arr[0]="APA_"+arr[0]
        fw.write('\t'.join(arr)+"\n")
        continue
    
    if len(geneDic)!=0:
        #如果有内容,且symbol,chr,strand一致
        if (arr[4] in geneDic) and \
            (geneDic[arr[4]][0]==arr[0]) and (geneDic[arr[4]][3]==arr[3]):
            linesPerSymbol.append(arr)
        
            #如果是最后一条，则保存到文件
            if i==len(lines):
                write2file(linesPerSymbol)
        else:
            #如果有不一致的，则字典写入新文件， 并清零字典
            write2file(linesPerSymbol)
            
            #字典清零
            geneDic={}
            linesPerSymbol=[]
    #如果为空，则接收消息，一开始或者删除过时
    if len(geneDic)==0:
        geneDic[arr[4]]=arr
        linesPerSymbol.append(arr)

#close files
fr.close()
fw.close()

print('==end==')

