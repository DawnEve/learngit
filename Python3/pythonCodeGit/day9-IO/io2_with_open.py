#原始写法
path='./test.cache'
try:
    f_name=open(path, 'w')
    print('write length:', f_name.write("hello, world!001"))
except Exception as e:
    print(e)
finally:
    if f_name:
        f_name.close()


########
#with语句自动帮我们调用close方法。
with open(r"C:\\Tools\\test.txt", 'w') as f:
    f.write('Hello, world!世界，你好！')