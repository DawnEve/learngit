import os


def dirDeepth(s):
    return s.count('\\')

for dirpath, dirnames, filenames in os.walk('F:\gitHub\learngit\Python3'):
    i=dirDeepth(dirpath)
    print ('|-'+'-'*i + dirpath)
    for filename in filenames:
        print (' '+ '-'*i + filename)
    i += 1


"""
list dir and filenames
http://www.jbxue.com/article/12968.html
"""

