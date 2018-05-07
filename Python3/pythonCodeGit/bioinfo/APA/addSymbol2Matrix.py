#################
# v0.0.1 位matrix添加symbol列
# v0.0.2 使用int()比较chr的坐标。
# v0.0.3 error文件分成两个Null和Multi。
#
# 比较慢，大概需要20min。
#################
import re

import time
def getTime():
    now_time = time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time()))
    return now_time

#原文件
fr=open(r"D:/Temp/hg19/all_matrix_APACounts-Filter0.txt", 'r')
#注释文件
fSymbol=open(r"D:/Temp/hg19/hg19SymbolSimple.txt", 'r')

fw=open(r"D:/Temp/hg19/all_matrix_APACounts-Filter0-addSymol.txt", 'a')
ferrorNull=open(r"D:/Temp/hg19/all_matrix_APACounts-Filter0-addSymol-ErrorNull.txt", 'a')
ferrorMulti=open(r"D:/Temp/hg19/all_matrix_APACounts-Filter0-addSymol-ErrorMulti.txt", 'a')

#用字典保存gene symbol文件
symbolDict={}
for lineRaw in fSymbol.readlines():    
    line=lineRaw.strip()
    arrS=re.split(r'\t',line)
    if arrS[4] not in symbolDict:
        symbolDict[arrS[4]]=arrS[0:4]
#print(len(symbolDict),': ', symbolDict) #27737

#由坐标查询基因symbol
def getSymbolByCoord(arr):
    counter=0
    symbol="Null"
    for k,v in symbolDict.items():
        if(v[0]==arr[0] and v[3]==arr[3]):
            if(int(arr[1])>=int(v[1]) and int(arr[2])<=int(v[2])):
            #if(arr[1]>=v[1] and arr[2]<=v[2]):#坐标之间的比较是数字形式
                counter+=1
                symbol=k
                #print(k);
            if counter>1:
                break;
    if counter<=1:
        return symbol;
    else:
        return "Multi"


##########################
#由坐标查询所有符合的基因symbol，手动检验用
##########################
def getSymbolByCoord_Manual(arr):
    print('find:',arr)
    counter=0
    symbol="Null"
    for k,v in symbolDict.items():
        if(v[0]==arr[0] and v[3]==arr[3]):
            if(int(arr[1])>=int(v[1]) and int(arr[2])<=int(v[2])):
            #if(arr[1]>=v[1] and arr[2]<=v[2]):
                counter+=1
                symbol=k
                print(k,'=',v);
    if symbol=="Null":
        print(symbol)            
################################
#getSymbolByCoord_Manual(['chr13','111532537','111532539','-'])
#assert 0,'stop here.'

       

i=0
for lineRaw in fr.readlines():
    i+=1
#    if i>10:
#        pass #break;
    if i%10000==0: #进度条提示： 共 34 2559
        now=getTime()
        print("processing lines:",i,' -- ',now)

    line=lineRaw.strip()
    arr=re.split(r'\t', line)
    #第一行是标题
    if i==1:
        pass
        arr[4:4]=["symbol"]
        fw.write("\t".join(arr)+"\n")
    else:
        # 第一行之外的部分
        #分割成数组
        ginfo=arr[0:4]
        symbol=getSymbolByCoord(ginfo)
        if symbol=='Null':
            ferrorNull.write(lineRaw)
        elif symbol=='Multi':
            ferrorMulti.write(lineRaw)
        else:
            arr[4:4]=[symbol]
            fw.write("\t".join(arr)+"\n")

#close files
fr.close()
fSymbol.close()
fw.close()
ferrorNull.close()
ferrorMulti.close()

print('==End==') #158 947行。
