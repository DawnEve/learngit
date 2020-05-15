#我的程序日记本：
廖雪峰的示例：https://github.com/michaelliao/learn-python3/tree/master/samples
廖雪峰博客： https://www.liaoxuefeng.com/wiki/1016959663602400
我的示例：https://github.com/DawnEve/learngit/tree/master/python3/

python3练习：https://www.cnblogs.com/cjsblog/p/9427157.html

Python官方的pypi.python.org网站注册

独立应用：
1.英语单词频率分析软件：day9/enTextAnalysis/wordFreq.py
	优化20180519：使用缓存提速。

==========================================
经验教训
1.文件头部
#!/usr/bin/env python3
# -*- coding: utf-8 -*-

2.命名文件的时候千万不要和要import的文件重名！

3. dir(str)查方法
比如查找正则表达式帮助，在命令行输入：
import re; help(re); dir(re); help(re.match) 
==========================================

第一天：运行模式、数据格式
	环境安装、两种运行模式(交互式和批量运行)
	测试中文是否支持
	格式化和C语言类似
	测试linux环境怎么直接运行python：需要加+x权限，然后./xx.py执行
	
	使用jupyter notebook网页运行python命令：学习python利器
		安装：pip install jupyter
		使用：windows的cmd中输入 jupyter notebook
		执行cell: shift+Enter
	
	Python3 的六个标准数据类型中：
		不可变数据（四个）：Number（数字）、String（字符串）、Tuple（元组）、Sets（集合）；
		可变数据（两个）：List（列表）、Dictionary（字典）。
		
		查询数据类型：type("good") #<class 'str'>
		最重要的是列表、元组、字符串和字典。
	list类型:[]
		分片赋值 mylist=list("some")
		是否在数组中 2 in number #True
		list的方法：append(),pop(),count(),
	tuple类型：()
		不可变所以安全，但是内嵌list时可变list内容；
	
	字符串
		截取 str2[n:m]
		格式化：printf()
		字符串的乘法表达式 "good"*3
		方法：replace,join,split,upper等。
	字典：没有顺序的键值对。
		常用的方法：keys,values,items等
	题目：从长字符串中截取出一个单词。

第二天：控制结构	
	if判断：is运算符、布尔运算符
		断言assert
	循环：
		while循环
		for循环：for x in range(101):
		打断： 终止循环 break; 跳过本次循环 continue;
		空语句：pass;
	dict字典元素（就是json）
	set集合：不能重复
	题目：1.猜数字游戏，只提示大和小，和猜的次数。
		2.求a和b之间奇数的和。

第三天：函数(减少重复代码、方便测试和复用)
	函数，获得帮助 help(abs)
	参数：
		默认参数, 函数的默认参数必须指向固定值
		可变参数: *para, **para 构建字典传入多个参数
	作用域：全局变量与本地变量，除非使用globe para 否则不改写全局变量的值。
	返回值：没有return则返回None。if xx is None:
	迭代: 求阶乘
	函数嵌套:
	返回函数: 闭包closure
	匿名函数lambda

	题目: py函数的坑。求单词复数形式。快速排序算法[todo]。


第四天：迭代器、生成器、过滤器、装饰器、偏函数
	切片：list和tuple
	迭代器
	字典的迭代
	生成器：yield用法(杨辉三角)
	高阶函数
	map和reduce
	filter:过滤器
	sorted()
	装饰器decorator（不懂）
		day4/decorator/

	偏函数（Partial function）



第五天：模块、包和包管理器PIP
	在Python中，一个.py文件就称之为一个模块（Module）。
	自己创建模块时要注意命名，不能和Python自带的模块名称冲突。
	导入 
		import random
		from time import clock

	第三方库都会在Python官方的pypi.python.org网站注册。
	pip是python包管理器。
	pip搜索：(搜索PIL) pip search imaging-library
	pip安装: pip install Pillow
	常用的第三方库:
		- Python Imaging Library, PIL，这是Python下非常强大的处理图像的工具库。
		- MySQL的驱动：mysql-connector-python
		- 用于科学计算的NumPy库：numpy
		- 用于生成文本的模板工具Jinja2, 等等
	模块搜索路径：sys.path
		添加自定义路径：sys.path.append("/path/to/my/package/")






