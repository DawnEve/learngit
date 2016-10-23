#StringIO操作的只能是str，如果要操作二进制数据，就需要使用BytesIO。
#BytesIO实现了在内存中读写bytes，我们创建一个BytesIO，然后写入一些bytes：


from io import BytesIO

f = BytesIO()
f.write('中文'.encode('utf-8'))
print(f.getvalue())
#中文 b'\xe4\xb8\xad\xe6\x96\x87'
#中国 b'\xe4\xb8\xad\xe5\x9b\xbd'
#其中 b'\xe5\x85\xb6\xe4\xb8\xad'
#与其 b'\xe4\xb8\x8e\xe5\x85\xb6'
# 请注意，写入的不是str，而是经过UTF-8编码的bytes。
# utf-8差不多是3个数字编码一个汉字