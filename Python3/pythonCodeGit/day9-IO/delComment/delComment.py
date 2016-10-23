#删除单独的注释行，其他的重新保存到另一个文件
#块状注释没有处理
#后半句还是注释的没有识别

fr=open('backup/total3.txt','r',encoding='utf-8')
fw=open('backup/after.txt','a',encoding='utf-8')

import re 

i=0
for line in fr:
    line2=line.strip() #去掉收尾的空格
    
    if re.match("//",line2)!=None:
        print('[', i ,']:',line)
        i += 1
    else:
        fw.write(line)
### 1514 行注释  