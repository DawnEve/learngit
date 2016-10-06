#C:\Tools\array

f=open(r'C:\Tools\array\raw_data_3_replicates.txt', 'r') ;

i=0;
for line in f.readlines():
    if i>100:
        break
    print('[',i,']',line.strip()) # 把末尾的'\n'删掉
    i+=1
    
print(i)