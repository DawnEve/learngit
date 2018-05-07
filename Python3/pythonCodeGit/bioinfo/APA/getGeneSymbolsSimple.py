###########################
# v0.0.1 简化获得的chr start end strand geneSymbol文件
# v0.0.2 使用int()比较chr坐标。
# bug1:同名但不连续的基因合并，是大错。
# v1.0.1 bug fix1:同名但不连续的基因片段不能合并。
###########################

import re

fr=open(r"D:/Temp/hg19/hg19Symbol.txt",'r')
#ferror=open(r"D:/Temp/hg19/hg19SymbolSimple-Error.txt",'a')
fw=open(r"D:/Temp/hg19/hg19SymbolSimple.txt",'a')

#记录到文件
def write2file(geneDic):
    k,v=list(geneDic.items())[0];
    #print(type(v));print(v)
    newStr=v[0]+"\t"+v[1]+"\t"+v[2]+"\t"+v[3]+"\t"+k+"\n";
    fw.write(newStr)

geneDic={}
lines=fr.readlines()
i=0
for lineR in lines:
    i+=1
    if i>20:
        pass;#break;
    if i%10000==0:
        print("processing line:",i)

    line=lineR.strip();
    arr=re.split(r'\t', line)
    if len(geneDic)!=0:
        #如果有内容,且symbol,chr,strand一致
        if (arr[4] in geneDic) and \
            (geneDic[arr[4]][0]==arr[0]) and (geneDic[arr[4]][3]==arr[3]):
            arrOld=geneDic[arr[4]]
            #print('debug1:',i,":",arr)
            #如果start小，则更新
            if int(arr[1])<int(arrOld[1]):
                arrOld[1]=arr[1]
            #如果end大，则更新
            if int(arr[2])>int(arrOld[2]):
                arrOld[2]=arr[2]
        
            #如果是最后一条，则保存到文件
            if i==len(lines):
                write2file(geneDic)
        else:
            #如果有不一致的，则字典写入新文件， 并清零字典
            write2file(geneDic)
            
            #字典清零
            geneDic={} 
    #如果为空，则接收消息，一开始或者删除过时
    if len(geneDic)==0:
        geneDic[arr[4]]=arr



#print(len(geneDic),geneDic)
fr.close()
fw.close()
print("==end===")
