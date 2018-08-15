# -*- coding: utf-8 -*-
# https://blog.csdn.net/CoderPai/article/details/80222947
# Python3-中把图片进行-base64-编码

import base64

#输入图片路径，返回突变的base64编码字符串
def getBase64ByImg(ImgFile):
    with open(ImgFile,"rb") as f:
        # b64encode是编码，b64decode是解码
        base64_data = base64.b64encode(f.read())
        # base64.b64decode(base64data)
        img_base64=str(base64_data,'utf-8') # 重新编码数据
        #print(base64_data)
        return img_base64;

img_base64=getBase64ByImg(r"C:\Users\admin\Desktop\blog_pics\英语读报logo\\lotus_ZH-CN12081917194_1920x1080.jpg")

#前端html中如何直接调用base64编码呢？
#<img src="data:image/jpg;base64,这里是base64的编码"/>
print("<img src='data:image/jpg;base64,%s'>" % (img_base64))
