#!/usr/bin/python3
# -*- coding: utf-8 -*-

#因为需要设置邮箱的授权码，该脚本没有运行成功。

import smtplib

from email.mime.text import MIMEText
from email.header import Header

sender = "wap314@163.com"
psw="授权码"
receivers=["wap314@163.com"]

message=MIMEText("Python 邮件发送测试...", 'plain','utf-8')
message["From"]=Header("邮件测试",'utf-8')
message['To']=Header('测试','utf-8')

subject='Python SMTP 邮件测试001'
message['Subject']=Header(subject, 'utf-8')

try:
    smtpObj=smtplib.SMTP_SSL('smtp.163.com', 465)
    smtpObj.set_debuglevel(1)
    smtpObj.login(sender, psw)
    smtpObj.sendmail(sender, receivers, message.as_string())
    print("邮件发送成功")
except smtplib.SMTPException as e:
    print("Error: 无法发送邮件. Case:%s" % e)
