using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ExcelFile
{
    public partial class reportForm : Form
    {
         /* 定义一些公用属性
         *  
         */
        //====================================中间信息（文件与界面之间）
        //板子基本信息-plate_Info
        private Dictionary<string, string> plate_info = new Dictionary<string, string>();

        //板子模板设置信息
        private Info[,] tpl = new Info[8, 12];

        //板子OD信息
        private Double[,] od = new double[8, 12];

        //====================================加工后的信息
        //private List<Info> std
        public Graphics g;

    
        public reportForm()
        {
            InitializeComponent();
        }


        private void reportForm_Load(object sender, EventArgs e)
        {
            //初始化重新拟合按钮
            btnFitAgain.BackColor = Color.Red;
            btnFitAgain.ForeColor = Color.White;
            btnFitAgain.FlatStyle = FlatStyle.Flat;

            //获取数据
            getData();

            //尝试打印接收的数据
            //DemoShowData();
        }


        private void btnFitAgain_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        private void reportForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            this.Dispose();
        }


        //从前一个窗体获得数据
        private void getData()
        {
            //获取第一窗体输入的数字
            //int num = ((Form1)this.Owner).num;
            plate_info = ((Form1)this.Owner).plate_info;
            tpl = ((Form1)this.Owner).tpl;
            od = ((Form1)this.Owner).od;
        }

        //计算线性拟合的标准曲线
        private void calclateStd(Graphics g) {
            //计算标准曲线
            List<PointF> stdPoints = new List<PointF>();//保存标准曲线上的点

            //lambda表达式 : double变为float格式
            Func<double, float> double2Float = x => float.Parse(x.ToString());

            //整理出标准品数据，用字典实现conc唯一性
            int std_count = 0;
            Dictionary<double, List<Info>> std = new Dictionary<double, List<Info>>();
            for (int i = 0; i < 8; i++)
            {
                for (int j = 0; j < 12; j++)
                {
                    Info info = tpl[i, j];
                    List<Info> infoPlus = new List<Info>();
                    if (info != null && info.well_class == "std")
                    {
                        //增加od属性
                        info.well_od = od[i, j]; 
                        //整合到数据中
                        if (std.ContainsKey(info.well_conc))
                        {
                            //如果存在，则先获得od值，然后增加
                            infoPlus = std[info.well_conc];
                            infoPlus.Add(info);
                            std.Add(info.well_conc, infoPlus);
                        }
                        else
                        {
                            //首次增加
                            std_count++;
                            infoPlus.Add(info);
                            std.Add(info.well_conc, infoPlus);
                        }
                    }
                }
            }
            //整理x和y数组
            double[] arr_x = new double[std_count];//conc
            double[] arr_y = new double[std_count];//od

            int std_i = 0;//最大值为 std_count
            foreach (double conc in std.Keys)
            {
                //MessageBox.Show(conc.ToString());
                arr_x[std_i] = conc;
                List<Info> list=std[conc];

                

                int od_counter=0;
                double od_sum = 0; 
                foreach(Info info in list)
                {
                    double temp = double2Float(info.well_od);
                    od_sum += temp;
                    od_counter++;

                    //保存标准曲线上的点
                    stdPoints.Add(new PointF(double2Float(conc), double2Float(temp)));
                }
                arr_y[std_i] = od_sum / od_counter;//计算od的平均值
                std_i++;
            }


            //输出数组
            //showArray(arr_x);
            this.richTextBox1.Text += "\r\r";
            //showArray(arr_y);


            //拟合计算============================================================================
            int Pointlen = arr_x.Length;
            //拟合，返回参数列表
            Double[] paras = CurveFit.MultiLine(arr_x, arr_y, Pointlen,1);

            //输出结果
            //y=a0+a1*x 返回值则为a0 a1
            int len = paras.Length;

            string str = "";
            for (int i = 0; i < len; i++)
            {
                str += paras[i].ToString() + "\r\n";
            }
            //显示结果
            this.richTextBox1.Text += str;



            //由参数计算回算测量值=============================================
            double a0 = paras[0], a1 = paras[1];
            double rss = 0, tss = 0;//残差平方和，总平方和

            double[] arrX2 = new double[Pointlen];//用于浓度回算
            double[] arrY2 = new double[Pointlen];//用于计算RSqure
            for (int i = 0; i < Pointlen; i++)
            {
                arrX2[i] = (arr_y[i] - a0) / a1;
                arrY2[i] = a0 + a1 * arr_x[i];

                rss += Math.Pow(arr_y[i] - arrY2[i], 2);
                tss += Math.Pow(arr_y[i], 2);
            }


            //计算R^2
            double RSqure = 1 - rss / tss;
            //this.richTextBox1.Text += "\r\nRSqure=" + RSqure;
            this.label2.Text = RSqure.ToString();


            //==========================================================画图 basic
            //计算最值
            double[] xM = getMinMax(arr_x);
            double[] yM = getMinMax(arr_y);
            //当前画布最值
            double pWidth = this.pictureBox1.Width;
            double pHeight = this.pictureBox1.Height; //this.richTextBox1.Text += "\r\r画布尺寸(" + pWidth + "," + pHeight + "); \r";
            //坐标轴范围
            double x_span=xM[1]-xM[0];
            double y_span=yM[1]-yM[0];

            //lambda表达式 : 做坐标变换，
            Func<double, double> getAjustX = x => 1 * (x - xM[0]) * pWidth / x_span;
            Func<double, double> getAjustY = y => 1 * (pHeight - (y - yM[0]) * pHeight / y_span); //纵轴倒置


            //==========================================================画图 坐标轴
            //定义铅笔
            Pen pen1 = new Pen(Color.Black, 1);//画坐标轴
            Pen pen2 = new Pen(Color.Black, 1);//画刻度
            //定义铅笔的头部箭头
            System.Drawing.Drawing2D.AdjustableArrowCap lineArrow =
                new System.Drawing.Drawing2D.AdjustableArrowCap(4, 4, true);
            pen1.CustomEndCap = lineArrow;


            //--------------------定义坐标轴刻度
            //坐标轴刻度 - 先按照 10格
            double x_kedu =Math.Ceiling( x_span/10 );//刻度
            double y_kedu = Math.Ceiling(y_span / 10);

            double x_o = xM[0] + x_kedu*0.5;//坐标轴所在位置
            double y_o = yM[0] + y_kedu*0.6;


            //--------------------画坐标轴
            //定义坐标点-x轴
            PointF px1 = new PointF(0, double2Float(getAjustY(y_o)));
            PointF px2 = new PointF(double2Float(getAjustX(xM[1])), double2Float(getAjustY(y_o)));
            //定义坐标点-y轴
            PointF py1 = new PointF(double2Float(getAjustX(x_o)), double2Float(getAjustY(0)));
            PointF py2 = new PointF(double2Float(getAjustX(x_o)), double2Float(getAjustY(yM[1])));
            //画坐标轴
            g.DrawLine(pen1, px1, px2);//x
            g.DrawLine(pen1, py1, py2);//y


            //--------------------画坐标轴刻度
            double x_axis = xM[0];
            double y_axis = yM[0];
            int ke_height = 6;//刻度尺寸
            int font_size = 8;
            Font font = new Font("微软雅黑", font_size);//刻度字体
            Brush brush=new SolidBrush(Color.Black);//用笔刷定义刻度字体颜色
            PointF kedu_point;// = new PointF();//刻度的坐标

            //x轴刻度
            while (x_axis <= xM[1])
            {
                //刻度向右递增
                x_axis += x_kedu;
                //定义刻度线的首尾点
                PointF px_k1 = new PointF(double2Float(getAjustX(x_axis)), double2Float(getAjustY(y_o)) - ke_height);
                PointF px_k2 = new PointF(double2Float(getAjustX(x_axis)), double2Float(getAjustY(y_o)));
                //画刻度
                g.DrawLine(pen2, px_k1, px_k2);
                //标上刻度
                kedu_point = new PointF(double2Float(getAjustX(x_axis)) - font_size, double2Float(getAjustY(y_o)));
                g.DrawString(x_axis.ToString(), font, brush,kedu_point);
            }

            //y轴刻度
            while (y_axis <= yM[1])
            {
                //刻度向右递增
                y_axis += y_kedu;
                //定义刻度线的首尾点
                PointF py_k1 = new PointF(double2Float(getAjustX(x_o)) + ke_height, double2Float(getAjustY(y_axis)));
                PointF py_k2 = new PointF(double2Float(getAjustX(x_o)), double2Float(getAjustY(y_axis)));
                //画刻度
                g.DrawLine(pen2, py_k1, py_k2);
                //标上刻度
                int y_axis_len = y_axis.ToString().Length;
                kedu_point = new PointF(double2Float(getAjustX(x_o)) - y_axis_len * font_size/2, double2Float(getAjustY(y_axis)));
                g.DrawString(y_axis.ToString(), font, brush, kedu_point);
            }



            //==========================================================画图 拟合曲线
            //细分点数
            int dot_num = 10;
            List<PointF> pointFList = new List<PointF>();

            //计算拟合出来的点
            double[] xp = new double[dot_num];
            double[] yp = new double[dot_num];
            for (int i = 0; i < dot_num; i++)
            {
                //生成点
                xp[i] = xM[0] + i * x_span / dot_num;
                yp[i] = a0 + a1 * xp[i];

                //针对当前画布调整
                xp[i] = double2Float(getAjustX(xp[i]));
                yp[i] = double2Float(getAjustY(yp[i]));

                //记录曲线
                pointFList.Add( new PointF(double2Float( xp[i] ),  double2Float( yp[i])));
            }
            
            //画很多线 - 很多点连起来就是一条直线
            myDraw.DrawLine(g, pointFList);



            //==========================================================画图 std原始点
            //画std原始点
            //myDraw.DrawPoints(g, xp, yp,1,true);
            PointF p = new PointF();
            int dot_radius = 6;//空心点的大小
            for (int i = 0; i < stdPoints.Count; i++)
            {
                p = stdPoints[i];
                p.X = double2Float(getAjustX(p.X));
                p.Y = double2Float(getAjustY(p.Y));
                g.DrawEllipse(new Pen(Color.Green), p.X, p.Y, dot_radius, dot_radius);
            }


            
        }



        //获取数组的最值
        private double[] getMinMax(double[] d) 
        {
            double min = d[0], max = d[0];
            for (int i = 0; i < d.Length; i++) 
            {
                if (d[i] < min) min = d[i];
                if (d[i] > max) max = d[i];
            }
            return new double[]{min,max};
        }




         private void pictureBox1_Paint(object sender, PaintEventArgs e)
        {
            //初始化图片框样式
            this.pictureBox1.BorderStyle = BorderStyle.Fixed3D;
            this.pictureBox1.Width = 800;
            this.pictureBox1.Height = 400;

            //创建Graphics对象
            //Graphics g = e.Graphics;
            g = e.Graphics;
            //白色背景
            g.Clear(Color.White);

            //画笔画图
            Pen pen = new Pen(Color.Red);
            g.DrawString("The xxx curve", new Font("宋体", 12), new SolidBrush(Color.Blue), new Point(Width / 3, 10));


            //以下尝试画图
            //List<double[]> d=calclateStd();
            //DrawPoint(g);
            //DemoPaint(g);


            calclateStd(g);
        }

        //尝试打印接收的数据
        private void DemoShowData()
        {
            string s = "===basic info \r\n";
            foreach (string k in plate_info.Keys) {
                s += k + ": " + plate_info[k] + "; \r\n";
            }


            s += "\r===tpl \r\n";
            for (int i = 0; i < 8; i++)
            {
                for (int j = 0; j < 12; j++)
                {
                    Info info = tpl[i, j];
                    if (info != null) {
                        s += "tpl(" + i + ", " + j + "):" + info.i + " | " + info.j + " | " + info.well_class + " | " + info.well_num + " | " + info.well_conc.ToString()+"\r";
                    }
                }
            }


            s += "\r===od \r\n";
            for (int i = 0; i < 8; i++)
            {
                for (int j = 0; j < 12; j++)
                {
                    Info info = tpl[i, j];
                    if (info != null)
                    {
                        s += "OD(" + i + ", " + j + "):" + od[i, j].ToString()+"\r";
                    }
                }
            }

            this.richTextBox1.Text = s;

        }

        ////以下尝试画图，可以删除
        private void DemoPaint(Graphics g) 
        {
            int dot_num = int.Parse(plate_info["Curve"]);

            int dot_radius = 6;
            for (int i = 0; i < dot_num; i++)
            {
                float x = Width * i / dot_num;
                float y = (float)(Height / 5 * Math.Sin(x * 3.1415926 / 180)) + Height / 3;//Height * i / dot_num;

                //g.FillEllipse(new SolidBrush(Color.Green), x, y, dot_radius, dot_radius);
                g.DrawEllipse(new Pen(Color.Green), x, y, dot_radius, dot_radius);
            }
        
        }


        //保存按钮
        private void btnSave_Click(object sender, EventArgs e)
        {
            SaveFileDialog saveFileDialog1 = new SaveFileDialog();

            //设置过滤文件类型
            //saveFileDialog1.InitialDirectory = "D:\\";
            //saveFileDialog1.Filter = "jpg|*.jpg;*.jpeg;|bmp|*.bmp;|*.gif,*.ico,*.png,*.tif,*.wmf|*.jpg;*.jpeg;*.bmp;*.gif;*.ico;*.png;*.tif;*.wmf";
            saveFileDialog1.Filter = "jpg|*.jpg;*.jpeg|bmp|*.bmp|gif|*.gif|png|*.png";//设置文件类型 
            saveFileDialog1.FilterIndex = 1;//设置默认文件类型显示顺序 

            //保存对话框是否记忆上次打开的目录
            saveFileDialog1.RestoreDirectory = true;

            //文件标题
            saveFileDialog1.Title = "保存图像";

            //设置默认文件名-日期
            saveFileDialog1.FileName = DateTime.Now.ToString("yyyy-MM-dd");
            //saveFileDialog1.FileName = null;

            saveFileDialog1.ShowDialog();
            //点了保存按钮进入 
            string fileName = saveFileDialog1.FileName.ToString();
            try
            {
                if (fileName != "" && fileName != null)
                {
                    /*
                     * http://zhidao.baidu.com/link?url=HUR9AhZduHR8QeqxW1Nt0yn2zBtl5pjBkLxpi03zrxFUVjxN6Ti1rli4iYMqFQeEZbG3Y_Hk4iEblLfuv1uPlq
                     * 对于创建自窗体的graphics对象，不能直接获取它的位图，
                     * 而是要先获取它所代表的窗体，然后调用窗体的DrawToBitmap方法
                     * 把窗体的图像画到已有的bitmap对象里，然后再由bitmap的save方法保存
                     * 下面跳过graphics对象，直接用this获取窗体：
                     */
                    //先新建位图
                    Bitmap b = new Bitmap(this.pictureBox1.Width, this.pictureBox1.Height);
                    //通过pictureBox1的DrawToBitmap方法获取该图片到位图中
                    this.pictureBox1.DrawToBitmap(b, new Rectangle(0, 0, this.pictureBox1.Width, this.pictureBox1.Height));

                    //防止覆盖的代码
                    if (File.Exists(fileName)) { fileName = GetNewPathForDupes(fileName); }

                    //保存位图
                    b.Save(fileName);
                    //释放位图资源
                    b.Dispose();
                }
            }
            catch (Exception ex)
            {
                System.Console.WriteLine("Exception " + ex);
            }
        }

        //防止重名的函数
        private string GetNewPathForDupes(string path)
        {
            string directory = Path.GetDirectoryName(path);
            string filename = Path.GetFileNameWithoutExtension(path);
            string extension = Path.GetExtension(path);
            int counter = 1;

            string newFullPath = path;

            while (File.Exists(newFullPath))
            {
                string newFilename = filename + " (" + counter + ")" + extension;
                newFullPath = Path.Combine(directory, newFilename);
                counter++;
            }
            //debug(newFullPath);
            return newFullPath;
        }

        //复制函数
        private void btnCopy_Click(object sender, EventArgs e)
        {
            //Bitmap b = new Bitmap(pictureBox1.Image);

            //先新建位图
            Bitmap b = new Bitmap(this.pictureBox1.Width, this.pictureBox1.Height);
            //通过pictureBox1的DrawToBitmap方法获取该图片到位图中
            this.pictureBox1.DrawToBitmap(b, new Rectangle(0, 0, this.pictureBox1.Width, this.pictureBox1.Height));

            Clipboard.SetImage(b);
            MessageBox.Show("图片已经复制到剪切板！", "系统提示");
        }
    }
}
