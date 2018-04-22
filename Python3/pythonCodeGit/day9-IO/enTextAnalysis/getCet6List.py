
#网上下载的cet6词汇表若干，仅仅一列单词，已经除去音标、意思。
#现在需要求并集：先合并，再保留唯一值。

#看看cet4和cet6词汇重叠多少？


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



#读入cet6词汇
cet6A=getArrFromTxt(r'F:\Temp\cet6\cet6A.txt')
cet6C=getArrFromTxt(r'F:\Temp\cet6\cet6C.txt')
cet6W=getArrFromTxt(r'F:\Temp\cet6\cet6W.txt')

cet6C2=getArrFromTxt(r'F:\Temp\cet6\cet6C2.txt')


#判断重复单词
tmp=[]
for w in cet6A:
    if w not in cet6C2:
        tmp.append(w)  

#print("非重复cet6单词 A not in C2", len(tmp), tmp)

print("Cet6 合并:", len(cet6C2), cet6C2)


#list去重
def getUniqList(mylist):
    ml=[]
    for i in mylist:
        if i not in ml:
            ml.append(i)
        else:
            print(i)
    return ml;


#去重
cet6C3=getUniqList(cet6C2)

        
print("uniq Cet6 words:", len(cet6C3), cet6C3)



#也就是最终cet6的列表


# 读取cet4和cet6，看重叠单词
cet4=getArrFromTxt(r'F:\Temp\cet4-3.txt');
cet6=getArrFromTxt(r'F:\Temp\cet6C2.txt');
tmp=[]
for w in cet4:
    if w in cet6:
        tmp.append(w)
print("cet4 and Cet6 overlap:", len(tmp), tmp)

#cet4 and Cet6 overlap: 432