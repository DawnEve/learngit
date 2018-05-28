#C:\Tools\

f=open(r'C:\Tools\test.txt', 'r',encoding='utf-8') ;

i=0;
for line in f.readlines():
    if i>100:
        break
    print('[',i,']',line.strip()) # 把末尾的'\n'删掉
    i+=1
    
print(i)

f.close()