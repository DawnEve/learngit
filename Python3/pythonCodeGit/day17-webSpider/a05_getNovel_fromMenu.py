#========================================
#爬取电子书  test on linux 《明朝那些事儿》
#----------------------------------------
#步骤：从目录页获取章节链接，接着下载章节。使用多线程。
# 难点： 如果原文有/n则需要加上re.S参数：  re.findall(reg,chapt_html, re.S)

#
# 被block了，怎么办？
#503 Service Temporarily Unavailable - Blocked By Anticc
#Server: kinponet
#Date: 2019-06-10 19:21:04
#Fikker/Webcache/3.7.5
#
#只能猜测：
#1、 服务器检测 host
#2、 服务器检测 cookie
#3、 服务器检测 user-agent
#4、 服务器检测 refer
#把这些改成和浏览器一样的行为试试。 没解决，半小时之后自动解封

import re,os
import requests
import time,random

# https://www.biqugek.com/xs/26/26258/7353880.html

#获取章节url列表
def download_novel_urls():
    url="https://www.biqugek.com/xs/26/26258/"
    html = requests.get(url)#获取页面源码
    #print(html.apparent_encoding) #GB2312
    html_content = html.content#以二进制编码读出页面源码    
    html_content = html_content.decode('GB2312')#指定编码（可在网页源码中搜索charset获取网页编码）
    #print(html_content)
    
    reg = r'<a href="http://www.biqugek.com/26/26258/(.*?)">(.*?)</a>'#筛选章节链接
    urls = re.findall(reg, html_content ) #列表：章节链接
    #
    return urls #urls

#从目录页获取全部章节的链接
urls=download_novel_urls()
print(urls[0], len(urls)) #('7353878.html', '第1章 引子') 375



#根据章节URL，下载章节内容
def get_chapter(url):
    #for url in urls:
    baseURL='https://www.biqugek.com/xs/26/26258/'
    #baseURL="https://www.xinxs.la/159_159857/"  
    #        https://www.xinxs.la/159_159857/8143759.html
    novel_url=baseURL + url[0]#正文地址
    novel_title=url[1]#章节名称    
    #print(novel_url)

    #
    headers={}
    #headers['Accept']='text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3'
    #headers['Accept-Encoding']='gzip, deflate, br'
    #headers['Accept-Language']='zh-CN,zh;q=0.9,en;q=0.8'
    #headers['Cache-Control']='max-age=0'
    #headers['Connection']='keep-alive'
    #headers['Cookie']='fikker-uhUB-1pJV=UtmjcvIBGVQLmrU69l7MQrUISNW0urOL; fikker-uhUB-1pJV=UtmjcvIBGVQLmrU69l7MQrUISNW0urOL'
    #headers['Host']='www.biqugek.com'
    #headers['If-None-Match']='1560165747|'
    headers['Upgrade-Insecure-Requests']='1'
    headers['User-Agent']='Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36'

    #
    #cookies={ 'fikker-uhUB-1pJV':'UtmjcvIBGVQLmrU69l7MQrUISNW0urOL', 'fikker-uhUB-1pJV':'UtmjcvIBGVQLmrU69l7MQrUISNW0urOL' }
    
    # 发出请求
    s=requests.session()
    chapt = s.get(novel_url, headers=headers )#地址所有内容 , cookies=cookies
    tempt = chapt.content
    chapt_html = tempt.decode('GB2312',errors='ignore') #指定编码, 忽略错误 
    #print('chapt_html=', chapt_html)
    
    #
    reg=r'class="linkcontent">(.*?)</div>'#读取正文
    chapt_content = re.findall(reg,chapt_html, re.S)#正则表达式筛选后
    
    chapt_content=chapt_content[0]
    #替换特殊符号
    chapt_content=re.sub(r'&nbsp;',' ',chapt_content)
    chapt_content=re.sub(r'<br />','\n',chapt_content)
    chapt_content=re.sub(r'\n\r\n\r','\r\n',chapt_content) #双换行变单换行
    chapt_content=re.sub(r'www.biqugek.Com</a>』，槟提供精彩小fx', '',chapt_content) #
    #返回
    return [novel_title, chapt_content, novel_url]

#text=get_chapter(urls[1])
#print('title=',text[0])
#print('url=',text[2])
#print(text[1]) #内容


#保存为本地文件
fpath="/home/wangjl/book.txt"
fw=open(fpath,'w',encoding="utf_8_sig")



#循环保存文件
chapter=0
#for i in range(0, 2): 
for i in range(0, len(urls)): #随机时间段后[3s,23s]执行
    chapter+=1
    
    #随机时间暂停，防止被反爬虫机制给墙了. 进度条 [10,25]
    pause=10+15*random.random()
    time.sleep(pause)
    print(chapter, urls[i], "i=",i, 'pause=',pause)

    #保存文本
    text=get_chapter(urls[i])
    #写入文件
    fw.write('='*10+"\n"+ str(text[0])+"\n"+text[1]+"\n")
    fw.write("\n From: "+text[2]+"\n\n\n")
    fw.flush()

fw.close()
print("End",chapter,'path:', os.getcwd()+fpath)

#
#$ wc book.txt 
# 118369   31573 4771938 book.txt
#$ sed -i 's/手机用户请浏览mbiqugek.com阅读，更优质的阅读体验//g' book.txt 
#$ sed -i 's/水印广告测试//g' book.txt
#118369   31334 4733742 book.txt

