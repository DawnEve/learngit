using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace winImg2
{
    class curveRender
    {
        //保存和获取最值；
        private Single minX, minY, maxX, maxY;
        //曲线点原始数据数组
        public Point[] curvePoints;
        public PointF[] curvePointsF;//标准化之后的结果
        //绘图板
        public PictureBox pictureBox1;

        //为坐标轴留下上下左右空白
        Single margin = 300;


        //构造函数传入曲线原始数据数组
        public curveRender(Point[] curvePoints,  PictureBox pictureBox1) {
            this.curvePoints = curvePoints;
            this.pictureBox1=pictureBox1;

            //标准化后
            this.curvePointsF = standarlizeXY(curvePoints);
        }

        public void getMaxMin()
        {
            //1.找出最大最小值
            minX = this.curvePoints[0].X; minY = this.curvePoints[0].Y;
            maxX = this.curvePoints[0].X; maxY = this.curvePoints[0].Y;
            foreach (Point p in this.curvePoints)
            {
                if (p.X < minX) minX = p.X;
                if (p.Y < minY) minY = p.Y;

                if (p.X > maxX) maxX = p.X;
                if (p.Y > maxY) maxY = p.Y;
            }
        }


        //传入任意点的数列，传出标准化后的点的坐标
        public PointF[] standarlizeXY(Point[] curvePoints)
        {
            //转化坐标1.找出最大最小值；2.数据映射到该绘图区；3.倒置y坐标=height-y
            getMaxMin();

            //计算跨度
            Single xSpan = maxX - minX; 
            Single ySpan = maxY - minY;
            //对于直线做特殊处理
            if (xSpan == 0) xSpan = 1;
            if (ySpan == 0) ySpan = 1;

            //2.数据映射到该绘图区；
            Single h = this.pictureBox1.Height - margin;
            Single w = this.pictureBox1.Width - margin;
            //放到新数组中
            PointF[] curvePointsF = new PointF[curvePoints.Length];
            //填充新数组
            for (int i = 0; i < curvePoints.Length; i++)
            {
                Point p = curvePoints[i];
                Single xF = (p.X - minX) / xSpan * w;
                Single yF = (p.Y - minY) / ySpan * h;
                //3.倒置y坐标=height-y
                yF = h - yF + margin/2;
                //移动到中间
                xF = xF + margin / 2;
                curvePointsF[i] = new PointF(xF, yF);
            }

            return curvePointsF;
        }
    }
}
