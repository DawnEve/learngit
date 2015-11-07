using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace polyfit
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            this.richTextBox2.Text = "//例如：y=a0+a1*x 返回值则为a0 a1  \r\n//例如：y=a0+a1*x+a2*x*x 返回值则为a0 a1 a2";
        }

        private void button1_Click(object sender, EventArgs e)
        {
            //Demo1();
            Demo2();
        }

        
        //重载函数
        public void showOnUI(string str)
        {
            this.richTextBox1.Text += str+'\r';
        }
        //重载函数
        public void showOnUI(double dd)
        {
            this.richTextBox1.Text += " [] "+dd+'\r';
        }


        //主函数
        private void Demo2()
        {
            //double[] x = new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
            //double[] y = new double[] { 283, 285, 300, 339, 380, 424, 516, 550, 542, 532 };
            //double[] y = new double[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

            //http://www.centerspace.net/blog/excel-trendlines/
            double[] x = { 11, 15, 18, 23, 26, 31, 39, 44, 54, 64, 74 };
            double[] y = { 0.00476, 0.0105, 0.0207, 0.0619, 0.337, 0.74, 1.7, 2.45, 3.5, 4.5, 5.09 };


            // double[,] xArray;  
            double[] ratio;


            showOnUI("一次拟合计算：");
            ratio = FittingFunct.linear(y, x);
            foreach (double num in ratio)
            {
                showOnUI(num);
            }
            double a = ratio[0];
            double b = ratio[1];
            showOnUI("  R2=" + FittingFunct.calRSquare_linear(x, y, a, b));


            showOnUI("对数拟合计算：");
            ratio = FittingFunct.Logest(y, x);
            foreach (double num in ratio)
            {
                showOnUI(num);
            }
            a = ratio[0];
            b = ratio[1];
            showOnUI("  R2=" + FittingFunct.calRSquare_Logest(x, y, a, b));


            showOnUI("幂函数级数拟合计算：");
            ratio = FittingFunct.PowEST(y, x);
            foreach (double num in ratio)
            {
                showOnUI(num);
            }
            a = ratio[0];
            b = ratio[1];
            showOnUI("  R2=" + FittingFunct.calRSquare_PowEST(x, y, a, b));


            showOnUI("指数函数拟合计算：");
            ratio = FittingFunct.indexEST(y, x);
            foreach (double num in ratio)
            {
                showOnUI(num);
            }
            a = ratio[0];
            b = ratio[1];
            showOnUI("  R2=" + FittingFunct.calRSquare_indexEST(x, y, a, b));


            //Console.ReadKey(); 
        }





        private void Demo1() 
        {
            //数据源
            //double[] arrX = { 1, 2, 3, 4, 5 };
            //double[] arrY = { 4.5, 4.5, 2.7, 2.2, 1.1 };

            double[] arrX = new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
            double[] arrY = new double[] { 283, 285, 300, 339, 380, 424, 516, 550, 542, 532 };


            int Pointlen = arrX.Length;
            //拟合，返回参数列表
            Double[] paras = CurveFit.MultiLine(arrX, arrY, Pointlen, int.Parse(this.textBox1.Text));

            //输出结果
            //y=a0+a1*x 返回值则为a0 a1
            int len = paras.Length;

            string str = "";
            for (int i = 0; i < len; i++)
            {
                str += paras[i].ToString() + "\r\n";
            }
            //显示结果
            this.richTextBox1.Text = str;



            //由参数计算回算测量值
            double a0 = paras[0], a1 = paras[1];
            double rss = 0, tss = 0;//残差平方和，总平方和

            double[] arrX2 = new double[Pointlen];//用于浓度回算
            double[] arrY2 = new double[Pointlen];//用于计算RSqure
            for (int i = 0; i < Pointlen; i++)
            {
                arrX2[i] = (arrY[i] - a0) / a1;
                arrY2[i] = a0 + a1 * arrX[i];

                rss += Math.Pow(arrY[i] - arrY2[i], 2);
                tss += Math.Pow(arrY[i], 2);
            }


            //计算R^2
            double RSqure = 1 - rss / tss;

            this.richTextBox1.Text += "\r\nRSqure=" + RSqure;
        }


    }
}
