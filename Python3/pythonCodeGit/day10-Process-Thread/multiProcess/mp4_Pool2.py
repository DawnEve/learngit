# 上边这段代码的主要工作就是将遍历传入的文件夹中的图片文件，一一生成缩略图，并将这些缩略图保存到特定文件夹中。
#这我的机器上，用这一程序处理 6000 张图片需要花费 27.9 秒。 
#map 函数并不支持手动线程管理，反而使得相关的 debug 工作也变得异常简单。

# map在爬虫的领域里也可以使用，比如多个URL的内容爬取，可以把URL放入元祖里，然后传给执行函数。
import os 
import PIL 

from multiprocessing import Pool 
from PIL import Image

SIZE = (75,75)
SAVE_DIRECTORY = 'thumbs'

def get_image_paths(folder):
    return (os.path.join(folder, f) 
            for f in os.listdir(folder) 
            if 'jpg' in f or 'png' in f)

def create_thumbnail(filename):
    im = Image.open(filename)
    im.thumbnail(SIZE, Image.ANTIALIAS)
    base, fname = os.path.split(filename) 
    save_path = os.path.join(base, SAVE_DIRECTORY, fname)
    im.save(save_path)
    print(save_path)

if __name__ == '__main__':
    import os
    print( os.getcwd() )

    folder = os.path.abspath(
        'C://Users//admin//Desktop//blog_pics//seq')
    os.mkdir(os.path.join(folder, SAVE_DIRECTORY))
    #raise(Exception,"XX")

    images = get_image_paths(folder)

    pool = Pool()
    pool.map(create_thumbnail, images) #关键点，images是一个可迭代对象
    pool.close()
    pool.join()
    print("==done==")
