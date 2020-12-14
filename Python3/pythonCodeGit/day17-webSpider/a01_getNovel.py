#========================================
#爬取电子书  test on linux
#----------------------------------------
#获取正文，替换<br>为\n，然后保存到文本文件。
#1.目标： https://www.haxbook.info/files/article/html/39/39393/index.html
#下载txt整本
import re
import requests


#发出请求
baseURL="https://www.haxbook.info/files/article/html/39/39393/"
chapter=0 #记录章节号
for i in range(3778699,3778955):
    chapter+=1

    #拼凑URL
    url=baseURL+str(i)+'.html'
    respose=requests.get(url)
    assert respose.status_code==200,'Error: requests.get'
    #print(respose.text) #test

    title=re.findall(r'<h1>正文(.*)</h1>',respose.text,re.S)[0] #标题 显示进度
    print('title= ',title)

    rs=re.findall(r'<div id="BookText">(.*?)</div>',respose.text,re.S)[0] #正文
    rs=re.sub("<br>","\n",rs)   #替换<br>或<br /> 为换行
    rs=re.sub("<br />","\n",rs)
    #print('='*10,"\n", rs)

    #写入文件
    with open('/home/wangjl/book.txt','a',encoding="utf_8_sig") as f:
        f.write(str(chapter)+'='*10+"\n"+rs)
        f.write("\n From: "+url+"\n\n\n")

    print(chapter," From: "+url+"\n")
#