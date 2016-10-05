#先用pip安装库
#要安装一个第三方库，必须先知道该库的名称，可以在官网或者pypi上搜索，
#pip install Pillow
#引入库
from PIL import Image

im = Image.open('test.jpg')
print(im.format, im.size, im.mode)

#缩小2倍
im.thumbnail((im.size[0]/2, im.size[0]/2))
im.save('thumb2.jpg', 'JPEG')

#缩小4倍
im.thumbnail((im.size[0]/4, im.size[0]/4))
im.save('thumb4.jpg', 'JPEG')