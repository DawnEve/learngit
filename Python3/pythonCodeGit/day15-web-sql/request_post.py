#测试py发起get请求
#服务器端php代码
# <?php
# //php code on the server side
# if($_SERVER['REQUEST_METHOD']=="POST"){
#     print("post:<hr>");
#     echo file_get_contents("php://input");
#     echo "<pre>";
#     print_r($_POST);
#}elseif($_SERVER['REQUEST_METHOD']=="GET"){
#    print("get:<hr>");
#    echo file_get_contents("php://input");
#    echo "<pre>";
#    print_r($_GET);
# }else{
#     print("get:<hr>");
#     print_r($_GET);
# }
#https://www.cnblogs.com/goldd/p/5457229.html
from urllib import parse,request
import json

url='http://localhost/bd/server.php'

textmod={'user':'admin','password':'adminPost'}
#textmod = parse.urlencode(textmod)

#json串数据使用
#textmod = json.dumps(textmod).encode(encoding='utf-8') #好像这种不能用
#普通数据使用
textmod = parse.urlencode(textmod).encode(encoding='utf-8')

print('1[post test]   textmod =',textmod)
#输出内容:user=admin&password=admin

header_dict = {'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Trident/7.0; rv:11.0) like Gecko',
               "Content-Type": "application/x-www-form-urlencoded"}
               #"Content-Type": "application/json"}
####https://blog.csdn.net/wwx890208/article/details/84501755
#enctype="multipart/form-data" 的时候 php://input 是无效的。
#如果把content-type换成text/html或者application/json我们在$_POST中返回就为空了，但是数据可以再php://input中获取到。

req = request.Request(url=url, data=textmod, headers=header_dict)

res = request.urlopen(req)
res = res.read()
print('2 res =',res)
#输出内容(python3默认获取到的是16进制'bytes'类型数据 Unicode编码，如果如需可读输出则需decode解码成对应编码)

print('3 res =',res.decode(encoding='utf-8'))# $_POST数组接收不到任何信息
#输出服务器返回的字符

