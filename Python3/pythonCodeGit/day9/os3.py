import os
#dirName = os.path.join("F:\gitHub\learngit\Python3","pythonCodeGit",'day9')
#dirName=os.path.join('C://')

pwd=os.path.abspath('../day9');
dirName=pwd

print(dirName)
#筛选出文件夹子=
# arr=[x for x in os.listdir('.') if os.path.isdir(x)]
print('全部：',os.listdir(dirName))
arr=[x for x in os.listdir(dirName) if os.path.isdir(os.path.join(dirName,x))] 
# 为什么不行？ 要用完整路径，否则就找当前路径
# http://stackoverflow.com/questions/32157127/os-path-isfile-not-work-why
print('文件夹：',arr)

#筛选出python文件

arr2=[x for x in os.listdir(dirName) if os.path.isfile(os.path.join(dirName,x)) and os.path.splitext(x)[1]=='.py']
print('py文件：',arr2)