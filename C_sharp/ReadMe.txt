﻿# ELISA data analysis

https://github.com/kaedei/gitignore/blob/master/VisualStudio.gitignore
for c#

day1:
	aboutMe
	tabPage
	mathQuiz: timer
	pictureViewer
	ExtendForms
	MDI_window
	
day2:
	别人做好的程序：可以参考界面
	D:\安装程序\数据分析\ELISA\mELISA 1.0.1.0
	
	dataGridView:初步使用该控件，鼠标设置和代码设置
	ExcelFile：
		继续练习dataGridView控件，尽量代码设置：复制/粘贴/剪切/删除
		写了一个类：初始化界面。
		文件的保存与获取。
	fileReadWrite:
		.dat文件的解析。对话框选取文件的读写。
		对文件的解析，写成类文件。【数据结构】很复杂：
			- OD值采用二维数组；
			- 模板基本信息采用字典；
			- 模板设置信息采用字典 + 对象；
		怎么保存？先新建文档，整合该项目和项目ExcelFile。
	ExcelFile2:	
		(1)怎么使dataGridView控件失去焦点为什么还处于选中状态？
		在leave事件中添加控件的ClearSelection方法。
		private void dataGridView1_Leave(object sender, EventArgs e)
        {
            this.dataGridView1.ClearSelection();
        }
		(2)主文件只写事件处理函数，其他函数都移动到主文件之外的独立文件中。
		第0个控件显示设置，只读；第1个控件显示OD。
		(3)增加了DataReadWrite类，能实现从文件读取到界面了。颜色还没有实现。
		(4)增加读取模板后的颜色变化std#008000, ctr#9ACD32, blank#808080,smp#87CEFA;
		    this.label1.BackColor = System.Drawing.Color.FromArgb(69, 209, 208);
            this.label1.BackColor = System.Drawing.ColorTranslator.FromHtml("#008000");
		(5)C#中设置ComboBox控件为不可编辑状态
			comboBox.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
			comboBox检测：http://www.shangxueba.com/jingyan/1829518.html
		(6)删除模板中的单元格，od值表不受影响。		
		怎么对每个选中的单元格赋值？
		//清除所选区域
        public static  void clearSelectCell(DataGridView dgv) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 12; j++)
                {
                    if (dgv.Rows[i].Cells[j].Selected==true)
                      dgv.Rows[i].Cells[j].Value = "";
                }
            }
        }
		(7)加入了内置模板类，方便扩展内置模板数量。
		(8)数据从界面保存到文件，有问题：
			- [0]ok 基本信息可以保存，
			- [1] od没设置时不应该是0；改用string[,]基本可行，一会改为double[,]。
				[bug-ok]已经改用double[,]，但是空白会被保存为0.(已经解决，使用的是默认赋值-10000)
			- [2] tpl保存正常；
			- [3]ok 如果调试好了，删除几个测试btn的代码
			- [4] 打开文件如果没有od信息会报错。
				原因是读取不到curve信息所以报错。稍后增加curve控件后修复。
				打开文件前也要刷新2个DataGridView控件。
			- [5] 切换内置模板不刷新页面bug。无法重现。
			- [6]ok 载入数据是否也清空所有od数据？yes
				而载入模板不需要清空od数据。
				
			- [7] 增加拟合选项按钮：radioButton
				用法：http://www.codefans.net/articles/1688.shtml
			- [8] 计划用第二个窗体进行拟合计算、画图
		(9)从界面获得数据，线性拟合，画图。
			- [0] 熟悉拟合方法-记录在day4的1中；
				利用最小二乘法拟合任意次函数曲线（C#）：http://blog.sina.com.cn/s/blog_6e51df7f0100thie.html
				添加了CurveFits方法，但是并没有立刻使用。需要添加第二个窗体，用来拟合、画图；
			- [1] 可以从第一个窗体向后传值，并用于demo画图。
				整理传递三个变量。可以打印这三个变量。（如果模板没有设置，则相应od数据程序不予处理）
			- [2] 整理std数据，已经整理好，拟合成功参数y=a0+a1*x 返回值则为a0 a1。并计算了R^2.
			- [3] 开始画图，初步能画图，但是数据还需要调整。
			- [4] 第一次调整，没有坐标轴。增加了myDebug类和myDraw类。
			- [5] 使用g.DrawCurve(new Pen(Color.Red, 1), temps,0.2F);方法划线，速度快、效果好。bug[2]
			- [6] 画出原始std空心点。g.DrawEllipse(new Pen(Color.Green), p.X, p.Y, dot_radius, dot_radius);//6
			- [7] 修复了bug：修改模板信息后，内置模板下拉框立刻变为“自定义模板”字样。
			- [8] 画出了坐标轴。用到了 匿名函数 做坐标变换，其他点（原始点）的绘制也用到该坐标变换。
			
				http://www.cnblogs.com/knowledgesea/p/3163725.html
				lambda表达式: Func<int, string> gwl = p => p + 10;// "--返回类型为string";
				调整表达式 使坐标尽量大且都显示。fix bug[2]
				
			- [9] 对坐标轴增加 自定义箭头 
				//定义铅笔的头部箭头
				System.Drawing.Drawing2D.AdjustableArrowCap lineArrow =
					new System.Drawing.Drawing2D.AdjustableArrowCap(4, 4, true);
				pen1.CustomEndCap = lineArrow;
			- [10] 画出了x、y轴刻度。
			- [11] 标注了x、y轴刻度，但是数据太大！
				已经使用科学计数法表示，但是边缘依旧不好看。
			- [12] 打开文件有异常：曲线类型问题。bug[3]
				打开文件是0的od为什么不显示？
				打开文件时曲线类型没处理
			- [13] fix bug[4]:打开时把od的空值设置为-10000，这个方案还不完美。//todo
			- [14] 坐标轴还是不完善，显示有问题。----------todo
			- [15] 画背景网格线。
			- [16] fix bug:打开文件最后一行全是0，本来是空格的。
			- [17] 生成一个release，测试用。
			单击上网：http://blog.csdn.net/testcs_dn/article/details/42246969		
