#get the even line of a file

fr=open('input.txt','r')
fw=open('output.txt.cache','a')
i=1
for line in fr:
    if i%2==0: 
       fw.write(line)
    i += 1

fr.close()
fw.close()