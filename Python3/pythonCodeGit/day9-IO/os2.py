import os
print(os.name) #nt

#print(os.uname) #nt
#注意uname()函数在Windows上不提供，也就是说，os模块的某些函数是跟操作系统相关的。
print(os.environ)
# environ({'PYTHONIOENCODING': 'UTF-8', 
# 'PROGRAMW6432': 'C:\\Program Files', 
# 'ALLUSERSPROFILE': 'C:\\ProgramData', 
# 'WINDOWS_TRACING_FLAGS': '3', 
# 'PROMPT': '$P$G', 
# 'PATH': 'D:/Program Files/Java/jdk1.8.0_66/bin/../jre/bin/server;D:/Program Files/Java/jdk1.8.0_66/bin/../jre/bin;D:/Program Files/Java/jdk1.8.0_66/bin/../jre/lib/amd64;C:\\Program Files (x86)\\Python35-32\\Scripts\\;C:\\Program Files (x86)\\Python35-32\\;C:\\Windows\\system32;C:\\Windows;C:\\Windows\\System32\\Wbem;C:\\Windows\\System32\\WindowsPowerShell\\v1.0\\;d:\\Program Files\\Git\\cmd;D:\\Program Files\\Java\\jdk1.8.0_66\\bin;D:\\Program Files\\nodejs\\;C:\\Users\\Administrator\\AppData\\Roaming\\npm;D:\\Program Files\\eclipsePHP\\eclipse;', 
# 'PROGRAMDATA': 'C:\\ProgramData', 
# 'JAVA_HOME': 'D:\\Program Files\\Java\\jdk1.8.0_66', 
# 'SYSTEMDRIVE': 'C:', 
# 'HOMEDRIVE': 'C:', 
# 'VBOX_MSI_INSTALL_PATH': 
# 'C:\\Program Files\\Oracle\\VirtualBox\\', 
# 'COMSPEC': 'C:\\Windows\\system32\\cmd.exe', 
# 'COMMONPROGRAMW6432': 'C:\\Program Files\\Common Files', 
# 'TMP': 'C:\\Users\\ADMINI~1\\AppData\\Local\\Temp', 
# 'PROCESSOR_IDENTIFIER': 'Intel64 Family 6 Model 60 Stepping 3, GenuineIntel', 
# 'PATHEXT': '.COM;.EXE;.BAT;.CMD;.VBS;.VBE;.JS;.JSE;.WSF;.WSH;.MSC;.PY;.PYW', 
# 'USERNAME': 'admin', 
# 'COMMONPROGRAMFILES(X86)': 'C:\\Program Files (x86)\\Common Files', 
# 'WINDIR': 'C:\\Windows', 
# 'PROGRAMFILES': 'C:\\Program Files (x86)', 
# 'PYDEV_COMPLETER_PYTHONPATH': 'C:\\Users\\Administrator\\.p2\\pool\\plugins\\org.python.pydev_5.2.0.201608171824\\pysrc', 
# 'PROCESSOR_REVISION': '3c03', 
# 'COMMONPROGRAMFILES': 'C:\\Program Files (x86)\\Common Files', 
# 'HOMEPATH': '\\Users\\Administrator', 
# 'PYTHONPATH': 'C:\\Users\\Administrator\\.p2\\pool\\plugins\\org.python.pydev_5.2.0.201608171824\\pysrc\\pydev_sitecustomize;C:\\Program Files (x86)\\Python35-32\\DLLs;C:\\Program Files (x86)\\Python35-32\\lib;C:\\Program Files (x86)\\Python35-32;C:\\Program Files (x86)\\Python35-32\\lib\\site-packages', 
# 'PYDEV_CONSOLE_ENCODING': 'UTF-8', 
# 'LOCALAPPDATA': 'C:\\Users\\Administrator\\AppData\\Local', 
# 'SESSIONNAME': 'Console', 
# 'USERPROFILE': 'C:\\Users\\Administrator', 
# 'PYTHONUNBUFFERED': '1', 
# 'OS': 'Windows_NT', 
# 'LOGONSERVER': '\\\\PEPTIDE', 
# 'PROCESSOR_LEVEL': '6', 
# 'PROCESSOR_ARCHITECTURE': 'x86', 
# 'COMPUTERNAME': 'PEPTIDE', 
# 'NUMBER_OF_PROCESSORS': '4', 
# 'PSMODULEPATH': 'C:\\Windows\\system32\\WindowsPowerShell\\v1.0\\Modules\\', 
# 'FP_NO_HOST_CHECK': 'NO', 
# 'APPDATA': 'C:\\Users\\Administrator\\AppData\\Roaming', 
# 'SYSTEMROOT': 'C:\\Windows', 
# 'TEMP': 'C:\\Users\\ADMINI~1\\AppData\\Local\\Temp', 
# 'PROGRAMFILES(X86)': 'C:\\Program Files (x86)', 
# 'PROCESSOR_ARCHITEW6432': 'AMD64', 
# 'USERDOMAIN': 'PEPTIDE', 
# 'PUBLIC': 'C:\\Users\\Public'})

#获取某个变量
print(os.environ.get('PATH'))

# 查看当前目录的绝对路径:
print(os.path.abspath('.')) #F:\gitHub\learngit\Python3\pythonCodeGit\day9

#创建目录
#os.mkdir('tempWJL')
# 删掉一个目录:
#os.rmdir('tempWJL')

#把两个路径合成一个时，不要直接拼字符串，而要通过os.path.join()函数，这样可以正确处理不同操作系统的路径分隔符。
dirName=os.path.join(os.path.abspath('.'),'abc');
print(dirName)
#os.mkdir(dirName)

#同样的道理，要拆分路径时，也不要直接去拆字符串，而要通过os.path.split()函数，
#这样可以把一个路径拆分为两部分，后一部分总是最后级别的目录或文件名：
dirArr=os.path.split(dirName)
print(dirArr)

print(os.listdir())

