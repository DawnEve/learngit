#杨辉三角定义如下：
# -*- coding: utf-8 -*-
def triangles(n):
    L = [1]
    while len(L) < n + 1:
        yield(L)
        L.append(0)
        L = [L[i] + L[i - 1] for i in range(len(L))]

n=0;
for i in triangles(15):
    print(i)