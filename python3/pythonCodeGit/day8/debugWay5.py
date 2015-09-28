# pdb.set_trace()

import pdb

s = '0'
n = int(s)
pdb.set_trace() # 运行到这里会自动暂停
print(10 / n)

# 运行代码，程序会自动在pdb.set_trace()暂停并进入pdb调试环境，可以用命令p查看变量，或者用命令c继续运行：

#这个方式比直接启动pdb单步调试效率要高很多，但也高不到哪去。



#IDE

#如果要比较爽地设置断点、单步执行，就需要一个支持调试功能的IDE。目前比较好的Python IDE有PyCharm：

#http://www.jetbrains.com/pycharm/

#另外，Eclipse加上pydev插件也可以调试Python程序。