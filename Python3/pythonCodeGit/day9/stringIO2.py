from io import StringIO

f = StringIO()
f.write('hello')
f.write(' -v- ')
f.write('world!')

print(f.getvalue()) #getvalue()方法用于获得写入后的str。
#hello world!


#要读取StringIO，可以用一个str初始化StringIO，然后，像读文件一样读取：
f2 = StringIO('Hello!\nHi!\nGoodbye!')
while True:
    s = f2.readline()
    if s == '':
        break
    print(s.strip())
    
