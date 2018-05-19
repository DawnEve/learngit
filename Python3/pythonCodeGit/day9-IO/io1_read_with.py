# 使用with可以省略close
# with open("C:\\Tools\\test.txt", 'r') as f:
#with open("C:\\Tools\\test.txt", 'r', encoding='GBK') as f:
with open("C:\\Tools\\test.txt", 'r', encoding='utf-8') as f:
    print(f.read())