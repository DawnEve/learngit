#py搜索包时的路径顺序

import sys
arr=sys.path

def status():
    global arr
    print('len =', len(arr),': ',arr[-1])

print(arr)
#['D:\\Program Files\\Python36\\DLLs', 
# 'D:\\Program Files\\Python36\\lib', 
# 'D:\\Program Files\\Python36', 
# 'D:\\Program Files\\Python36\\lib\\site-packages', 
# 'D:\\Program Files\\Python36\\python36.zip']

status()
# eclipse
# ['F:\\gitHub\\learngit\\Python3\\pythonCodeGit\\day5', 
# 'C:\\Program Files (x86)\\Python35-32\\DLLs', 
# 'C:\\Program Files (x86)\\Python35-32\\lib', 
# 'C:\\Program Files (x86)\\Python35-32', 
# 'C:\\Program Files (x86)\\Python35-32\\lib\\site-packages', 
# 'C:\\Program Files (x86)\\Python35-32\\python35.zip']


#如果我们要添加自己的搜索目录，有两种方法：
#1.一是直接修改sys.path，添加要搜索的目录：
sys.path.append('/Users/defined/Python3/scripts/path')
#这种方法是在运行时修改，运行结束后失效。
status()

#第二种方法是设置环境变量PYTHONPATH，该环境变量的内容会被自动添加到模块搜索路径中。
#设置方式与设置Path环境变量类似。注意只需要添加你自己的搜索路径，Python自己本身的搜索路径不受影响。


#===================
print('===========引入自定义类===========')
sys.path.append('G:\\learngit\\Python3\\pythonCodeGit\\day5-import\\')
# status()

print("path:",len(sys.path), sys.path)
import mycompany
mycompany.test(12)

import mycompany.abc
mycompany.abc.test(120)


#所以相比import math，from math import *的后续代码都可省略 math. 前缀 
#不过不建议使用，因为可能导致命名冲突、混乱，不利于编写清晰、简单的代码
from math import *
print(pi)
print(sin(3.1415926/6))#0.5

from mycompany import xyz #而这种引入可以省略部分前缀
xyz.test(1200)

from mycompany.xyz import test #完全省略前缀
test(1202)

#或者重命名，防止命名冲突
from mycompany.xyz import test as testXYZ 
testXYZ(1300)

