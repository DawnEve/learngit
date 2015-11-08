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
        //画很多点
        public static void DrawPoints(Graphics g, double[] x, double[] y, int dot_radius = 1, bool isSolid = false)
        {
            int iM = x.Length;
            for (int i = 0; i < iM; i++)
            {
                if (isSolid)
                {
                    g.DrawEllipse(new Pen(Color.Black), int.Parse(Math.Round(x[i]).ToString()), int.Parse(Math.Round(y[i]).ToString()), dot_radius, dot_radius);
                }
                else
                {
                    g.FillEllipse(new SolidBrush(Color.Green), int.Parse(Math.Round(x[i]).ToString()), int.Parse(Math.Round(y[i]).ToString()), dot_radius, dot_radius);

                }
            }
        }


        //画单个点
        public static void DrawPoints(Graphics g, double x, double y, int dot_radius = 1, bool isSolid = false)
        {
            if (isSolid)
            {
                g.DrawEllipse(new Pen(Color.Blue), int.Parse(Math.Round(x).ToString()), int.Parse(Math.Round(y).ToString()), dot_radius, dot_radius);
            }
            else
            {
                g.FillEllipse(new SolidBrush(Color.Green), int.Parse(Math.Round(x).ToString()), int.Parse(Math.Round(y).ToString()), dot_radius, dot_radius);

            }
        }


        //划很多线
        public static void DrawLine(Graphics g, List<PointF> pointList)
        {
            PointF[] temps = new PointF[pointList.Count];
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
