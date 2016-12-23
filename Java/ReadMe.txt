
====================================================
目录：


第一章：编程基础 3-11 
    - 变量、运算符、流程控制;
    - md5加密
第二章：数组 11 -31
    - 数组是按照地址传递的！
    - 数组遍历、复制、求最值、冒泡法排序、二分法查找
    - 排序可以自己实现，或者引用类 import java.util.Arrays;
                    
第三章：面向对象程序开发 31 -74
    - 继承、多态、抽象、封装、
    - 对象的相等
    - 包，包引入、包的静态引入
    - 静态static
    - 复写、重写、重载
    	- @override写不写有什么区别? http://zpointer.iteye.com/blog/1066992
    - 抽象类、抽象方法
    - 枚举(DK1.5+)： 枚举的本质是类 http://www.jb51.net/article/83104.htm
    - 反射: 
    - 泛型： 
		    问题：
		    1.四种权限修饰符的不同点有哪些？
		    2.重写和重载的区别有哪些？

    - 接口和抽象类： 
    - 构造器：执行顺序
    - 内部类: 静态内部类、匿名内部类、


第四章：异常机制 74 -89
	异常分类
	抛出异常
	自定义异常
	

第五章：多线程技术 89 -122
	获取线程名字 Thread.currentThread().toString()
	两种创建方式：继承Thread类，实现Runnable接口，
	运行多线程
		new Thread(new RunnableDemo1()).start();
		new ThreadDemo1().start();
	线程的生命周期
	sleep()
	线程优先级 
		yield让步
		join让步

第六章：常用类 API 122-139
第七章：集合框架（容器） +其他类对象使用 139 -199
	set
	list
	map

第八章：IO 流 199 -280
	字符流与字节流 x 输入与输出 = 4种IO基类
	缓冲流：BufferedInputStream
	追加文件：合并文件、
	管道流
	压缩文件流：压缩与解压
	字符与字节流的转换

第九章：GUI编程 280 -284
	略
第十章：网络编程 284 -309
	java.net包
	DataInputStream对象的input.readUTF()方法可以直接输入utf8字符串
	

第十一章：反射机制 310 -315
	和第三章反射重复。
	
第十二章：正则表达式 315 -322
	匹配
	替换
	查找
	切割


第十三章：HTML语言 322 -335
第十四章：CSS语言 335-341
第十五章：JavaScript 语言 341-375
第十六章：DOM 375-429

第十七章：JDBC 
	事务 

第十八章：javaEE概述
	1.JavaSE是基础，里面的很多东西会经常用到，IO流，Collection，Map等。
	2.:javase就是java基本库，ee是javaweb 一般培训机构就是先教javase，
		然后oracle数据库，
		然后html css js jquery ajax；
		然后servlet jsp struts hibernite spring。
		最后做项目
	3.顺序
	- 1.html，css，javascript
	- 2.servlet(重点) ，数据库（mysql,oracle等等） 【敲demo】
	- 3.三大框架（struts2,spring,hibernate），【查看一下看源的程序当做demo学习】【敲demo】
	- 4.然后开源项目学习，各种插件了解【跟着自己写】
	4.
	肯定先学se了 se是基础 se主要是桌面应用程序 但是你有见过java的桌面应用程序没??? 所以就剩下基础了
ee分两部分jsp和ejb jsp就是做网站 我们常说的ee 其实就是jsp  ejb是java企业级组件这个用的很少只有真正的大型公司才会用到这个所以说基本没有不用学搜索
现在学完se以后还可以去学安卓也不错









====================================================
doc path: D:\coding\Java

Eclipse 快捷键
http://www.cnblogs.com/iamfy/archive/2012/07/11/2586869.html
	ctrl+/ : 添加和去掉行注释
	
	alt + / :快速补齐命令，比如for之后可以使用该快捷键
	shift+ctrl: 所选字母变大写
	
	ctrl + enter: 在当前行的下一行加回车换行，无论光标是否在行尾
	ctrl + enter+shift: 在当前行的上一行加回车换行，无论光标是否在行尾
	
	ctrl+m 大显示屏幕能够提高工作效率是大家都知道的。Ctrl+m是编辑器窗口最大化的快捷键。
	
	输入sysout后按下alt+/，即可自动补全成 System.out.println();
	
	
	
