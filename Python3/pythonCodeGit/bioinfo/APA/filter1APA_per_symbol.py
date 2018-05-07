####################
# v0.0.1 去掉相同symbol中仅有一行的条目
####################
import re

#1.读取并统计symbol出现的次数
symbolDict={}

fr=open(r'D:/Temp/hg19/all_matrix_APACounts-Filter0-addSymol.txt', 'r')
fw=open(r'D:/Temp/hg19/all_matrix_APACounts-Filter0-addSymol-Filter1Symbol.txt', 'a')
fw2=open(r'D:/Temp/hg19/all_matrix_APACounts-Filter0-addSymol-Filter1Symbol_Once.txt', 'a')

i=0
for lineR in fr.readlines():
    i+=1
    if i>4:
        pass;#break;
    
    line=lineR.strip()
    if i>1:
        arr=re.split(r'\t',line)
        symbol=arr[4]
        if symbol in symbolDict:
            symbolDict[symbol]+=1
        else:
            symbolDict[symbol]=1


print('before:', len(symbolDict),symbolDict) #18313

#2.收集仅出现一次的symbol集合
symbolOnce=[]
for k,v in symbolDict.items():
    if v==1:
        symbolOnce.append(k)
print('after:', len(symbolOnce),symbolOnce) # 2589


#3.对文件重新过滤
fr.seek(0,0)#重置文档指针到最前

i=0
for lineR in fr.readlines():
    i+=1
    if i>30:
        pass;#break;
    
    if i%10000==0:
        print('processing line:',i)
    
    line=lineR.strip()
    if i==1:
        fw.write(lineR)
    else:
        arr=re.split(r'\t', line)
        if arr[4] in symbolOnce:
            fw2.write(lineR)
        else:
            fw.write(lineR)


#close file
fr.close()
fw.close()


print("--end--")