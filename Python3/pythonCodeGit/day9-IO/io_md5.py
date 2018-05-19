import hashlib
#https://blog.csdn.net/haungrui/article/details/6959340

#读取文件
txt=open('G:\learngit\Python3\pythonCodeGit\day9-IO\enTextAnalysis\cet4-3.txt',encoding="utf-8").read()
txtEncode=txt.encode('utf-8') #要先编码才能计算摘要
print(dir(txtEncode),'\n',txtEncode[1:50])


#计算md5
md5_before = hashlib.md5( txtEncode ).hexdigest()
print(len(md5_before),' md5:',md5_before) #0b613ea3f1bb7e3409d56d213c40a79c

#计算sha1
sha1_b=hashlib.sha1(txtEncode).hexdigest()
print(len(sha1_b), 'sha1:',sha1_b) #06b2aba0fe50c0370d2dcaa4c1224597b29273be

