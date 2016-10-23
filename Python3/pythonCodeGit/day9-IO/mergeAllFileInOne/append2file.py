#把文件名和文件内容都追加到一个新的文件中

def append2File(abspath):
    fr=open(abspath,'r',encoding='utf-8')
    fw=open('d://R_code/total.txt','a',encoding='utf-8')
    
    fw.write('='*20+"\n")
    fw.write(abspath+'\n')
    fw.write('='*20+"\n")
    for line in fr:
        fw.write(line)
    fr.close()
    fw.close()
    
append2File("F:\gitHub\learngit\Python3\pythonCodeGit\day9\json2.py")