第六天：面向对象OOP
	构造函数：在init中初始化对象的全部属性是一个好习惯。
	数据封装：封装的不彻底
		私有属性: __name
		私有方法: __fn()
	继承和多态:也不严格，“鸭子类型”（JAVA的interface才是精华）
		继承中的构造函数的执行
		py允许多重继承：参见day7
		类型判断: isinstance(dog, Dog) )
		多态的真正威力：调用方只管调用(该方法存在)，不用关心细节。
		实例属性和类属性
	获取对象信息：type或isinstance判断会毁掉多态。要尽量保持多态。
		type()基本类型的判断；
		isinstance()不仅能判断基本类型，还能判断继承关系；
		dir("str")获得一个对象的所有属性和方法。
		hasattr(a,b)

第七天 OOP adv 面向对象高级：多重继承、定制类、元类【难！！！特别是元类】
	多重继承:一个子类可以继承多个父类，同时获得多个父类所有的非私有功能。py允许mixin写法。
	定制类(类的专有方法、魔术方法)：__len__, __str__, __repr__, 
		Fib.py:__iter__, __next__, __getitem__,
		__call__:可以对实例直接调用 instance(), callable()函数
		slice, REST API(链式调用), 
	OOP高级
	__slots__变量，来限制该class实例能添加的属性
	@property:对直接操作的属性做限制
	使用枚举类
	使用元类(太难了！为了不影响学习的积极性，还是暂且跳过这章吧)

第八天：异常
	错误处理: try-except-else-finally
		 捕获多个异常; else子句; BaseException基类
	自定义异常，抛出异常: raise 抛出错误.
	debug:
		- 虽然用IDE调试起来比较方便，
		但是最后你会发现，logging才是终极武器。
	单元测试 class TestDict(unittest.TestCase):
	文档测试:docTest(没懂)

第九天：IO
	文件读写:内存为核心，流进内存的叫input,从内存写到硬盘或发到网络的叫output。
	read、write:使用with语句操作文件IO是个好习惯。
	StringIO和BytesIO:就是内存的读写
	操作文件和目录:环境变量； 路径操作汇总http://www.jb51.net/article/59901.htm
		文件重命名 os.rename(oldName, newName) 没有返回值;
		删除文件 os.remove(path)
		文件是否存在 os.path.isfile("001.cache")
		文件夹是否存在 os.path.exists(dirName)
	序列化：pickle
		- Python语言特定的序列化模块是pickle，
		- 但如果要把序列化搞得更通用、更符合Web标准，就可以使用json模块。
			ss=json.dumps(s, default=stu2dict) #序列化
			s2=json.loads(ss, object_hook=dict2stu) #反序列化
	某个字符出现的次数 str2.count('a')	
	重置文件指针：file.seek(0, 0)
	图片进行base64编码
	求中文文本文件的md5值：

	[实例]
	1.合并文件夹下所有文本文件的内容 day9/mergeAllFileInOne/
	2. day9/enTextAnalysis/ 分析英文文章中用词频率，和超出4/6级的词汇。该文件夹包含部分4-6级词汇list。




