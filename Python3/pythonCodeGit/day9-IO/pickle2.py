import pickle
import os
os.chdir('c:/Tools/') #定义临时文件地点
#print(os.path.abspath(".")) #打印当前路径

d=dict(name='Jim',age=12,country='中国')
print('1>',d)

#我们把变量从内存中变成可存储或传输的过程称之为序列化，在Python中叫pickling，在其他语言中也被称之为serialization，marshalling，flattening等等，都是一个意思。
#序列化之后，就可以把序列化后的内容写入磁盘，或者通过网络传输到别的机器上。
pd=pickle.dumps(d)
print("2>", pd) #已经序列化了
pd2=pickle.loads(pd)
print('内存中 反序列化后：',pd2)
print('内存中 反序列化后：age =',pd2['age'])
#变量的内容又回来了！


##############################
# 可以把 pickle.dumps(d) 结果保存到文件，或者使用 pickle.dump(dict, file) 直接写入文件
##############################


#序列化写入文件
#pickle.dumps()方法把任意对象序列化成一个bytes，然后，就可以把这个bytes写入文件。或者用另一个方法pickle.dump()直接把对象序列化后写入一个file-like Object：
f = open('dump.txt', 'wb')
pickle.dump(d, f)
f.close()
#看看写入的dump.txt文件，一堆乱七八糟的内容，这些都是Python保存的对象内部信息。

#读取
f2 = open('dump.txt', 'rb')
d2 = pickle.load(f2) #内容相同，但是变量已经变了。
f2.close()
print(d2)
#{'age': 12, 'country': '中国', 'name': 'Jim'}

#
#可能不同版本的Python彼此都不兼容，因此，只能用Pickle保存那些不重要的数据，
# 不能成功地反序列化也没关系。
# 最好是用json格式存储结果
#
