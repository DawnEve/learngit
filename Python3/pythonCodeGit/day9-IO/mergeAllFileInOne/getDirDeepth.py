
#python统计字符串中指定字符出现的次数
#http://www.jb51.net/article/63476.htm

# format 1
n='F:\gitHub\learngit\Python3\pythonCodeGit'.count('\\')
print(n) #4

# format 2
def dirDeepth(s):
    return s.count('\\')

print(dirDeepth('F:\gitHub\learngit\Python3\pythonCodeGit'))