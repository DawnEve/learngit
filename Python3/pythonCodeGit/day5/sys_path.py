import sys
arr=sys.path

def status():
    global arr
    print(len(arr))
    print(arr[-1])
# cmd
#             ['', 
#             'C:\\Program Files (x86)\\Python35-32\\python35.zip', 
#             'C:\\Program Files (x86)\\Python35-32\\DLLs', 
#             'C:\\Program Files (x86)\\Python35-32\\lib', 
#             'C:\\Program Files (x86)\\Python35-32', 
#             'C:\\Program Files (x86)\\Python35-32\\lib\\site-packages']
status()
# eclipse
# ['F:\\gitHub\\learngit\\Python3\\pythonCodeGit\\day5', 
# 'C:\\Program Files (x86)\\Python35-32\\DLLs', 
# 'C:\\Program Files (x86)\\Python35-32\\lib', 
# 'C:\\Program Files (x86)\\Python35-32', 
# 'C:\\Program Files (x86)\\Python35-32\\lib\\site-packages', 
# 'C:\\Program Files (x86)\\Python35-32\\python35.zip']

#如果我们要添加自己的搜索目录，有两种方法：
#一是直接修改sys.path，添加要搜索的目录：
sys.path.append('/Users/defined/Python3/scripts/path')
#这种方法是在运行时修改，运行结束后失效。
status()

#第二种方法是设置环境变量PYTHONPATH，该环境变量的内容会被自动添加到模块搜索路径中。
#设置方式与设置Path环境变量类似。注意只需要添加你自己的搜索路径，Python自己本身的搜索路径不受影响。


sys.path.append('F:\\gitHub\\learngit\\Python3\\pythonCodeGit\\day5\\')
status()

import mycompany
mycompany.test(100)
