import mysql_conn #引入MySQL的链接

def showlist(sql,conn):
    #输出：查询
    cursor = conn.cursor()
    #print('cursor type:',type(cursor)) #<class 'mysql.connector.cursor.MySQLCursor'>
    #print('cursor dir:',dir(cursor))
    # cursor.execute('select * from python_user where id = %s', ('1',))
    cursor.execute(sql)

    #1.1获取全部信息
    data = cursor.fetchall() #打印前可以关闭游标。
    cursor.close()

    #1.2使用 fetchone() 方法获取单条数据.
    #data = cursor.fetchone() #打印前不能关闭游标cursor，否则会报错。
    #此时我们可以通过 data[0],data[1],data[2]获取字段的值

    return data # 返回list 
    #[('2', 'Tom'), ('3', 'Lilei')]

# sql='select * from python_user where id !=2';
# sql='select * from python_user where id !=2';
'''
# test 
'''
#sql='select * from think.think_weibo';
sql='select * from user';
rs=showlist(sql,mysql_conn.conn)

print('type: ', type(rs)) #<class 'list'>
print('len: ', len(rs)) #86
print('detail: ', rs) #86


#最后不用了在close连接
mysql_conn.conn.close()