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
            //数据源
            double[] arrX = { 1, 2, 3, 4, 5.1 };
            double[] arrY = { 5, 4, 3, 2, 1 };
            int Pointlen=arrX.Length;
            //拟合，返回参数列表
            Double[] paras = CurveFit.MultiLine(arrX, arrY, Pointlen, int.Parse(this.textBox1.Text));

            //输出结果
            //y=a0+a1*x 返回值则为a0 a1
            int len=paras.Length;

            string str="";
            for(int i=0; i<len;i++){
                str+=paras[i].ToString() + "\r\n";
            }
            //显示结果
            this.richTextBox1.Text = str;



            //由参数计算回算测量值
            double a0 = paras[0], a1 = paras[1];
            double rss = 0, tss = 0;//残差平方和，总平方和

            double[] arrX2 = new double[Pointlen];//用于浓度回算
            double[] arrY2 = new double[Pointlen];//用于计算RSqure
            for (int i = 0; i < Pointlen; i++) { 
                arrX2[i]=(arrY[i]-a0)/a1;
                arrY2[i] = a0 + a1 * arrX[i];

                rss += Math.Pow(arrY[i] - arrY2[i],2);
                tss += Math.Pow(arrY[i], 2);
            }


            //计算R^2
            double RSqure = 1-rss/tss;

            this.richTextBox1.Text += "\r\n"+RSqure;

        }



    }
}
