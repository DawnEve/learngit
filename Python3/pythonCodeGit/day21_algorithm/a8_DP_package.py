# 背包问题的解，这个是粗糙解，还有很大优化空间。

# 一个背包最多能装4磅货物，则它能装的最大价值是多少？
#G吉他   $1500    1p
#S音响   $3000    4p
#N笔记本 $2000    3p

# 限制因素: 物品重量
weight=[1, 4, 3]
# 优化指标: 价值 max
price=[1500, 3000, 2000]

# 增加一个物品 p手机  $2000 1P
weight.append(1); price.append(2000)

# 重量最大值，粒度默认 1
weightMax=len(weight)+1;

# 创建表格，并初始化，边缘行列（第0行，第0列）也是0.
cell=[];
for i in range(0, len(price)+1 ):
    cell.append([]);
    for j in range(0,weightMax,1): #各种小背包的重量 粒度
        # print("item=",i, ", weight=", j)
        cell[i].append(0)
print("init:", cell)

# 装不装该物品的价值，这次遍历不含第0行，第0列。
print("分解为若干小问题: ");
for i in range(1, len(price)+1 ): #遍历物品
    for j in range(1,weightMax,1): #遍历背包的可能最大重量
        # 1.每个物品都有2个状态，装或者不装进去。返回两者的最大值。         
        # 2.如果该物品超重，直接返回不装它的状态
        # (1)不装它的价值，就是上一个单元格的价值
        val1=cell[i-1][j]
        # (2)装它的价值，就是 当前商品的价值 + 剩余空间的价值 cell[i-1][j-当前商品的重量]
        cW=weight[i-1] #当前物品的重量        
        val2=0
        if j- cW >= 0: #当前背包的最大容量 - 当前物品的重量不能是负数
            val2 = price[i-1] + cell[i-1][j-cW]
        
        cell[i][j]=max(val1, val2)
        print(f">> [{i},{j}]",cW,val1, val2, cell[i][j])
print("result:", cell)

# 打印结果, 不含第0行，第0列。
print("\n>> Row: item; Column: weight. Max: last cell.")
for i in range(1, len(price)+1 ):
    print(cell[i][1:])