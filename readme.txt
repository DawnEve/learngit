# Git 常用命令
http://git-scm.com/book/zh/v1
---

# Git is a version control system.
## Some very good notes about Git are in the folder [git_note].


…or create a new repository on the command line

echo # DawnPHPTools >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin git@github.com:DawnEve/DawnPHPTools.git
git push -u origin master
…or push an existing repository from the command line

--------------------------
在本地增加远程版本库信息
git remote add origin git@github.com:DawnEve/DawnPHPTools.git

推送当前文件到远程版本库
git push -u origin master

从远程获取最新文件
git pull

--------------------------
查看当前版本：
$ git log --pretty=oneline

版本回退到上一个版本：
$ git reset --hard HEAD^
HEAD is now at ea34578 add distributed

或者
git reset --hard HEAD~
或者 
git reset --hard HEAD~1

回退到指定的版本：
$ git reset --hard 3628164
HEAD is now at 3628164 append GPL


--------------------------
某个文件版本回退(简易版本)

$git checkout SHA1 a.txt
此时a.txt 是 SHA1时的文件内容 
-------
某个文件版本回退(比较复杂)

在/git_note/git-Roll_Back_One_File.txt有详细记录。
在/git_note/git-Roll_Back_One_File2.txt有详细记录。

refer: http://blog.csdn.net/b_h_l/article/details/17266849

1.获取指定文件的历史提交id列表
$git log demo.txt

2.回退到指定版本
$git reset a4e215234 demo.txt

3.提交绿色文件到版本库
$git commit -m "revert old file because a commmit have a bug"

4.更新到工作区：
$git checkout demo.txt

此时可以看到工作区文件已经更新了。



--------------------------
查看所有提交命令：
git reflog

--------------------------
标签

默认情况下，git push并不会把tag标签传送到远端服务器上，只有通过显式命令才能分享标签到远端仓库。
1.push单个tag，命令格式为：git push origin [tagname]
例如：
git push origin v1.0 #将本地v1.0的tag推送到远端服务器
2.push所有tag，命令格式为：git push [origin] --tags
例如：
git push --tags
或
git push origin --tags


---------------------------

===========================
git push总是失败的排错方法：

$ git config --list
      你也可以查看Git认为的一个特定的关键字目前的值，使用如下命令 git config {key}:
$ git config user.name

http://blog.163.com/023_dns/blog/static/1187273662013111301046930/



尝试连接，失败,这怎么解决啊
$ ssh git@github.com
Permission denied (publickey).

# ssh -T git@github.com
Hi NuadaAndre! You've successfully authenticated, but GitHub does not provide shell access.

GitHub不允许你登陆到它的shell，只能git pull/push



github ssh失败
按照github上面添加ssh的指示来操作的

然后在ssh -T git@github.com出现了错误，最后显示Host key verification failed.
之后用ssh -T -v git@github.com显示调试信息，输出如下：

OpenSSH_6.4, OpenSSL 1.0.1e-fips 11 Feb 2013
debug1: Reading configuration data /etc/ssh/ssh_config
debug1: /etc/ssh/ssh_config line 51: Applying options for *
debug1: Connecting to github.com [192.30.252.130] port 22.
debug1: Connection established.
debug1: identity file /home/terranlee/.ssh/id_rsa type 1
debug1: identity file /home/terranlee/.ssh/id_rsa-cert type -1
debug1: identity file /home/terranlee/.ssh/id_dsa type -1
debug1: identity file /home/terranlee/.ssh/id_dsa-cert type -1
debug1: identity file /home/terranlee/.ssh/id_ecdsa type -1
debug1: identity file /home/terranlee/.ssh/id_ecdsa-cert type -1





---------------------------
Git is free software. under the GPL.
stash.
- URL:http://www.liaoxuefeng.com/wiki/0013739516305929606dd18361248578c67b8067c8c017b000/0013752340242354807e192f02a44359908df8a5643103a000

- URL2(Blog):http://firecloudphp.blog.163.com/blog/static/250822070201573072450693/

- gitLab is similar to gitHub.
https://about.gitlab.com/gitlab-com/

New line By Dawn. new branch:dev

new master insertion.branck feature1;
new dev branck again;

Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.157 Safari/537.36


Some PHPers at zz:
https://github.com/zgldh
Zhengzhou
zgldh@hotmail.com
Joined on 23 Jun 2010

https://github.com/kingfree
Zhengzhou
anytjf@gmail.com
http://weibo.com/kingfree/
Joined on 9 Aug 2010