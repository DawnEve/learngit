# 选择排序

arr=[20,1,6,100,5]

# 返回最小元素的下标
def findSmallest(arr):
    small=arr[0]
    index=0
    for i in range( len(arr)):
        if small> arr[i]:
            small=arr[i]
            index=i;
    return index

# use this function in sorting
def searchSort(arr):
    arr2=[]
    for i in range( len(arr) ):
        print(i, arr2)
        smallest=findSmallest(arr)
        arr2.append(arr.pop(smallest))
    return arr2;

print(arr)
arr2=searchSort(arr)
print(arr2)