第十天：进程和线程(难点，需要反复练习和研究) py的多进程Process才有意义。py多线程是鸡肋。
	进程和线程(Python既支持多进程，又支持多线程)
		- 对于操作系统来说，一个任务就是一个进程（Process）
		- 有些进程还不止同时干一件事，比如Word，它可以同时进行打字、拼写检查、打印等事情。
			在一个进程内部，要同时干多件事，就需要同时运行多个“子任务”，
			我们把进程内的这些“子任务”称为线程（Thread）。
	#多进程的几种形式
		- 多进程模式；
		- 多线程模式；
		- 多进程+多线程模式。	最后一种太复杂，很少用。
	多进程和多线程的程序涉及到同步、数据共享的问题，编写起来更复杂。
	但是类似电影必须多线程：一个播放画面，一个播放声音。
	多进程：fork() 在linux下建立子进程。
		Process()实例可以跨系统开启多线程。
		启动大量的子进程,可以用进程池的方式Pool.
	子进程：subprocess模块非常方便地启动一个子进程，然后控制其输入和输出。
		- linux下是封装的fork()
		- windows下是用pickle模拟的,失败要先考虑是不是pickle失败了。
	进程间通信：Python的multiprocessing模块包装了底层的机制，提供了Queue、Pipes等多种方式来交换数据。
		我们以Queue为例，在父进程中创建两个子进程，一个往Queue里写数据，一个从Queue里读数据。
		进程之间的通信：https://blog.csdn.net/tanzuozhev/article/details/77090119

	Python的线程是真正的Posix Thread，而不是模拟出来的线程。
	threading.Thread(target=loop, name='LoopThread')
	多进程不共享变量，而多线程共享变量，有变量改乱的风险。
	锁与死锁。
	ThreadLocal:
		一个ThreadLocal变量虽然是全局变量，但每个线程都只能读写自己线程的独立副本，互不干扰。
		ThreadLocal解决了参数在一个线程中各个函数之间互相传递的问题。
	
	进程 vs. 线程
	用异步IO编程模型来实现多任务是一个主要的趋势。
	协程:
		对应到Python语言，单进程的异步编程模型称为协程
		有了协程的支持，就可以基于事件驱动编写高效的多任务程序。
	
	
	分布式进程
	(1)task_master.py 在Ubuntu上添加文件头，先运行。
#!/usr/bin/python
# -*- coding: utf-8 -*-
	
	(2)task_worker.py 在win7上接着运行。
	

第十一天：正则表达式RegExp:与Perl中的正则类似。
http://www.runoob.com/python/python-reg-expressions.html
	字符匹配：
		re.match(r'^\d{3}\-\d{3,8}$', '010-12345')
		re.search(r'cat', 'this is a cat', re.I)
		group(0)是字符串本身，group(1)是第一个匹配项；groups()返回匹配字符数组。
	字符分割
		#无论多少个空格都可以正常分割。	
		re.split(r'\s+', 'a b   c') # ['a', 'b', 'c']
	字符替换
		re.sub(r'\D', '', '010-123-456') #'010123456'
	字符提取
		import re
		m = re.match(r'^(\d{3})-(\d{3,8})$', '010-12345')
		print(m) #<_sre.SRE_Match object; span=(0, 9), match='010-12345'>
		print(m.groups()) #('010', '12345')
		#注意到group(0)永远是原始字符串，group(1)、group(2)……表示第1、2、……个子串。
		print(m.group(0)) #010-12345
		print(m.group(1)) #010
		print(m.group(2)) #12345		
	贪婪匹配
		默认是贪婪匹配
		非贪婪匹配就是量词后面加上?
	编译
		正则表达式默认是先编译，不出错后再匹配。
		如果一个正则表达式使用次数频繁，就可以一次编译，多次使用。
		
		


第十二天：常用内建模块
	Python之所以自称“batteries included”，就是因为内置了许多非常有用的模块，无需额外安装和配置，即可直接使用。
	获取帮助：命令行模式下，import time; dir(time); dir(time.mktime); help(time.mktime)
	日期和时间: time, datetime, calendar
		datetime:获取当前日期
	collections:内建的一个集合模块，提供了许多有用的集合类。
	base64:
	struct模块: 来解决bytes和其他二进制数据类型的转换。 不懂
	
	hashlib模块: md5 sha1摘要计算
	itertools：迭代器工具。 不懂

	XML：http://www.w3school.com.cn/xml/index.asp
	HTMLParser
	urllib提供了一系列用于操作URL的功能。很好用，可以用于爬虫抓取步骤！

	smtplib 发送邮件

