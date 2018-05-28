#quick sort是一种分治排序算法。先选取一个划分元素(partition element,也称pivot);
# 然后重排列表，划分为3部分 left(小于pivot的元素), pivot, right(大于pivot的元素)，此时pivot已经位于列表的最终位置上；
# 然后分别对left和right进行递归排序。
#优化：快排的优化点就是第一次划分的选取。一般是选择首尾和中间。

def d(s,L): #todo 是为了监视操作步骤
    pass
    #print(s,L)
    
    
def quicksort(L):
    qsort(L,0,len(L)-1)
    
def qsort(L,first,last):
    if first<last:
        split=partition(L,first,last) #获得划分元素位置

        qsort(L,first,split-1) #左排序
        qsort(L,split+1,last) #右排序

def partition(L,first,last):
    #选取第一个元素
    pivot=L[first]
    leftmark=first+1
    rightmark=last

    while True:
        while L[leftmark]<=pivot:
            if leftmark==rightmark:#要防止越界
                break;
            leftmark+=1
        while L[rightmark]>pivot:
            rightmark-=1 #这里不会越界。最终会停在first位置。
        if leftmark<rightmark:
            #此时，leftmarker处的元素>pivot，rightmarker处的元素<pivot，交换
            L[leftmark],L[rightmark]=L[rightmark],L[leftmark]
            d('m-', L)#todo
        else:
            break;
    #此时leftmark>=rightmark,交换first处的划分元素和rightmark处的元素
    L[first],L[rightmark]=L[rightmark],L[first]; d('e-', L)#todo
    #返回划分元素pivot的最终位置
    return rightmark;

#######################
# test
myL=[20,-5,3,100,90,67,-89,0]
print('前: ',myL)
quicksort(myL)
print('后: ',myL)
