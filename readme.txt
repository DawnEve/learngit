---

layout: post  
title: "Git 常用命令"

---
#Git is a version control system.
##Some very good notes about Git are in the folder [git_note].


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

版本回退：
$ git reset --hard 3628164
HEAD is now at 3628164 append GPL


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