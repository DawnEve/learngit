path2=r'C:\Tools\sample.txt'

#readline()方法对文件进行迭代:按行迭代
fr=open(path2, 'r',encoding='utf-8') ;
j=0
while True:
    j+=1
    if(j>5):
        break;
    lineR=fr.readline();#fr.readline(size=-1) 不加数字size，是读取一行，否则是读取size个字符
    if not lineR:
        break;
    print("line> ", lineR.strip())
fr.close();print();

#readlines()方法
f=open(path2, 'r',encoding='utf-8') ;
lines=f.readlines();
i=0; 
print("len(lines)=",len(lines))

for line in lines:
    if i>5:
        break
    print('[',i,']',line.strip()) # 把末尾的'\n'删掉
    i+=1
print(i)
f.close()