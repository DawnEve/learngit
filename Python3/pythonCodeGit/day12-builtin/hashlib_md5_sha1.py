# import hashlib 
# from hashlib import md5
# print(type(hashlib)) #<class 'module'>
# print(dir(hashlib))
#['__all__', '__builtin_constructor_cache', '__builtins__', '__cached__', '__doc__', '__file__', 
#'__get_builtin_constructor', '__loader__', '__name__', '__package__', '__spec__', '_hashlib', 
#'algorithms_available', 'algorithms_guaranteed', 'md5', 'new', 'pbkdf2_hmac', 'sha1', 'sha224', 'sha256', 
#'sha384', 'sha512']




'''
md5 = hashlib.md5()
md5.update('how to use md5 in python hashlib?'.encode('utf-8'))
 
print(md5.hexdigest()) #d26a53750bc40b38b65a520292f69306
'''

#MD5是最常见的摘要算法，速度很快，生成结果是固定的128 bit字节，通常用一个32位的16进制字符串表示。
def getmd5(str):
    import hashlib 
    md5 = hashlib.md5()
    md5.update(str.encode('utf-8'))
    return md5.hexdigest()

#SHA1的结果是160 bit字节，通常用一个40位的16进制字符串表示。
def getsha1(str):
    import hashlib 
    sha1 = hashlib.sha1()
    sha1.update(str.encode('utf-8'))
    return sha1.hexdigest()

str1='how to use md5 in python hashlib?'
rs=getmd5(str1)
print(getmd5(str1))

print(getsha1(str1))
