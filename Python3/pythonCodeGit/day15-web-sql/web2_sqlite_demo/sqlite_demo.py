#在使用SQLite前，我们先要搞清楚几个概念：
#表是数据库中存放关系数据的集合，一个数据库里面通常都包含多个表，比如学生的表，班级的表，学校的表，等等。表和表之间通过外键关联。

#1.要操作关系数据库，首先需要连接到数据库，一个数据库连接称为Connection；
#2.连接到数据库后，需要打开游标，称之为Cursor，通过Cursor执行SQL语句，然后，获得执行结果。

#Python定义了一套操作数据库的API接口，任何数据库要连接到Python，只需要提供符合Python标准的数据库驱动即可。
#由于SQLite的驱动内置在Python标准库中，所以我们可以直接来操作SQLite数据库。

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
print('1  ', cursor.fetchall())

cs_obj=query(cursor,'select * from user;')
#cs_obj=query(cursor,'select * from user where id>2;')
print('2  ', cs_obj)
values = cursor.fetchall()
print('3  ', values)

# 关闭Cursor:
cursor.close()
# 提交事务:
conn.commit()
# 关闭Connection:
conn.close()