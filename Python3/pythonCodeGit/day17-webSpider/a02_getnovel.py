#========================================
#爬取电子书  test on linux
#----------------------------------------
#获取正文，替换<br>为\n，然后保存到文本文件。
#1.目标： https://www.haxbook.info/files/article/html/39/39393/index.html
#2.可能互补的章节 https://www.smxs.cc/book/worenshide100genvhai/

#下载txt整本

import re
import requests


#发出请求
baseURL="https://www.smxs.cc/book/worenshide100genvhai/"
chapter=0
for i in range(10010,11100,10):
#for i in range(10010,10090,10): #test
    chapter+=1 # 章节 
    url=baseURL+str(i)+'.html'
    respose=requests.get(url)
    assert respose.status_code==200,'Error: requests.get'

    #print(respose.text) #test

    title=re.findall(r'<h1>(.*)</h1>',respose.text,re.S)[0] #标题 显示进度
    print('title= ',title)

    rs=re.findall(r'<div id="content">(.*?)</div>',respose.text,re.S)[0] #正文
    rs=re.sub("<p>","\n",rs)   #替换<br>或<br /> 为换行
    rs=re.sub("</p>","\n",rs)
    rs=re.sub("<em  class=\" tc-f4\">作者：德俊</em>阅读更多网络流行小说，请点击 ，请使用360或者搜狗搜索内兄小说网！","",rs)
    #print(chapter,'='*10,"\n", rs)

    #写入文件
    with open('/home/wangjl/book.txt','a',encoding="utf_8_sig") as f:
        f.write('='*10+"\n"+ str(chapter)+" "+title+"\n"+rs)
        f.write("\n From: "+url+"\n\n\n")

    print(chapter," From: "+url+"\n")

# 使用sed去掉这一行
# 小提示：按 回车[Enter]键 返回书目，按 ←键 返回上一章， 按 → 键 进入下一章。
# sed -i '/小提示：按 回车/d' book.txt
