# 分而治之: 数组求和，递归法;

def sumArr(arr):
    sum=0;
    for i in arr:
        sum+=i 
    return sum 

print(sumArr([2,4,6]))


# 方法二，使用递归，数组长度为1或0时返回，否则拿出一个值加上其余 求和数组
def sumArr2(arr):
    if len(arr)==0:
        return 0
    else:
        return arr[0] + sumArr2(arr[1:])

print(sumArr2([2,4,6]))
