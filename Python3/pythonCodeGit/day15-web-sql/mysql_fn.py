import mysql_conn #引入MySQL的链接

def showlist(sql,conn):
    #输出：查询
    cursor = conn.cursor()
    #print('cursor type:',type(cursor)) #<class 'mysql.connector.cursor.MySQLCursor'>
    #print('cursor dir:',dir(cursor))
    # cursor.execute('select * from python_user where id = %s', ('1',))
    cursor.execute(sql)
    values = cursor.fetchall() #获取全部信息
    cursor.close()
    conn.close()
    return values # 返回list 
    #[('2', 'Tom'), ('3', 'Lilei')]
    
# sql='select * from python_user where id !=2';
# sql='select * from python_user where id !=2';
'''
# test 
'''
# sql='select * from think.think_weibo';
sql='select * from python_user';
rs=showlist(sql,mysql_conn.conn)

print(type(rs)) #<class 'list'>
print(len(rs)) #86
print(rs) #86
