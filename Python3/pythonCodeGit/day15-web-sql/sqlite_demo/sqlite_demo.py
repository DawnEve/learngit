# 导入SQLite驱动:
import sqlite3
# 连接到SQLite数据库
# 数据库文件是test.db
# 如果文件不存在，会自动在当前目录创建:
conn = sqlite3.connect('test.db')
# 创建一个Cursor:
cursor = conn.cursor()


def create(cursor):
    # 执行一条SQL语句，创建user表:
    cursor.execute('create table user (id varchar(20) primary key, name varchar(20))')
    #<sqlite3.Cursor object at 0x10f8aa260>

def insert(cursor,sql=''):
    # 继续执行一条SQL语句，插入一条记录:
    if sql=='':
        sql='insert into user (id, name) values (\'1\', \'Michael\')'
    cursor.execute(sql)
    #<sqlite3.Cursor object at 0x10f8aa260>
    # 通过rowcount获得插入的行数:
    return cursor.rowcount
    #1

def query(cursor,sql=''):
    if sql=='':
        exit()
    return cursor.execute(sql)

#create(cursor)
#insert(cursor,'insert into user values("4","Tom")')


# 使用占位符,名字中带m的
cursor.execute('select * from user where name like ? and id>?', ('%m%', 1))
print(cursor.fetchall())

# cs_obj=query(cursor,'select * from user;')
cs_obj=query(cursor,'select * from user where id>2;')
print(cs_obj)
values = cursor.fetchall()
print(values)

# 关闭Cursor:
cursor.close()
# 提交事务:
conn.commit()
# 关闭Connection:
conn.close()