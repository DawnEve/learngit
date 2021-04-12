# 白色变透明，输出png
# https://stackoverflow.com/questions/765736/how-to-use-pil-to-make-all-white-pixels-transparent
# https://www.codercto.com/a/32221.html
import os
os.chdir("G:\\xampp\\htdocs\\webPan.py\\static\\images\\dustbin\\")

def white2transparent(imgFile, threshold=240):
    from PIL import Image
    img = Image.open(imgFile)
    img = img.convert("RGBA")
    datas = img.getdata()
    newData = []
    for item in datas:
        if item[0] > threshold and item[1] > threshold and item[2] > threshold:
            newData.append((255, 255, 255, 0))
        else:
            newData.append(item)
    
    img.putdata(newData)
    return(img)

def save(img, outputFile="img1234.png"):
    img.save(outputFile, "PNG")



def resize(img):
    # 缩放
    w, h = img.size
    img.thumbnail((w//6, h//6))
    return img


# test 1
#imgFile="34.png"
#save( white2transparent(imgFile, 200) )
#print("==end==")



def replaceByPixel(imgFile):
    from PIL import Image
    
    img = Image.open(imgFile)
    img = img.convert("RGBA")
    
    pixdata = img.load()
    
    width, height = img.size
    for y in range(height):
        for x in range(width):
            if pixdata[x, y] == (129, 131, 241, 255):
                pixdata[x, y] = (129, 131, 241, 200)
    
    return(img)
# test2
imgFile="icon_music.png"
save( replaceByPixel(imgFile) )
print("==end==")