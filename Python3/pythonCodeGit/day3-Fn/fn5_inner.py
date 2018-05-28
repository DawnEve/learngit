#支持函数嵌套
def add3(a,b,c):
    #内部函数
    def add2(x,y):
        return x+y
    return add2(add2(a,b),c)

print(add3(1,2,3))
