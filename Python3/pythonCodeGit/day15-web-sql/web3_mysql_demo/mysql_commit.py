#数据库事务：要么全部执行，要么全部不执行
#事务应该具有4个属性：原子性、一致性、隔离性、持久性。这四个属性通常称为ACID特性。
# http://www.runoob.com/python3/python3-mysql.html

import mysql_conn #引入MySQL的链接
conn=mysql_conn.conn
cursor = conn.cursor()


#查询结果
def check(cursor):
    cursor.execute("select * from user;")
    rs=cursor.fetchall()
    return(rs)

print("befer:", check(cursor))

#事务操作
try:
   cursor.execute(" delete from user where id=4;")# 删除
   cursor.execute("insert into user values(3,'Lilei4');")# 插入
   conn.commit() #提交事务
except:
   conn.rollback()# 如果发生错误则回滚
   print("cursor.errror")
#finally:
#    conn.close()

print("after:", check(cursor))

#打印结果

#最后不用了在close连接
cursor.close()#关闭游标
conn.close()#释放数据库资源