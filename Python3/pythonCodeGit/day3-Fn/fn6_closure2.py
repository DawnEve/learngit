#返回闭包时牢记的一点就是：返回函数不要引用任何循环变量，或者后续会发生变化的变量。
#闭包的返回很需要理解：http://www.liaoxuefeng.com/wiki/0014316089557264a6b348958f449949df42a6d3a2e542c000/001431835236741e42daf5af6514f1a8917b8aaadff31bf000

def count():
    fs = []
    for i in range(1, 4):
        def f():
             return i*i
        fs.append(f)
    return fs

fn1, fn2, fn3 = count()
print('返回fn1：',fn1);
print( fn1() )
print( fn2() )
print( fn3() )

#为什么都是9？
#返回闭包时牢记的一点就是：返回函数不要引用任何循环变量，或者后续会发生变化的变量。
#因为你返回闭包时，闭包代码还没有执行。如果当前函数的循环变量改变了，会导致闭包引用的变量被改了

#==================使用闭包==========================
def count():
    def f(j):
        def g():
            return j*j
        return g
    fs = []
    for i in range(1, 4):
        fs.append(f(i)) # f(i)立刻被执行，因此i的当前值被传入f()
    return fs

	
f1,f2,f3=count();
print('返回f1-2：',f1);
print( f1() )
print( f2() )
print( f3() )
	
#一个函数可以返回一个计算结果，也可以返回一个函数。
#返回一个函数时，牢记该函数并未执行，返回函数中不要引用任何可能会变化的变量。




#默认参数的计算是在函数定义时候就已经计算完毕的.
#也就是说虽然这里没有定义另外一个新的函数,
#因为已经计算完毕了默认参数的值，所以返回的实际上就是含有特定默认参数的f，那么自然能达到效果，但是这种方法其实不利于理解闭包。why?
def pow_three():
    fs = []
    for i in range(1, 4):
        def f(j=i):
            return j*j
        fs.append(f)
    return fs
f21,f22,f23=pow_three();
print('返回f21-3：',f21);	
print( f21() )
print( f22() )
print( f23() )



#另一种定义方式
def count():
    def f(j):#另一种传递
        return lambda :j*j
    fs = []
    for i in range(1,4):
        fs.append(f(i))
    return fs
	
a1,a2,a3=count();
print('返回a1-4：',a1);
print( a1() )
print( a2() )
print( a3() )