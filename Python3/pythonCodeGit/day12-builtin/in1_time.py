#time 模块
import time 

#获取帮助：命令行模式下，import time; dir(time); dir(time.mktime); help(time.mktime)

#1 time.time()
print(time.time()) #返回的是时间戳(从1970.1.1 8:0:0至今的秒数) 1526019682.7122374

#2.把时间戳转换车本地时间
print(time.localtime())#不指定参数则传入当前时间
lt=time.localtime(1475932380.0) 
print('1',type(lt), lt)
#<class 'time.struct_time'> time.struct_time(tm_year=2016, tm_mon=10, tm_mday=8, tm_hour=21, tm_min=13, tm_sec=0, tm_wday=5, tm_yday=282, tm_isdst=0)
#这个 struct_time 元组 共9个元素:年、月、日、时、分、秒，一年中第几周，一年中第几天，是否为夏令时。
ltL=list(lt) #可以变成一个list格式。
print('2',type(ltL), ltL)#<class 'list'> [2016, 10, 8, 21, 13, 0, 5, 282, 0]
#3.gmtime([secs])函数和localtime([secs])差不多，不过是转换为UTC时区(0时区)de struct_time.
print('3 time.gmtime()',time.gmtime(1475932380.0))

#4.mktime(t)由时间计算时间戳。 和localtime、gmtime操作相反。
print("4 time.mktime()", time.mktime( (2016, 10, 8, 21, 13, 0, 5, 282, 0) ) )
# print("time.mktime()", time.mktime( [2016, 10, 8, 21, 13, 0, 5, 282, 0] ) )
# Tuple or struct_time argument required

#5.asctime([t])由9位元组或localtime、gmtime的返回值作为输入，输出为可读的时间
print("5 time.asctime()",time.asctime( time.localtime() ))
#6.ctime([secs])把时间戳转换为asctime()的形式，相当于 asctime(loacltime(secs))
print("6 time.ctime()",time.ctime())

#7.sleep(secs) 用于推迟调用线程的运行
def processing():
    time.sleep(1);
print("-7. start:", time.ctime())
processing()
print("-7. end  :", time.ctime())

#8.clock()计算当前cpu时间(linux)，在win32下是真实时间。
t1=time.clock()
processing()
print("8.seconds process time: ", time.clock()-t1) #linux下这个接近于0.
print(type(t1),t1)
#8.使用time()计算时间
t2=time.time()
processing()
print("8.seconds wall time: ", time.time()-t2)

#9.strftime(format[,t])函数 接收时间元组，并返回可读字符串表示当地时间。
t=(2018,5,11,15,30,0,4,131,0)
t2=time.mktime(t)
t3=time.gmtime(t2)
print('9.', time.strftime("%b %d, %Y %H:%M:%S",t))#May 11, 2018 15:30:00
#10.strptime(string[,format])是strftime()的反处理：输入时间字符串，输出时间元组。
print("10.", time.strptime("May 11 2018", "%b %d %Y"))

