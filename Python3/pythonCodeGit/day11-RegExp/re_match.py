import re


s = r'ABC\-001' # Python的字符串
# 对应的正则表达式字符串不变：
# 'ABC\-001'

#re.match(r'^\d{3}\-\d{3,8}$', '010-12345')

#match()方法判断是否匹配，如果匹配成功，返回一个Match对象，否则返回None。
#常见的判断方法就是：
def match(str):
    #test = '用户输入的字符串'
#     if re.match(r'正则表达式', test):
    if re.match(r'^\d{3}\-\d{3,8}$', str):
        print('ok')
    else:
        print('failed')

match('book')
match('010-12345')

