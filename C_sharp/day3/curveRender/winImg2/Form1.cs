using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Drawing2D;
using System.Drawing.Imaging;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace winImg2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void pictureBox1_Paint(object sender, PaintEventArgs e)
        {
            //设置边框
            this.pictureBox1.BorderStyle = BorderStyle.FixedSingle;
            this.pictureBox1.Width = 700;
            this.pictureBox1.Height = 400;


            //创建Graphics对象
            //Graphics g = this.pictureBox1.CreateGraphics();//这种获取方式不显示图
            Graphics g = e.Graphics;
            g.SmoothingMode = SmoothingMode.AntiAlias;
            //刷新为白色背景
            g.Clear(Color.White);

            //DemoDrawPoint(g);//由设定的点划线。very good. 一个类有待完善。
            DemoDrawLines(g);//画坐标轴
            DemoDrawFont(g, "this is a title（some comment goes here）");//写文字

            DemoDrawPoint(g);

            //DemoMyArrow(g);
            //DemoRotate(g);
        }

        private void DemoMyArrow(Graphics g) {
            //定义新画笔
            //Pen pen1 = new Pen(Color.Black);
            //Pen pen1 = new Pen(Color.LightGray, 1);
            Pen pen1 = new Pen(Color.FromArgb(95,0,0,0));//从rgb定义颜色

            for (int i = 2; i < 15; i++)
            {
                //定义画笔宽度
                pen1.Width = i;
                //定义画笔尖端
                pen1.EndCap = LineCap.ArrowAnchor;
                //定义点
                Point point1=new Point(100, 25*i);
                Point point2=new Point(500, 25*i);
                //划线
                g.DrawLine(pen1, point1, point2);
                //画标注
                g.DrawString(i.ToString(), new Font("宋体", 12), new SolidBrush(Color.Red), point2.X,point2.Y-10);
            }

            //以上箭头都太丑了，自定义一个
            // http://bbs.csdn.net/topics/390311725
            Pen penSmall = new Pen(Color.Orange, 1);
            System.Drawing.Drawing2D.AdjustableArrowCap lineArrow =
                new System.Drawing.Drawing2D.AdjustableArrowCap(4, 4, true);
            penSmall.CustomEndCap = lineArrow;
            g.DrawLine(penSmall, new Point(100, 10), new Point(500, 10));


            //定义画笔-画空心圆圈
            Brush BlueBrush = new SolidBrush(Color.Blue);//定义刷子
            Pen pen = new Pen(BlueBrush);//凑够刷子创建画笔
            g.DrawEllipse(pen, 20, 30, 10, 10); //画空心圆
            g.DrawEllipse(pen, 20, 50, 10, 10); //画另一个空心圆          
        }

        private void DemoDrawFont(Graphics g, string txt) {
            //写文字
            //Font font = new Font("MS UI Gothic", 12);
            Font font = new Font("微软雅黑", 12);
            SolidBrush brush = new SolidBrush(Color.BlueViolet);
            //g.DrawString("堵塞！", font, brush, 100, 100);
            g.DrawString(txt, font, brush, 200, 10);
        }

        //旋转的箭头
        private void DemoRotate(Graphics g) {
            //还可以旋转
            using (Pen p = new Pen(Color.Red))
            {
                g.TranslateTransform((float)(Width / 2 * 0.8), (float)(Height / 2 * 0.8));
                for (int i = 0; i < 12; i++)
                {
                    System.Drawing.Drawing2D.AdjustableArrowCap myLineArrow =
                        new System.Drawing.Drawing2D.AdjustableArrowCap(4, 4, true);
                    p.CustomEndCap = myLineArrow;
                    g.DrawLine(p, new Point(0, 15), new Point(180, 15));
                    g.RotateTransform(30);
                }


            }
            g.ResetTransform();
        
        }


        //数据/月份
        public ArrayList arrData = new ArrayList();
        public ArrayList arrMonth = new ArrayList();
        //定义幕布高宽
        private int iCanvasWidth = 400;
        private int iCanvasHeight = 300;
        //x轴的间距
        private int iX = 30;
        //y轴间距
        private int iY = 15;
        private void InitArray(){
            //初始化数据
            for (int i = 0; i < 6; i++)
                arrMonth.Add(i + 1);
            arrData.Add(200);
            arrData.Add(180);
            arrData.Add(285);
            arrData.Add(290);
            arrData.Add(275);
            arrData.Add(350);
        }

        private void DemoDrawLines(Graphics g) {
            //初始化数据
            this.InitArray();
            Bitmap bitmap = new Bitmap(iCanvasWidth, iCanvasHeight, PixelFormat.Format24bppRgb);
            //Graphics g=Graphics.FromImage(bitmap);
            //Graphics g = this.pictureBox1.CreateGraphics();
            g.Clear(Color.White);

            Pen pen = new Pen(Color.Black);
            Pen pen2 = new Pen(Color.Red);
            pen.EndCap = LineCap.ArrowAnchor;
            pen.DashStyle = DashStyle.Solid;
            //坐标轴
            g.DrawLine(pen, 20, 220, 620, 220);
            g.DrawLine(pen, 20, 380, 20, 20);
            //x轴标格
            for (int i = 0; i < 20; i++) {
                g.DrawLine(Pens.Black, 20 + iX * i, 220, 20 + iX * i, 220 - 2);
            }
            
            //y轴标格
            g.DrawLine(Pens.Black, 20, 220 - iY * 1, 20 + 2, 220 - iY * 1);
            g.DrawLine(Pens.Black, 20, 220 - iY * 2, 20 + 2, 220 - iY * 2);
            g.DrawLine(Pens.Black, 20, 220 - iY * 3, 20 + 2, 220 - iY * 3);
            g.DrawLine(Pens.Black, 20, 220 - iY * 4, 20 + 2, 220 - iY * 4);
            g.DrawLine(Pens.Black, 20, 220 - iY * 5, 20 + 2, 220 - iY * 5);
            g.DrawLine(Pens.Black, 20, 220 - iY * 6, 20 + 2, 220 - iY * 6);

            //
            double dblX1 = 20;
            double dblY1 = 220;
            for (int i = 0; i < arrData.Count; i++)
            {
                double dblData = Convert.ToDouble(arrData[i]);
                double dblY2 = 220 - dblData * 15 / 200;
                double dblX2 = 20 + iX * Convert.ToInt32(arrMonth[i]);
                if (i != 0)
                {
                    if (i < arrData.Count - 1)
                    {
                        //g.DrawLine(Pens.Black, float.Parse(dblX1.ToString()), float.Parse(dblY1.ToString()), float.Parse(dblX2.ToString()), float.Parse(dblY2.ToString()));
                        g.FillEllipse(Brushes.Blue, float.Parse(dblX1.ToString()), float.Parse(dblY1.ToString()), 10, 10);
                    
                    }
                    else
                    {
                        //g.DrawLine(pen2, float.Parse(dblX1.ToString()), float.Parse(dblY1.ToString()), float.Parse(dblX2.ToString()), float.Parse(dblY2.ToString()));
                        g.FillEllipse(Brushes.Blue, float.Parse(dblX1.ToString()), float.Parse(dblY1.ToString()), 10, 10 );
                    }
                }
                dblX1 = dblX2;
                dblY1 = dblY2;
            }
        }



        //由点划线
        private void DemoDrawPoint(Graphics g)
        {
            
            //创建曲线中的点
            Point point0 = new Point(1, 2);
            Point point1 = new Point(30, 5);
            Point point2 = new Point(60, 10);
            Point point3 = new Point(74, 23);
            Point point4 = new Point(77, 102);
            Point point5 = new Point(80, 160);
            Point point6 = new Point(90, 180);
            Point point7 = new Point(150, 181);
            Point point8 = new Point(220, 200);
            //放到数组中
            Point[] curvePoints = { point0, point1, point2, point3, point4, point5, point6, point7, point8 };

            //使用类标准化数据
            PointF[] curvePointsF = new curveRender(curvePoints, this.pictureBox1).curvePointsF;


            //创建路径
            GraphicsPath myPath = new GraphicsPath();
            //AddCurve(点阵,起点,终点,弯曲程度)
            //myPath.AddCurve(curvePoints, 0, 7, 0.5f);//最后一个参数[0,1]越大，曲线越平滑
            //myPath.AddCurve(curvePointsF, 0, 7, 0.99f);//最后一个参数[0,1]越大，曲线越平滑
            myPath.AddCurve(curvePointsF);

            //定义铅笔
            Pen myPen = new Pen(Color.Red, 1);
            Pen myPen2 = new Pen(Color.Blue, 2);

            //画路径
            g.DrawPath(myPen, myPath);
            //画空心圆
            g.DrawEllipse(myPen, 20, 30, 10, 10);

            //画点
            //int x = 10, y = 100;
            //g.FillEllipse(Brushes.Blue, x, y, 10, 10);
            int pointRadius = 8;//点的半径
            Brush blueBrush = Brushes.BlueViolet;//点的颜色
            foreach(PointF p in curvePointsF){
                g.FillEllipse(blueBrush, p.X, p.Y, pointRadius, pointRadius);
            }
        }



        public void debug(string s) {
            this.label1.Text = s;
            MessageBox.Show(s);
        }


        //按钮颜色的改变
        private void button1_Click(object sender, EventArgs e)
        {
            button1.BackColor = System.Drawing.ColorTranslator.FromHtml("#0096FF");
        }
    }
}
