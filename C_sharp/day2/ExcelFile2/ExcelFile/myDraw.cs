using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExcelFile
{
    public class myDraw
    {
        //画点
        public static void DrawPoints(Graphics g, double[] x, double[] y, int dot_radius = 5)
        {
            int iM = x.Length;
            for (int i = 0; i < iM; i++)
            {
                //if (x[i] > 0 && y[i] > 0 && x[i<]) 
                g.DrawEllipse(new Pen(Color.Green), int.Parse(x[i].ToString()), int.Parse(y[i].ToString()), dot_radius, dot_radius);
            }

        }


        //划线
        public static void DrawLine(Graphics g, List<Point> pointList)
        {
            Point[] temps = new Point[pointList.Count];
            for (int i = 0; i < pointList.Count; i++)
            {
                temps[i] = pointList[i];
            }
            g.SmoothingMode = System.Drawing.Drawing2D.SmoothingMode.AntiAlias;
            g.DrawCurve(new Pen(Color.Red, 1), temps, 0.2F);
            //g.Dispose();

        }



    }
}
