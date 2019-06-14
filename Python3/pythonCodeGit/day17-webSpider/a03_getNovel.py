#========================================
#爬取电子书  test on linux
#----------------------------------------
#获取正文，替换<br>为\n，然后保存到文本文件。
#1.目标： https://www.haxbook.info/files/article/html/39/39393/index.html
#2.可能互补的章节 https://www.smxs.cc/book/worenshide100genvhai/
#3.另一个版本 http://www.txt81.com/read/14314.html

#下载txt整本

import re
import requests


f=open('/home/wangjl/book.txt','w',encoding="utf_8_sig")


#发出请求
baseURL="http://www.txt81.com/read/14314_"
chapter=0
#for i in range(10010,11100,10):
for i in range(1,478): #test
    chapter+=1 # 章节 
    url=baseURL+str(i)+'.html'
    respose=requests.get(url)
    assert respose.status_code==200,'Error: requests.get'
    
    #print(2,respose.encoding) #乱码处理
    respose_text=respose.text.encode('ISO-8859-1').decode("utf-8")
    
    
    #print(respose_text) #test    

    title=re.findall(r'<div class="view_t">(.*?)</div>',respose_text,re.S)[0] #标题 显示进度
    print('title= ',title)

    rs=re.findall(r'<div id="view_content_txt">(.*?)</div>',respose_text,re.S)[0] #正文
    rs=re.sub("<br />","\n",rs)   #替换<br>或<br /> 为换行
    rs=re.sub("&nbsp;"," ",rs)
    rs=re.sub("\n\n","\n",rs) #换行变成一行
    #删除无用的内容
    rs=re.sub(r"<div class=\"view_page\">", "", rs)
    rs=re.sub(r'<a href=.*script>',"",rs)
    #print(chapter,'='*10,"\n", rs)

    #写入文件
    f.write('='*10+"\n"+ str(chapter)+" "+title+"\n"+rs)
    f.write("\n From: "+url+"\n\n\n")

    print(chapter," From: "+url+"\n")

f.close()
print("End",chapter)
# 使用sed去掉这一行
# 小提示：按 回车[Enter]键 返回书目，按 ←键 返回上一章， 按 → 键 进入下一章。
# sed -i '/本文每页显示/d' book.txt