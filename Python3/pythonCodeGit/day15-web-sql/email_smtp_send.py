from email.mime.text import MIMEText
msg = MIMEText('hello, send by Python... This is a test file. I want you to know this ...', 'plain', 'utf-8')

# 输入Email地址和口令:
from_addr = input('From: ')
password = 'ijseztytqsfabgff' #  input('Password: ')
# 输入收件人地址:
to_addr = input('To: ')
# 输入SMTP服务器地址:
#smtp_server = input('SMTP server: ')
# smtp_server = 'smtp.163.com'  #input('SMTP server: ')
smtp_server = 'smtp.qq.com'  #input('SMTP server: ')

import smtplib
server = smtplib.SMTP(smtp_server, 25) # SMTP协议默认端口是25
server.set_debuglevel(1)
server.login(from_addr, password)
server.sendmail(from_addr, [to_addr], msg.as_string())