====================================================
2. 掌握核心 API

如果你不知道语言结构和核心 API，那么即使你在理论知识上再怎么彪悍也是独木难成林。
在 Java 中，我们最好能对核心 API，如 java.lang.*、I/O、异常、集合、泛型、线程、JDBC 等有很强的实战经验。
要是涉及到 Web 应用的开发，无论你使用的是对 Servlet 有多大关系的框架，JSP 都是必须的。

====================================================
Java语言
(1)从来没有接触过Java语言的人，要想开始自学Java，从哪里开始呢？
可以从Oracle官方提供的Tutorial入手：  http://docs.oracle.com/javase/tutorial/
这份资料《The Java? Tutorials 》，集中体现了Tutorial类型的资料的特点。
    它从最开始的编译和运行环境搭建说起，教你写出第一个Hello World，
    再用介绍的方式将Java各种语言特性（变量、类、泛型、Lambda表达式、JavaBeans，等等）进行讲解，
    同时还有对于JDK里常用API（集合类、多线程、IO等等）的介绍。
　对初学者而言，需要的就是这样一份资料。
    即使你手头没有任何Java的入门书籍，读完这样的一份资料之后，一个新手基本就可以开始使用Java来编程了。

(2)再看Spec：  http://docs.oracle.com/javase/specs/jls/se8/html/index.html
　这份文档，叫做《The Java? Language Specification》。是一份很典型的Spec，完备而规范。
　任何讲Java语法的资料，包括各种书籍和前面提到的Tutorial，都只能涉及部分。
    而这份Spec，如果你能读通的话，那么与Java语言特性有关的所有一切，你就再也不用求人了。
	
	specs: http://docs.oracle.com/javase/specs/

(3)JDK 8的API Reference:  http://docs.oracle.com/javase/8/docs/api/index.html
　用Java语言编程的时候，我们需要不断查阅的就是这份API Reference。我们平常一般是通过IDE来快速查看某个接口的文档说明。







====================================================
git常用用法

1. 初步
上来一开是就是注册一个邮箱，然后按照 https://help.github.com/articles/set-up-git 这上面的做，
 基本就是生成一个ssh key 然后balabala
还有就是安装git - -， 没有用过的同学请自行百度

2. 建repo
github上的repo也基本上就是项目的意思， 建项目基本也没有几步，
可以按照上面的做 https://help.github.com/articles/create-a-repo

我简单的叙述一下， 在git的网站上弄一个新的repo， 然后就是选一下你的repo名字，你的描述， 你的语言，
以及你选的licence， 推荐用宽松的gpl协议。 这样不会有人改你的代码，虽然我一直都用apache= =。

都弄好了之后，你发现你的项目右面有一个url， 打git clone url ， 就会将项目clone下来， 然后你就可以搞了。
在readme里面可以打个什么hello world之类的，然后传上去， 即 git push origin master

3. 版本恢复，这个可以被认为是git最牛逼的功能。svn来回切版本的时间会特别长， 所以这时候git就显得比较牛逼。 
如果你想回退到之前某个版本，打git log， 会看到一陀数， 那个应该就是你的commit的md5值， 
然后打git reset --hard + 数， 就ok， 这时候就可以提交了。
但是有问题会。

4. git 提交
基本上就是先git add 两遍， 然后commit ， 也可以直接commit -m 什么的。
要是你reset之前的版本，会跟远程版本的不一直，这就难搞了， 
一个比较正常的做法是 git pull origin，将远端的代码搞下来， 然后打git merge， 然后开冲突文件，
 你的文件基本上就会显示有冲突的地方， 你修改之后commit就可以了， 这是做比赛最需要的！ 
为什么呢， 因为我们需要修改参数，有的时候太乱了，特别容易坑爹TT。 

5. 打tag
git tag 版本号
git tag 版本号 -m "添加对该标签的评论"
git push --tags
git tag -d 版本号 #删除tag 


====================================================
优秀博客推荐：csdn/cnblog/iteye/
[1]http://swiftlet.net/archives/category/java-basic
[2]http://www.weixueyuan.net/java/rumen/
[3]http://www.ibm.com/developerworks/cn/java/j-lo-javaio/
[4]http://www.runoob.com/java/java-regular-expressions.html




