using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Drawing2D;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace winImgs1
{
    public partial class Form1 : Form
    {

        public Form1()
        {
            InitializeComponent();
        }


        private void pictureBox1_Paint(object sender, PaintEventArgs e)
        {
            //画框加边框
            this.pictureBox1.BorderStyle = BorderStyle.FixedSingle;

            //声明画图对象
            Graphics g = e.Graphics; 

            //背景填充为白色
            g.Clear(Color.White);

            //使用函数在g上画图
            Demo0(g);

            //CurvePaint类直接画图=========================没看懂这个类
            //不能使用 g.Clear(Color.White); 否则白色背景，啥都没有
            //Demo1();
            //Demo2();
        }

        private void Demo2()
        {
            float[] conc = new float[8];
            for (int i = 0; i < 8; i++)
            {
                conc[i] = i + 1;
            }

            float[] od = new float[8] { 0.05F, 0.1F, 0.2F, 1.2F, 2.7F, 3.5F, 3.6F, 3.65F };
            pictureBox1.SizeMode = PictureBoxSizeMode.Zoom;
            CurvePaint cp = new CurvePaint();
            cp.XkeduCount = 10;
            cp.YkeduCount = 10;
            cp.XvalueStrMoveleft = 15;
            pictureBox1.Image = cp.drawCurve(conc, od, "Standard Curve", "Conc.", "OD Value");
        }

        private void Demo1() {
            float[] month = new float[12];
            for (int i = 0; i < 12; i++)
            {
                month[i] = i + 1;
            }

            float[] d = new float[12] { 20.5f, 60, 10.8f, 15.6f, 30, 70.9f, 50.3f, 30.7f, 70, 50.4f, 30.8f, 20 };
            pictureBox1.SizeMode = PictureBoxSizeMode.Zoom;
            CurvePaint cp = new CurvePaint();
            cp.XkeduCount = 10;
            cp.YkeduCount = 10;
            cp.XvalueStrMoveleft = 15;
            pictureBox1.Image = cp.drawCurve(month, d, "某工厂某产品月生产量图表2", "月份", "产量（万）");
        }


        private void Demo0(Graphics g)
        {
            renderXY(g);//初始化坐标轴

            //========划线-画点
            Pen pen1 = new Pen(Color.Red, 1);
            Pen pen2 = new Pen(Color.Blue);
            int total_point_num=1000;
            PointF[] CurvePoints = new PointF[total_point_num];
            for (int x = 0; x < total_point_num; x += 10)
            {
                //计算点坐标-正弦曲线
                float y = (float)( 100*Math.Sin(x*300) );
                //坐标轴置换
                y = -y + this.pictureBox1.Height-200;
                //点保存到数组中,供下文创建路径用
                CurvePoints[x] = new PointF(x, y);
                //画空心点-画笔，矩形（坐标x，坐标y，宽度，高度）;
                g.DrawEllipse(pen2, new RectangleF(x, y, 3, 3));
            }


            //创建路径
            GraphicsPath myPath = new GraphicsPath();
            //AddCurve(点阵,起点,终点,弯曲程度)
            //myPath.AddCurve(CurvePoints, 0, 7, 0.8f);
            myPath.AddCurve(CurvePoints,0,300,0.01F);
            //定义画笔
            Pen myPen = new Pen(Color.Red, 1);
            //划线--------------------------------------------bug为什么点稀疏的时候不是两两连接？
            //g.DrawPath(myPen, myPath);

            //g.DrawCurve(pen1, CurvePoints, 0.05F);            
        }


        //这是一个公用实例，可以用来画坐标轴
        private void renderXY(Graphics g) {
            //定义钢笔：颜色，直径
            Pen pen0 = new Pen(Color.Black, 1);

            //================划线-坐标1，坐标2
            float originX = (float)(Width * 0.1);//原点在画布上的位置x
            float margin_bottom = 200;//坐标轴底部距离
            float originY = (float)(Height - margin_bottom);//(Height * 0.7);//原点在画布上的位置y
            //g.DrawLine(pen1, pictureBox1.Left, pictureBox1.Top, pictureBox1.Left, pictureBox1.Bottom);
            //g.DrawLine(pen1, pictureBox1.Left, (int)(pictureBox1.Bottom * 0.85), pictureBox1.Right, (int)(pictureBox1.Bottom * 0.85));
            g.DrawLine(pen0, originX, 0, originX, Height);
            g.DrawLine(pen0, 0, originY, Width, originY);

            //画背景虚线 
            //todo
            
            //画坐标刻度 
            //todu


            //画标题-标注
            string Title = "This is a title";
            Brush brush = new SolidBrush(Color.Black);//字体颜色
            int intFontSize = 20;
            Font font = new Font("宋体", intFontSize);//字体类型、字号
            Font fontSmall = new Font("宋体", intFontSize / 2);//字体类型、字号
            int Ytop = 30;//Y轴距离顶端
            //设置居中的标题
            g.DrawString(Title, font, brush, new Point((int)(Width / 2 - intFontSize * Title.Length / 2), Ytop));
            //设置x轴标注
            g.DrawString("lg[Conc.]", fontSmall, brush, (float)(Width * 0.65), originY);
            //设置y轴标注
            g.DrawString("OD Value", fontSmall, brush, originX, (float)(Height * 0.1));
            //设置原点标注
            g.DrawString("O", fontSmall, brush, originX, originY);
        }
    }
}
