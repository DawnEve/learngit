# datetime模块包含5个类：datetime.date, datetime.time,datetime.datetime,datetime.timedelta,datetime..tzinfo等
#>>> import datetime
#>>> dir(datetime)
#['MAXYEAR', 'MINYEAR', '__builtins__', '__cached__', '__doc__', '__file__', 
#'__loader__','__name__', '__package__', '__spec__', 'date', 'datetime', 
# 'datetime_CAPI', 'time', 'timedelta', 'timezone', 'tzinfo']
from datetime import datetime
#1.now
now = datetime.now() # 获取当前datetime
print('1.',now)
# 2016-10-08 09:13:09.785996
print(type(now))
# <class 'datetime.datetime'>
#注意到datetime是模块，datetime模块还包含一个datetime类，通过from datetime import datetime导入的才是datetime这个类。
#如果仅导入import datetime，则必须引用全名datetime.datetime。

# from datetime import datetime
dt = datetime(2016, 10, 8, 21, 13) # 用指定日期时间创建datetime
t=dt.timestamp()
print(t) # 把datetime转换为timestamp 1475932380.0


print(datetime.fromtimestamp(t)) #2016-10-08 21:13:00