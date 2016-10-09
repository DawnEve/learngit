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

print(dir(conn))
#['__abstractmethods__', '__class__', '__delattr__', '__dict__', '__dir__', '__doc__', '__eq__', 
#'__format__', '__ge__', '__getattribute__', '__gt__', '__hash__', '__init__', '__le__', '__lt__', 
#'__module__', '__ne__', '__new__', '__reduce__', '__reduce_ex__', '__repr__', '__setattr__', 
#'__sizeof__', '__str__', '__subclasshook__', '__weakref__', '_abc_cache', '_abc_negative_cache', 
#'_abc_negative_cache_version', '_abc_registry', '_auth_plugin', '_auth_switch_request', 
#'_autocommit', '_buffered', '_charset_id', '_check_server_version', '_client_flags', 
#'_client_host', '_client_port', '_compress', '_connection_timeout', '_consume_results', 
#'_converter_class', '_database', '_do_auth', '_do_handshake', '_execute_query', 
#'_force_ipv6', '_get_connection', '_get_self', '_get_warnings', '_handle_binary_ok', 
#'_handle_binary_result', '_handle_eof', '_handle_load_data_infile', '_handle_ok', '_handle_result', 
#'_handle_server_status', '_handshake', '_have_next_result', '_host', '_in_transaction', 
#'_open_connection', '_password', '_pool_config_version', '_port', '_post_connection', 
#'_prepared_statements', '_protocol', '_raise_on_warnings', '_raw', '_read_option_files', 
# '_send_cmd', '_send_data', '_server_version', '_socket', '_sql_mode', '_ssl', '_ssl_active', 
# '_time_zone', '_unix_socket', '_unread_result', '_use_unicode', '_user', 'autocommit', 
# 'can_consume_results', 'charset', 'close', 'cmd_change_user', 'cmd_debug', 'cmd_init_db', 'cmd_ping', 
# 'cmd_process_info', 'cmd_process_kill', 'cmd_query', 'cmd_query_iter', 'cmd_quit', 'cmd_refresh', 
# 'cmd_reset_connection', 'cmd_shutdown', 'cmd_statistics', 'cmd_stmt_close', 'cmd_stmt_execute', 
# 'cmd_stmt_prepare', 'cmd_stmt_reset', 'cmd_stmt_send_long_data', 'collation', 'commit', 'config', 
# 'connect', 'connection_id', 'consume_results', 'converter', 'cursor', 'database', 'disconnect', 
# 'get_row', 'get_rows', 'get_server_info', 'get_server_version', 'get_warnings', 'handle_unread_result', 
# 'in_transaction', 'info_query', 'is_connected', 'isset_client_flag', 'ping', 'python_charset', 
# 'raise_on_warnings', 'reconnect', 'reset_session', 'rollback', 'server_host', 'server_port', 
# 'set_charset_collation', 'set_client_flags', 'set_converter_class', 'set_login', 'set_unicode', 
# 'shutdown', 'sql_mode', 'start_transaction', 'time_zone', 'unix_socket', 'unread_result', 'user']


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
