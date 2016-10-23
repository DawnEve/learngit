def application2(environ, start_response):
    start_response('200 OK', [('Content-Type', 'text/html')])
    return [b'<h1>Hello, web!</h1>']
'''
上面的application()函数就是符合WSGI标准的一个HTTP处理函数，它接收两个参数：
    environ：一个包含所有HTTP请求信息的dict对象；
    start_response：一个发送HTTP响应的函数。

在application()函数中，调用：
start_response('200 OK', [('Content-Type', 'text/html')])

有了WSGI，我们关心的就是如何从environ这个dict对象拿到HTTP请求信息，
然后构造HTML，
通过start_response()发送Header，最后返回Body。


'''

def application(environ, start_response):
    start_response('200 OK', [('Content-Type', 'text/html')])
    print(environ['REQUEST_METHOD'])
    print(environ['PATH_INFO'])
    body = '<h1>Hello, %s!</h1>' % (environ['PATH_INFO'][1:] or 'web')
    return [body.encode('utf-8')]

#http://localhost:8000/%3Cu%3Ealert(%22xss%22)%3C/u%3E
'''
Serving HTTP on port 8000...
{'COMMONPROGRAMW6432': 'C:\\Program Files\\Common Files', 
'PATH_INFO': '/wjl000', 'PROMPT': '$P$G', 'PROCESSOR_REVISION': '3c03', 
'SERVER_NAME': 'peptide', 'APPDATA': 'C:\\Users\\Administrator\\AppData\\Roaming', 
'OS': 'Windows_NT', 'QUERY_STRING': '', 'PROGRAMDATA': 'C:\\ProgramData', 
'JAVA_HOME': 'D:\\Program Files\\Java\\jdk1.8.0_66', 'PROGRAMFILES(X86)': 'C:\\Program Files (x86)', 
'PATH': 'D:/Program Files/Java/jdk1.8.0_66/bin/../jre/bin/server;D:/Program Files/Java/jdk1.8.0_66/bin/../jre/bin;D:/Program Files/Java/jdk1.8.0_66/bin/../jre/lib/amd64;C:\\Program Files (x86)\\Python35-32\\Scripts\\;C:\\Program Files (x86)\\Python35-32\\;C:\\Windows\\system32;C:\\Windows;C:\\Windows\\System32\\Wbem;C:\\Windows\\System32\\WindowsPowerShell\\v1.0\\;d:\\Program Files\\Git\\cmd;D:\\Program Files\\Java\\jdk1.8.0_66\\bin;D:\\Program Files\\nodejs\\;C:\\Users\\Administrator\\AppData\\Roaming\\npm;D:\\Program Files\\eclipsePHP\\eclipse;', 
'TMP': 'C:\\Users\\ADMINI~1\\AppData\\Local\\Temp', 
'HTTP_ACCEPT': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8', 
'COMSPEC': 'C:\\Windows\\system32\\cmd.exe', 
'wsgi.errors': <_io.TextIOWrapper name='<stderr>' mode='w' encoding='UTF-8'>, 
'PROGRAMW6432': 'C:\\Program Files', 'HTTP_ACCEPT_LANGUAGE': 'zh-CN,zh;q=0.8,en;q=0.6', 
'WINDIR': 'C:\\Windows', 'CONTENT_TYPE': 'text/plain', 
'PATHEXT': '.COM;.EXE;.BAT;.CMD;.VBS;.VBE;.JS;.JSE;.WSF;.WSH;.MSC;.PY;.PYW', 
'HTTP_CACHE_CONTROL': 'max-age=0', 'SYSTEMROOT': 'C:\\Windows', 
'HOMEPATH': '\\Users\\Administrator', 
'HTTP_USER_AGENT': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36', 
'PROCESSOR_ARCHITEW6432': 'AMD64', 
'PYTHONPATH': 'C:\\Users\\Administrator\\.p2\\pool\\plugins\\org.python.pydev_5.2.0.201608171824\\pysrc\\pydev_sitecustomize;C:\\Program Files (x86)\\Python35-32\\DLLs;C:\\Program Files (x86)\\Python35-32\\lib;C:\\Program Files (x86)\\Python35-32;C:\\Program Files (x86)\\Python35-32\\lib\\site-packages', 
'PROGRAMFILES': 'C:\\Program Files (x86)', 'wsgi.multiprocess': False, 'COMPUTERNAME': 'PEPTIDE', 
'HOMEDRIVE': 'C:', 'USERDOMAIN': 'PEPTIDE', 'HTTP_UPGRADE_INSECURE_REQUESTS': '1', 
'PROCESSOR_IDENTIFIER': 'Intel64 Family 6 Model 60 Stepping 3, GenuineIntel', 
'PROCESSOR_ARCHITECTURE': 'x86', 'SCRIPT_NAME': '', 
'PSMODULEPATH': 'C:\\Windows\\system32\\WindowsPowerShell\\v1.0\\Modules\\', 
'SERVER_SOFTWARE': 'WSGIServer/0.2', 'wsgi.version': (1, 0), 
'PYDEV_COMPLETER_PYTHONPATH': 'C:\\Users\\Administrator\\.p2\\pool\\plugins\\org.python.pydev_5.2.0.201608171824\\pysrc', 
'USERNAME': 'admin', 'GATEWAY_INTERFACE': 'CGI/1.1', 'PYTHONUNBUFFERED': '1', 
'SERVER_PORT': '8000', 'LOGONSERVER': '\\\\PEPTIDE', 'PYTHONIOENCODING': 'UTF-8', 
'PYDEV_CONSOLE_ENCODING': 'UTF-8', 'USERPROFILE': 'C:\\Users\\Administrator', 'PUBLIC': 'C:\\Users\\Public', 
'HTTP_CONNECTION': 'keep-alive', 'CONTENT_LENGTH': '', 'wsgi.input': <_io.BufferedReader name=568>, 
'TEMP': 'C:\\Users\\ADMINI~1\\AppData\\Local\\Temp', 'wsgi.run_once': False, 'REMOTE_ADDR': '127.0.0.1', 
'PROCESSOR_LEVEL': '6', 'VBOX_MSI_INSTALL_PATH': 'C:\\Program Files\\Oracle\\VirtualBox\\', 
'wsgi.url_scheme': 'http', 'COMMONPROGRAMFILES(X86)': 'C:\\Program Files (x86)\\Common Files', 
'SERVER_PROTOCOL': 'HTTP/1.1', 'HTTP_ACCEPT_ENCODING': 'gzip, deflate, sdch', 'NUMBER_OF_PROCESSORS': '4', 
'SYSTEMDRIVE': 'C:', 'HTTP_HOST': '127.0.0.1:8000', 'SESSIONNAME': 'Console', 'REQUEST_METHOD': 'GET', 
'REMOTE_HOST': '', 'COMMONPROGRAMFILES': 'C:\\Program Files (x86)\\Common Files', 
'wsgi.file_wrapper': <class 'wsgiref.util.FileWrapper'>, 'ALLUSERSPROFILE': 'C:\\ProgramData', 
'LOCALAPPDATA': 'C:\\Users\\Administrator\\AppData\\Local', 'FP_NO_HOST_CHECK': 'NO', 
'wsgi.multithread': True, 'WINDOWS_TRACING_FLAGS': '3'}


127.0.0.1 - - [23/Oct/2016 18:17:07] "GET /wjl000 HTTP/1.1" 200 23

'''