第十三天：常用第三方模块
	基本上，所有的第三方模块都会在PyPI - the Python Package Index上注册，只要找到对应的模块名字，即可用pip安装。
	virtualenv:隔离的python版本环境



第十四天：图形界面
	布局是个大话题，简单说就是我们没有指定任何布局时系统有个默认布局，
	如果要自己控制位置和大小，需要指定布局和各种参数，要把GUI全部讲清楚可以写一本书了，
	这里只能是入门GUI的Hello World


第十五天：网络编程, DB, 框架
	TCP/IP
		tcp: hello_server, hello_client
		udp:
			UDP的使用与TCP类似，但是不需要建立连接。
			此外，服务器绑定UDP端口和TCP端口互不冲突，也就是说，UDP的9999端口与TCP的9999端口可以各自绑定。
	get和post请求：https://www.cnblogs.com/goldd/p/5457229.html
	
	访问数据库:SQLite MySQL 
		ORM(Object-Relational Mapping)框架： SQLAlchemy
		
	Python内置了一个WSGI服务器，这个模块叫wsgiref
		因为我们不希望接触到TCP连接、HTTP原始请求和响应格式，所以，需要一个统一的接口，让我们专心用Python编写Web业务。
		这个接口就是WSGI：Web Server Gateway Interface。
	Web开发：web框架,把我们从WSGI中拯救出来了。
	使用Web框架:比较流行的Web框架——Flask来使用。用Flask编写Web App比WSGI接口简单
	Flask: http://flask.pocoo.org/

	除了Flask，常见的Python Web框架还有：
	- Django：全能型Web框架； https://www.djangoproject.com/
	- web.py：一个小巧的Web框架； http://webpy.org/
	- Bottle：和Flask类似的Web框架； http://bottlepy.org/docs/dev/
	- Tornado：Facebook的开源异步Web框架。http://www.tornadoweb.org/en/stable/
	当然了，因为开发Python的Web框架也不是什么难事，我们后面也会讲到开发Web框架的内容。

	有了MVC，我们就分离了Python代码和HTML代码。HTML代码全部放到模板里，写起来更有效率。
	Flask默认支持的模板是jinja2:  pip install jinja2
	使用模板jinja2
		"不懂前端的Python工程师不是好的产品经理",Web App最复杂的部分就在HTML页面。
		http://jinja.pocoo.org/

	


	
第十六天：异步IO	
	协程的特点在于是一个线程执行，那和多线程比，协程有何优势？
	- 最大的优势就是协程极高的执行效率。
	- 第二大优势就是不需要多线程的锁机制。
	因为协程是一个线程执行，那怎么利用多核CPU呢？最简单的方法是多进程+协程，
		既充分利用多核，又充分发挥协程的高效率，可获得极高的性能。
	
	不懂yield表达式。//TODO
	
	为了简化并更好地标识异步IO，从Python 3.5开始引入了新的语法async和await，可以让coroutine的代码更简洁易读。
	//TODO



第十七天：实战python爬虫
	爬取小说的最佳策略是：从目录页获取章节链接，然后下载每个章节-> a04_getNovel_fromMenu.py
	遇到的坑：
		 如果原文有/n则需要加上re.S参数：  re.findall(reg,chapt_html, re.S)
		chapt_html = tempt.decode('GB2312',errors='ignore') #指定编码, 忽略错误 
	希望爬取现实主义题材的小说：
		萧东楼： 《广州的一场春梦》、《猎头局中局》、《猎头局中局II》、《进退·猎头局中局前传》等
			http://book.jrj.com.cn/book/book/bookinfo_424.shtml

第十八天：实战python Web项目
	先学好flask框架、异步再继续。



