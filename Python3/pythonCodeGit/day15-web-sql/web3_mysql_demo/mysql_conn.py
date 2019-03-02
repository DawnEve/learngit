#!/usr/bin/python
# -*- coding: utf-8 -*-

# =============================
# Environment Preview
# System: Windows 7 x86_64
# IDE: Eclipse for PHP Developers Version: Neon.1 Release (4.6.1) Build id: 20160913-0900
# SQL: mysql in XAMPP   => ../bin/mysqld.exe  SELECT version() 5.6.11
# Driver: mysql-connector-python-rf
# ../Python35/Scripts> pip -V
# pip 8.1.2 from c:\program files (x86)\python35-32\lib\site-packages (python 3.5)
# ../Python35/Scripts> pip install --upgrade pip
# ../Python35/Scripts> pip install --upgrade wheel
# ../Python35/Scripts> pip install mysql-connector-python-rf
# =============================

# 导入MySQL驱动
import mysql.connector

# 创建连接
conn = mysql.connector.connect(user='root', password='', database='test')

# 后面的忽略吧
# 本文件仅用作创建连接===============在另一个文件内使用

print(dir(conn)) #很多方法名


"""
#输入：建表、插入
cursor = conn.cursor()
cursor.execute('drop table if exists `python_user` ')
cursor.execute('create table python_user (id int(20) primary key AUTO_INCREMENT, name varchar(20))')
cursor.execute('insert into python_user (id, name) values (%s, %s)', ['1', 'Michael'])
cursor.execute('insert into python_user (id, name) values (%s, %s)', ['2', 'Tom'])
cursor.execute('insert into python_user (id, name) values (%s, %s)', ['3', 'Lilei'])
row_count = cursor.rowcount
conn.commit()
cursor.close()

#输出：查询
cursor = conn.cursor()
# cursor.execute('select * from python_user where id = %s', ('1',))
cursor.execute('select * from python_user where id > %s', ('1',))
values = cursor.fetchall()
print(values)           # [('1', 'Michael')]
#[('2', 'Tom'), ('3', 'Lilei')]
cursor.close()
conn.close()

"""