=====================================================================================
=====[0.2.9.17]======================================================================
	发布地址：https://github.com/DawnEve/learngit/releases
	文档地址：http://blog.163.com/med_devices/blog/static/2199720502015108321798/
 [version 0.2.9.17] 2015-11-8
该版本实现基本的界面设计，可以设置模板，粘贴od数据，打开文件，保存文件，线性拟合，线性画图。
=====================================================================================
		(10) 继续优化第一个拟合功能：线性拟合
			- [1] 使用笔记本对窗体大小做了优化：缩减了底下od的高度。
	
	

		
			[bug]【toDoList】
			[1].修改模板之前应设置逻辑，增加对std的限制，编号只能是数字且浓度相同的必须编号相同。或者内部给编号。
			[2+].为什么点不在线上？
			[3].打开文件有异常：曲线类型问题。
			[4+].打开文件是0的od为什么不显示？
		
		
		
		
		
		
		
		
		

day3:	画图
	winImg1:简单画图，熟悉概念：Graphics、Pen、Brush, Draw开头的划线方法，Fill开头的填充方法
		自定义方法 private void renderXY(Graphics g)画背景坐标：背景虚线、坐标刻度还没画
		下载的CurvePaint类=========todo:需要看懂。
	
	curveRender:(1)我自己的curveRender类，有待完善。已有：坐标轴转换。
			(2)自定义一个箭头，代替不好用的默认箭头
			//自定义箭头-可以用于画坐标轴的箭头
            // http://bbs.csdn.net/topics/390311725
            Pen penSmall = new Pen(Color.Orange, 1);
            System.Drawing.Drawing2D.AdjustableArrowCap lineArrow =
                new System.Drawing.Drawing2D.AdjustableArrowCap(4, 4, true);
            penSmall.CustomEndCap = lineArrow;
            g.DrawLine(penSmall, new Point(100, 10), new Point(500, 10));
			(3)旋转的箭头
	winImgSaveCopyPaste:图片的保存。复制，粘贴。截屏（很不完善）。
		(1)保存图片
			//先新建位图
			Bitmap b = new Bitmap(this.pictureBox1.Width, this.pictureBox1.Height);
			//通过pictureBox1的DrawToBitmap方法获取该图片到位图中
			this.pictureBox1.DrawToBitmap(b, new Rectangle(0, 0, this.pictureBox1.Width, this.pictureBox1.Height));

			//保存位图
			b.Save(fileName);
			//释放位图资源
			b.Dispose();
	winChart:另一个画图控件chart。感觉用于画饼状图、柱状图。
	
	myCurve:正在做的项目集成。2窗口的切换、关闭。v1.0
		修改启动窗体：Program.cs里面修改
			Application.Run(new LoginForm());
			但是有一点要注意，你将loginform作为启动窗体之后，这个窗体是不能关闭的，一旦关闭，程序就结束了，只能隐藏

		保存。复制。
		怎么从第一个窗体向另一个窗体传值？
				//http://zhidao.baidu.com/link?url=kxz98yHmsCCjGoaRyiLOb16MDHLVXH2tgpEE_R8aK5UN1Y6nP4j78Eg5z0PGx07HMQgE1dAAoZEK9it8cbv2YSeEJwGK9t-1opUptfUhHEe
	
