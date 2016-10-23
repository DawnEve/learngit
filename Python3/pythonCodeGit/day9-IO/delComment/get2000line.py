
line_count = len(open('backup/after.txt','rU',encoding='utf-8').readlines()) #7950
print(line_count)


fr=open('backup/after.txt','r',encoding='utf-8')
fw=open('backup/2000lines.txt','a',encoding='utf-8')

import re 

i=0
for line in fr:
    line2=line.strip() #去掉收尾的空格
    i+=1
    if i<2010 or i>(line_count-1990):
        fw.write(line)
        if i==2009:
            fw.write('\n\n'+'-'*10+'the middle'+'-'*10+'\n\n')
