﻿# 第4种方式是启动Python的调试器pdb，让程序以单步方式运行，

# err.py
s = '0'
n = int(s)
print(10 / n)

# $ python3 -m pdb err.py
# 输入命令n可以单步执行代码：
# 任何时候都可以输入命令p 变量名来查看变量：
# 输入命令q结束调试，退出程序：

# 这种通过pdb在命令行调试的方法理论上是万能的，但实在是太麻烦了，如果有一千行代码，要运行到第999行得敲多少命令啊。还好，我们还有另一种调试方法。