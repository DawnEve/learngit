#先用pip安装库
#要安装一个第三方库，必须先知道该库的名称，可以在官网或者pypi上搜索，
#pip install Pillow
#引入库
from PIL import Image


im = Image.open('test.jpg')
print(im.format, im.size, im.mode)

im.thumbnail((500, 1700))
im.save('thumb2.jpg', 'JPEG')