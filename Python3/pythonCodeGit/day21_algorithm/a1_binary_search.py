# 二分法查找

import math

def binary_search(sorted_arr, num, debug=False):
    low=0
    high=len(sorted_arr)-1
    mid= math.floor( (low+high)/2 )
    #
    while low<=high:
        mid= math.floor( (low+high)/2 )
        guess=sorted_arr[mid]
        if debug:
            print(low, mid, high)
        if guess==num:
            return mid;
        elif guess>num:
            high=mid-1
        else:
            low=mid+1
    return -1

arr1=[1,3,5,6,7]
print(binary_search(arr1, 50))
print(binary_search(arr1, 0))
print(binary_search(arr1, 7))
print(binary_search(arr1, 6, 0))
#print(binary_search(arr1, 6, True))