# v0.0.1给出英语单词的复数形式 http://andylin02.iteye.com/blog/842718
#
# //todo
# 动词变形：es, ing, ed

def plural(word):
    if word.endswith('y'):  
        return word[:-1]+'ies'  
    elif word[-1] in 'sx' or word[-2:] in ['sh','ch']:  
        return word+'es'  
    elif word.endswith('an'):  
        return word[:-2]+'en'  
    else:  
        return word+'s'

#名词
wd_n=["book",'peach','woman','boy']
#动词
wd_v=['love', 'play','pick','give']

for w in wd_n:
    print(w,'==>',plural(w))
