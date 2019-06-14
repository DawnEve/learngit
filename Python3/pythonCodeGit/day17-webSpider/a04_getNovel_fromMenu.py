#========================================
#爬取电子书  test on linux
#----------------------------------------
#获取目录页的标题和链接，逐个下载正文，替换<br>为\n，然后保存到文本文件。
# 难点： 章节目录的链接很混乱，很多没有规律。
#参考 https://blog.csdn.net/lijiachu/article/details/88182884
#模拟真实用户访问：1.访问间隔时间，可能需要多花很多时间，2.header头随机替换(todo)

#《重生资本狂人》
# 1970年代，世界经济秩序剧变，布雷顿森林体系崩溃，石油危机爆发；正向亚洲金融中心前进的香江，也迎来了机遇无限的第一次全民炒股大时代；而一位年轻的项目经理，莫名其妙地闯入了这个华资开始崛起的时空。在这个令人眼花缭乱的大舞台上，数不胜数的奋斗者、投机客、暴发户、豪强、名门、望族、大亨、名流、阔少、名媛、明星、天才、泰斗……你方唱罢我登场。新旧之间，纵有万般不同，但一样不变——穷人仍是富人的燃料，    
#https://www.biqiuge.com/book/37830/22939716.html
#https://wap.biqiuge.com/book_37830/22939716.html


#import urllib.request
import re
import requests
import os
import time,random



#获取章节url列表
def download_novel_urls():
    url = 'https://www.biqiuge.com/book/37830/'
    html = requests.get(url)#获取页面源码
    html_content = html.content#以二进制编码读出页面源码
    html_content = html_content.decode('gbk')#指定编码（可在网页源码中搜索charset获取网页编码）
    #
    reg = r'<dd><a href ="/book/37830/(.*?)">(.*?)</a></dd>'#筛选章节链接
    urls = re.findall(reg,html_content)#列表：章节链接
    #
    return urls

#从目录页获取全部章节的链接
urls=download_novel_urls()
print(urls[6], len(urls)) #('22939716.html', '第0001章 开局一个包') 468


#根据章节URL，下载章节内容
def get_chapter(url):
    #for url in urls:
    novel_url='https://www.biqiuge.com/book/37830/' + url[0]#正文地址
    novel_title=url[1]#章节名称
    #
    chapt = requests.get(novel_url)#地址所有内容
    tempt = chapt.content
    #chapt_html = tempt.decode('gbk')#指定编码
    chapt_html = tempt.decode('gb2312',errors='ignore') #指定编码, 忽略错误 
    
    reg=r'class="showtxt">(.*?)https:'#读取正文
    chapt_content = re.findall(reg,chapt_html)#正则表达式筛选后
    chapt_content=chapt_content[0]
    #替换特殊符号
    chapt_content=re.sub(r'&nbsp;',' ',chapt_content)
    chapt_content=re.sub(r'<br />','\n',chapt_content)
    #chapt_content=re.sub(r'\r\n\r\n','\r\n',chapt_content) #双换行变单换行
    chapt_content=re.sub(r'\n\n\u3000\u3000','',chapt_content) #
    #返回
    return [novel_title, chapt_content, novel_url]

#test
#text=get_chapter(urls[7])
#print(text)




#保存为本地文件
fpath="/home/wangjl/book.txt"
fw=open(fpath,'w',encoding="utf_8_sig")


#循环保存文件
chapter=0
for i in range(6, len(urls)): #随机时间段后[3s,23s]执行
    chapter+=1
    
    #随机时间暂停，防止被反爬虫机制给墙了. 进度条
    pause=3+20*random.random()
    #print(str(i)+' '+str(pause))
    time.sleep(pause)
    print(chapter, urls[i], "i=",i, 'pause=',pause)
    
    #保存文本
    text=get_chapter(urls[i])
    #写入文件
    fw.write('='*10+"\n"+ str(text[0])+"\n"+text[1]+"\n")
    fw.write("\n From: "+text[2]+"\n\n\n")

fw.close()
print("End",chapter,'path:', os.getcwd()+fpath)
