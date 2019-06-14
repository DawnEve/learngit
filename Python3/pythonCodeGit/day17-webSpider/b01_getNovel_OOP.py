#========================================
#爬取电子书  test on linux 《猎头局中局》 OOP 模式
#----------------------------------------
#步骤：从目录页获取章节链接，接着下载章节。使用多线程。
# 难点： 如果原文有/n则需要加上re.S参数：  re.findall(reg,chapt_html, re.S)
# http://book.jrj.com.cn/book/book/bookinfo_424.shtml
# 第二部不完整 II http://www.31wxw8.com/5/5238/

import re,os
import requests
import time,random

class Novel():
    urls=[];
    codeType="GB2312"
    def __init__(self, menuURL, baseURL, filePath): 
        self.__getChapterURL(menuURL) # 从目录页url，获取各章节url和标题
        self.baseURL=baseURL # 章节目录前缀
        self.filePath=filePath #本地（路径和）文件名
        print("Menu Ready!", len(self.urls), "chapters. Run getBook() to start!")
    #获得url链接
    def __getChapterURL(self,url):
        #url="http://book.jrj.com.cn/book/book/bookinfo_424.shtml"
        html = requests.get(url)#获取页面源码
        self.codeType=html.apparent_encoding #GB2312 编码方式
        html_content = html.content#以二进制编码读出页面源码    
        html_content = html_content.decode(self.codeType)#指定编码
        #print(html_content)
        
        reg = r'<li><a href="http://book.jrj.com.cn/book/book/detail_(.*?)" title=".*?">(.*?)</a></li>'#筛选章节链接
        urls = re.findall(reg, html_content ) #列表：章节链接
        self.urls=urls
    
    #从一个链接下载章节内容，传入的是urls中的一个，比如 ('17132.shtml', '02')
    def get_chapter(self, url):
        novel_url=baseURL + url[0]#正文地址
        novel_title=url[1]#章节名称
        
        #设置 headers信息，模拟真实用户访问
        headers={}
        headers['Accept']='text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3'
        headers['Accept-Encoding']='gzip, deflate, br'
        headers['Accept-Language']='zh-CN,zh;q=0.9,en;q=0.8'
        headers['Cache-Control']='max-age=0'
        headers['Connection']='keep-alive'
        headers['Upgrade-Insecure-Requests']='1'
        headers['User-Agent']='Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36'
        
        # 发出请求
        s=requests.session()
        chapt = s.get(novel_url, headers=headers )#地址所有内容 , cookies=cookies
        self.codeType=chapt.apparent_encoding; #print(self.codeType)
        
        tempt = chapt.content
        chapt_html = tempt.decode(self.codeType,errors='ignore') #指定编码, 忽略错误 
        #print('chapt_html=', chapt_html) #debug
        #筛选内容
        reg=r'class="content">(.*?)</div>'#读取正文
        chapt_content = re.findall(reg,chapt_html, re.S)#正则表达式筛选后
        chapt_content=chapt_content[0]
        
        #替换特殊符号
        chapt_content=re.sub(r'\u3000','  ',chapt_content)
        chapt_content=chapt_content.replace("\r\n","")
        chapt_content=re.sub(r'</P><P>','\r\n',chapt_content)
        #
        chapt_content=re.sub(r'\t','',chapt_content)
        chapt_content=re.sub(r'<div class="in">','',chapt_content)
        chapt_content=re.sub(r'<h3>.*</h3>','',chapt_content)
        chapt_content=re.sub(r'<p class="infor">.*</p>','',chapt_content)
        chapt_content=re.sub(r'<P>','',chapt_content)
        chapt_content=re.sub(r'</P>','',chapt_content)
        return [novel_title,chapt_content,novel_url]
    #获得全本，并保存
    def getBook(self):
        #打开文件
        fw=open(self.filePath,'w',encoding="utf_8_sig")
        #循环保存文件
        chapter=0
        #for i in range(0, 2): 
        for i in range(0, len(self.urls)): #随机时间段后[3s,23s]执行
            chapter+=1
            #随机时间暂停，防止被反爬虫机制给墙了. 进度条 [10,25]
            pause=3+15*random.random()
            time.sleep(pause)
            print(chapter, self.urls[i], "[i=",i, len(self.urls), ']pause=',pause)
        
            #获取文本
            text=self.get_chapter(self.urls[i])
            #写入文件
            fw.write('='*10+"\n"+ str(text[0])+"\n"+text[1]+"\n")
            fw.write("\n From: "+text[2]+"\n\n\n")
            fw.flush()
        fw.close()
        print("End",chapter,'path:', os.getcwd()+fpath)

# test(Win似乎总是出错)
menuURL="http://book.jrj.com.cn/book/book/bookinfo_424.shtml"
baseURL="http://book.jrj.com.cn/book/book/detail_"
filePath="bookWJL.txt"
novel=Novel(menuURL,baseURL,filePath)
#novel.get_chapter(novel.urls[1])
novel.getBook()