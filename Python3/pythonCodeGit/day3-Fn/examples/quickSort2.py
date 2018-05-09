#quick sort from baidu baike.
# https://baike.baidu.com/item/快速排序算法/369842?fr=aladdin
def d(s,i,j,L): #todo 是为了监视操作步骤
    pass
    print(s,i,j,L)

#经典版本
def quickSort(L, low, high):
    i = low
    j = high
    if i >= j:
        return L
    key = L[i]
    while i < j:
        while i < j and L[j] >= key:
            j = j-1
        L[i] = L[j]; d('m1-',i,j, L)#todo
        while i < j and L[i] <= key:
            i = i+1
        L[j] = L[i]; d('m2-',i,j, L)#todo
    L[i] = key; d('e-',i,j, L)#todo

    quickSort(L, low, i-1)
    quickSort(L, j+1, high)
    return L

#######################
# test
myL=[20,-5,3,100,90,67,-89,0]
print('前: ',myL)
quickSort(myL,0,len(myL)-1)
print('后: ',myL)
