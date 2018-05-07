#!/usr/bin/env python3
# -*- coding: utf-8 -*-

' a test module ' #任何模块代码的第一个字符串都被视为模块的文档注释；


#为什么运行不了？因为缩进不完善！

__author__ = 'Michael Liao' #当你公开源代码后别人就可以瞻仰你的大名

#系统模块，引入命令行变量
import sys 

def test():
	args = sys.argv #系统参数，从命令行获取参数
	if len(args)==1:
            print('Hello, world!')
	elif len(args)==2:
		 print('Hello, %s!' % args[1])
	else:
		print('Too many arguments!')

if __name__=='__main__':
    test()
    
#>>> import MHello
#>>> MHello.test()
