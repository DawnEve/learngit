# 求组合数的累加和

# 排列数
def A(n):
    if n<1:
        return 1;
    return n*A(n-1)
# test
#for i in range(10):
#    print(i, A(i) )

# 组合数
def C(n, x):
    return int( A(n)/A(x)/A(n-x) );
# test
#for i in range(5+1):
#    print(i, C(5, i) )

# 组合数累加
def com_sum(n):
    sum=1;
    for i in range(1, n+1):
        sum += C(n, i)
    return sum;
# test
for i in range(10+1):
    print(i, com_sum(i))
