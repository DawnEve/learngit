using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace winImgs1
{
    /// <summary>
    /// from http://blog.csdn.net/qshpeng/article/details/2047734
    /// </summary>
    class CurvePaint
    {
        public CurvePaint() { }
        //刻度线条数
        private int _X_KeduCount = 12;
        private int _Y_KeduCount = 12;

        //刻度值位置对应刻度线左移像素
        private float _X_valueStrMoveleft = 5f;
        private float _Y_valueStrMoveleft = 45f;

        //格式化刻度值
        private string _X_Format = "#0.0";
        private string _Y_Format = "#0.00";

        //X轴刻度值文字方向
        private bool _X_DirectionVertical = false;
        public int XkeduCount
        {
            get { return _X_KeduCount; }
            set { _X_KeduCount = value; }
        }

        public int YkeduCount
        {
            get { return _Y_KeduCount; }
            set { _Y_KeduCount = value; }
        }

        public float XvalueStrMoveleft
        {
            get { return _X_valueStrMoveleft; }
            set { _X_valueStrMoveleft = value; }
        }

        public float YvalueStrMoveleft
        {
            get { return _Y_valueStrMoveleft; }
            set { _Y_valueStrMoveleft = value; }
        }

        public bool XdirectionVertical
        {
            get { return _X_DirectionVertical; }
            set { _X_DirectionVertical = value; }
        }

        public string Xformat
        {
            get { return _X_Format; }
            set { _X_Format = value; }
        }

        public string Yformat
        {
            get { return _Y_Format; }
            set { _Y_Format = value; }
        }

        private void setExtremeValues(float[] arr, ref float smallestValue, ref float greatestValue)
        {
            if (arr == null || arr.Length == 0) throw new Exception("用于绘曲线图的数组为空");
            smallestValue = arr[0];
            greatestValue = arr[0];
            for (int i = 1; i < arr.Length; i++)
            {
                if (smallestValue > arr[i]) smallestValue = arr[i];
                if (greatestValue < arr[i]) greatestValue = arr[i];
            }
        }

        private void setKeduStringArray(float[] keduArr, float increment)
        {
            for (int i = 1; i < keduArr.Length; i++)
            {
                keduArr[i] = keduArr[i - 1] + increment;
            }
        }
        // 数据规格化f(x)=ax+b
        private float Standard(float x, float A, float B, float C, float D)
        {
            return C * (A * x + B) + D;
        }

        public Bitmap drawCurve(float[] X_array, float[] Y_array, string chartTitle, string X_title, string Y_title)
        {
            //画图初始化
            Bitmap bmap = new Bitmap(500, 500);//图片大小
            Graphics gph = Graphics.FromImage(bmap);
            gph.Clear(Color.White);

            //曲线图左、下、右、上的空隙均为60像素
            PointF cpt = new PointF(60f, bmap.Height - 60f);//坐标原点，坐标轴起始点（60,440）
            PointF X_EndPoint = new PointF(bmap.Width - 60f, cpt.Y);//X轴终点(440,440)
            PointF Y_EndPoint = new PointF(cpt.X, 60f);//Y轴终点(60,60)

            //坐标轴三角形箭头
            PointF[] xpt = new PointF[3] { new PointF(X_EndPoint.X + 15, X_EndPoint.Y), new PointF(X_EndPoint.X, X_EndPoint.Y - 4), new PointF(X_EndPoint.X, X_EndPoint.Y + 4) };//x轴三角形
            PointF[] ypt = new PointF[3] { new PointF(Y_EndPoint.X, Y_EndPoint.Y - 15), new PointF(Y_EndPoint.X - 4, Y_EndPoint.Y), new PointF(Y_EndPoint.X + 4, Y_EndPoint.Y) };//y轴三角形            

            //画图表标题
            gph.DrawString(chartTitle, new Font("宋体", 14), Brushes.Black, new PointF(Y_EndPoint.X + 60, Y_EndPoint.Y - 30));//图表标题
            //画x轴三角箭头、标题
            gph.DrawLine(Pens.Black, cpt.X, cpt.Y, X_EndPoint.X, X_EndPoint.Y);
            gph.DrawPolygon(Pens.Black, xpt);
            gph.FillPolygon(new SolidBrush(Color.Black), xpt);
            gph.DrawString(X_title, new Font("宋体", 12), Brushes.Black, new PointF(X_EndPoint.X + 10, X_EndPoint.Y + 10));
            //画y轴三角箭头、标题
            gph.DrawLine(Pens.Black, cpt.X, cpt.Y, Y_EndPoint.X, Y_EndPoint.Y);
            gph.DrawPolygon(Pens.Black, ypt);
            gph.FillPolygon(new SolidBrush(Color.Black), ypt);
            gph.DrawString(Y_title, new Font("宋体", 12), Brushes.Black, new PointF(0, Y_EndPoint.Y - 30));

            float X_smallestValue = 0f, X_greatestValue = 0f;
            float Y_smallestValue = 0f, Y_greatestValue = 0f;
            //猎取横、纵坐标的最大最小值
            setExtremeValues(X_array, ref X_smallestValue, ref X_greatestValue);
            setExtremeValues(Y_array, ref Y_smallestValue, ref Y_greatestValue);

            //增量＝（最大值－最小值）
            float X_Increment = (X_greatestValue - X_smallestValue);
            float Y_Increment = (Y_greatestValue - Y_smallestValue);

            //平均增量＝（最大值－最小值）/刻度间隔数，刻度间隔数＝刻度线数－1
            float X_AvgIncrement = X_Increment / (XkeduCount - 1);
            float Y_AvgIncrement = Y_Increment / (YkeduCount - 1);

            float[] X_KeduArr = new float[XkeduCount];//X轴刻度值
            float[] Y_KeduArr = new float[YkeduCount];//Y轴刻度值
            X_KeduArr[0] = X_smallestValue;
            Y_KeduArr[0] = Y_smallestValue;

            //给刻度值数组赋值
            setKeduStringArray(X_KeduArr, X_AvgIncrement);
            setKeduStringArray(Y_KeduArr, Y_AvgIncrement);

            //刻度线起始位置
            PointF X_KeduStart = new PointF(cpt.X + 30, cpt.Y);             //(90,440) x轴第一根刻度线
            PointF X_KeduEnd = new PointF(X_EndPoint.X - 10, X_EndPoint.Y); //(430,440) x轴最后一根刻度线
            PointF Y_KeduStart = new PointF(cpt.X, cpt.Y - 30);             //(60,410) y轴第一根刻度线
            PointF Y_KeduEnd = new PointF(Y_EndPoint.X, Y_EndPoint.Y + 10); //(60,70) y轴最后一根刻度线

            //刻度线位置坐标平均增量
            float X_KeduIncrement = (X_KeduEnd.X - X_KeduStart.X) / (XkeduCount - 1);
            float Y_KeduIncrement = (Y_KeduStart.Y - Y_KeduEnd.Y) / (YkeduCount - 1);

            //设置X轴刻度值显示方向
            StringFormat X_StringFormat = new StringFormat();
            if (XdirectionVertical)
            {
                X_StringFormat.FormatFlags = StringFormatFlags.DirectionVertical;
            }

            //画x轴刻度线、刻度值
            for (int i = 1; i <= XkeduCount; i++)
            {
                if (i == 1)
                {
                    gph.DrawString(X_KeduArr[i - 1].ToString(Xformat), new Font("Times New Roman", 11), Brushes.Black, new PointF(X_KeduStart.X - XvalueStrMoveleft, X_KeduStart.Y + 5), X_StringFormat);// new StringFormat(StringFormatFlags.DirectionVertical));//最后一个参数实现文字竖排，默认为横排
                    gph.DrawLine(Pens.LightGray, X_KeduStart.X, X_KeduStart.Y, X_KeduStart.X, Y_EndPoint.Y);
                }
                else
                {
                    gph.DrawString(X_KeduArr[i - 1].ToString(Xformat), new Font("Times New Roman", 11), Brushes.Black, new PointF(X_KeduStart.X + (i - 1) * X_KeduIncrement - XvalueStrMoveleft, cpt.Y + 5), X_StringFormat);// new StringFormat(StringFormatFlags.DirectionVertical));//最后一个参数实现文字竖排，默认为横排
                    gph.DrawLine(Pens.LightGray, X_KeduStart.X + (i - 1) * X_KeduIncrement, cpt.Y, X_KeduStart.X + (i - 1) * X_KeduIncrement, Y_EndPoint.Y);
                }
            }
            //画y轴刻度线、刻度值
            for (int i = 1; i <= YkeduCount; i++)
            {
                if (i == 1)
                {
                    gph.DrawString(Y_KeduArr[i - 1].ToString(Yformat), new Font("Times New Roman", 11), Brushes.Black, new PointF(Y_KeduStart.X - YvalueStrMoveleft, Y_KeduStart.Y - 6));
                    gph.DrawLine(Pens.LightGray, Y_KeduStart.X, Y_KeduStart.Y, X_EndPoint.X, Y_KeduStart.Y);
                }
                else
                {
                    gph.DrawString(Y_KeduArr[i - 1].ToString(Yformat), new Font("Times New Roman", 11), Brushes.Black, new PointF(Y_KeduStart.X - YvalueStrMoveleft, Y_KeduStart.Y - (i - 1) * Y_KeduIncrement - 6));
                    gph.DrawLine(Pens.LightGray, Y_KeduStart.X, Y_KeduStart.Y - (i - 1) * Y_KeduIncrement, X_EndPoint.X, Y_KeduStart.Y - (i - 1) * Y_KeduIncrement);
                }
            }

            //(90,440) x轴第一根刻度线起点，(430,440) x轴最后一根刻度线起点，(60,410) y轴第一根刻度线起点， (60,70) y轴最后一根刻度线起点 
            //为了方便画图，将原二维数据规格化到固定的画图区间(90-430,70－410),规格化函数F(x) = A * x + B
            //因为窗口Y轴坐标方向与正常坐标Y轴方向相反，故需要将Y坐标再变换一次，变换函数G(x) = C * x + D
            //下面是X坐标变换因子A,B，Y坐标对应的变换因子A,B,C,D
            float X_A = 340.0f / X_Increment;
            float X_B = 90.0f - (340.0f * X_smallestValue) / X_Increment;
            float Y_A = 340.0f / Y_Increment;
            float Y_B = 70.0f - (340.0f * Y_smallestValue) / Y_Increment;
            float Y_C = -1f, Y_D = 480f;

            for (int i = 1; i <= Y_array.Length; i++)
            {
                //画点
                gph.DrawEllipse(Pens.Black, Standard(X_array[i - 1], X_A, X_B, 1, 0) - 1.5f, Standard(Y_array[i - 1], Y_A, Y_B, Y_C, Y_D) - 1.5f, 3, 3);
                gph.FillEllipse(new SolidBrush(Color.Black), Standard(X_array[i - 1], X_A, X_B, 1, 0) - 1.5f, Standard(Y_array[i - 1], Y_A, Y_B, Y_C, Y_D) - 1.5f, 3, 3);
                //画数值
                gph.DrawString(Y_array[i - 1].ToString(), new Font("Times New Roman", 11), Brushes.Black, new PointF(Standard(X_array[i - 1], X_A, X_B, 1, 0), Standard(Y_array[i - 1], Y_A, Y_B, Y_C, Y_D)));
                //画折线
                if (i > 1) gph.DrawLine(Pens.Red, Standard(X_array[i - 2], X_A, X_B, 1, 0), Standard(Y_array[i - 2], Y_A, Y_B, Y_C, Y_D), Standard(X_array[i - 1], X_A, X_B, 1, 0), Standard(Y_array[i - 1], Y_A, Y_B, Y_C, Y_D));
            }
            return bmap;
            //保存输出图片
        }

        static public Bitmap drawCurveOnImage(float[] X_array, float[] Y_array, string chartTitle, string X_title, string Y_title)
        {
            CurvePaint CI = new CurvePaint();
            return CI.drawCurve(X_array, Y_array, chartTitle, X_title, Y_title);
        }

        static public Bitmap drawCurveOnImage(float[] X_array, float[] Y_array, string chartTitle, string X_title, string Y_title, int X_KeduCount, int Y_KeduCount)
        {
            CurvePaint CI = new CurvePaint();
            CI.XkeduCount = X_KeduCount;
            CI.YkeduCount = Y_KeduCount;
            return CI.drawCurve(X_array, Y_array, chartTitle, X_title, Y_title);
        }

        static public Bitmap drawCurveOnImage(float[] X_array, float[] Y_array, string chartTitle, string X_title, string Y_title, int X_KeduCount, int Y_KeduCount, float X_valueStrMoveleft, float Y_valueStrMoveleft, bool X_DirectionVertical)
        {
            CurvePaint CI = new CurvePaint();
            CI.XkeduCount = X_KeduCount;
            CI.YkeduCount = Y_KeduCount;
            CI.XvalueStrMoveleft = X_valueStrMoveleft;
            CI.YvalueStrMoveleft = Y_valueStrMoveleft;
            CI._X_DirectionVertical = X_DirectionVertical;
            return CI.drawCurve(X_array, Y_array, chartTitle, X_title, Y_title);
        }
    }

    
}
