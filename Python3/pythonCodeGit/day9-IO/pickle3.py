import pickle

d=dict(name='Jim',age=12,country='中国')
print(d)

#我们把变量从内存中变成可存储或传输的过程称之为序列化，在Python中叫pickling，在其他语言中也被称之为serialization，marshalling，flattening等等，都是一个意思。
#序列化之后，就可以把序列化后的内容写入磁盘，或者通过网络传输到别的机器上。
pd=pickle.dumps(d)
print(pd)
pd2=pickle.loads(pd)
print('内存中 反序列化后：',pd2)
print('内存中 反序列化后：age =',pd2['age'])
#变量的内容又回来了！


##############################

#序列化写入文件
#pickle.dumps()方法把任意对象序列化成一个bytes，然后，就可以把这个bytes写入文件。或者用另一个方法pickle.dump()直接把对象序列化后写入一个file-like Object：
f = open('dump.txt', 'wb')
pickle.dump(d, f)
f.close()
#看看写入的dump.txt文件，一堆乱七八糟的内容，这些都是Python保存的对象内部信息。

#读取
f2 = open('dump.txt', 'rb')
d2 = pickle.load(f2)
f2.close()
print(d2)
#{'age': 12, 'country': '中国', 'name': 'Jim'}



#
#可能不同版本的Python彼此都不兼容，因此，只能用Pickle保存那些不重要的数据，
# 不能成功地反序列化也没关系。
# 最好用json格式存储结果
#



