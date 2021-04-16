import os

# 根据后缀名，获取文件名
def get_image_paths(folder):
    return (os.path.join(folder, f) 
            for f in os.listdir(folder) 
            if 'jpg' in f or 'png' in f)

folder = os.path.abspath(
        'C://Users//admin//Desktop//blog_pics//seq')
rs=get_image_paths(folder)
print(rs)
print(dir(rs)) #生成器

#打印文件
for i in rs:
    print(i)
