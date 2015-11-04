using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace myCurve
{
    public partial class Form1 : Form
    {
        public float num;//传递给后面的窗体
        public Form1()
        {
            InitializeComponent();//新建窗体
        }
        
        private void Form1_Load(object sender, EventArgs e)
        {
            //btnFit_Click( sender,  e);
            this.StartPosition = FormStartPosition.CenterScreen; 
        }

        //
        private void btnFit_Click(object sender, EventArgs e)
        {
            //获取值，便于传递后后者
            string str = this.richTextBox1.Text.Trim();
            if (str == "")
            {
                num = 100;    
            }
            else
            {
                num=float.Parse(str);
            }

            FitForm ff = new FitForm();//给窗体赋值
            ff.Owner = this;//向窗口ff传递值得关键
            ff.Show();//显示拟合窗体
        }

        //http://www.cnblogs.com/lgzslf/archive/2011/01/11/1932757.html
        //防止填出2次确认框的方法
        //重写了onClosing方法
        protected override void OnClosing(CancelEventArgs e)
        {
            DialogResult result = MessageBox.Show("确认要退出本系统吗？", "系统提示", MessageBoxButtons.OKCancel, MessageBoxIcon.Information);
            if (result == DialogResult.OK)
            {
                this.Dispose();//注意这一句
                Application.Exit();
            }
            else
            {
                e.Cancel = true;
            }
            base.OnClosing(e);
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            DialogResult result = MessageBox.Show("确认要退出本系统吗？", "系统提示", MessageBoxButtons.OKCancel, MessageBoxIcon.Information);
            if (result == DialogResult.OK)
            {
                this.Dispose();//注意这一句
                //Application.Exit();
            }
        }


    }
}
