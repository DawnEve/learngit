# 快速排序，使用递归，是一种分而治之的策略。

def quickSort(arr):
    if len(arr)<2:
        return arr;
    else:
        pivot=arr[0]; #第一个数做参考，其余部分，分割成比它小的，比它大的
        less = [i for i in arr[1:] if i<=pivot]
        greater =[i for i in arr[1:] if i>pivot]
        
        # 然后分别排序，拍好后放出来
        return quickSort(less)+[pivot] + quickSort(greater)

print(quickSort([10,2,30,-100,5]))