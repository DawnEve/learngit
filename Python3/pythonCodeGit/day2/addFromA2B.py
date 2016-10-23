
#求a到b中间奇数的和

def add(a,b):
    sum=0
    while a<b:
        if a%2==1:
            sum += a
        a +=1
    return sum 

#print(add(100,200)) #7500
print(add(4104,8384))
