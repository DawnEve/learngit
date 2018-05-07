###########################
# v0.0.1 获得chr start end strand geneSymbol文件
###########################

#合并 hg19_ucsc_genes.gtf 和 hg19_ucsc_names.txt
#相当于为gtf文件增加geneSymbol列。获得 hg19Symbol.txt
import re 

f1=open(r"D:\Temp\hg19\hg19_ucsc_genes.gtf",'r');
f2=open(r'D:\Temp\hg19\hg19_ucsc_names.txt','r');
f3=open(r"D:\Temp\hg19\hg19Symbol.txt",'a');

# 把已知gid和symbol直接保存到字典
mydic={}
for line in f2.readlines():
    str=line.strip()
    arr=re.split('\t', str)
    if arr[1] not in mydic:
        mydic[arr[1]]=arr[2]


# 在字典中查找gid对应的geneSymbol
def getSymbolByID(gid):
    if gid in mydic:
        return mydic[gid]
    #没有找到
    return 'NullSymbol-'+gid;


#主程序
i=0
for line in f1.readlines():
    
    i+=1
    if i>40:
        pass;
        #break;
    
    #提取gene_id
    str=line.strip()   
    str2=re.split(r'";',str)[0]
    str3=re.split(r'gene_id "',str2)[1]
    symbol=getSymbolByID(str3)
    
    #构建新字符串    
    arr=re.split(r'\t',str)
    strN=arr[0]+"\t"+arr[3]+"\t"+arr[4]+"\t"+arr[6]+"\t"+symbol
    f3.write(strN+"\n") #保存到新文件

f1.close()
f2.close()
f3.close()



#
print("--end--")

#result file:
# chr1    11874    12227    +    DDX11L1
# chr1    12613    12721    +    DDX11L1
# chr1    13221    14409    +    DDX11L1
# chr1    11874    12227    +    DDX11L1
# chr1    12646    12697    +    DDX11L1
# chr1    13221    14409    +    DDX11L1
# chr1    12190    12192    +    DDX11L1
# chr1    12190    12227    +    DDX11L1
# chr1    11874    12227    +    DDX11L1
# chr1    12595    12721    +    DDX11L1
# chr1    12595    12721    +    DDX11L1
# chr1    13403    13636    +    DDX11L1
# chr1    13637    13639    +    DDX11L1
# chr1    13403    14409    +    DDX11L1
# chr1    14362    14829    -    WASH7P
# chr1    14970    15038    -    WASH7P