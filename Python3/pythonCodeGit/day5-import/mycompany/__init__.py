#__init__.py可以是空文件，
#也可以有Python代码，因为__init__.py本身就是一个模块，而它的模块名就是mycompany

def test(n):
    print('From mycompany base:',n)
    
def test2(n):
    #import abc
    abc.test(n)
    xyz.test(n)
    
def uniquefn(n):
    print('unique fn',n)