day4:	拟合
		01-polyfit: 拟合算法的集合
			1). [1]CurveFit类：多项式拟合，包括线性拟合（一次方拟合）；
				[2]FittingFunct类：多项式拟合，指数拟合等；没看懂
			
	
day5:	报表与打印：
	http://blog.sciencenet.cn/blog-244606-747345.html
	reportView: 可以读取并显示用户设置的数据了，可以导出到excel，但速度极慢无比。
	

----------------------------
ReportViewer优势评测

免费-微软自带的免费报表控件，不存在任何版权或者限制
简单-ReportViewer适合轻量的报表，开发相对简单
所见即所得-你只要在报表中设定好格式，打印出来是跟你看到的报表一样的
查看/打印-ReportViewer报表浏览器集成了报表查看及打印预览功能，可直接输出到打印机，也可直接输出为Excel文件或PDF文件，对于习惯Excel表格的人来说，ReportViewer报表控件非常适合
双平台-既可以在Web程序中使用，也可以在Windows程序中使用
----------------------------

	
	
	
	
	
	
	
	
	
	
	
---------------------------
安卓的开源项目
http://blog.csdn.net/sasoritattoo/article/details/26400347
---------------------------
主要内容
- 按钮
- 标签
- 文本框
- 单选框和复选框
- 进度条





第1周 绘图及图像
第2周 文本处理及正则表达式
第3周  网络信息获取及Xml处息
第4周 多线程与异步编程
第5周 访问数据库
第6周 如何写好应用程序
第7周 深入理解C#语言



=============================================
微软虚拟学院 — 免费微软技术培训
http://www.microsoftvirtualacademy.com/

c#视频教程
https://channel9.msdn.com/series/c-sharp-fundamentals-development-for-absolute-beginners



百度的xaml教程（for win8 and msPhone）
http://wenku.baidu.com/link?url=9vdt5YM6Np_M_ORdvdZLu5nI-I0cAwae_rQ-X9-PzThSIzTtg337M5OWRqHqhvrDIcoGbXJ9d1fk62uMSsaLW1scBD712s-UcjmdWUOBfGW
=============================================
excel文件的读写：
http://blog.csdn.net/testcs_dn/article/details/25509249


=============================================
一个小时快速入门

接下来关于 C# 的讨论主题：
编程结构      命名空间      变量           数据类型          枚举
类与结构      属性          修饰符         接口              数组
索引器        装箱与拆箱    函数参数       运算符与表达式    语句
委托          继承与多态

以下主题不会进行讨论：
C++ 与 C# 的共同点       诸如垃圾回收、线程、文件处理等概念
数据类型转换             异常处理         .NET 库




--------------------------------
c# books at the library
01020205400906|二楼北：工程与信息技术书库 27架B面9列6层(2)
 
01020205500102|二楼北：工程与信息技术书库 28架A面1列2层
 
01020205500102|二楼北：工程与信息技术书库 28架A面1列2层
 
01020205400906|二楼北：工程与信息技术书库 27架B面9列6层
01020205500102|二楼北：工程与信息技术书库 28架A面1列2层
01020205400906|二楼北：工程与信息技术书库 27架B面9列6层
 
 
--------------------------------
msdn的VB教程
https://msdn.microsoft.com/zh-cn/library/2x7h1hfk.aspx

--------------------------------
asp.net的教程
http://www.runoob.com/aspnet/aspnet-tutorial.html

1.	3.54    21.8
2.	3.74	23
--------------------------------
MSDN资源：
https://msdn.microsoft.com/zh-cn/library/ms180794(v=vs.80).aspx

MSDN C#3个例子
https://msdn.microsoft.com/zh-cn/library/dd492171.aspx
第三个例子
https://msdn.microsoft.com/zh-cn/library/dd553235.aspx

客户端开发：
https://msdn.microsoft.com/zh-cn/aa570309#two

windows SDK
http://www.microsoft.com/en-us/download/details.aspx?id=8279

--------------------------------
c#(.net framework)环境变量：

C:\Windows\Microsoft.NET\Framework\v4.0.30319>csc
Microsoft (R) Visual C# Compiler version 4.6.0081.0
for C# 5
Copyright (C) Microsoft Corporation. All rights reserved.

This compiler is provided as part of the Microsoft (R) .NET Framework, but only
supports language versions up to C# 5, which is no longer the latest version. Fo
r compilers that support newer versions of the C# programming language, see http
://go.microsoft.com/fwlink/?LinkID=533240

warning CS2008: 未指定源文件
error CS1562: 必须为没有源的输出指定 /out 选项

C:\Windows\Microsoft.NET\Framework\v4.0.30319>
