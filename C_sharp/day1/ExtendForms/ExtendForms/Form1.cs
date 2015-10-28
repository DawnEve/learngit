using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ExtendForms
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string message=textBox1.Text;
            var result = MessageBox.Show("您输入的是： "+message, "Notice",
                                 MessageBoxButtons.YesNo,
                                 MessageBoxIcon.Question);

            //根据点击结果显示数据
            if (result == DialogResult.Yes)
            {
                label1.Text = message;
            }
            else 
            {
                Form2 f2 = new Form2();
                f2.Show();   
            }

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
    }
}
