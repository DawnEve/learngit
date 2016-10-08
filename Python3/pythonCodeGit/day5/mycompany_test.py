from mycompany import abc #调用的包内文件
abc.test(1)

from mycompany import xyz
xyz.test(2)

import mycompany  #就在包内的__init__.py中定义
mycompany.test(3)


#包内调用两个
mycompany.test2(4)
 
mycompany.uniquefn(100) #为什么不能省略模块/包名？