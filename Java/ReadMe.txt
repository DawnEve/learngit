
====================================================
目录：


第一章：编程基础 3-11 
    - 变量、运算符、流程控制;
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

    - 接口： 
    
    

第四章：异常机制 74 -89
第五章：多线程技术 89 -122
第六章：常用类 API 122-139
第七章：集合框架（容器） +其他类对象使用 139 -199
第八章：IO 流 199 -280
第九章：GUI编程 280 -284
第十章：网络编程 284 -309
第十一章：反射机制 310 -315
第十二章：正则表达式 315 -322
第十三章：HTML语言 322 -335
第十四章：CSS语言 335-341
第十五章：JavaScript 语言 341-375
第十六章：DOM 375-429
====================================================
doc path: D:\coding\Java

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
优秀博客推荐：
[1]http://swiftlet.net/archives/category/java-basic







