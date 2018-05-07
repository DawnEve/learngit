##############
# v0.0.2 去掉全是0的行
##############
import re

fr=open(r'D:/Temp/hg19/all_matrix_APACounts.txt','r')
fw=open(r'D:/Temp/hg19/all_matrix_APACounts-Filter0.txt','a')

#
i=0
for line in fr.readlines():
    i+=1
    if i>400:
        pass #break;

    line=line.strip()
    arr=re.split(r'\t',line)

    if i==1:
        #print(arr[4:])
        fw.write(line+"\n")
    else:
        sum=0
        #print(arr)
        arrNum=arr[4:]
        #print(arrNum)

        for rc in arrNum:
            sum+=int(rc)
        if sum!=0:
            fw.write(line+"\n")
            #print("全是0的行：",str(i))
    
    if i%20000==0:
        print("processing:"+str(i))
#

print('--end--')
