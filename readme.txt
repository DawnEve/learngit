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

git reset --hard HEAD
回退整套代码到最近一次提后的状态。

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
日常使用Git的19个建议
http://blog.jobbole.com/96088/

变更基线一个非常有用的特殊用法 git pull –rebase。

举个例子，假设你正在master分支的一个本地版本上工作，你已经向仓库提交了一小部分变更。与此同时，也有人向master分支提交了他一周的工作成果。当你尝试推送本地变更时，git提示你需要先运行一下 git pull ， 来解决冲突。作为一个称职的工程师，你运行了一下 git pull ，并且git自动生成了如下的提交信息。

Merge remote-tracking branch ‘origin/master’
尽管这不是什么大问题，也完全安全，但是不太有利于历史记录的聚合。

这种情况下，git pull --rebase 是一个不错的选择。

这个命令会迫使git将远程分支上的变更同步到本地，然后将尚未推送的提交重新应用到这个最新版本，就好象它们刚刚发生一样。这样就可以避免合并以及随之而来的丑陋的合并信息了。

-----------------------------
通过运行 git log --oneline --graph 显示的视图，清楚地看到合并分支的历史。



-----------------------------
8. 修复而非新建提交

示例：
git commit --amend
这个指令顾名思义。

假设提交之后，你意识到自己犯了一个拼写错误。你可以重新提交一次，并附上描述你的错误的提交信息。但是，还有一个更好的方法：

如果提交尚未推送到远程分支，那么按照下面步骤简单操作一下就可以了：

修复你的拼写错误
将修正过的文件暂存，通过git add some-fixed-file.js
运行 git commit –amend 命令，将会把最近一次的变更追加到你最新的提交。同时也会给你一个编辑提交信息的机会。
准备好之后，将干净的分支推送到远程分支。




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