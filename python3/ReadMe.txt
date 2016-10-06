#我的程序日记本：
廖雪峰的示例：https://github.com/michaelliao/learn-python3/tree/master/samples
我的示例：https://github.com/DawnEve/learngit/tree/master/python3/

第一天：运行模式、数据格式
	基础知识。
	测试中文是否支持；
	测试linux环境怎么直接运行python：失败  //todo
	格式化和C语言类似。
	list类型的append方法和pop方法
	tuple类型：不可变所以安全，但是内嵌list时可变list内容；

第二天：控制结构	
	if循环
	for循环：for x in range(101):
	dict字典元素（就是json）
	set集合：不能重复
	while循环

第三天：函数	
	函数，默认参数
	函数的默认参数必须指向固定值
	函数：构建字典传入多个参数
	迭代
	函数嵌套
	函数：全局变量与本地变量
	
第四天：迭代器、生成器、过滤器、装饰器、偏函数
	切片：list和tuple
	迭代器
	字典的迭代
	生成器：yield用法(杨辉三角)
	高阶函数
	map和reduce
	filter:过滤器
	sorted()
	闭包closure
	匿名函数lambda
	装饰器decorator（不懂）
	偏函数（Partial function）（不太懂）
	
第五天：模块、包和包管理器PIP
	模块与包  运行不了MHello.py //todo
	常用的第三方库:#pip install Pillow
		- MySQL的驱动：mysql-connector-python
		- 用于科学计算的NumPy库：numpy
		- 用于生成文本的模板工具Jinja2, 等等
	升级pip：（win7下升级会出错！如果没必要，还是别升级了）
		- You are using pip version 6.0.8, however version 7.1.2 is available.
You should consider upgrading via the 'pip install --upgrade pip' command.
	导入 import random      from time import clock

第六天：面向对象
	OOP
	数据封装：封装的不彻底
	继承和多态:也不严格，“鸭子类型”（JAVA的interface才是精华）
	获取对象信息：dir(),hasattr(a,b)
	实例属性和类属性
	
第七天【难！！！特别是元类】：面向对象高级
	OOP高级
	__slots__变量，来限制该class实例能添加的属性
	@property:对直接操作的属性做限制
	多重继承
	定制类：__len__, __str__, __repr__, slice, REST API(链式调用), 
	使用枚举类
	使用元类(太难了！为了不影响学习的积极性，还是暂且跳过这章吧)
	
第八天：异常
	错误处理
	debug:		
		- 虽然用IDE调试起来比较方便，
		但是最后你会发现，logging才是终极武器。
	单元测试 class TestDict(unittest.TestCase):
	文档测试:docTest(没懂)

第九天：IO
	文件读写
	read、write:使用with语句操作文件IO是个好习惯。
	StringIO和BytesIO:就是内存的读写
	操作文件和目录:环境变量； 路径操作汇总http://www.jb51.net/article/59901.htm
	序列化：pickle
		- Python语言特定的序列化模块是pickle，
		- 但如果要把序列化搞得更通用、更符合Web标准，就可以使用json模块。
			ss=json.dumps(s, default=stu2dict) #序列化
			s2=json.loads(ss, object_hook=dict2stu) #反序列化
		
		
第十天：进程和线程
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
		- windows下是用pickle模拟的,失败要先虑是不是pickle失败了。
	进程间通信：Python的multiprocessing模块包装了底层的机制，提供了Queue、Pipes等多种方式来交换数据。
		们以Queue为例，在父进程中创建两个子进程，一个往Queue里写数据，一个从Queue里读数据。
		

	
	

#


//TODO

第十一天：正则表达式





第十二天：常用内建模块
	


第十三天：常用第三方模块



第十四天：图形界面


第十五天：网络编程
	TCP/IP
	访问数据库:SQLite MySQL
	Web开发：web框架
	
	
第十六天：异步IO	
		
第十七天：实战python Web项目




		