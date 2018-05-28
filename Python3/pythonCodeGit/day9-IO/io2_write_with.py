#with语句自动帮我们调用close方法。

with open(r"C:\\Tools\\test.txt", 'w') as f:
    f.write('Hello, world!世界，你好！')