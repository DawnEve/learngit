import re
 
#可以匹配
strs_right=["someone@gmail.com",
           "bill.gates@microsoft.com",
           "jimmy.Wang@zzu.edu.cn",
           ]

#不能匹配
strs_wrong=[
    "@gmail.com",
    "w@.com",
    "w@gmail.",
    "w@gmail.com.",
    "w@gmail.com", #这个是可以的 todo
    ".@gmail.com",
    "w.@cn.gmail.com",
    ".w@cn.gmail.com"
    ]

"""
是否是邮箱：
1.要有一个@
2.@前面至少一个字符,且不能只有一个(?)
3.@后面至少一个点，点前后至少要各有一个字符
"""
def isEmail(str):
    #rs=re.match(r'^(\w+[\w\.]*)@{1}(\w+[\w\.]+)$',str) # 不能否认 w@gmail.
    #reg=r'^[0-9a-z\_\.]+@[0-9a-z]+\.[a-z]+$' #不行，缺陷太多

    myreg=r'^(\w+[\w\.]*?\w+)@{1}(\w+[\w\.]+?\w+)$' #完美匹配上述email规则

    rs=re.match(myreg,str)
    if rs!=None:
        return True,rs
    return False,rs

def test(strs,expect_result=True):
    flag=0
    for str in strs:
        rs=isEmail(str)
        #print(rs)
        if(rs[0]!=expect_result): #只报告不符合预期的值
            print(str,' cannot pass the test!')
            flag += 1
    if flag==0:
        print('----All items passed the test----')
    else:
        print('--Test over,%d item(s) can not pass'%flag)

test(strs_right)
#test(strs_wrong,False)
#print(isEmail(strs_wrong[2]))

# print(re.match(r'^\w*',str1)) #<_sre.SRE_Match object; span=(0, 7), match='someone'>
# print(re.match(r'^\w*$',str1)) #None




def test2(strs,expect_result=True):
    for str in strs:
        rs=isEmail(str)
        #print(rs)
        if rs[0]==expect_result:
            r=rs[1]
            #print(str,' --> ',r)
            if expect_result==True:
                print(str,' --> ',r,r.groups())
            else:
                print(str,' --> ',' is not an Email Address')
        else:
            print(str,' is NOT ',expect_result)
    print('----Test over----')