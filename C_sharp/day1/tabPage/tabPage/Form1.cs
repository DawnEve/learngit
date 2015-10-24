using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace tabPage
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            //为tabPage3改变样式图案和文字
            tabPage3.ImageIndex = 0;
            tabPage3.Text = "standard curves";

            //为batPage3添加一个图片框
            PictureBox pb = new PictureBox();
            pb.Dock = DockStyle.Fill;
            pb.BorderStyle = BorderStyle.Fixed3D;
            tabPage3.Controls.Add(pb);

            //代码添加tab
            string title = "[init]新增选项卡"+(tabControl1.TabCount+1).ToString();
            TabPage newTp = new TabPage(title);
            //使用tabControl1控件的TabPages属性的Add方法添加新的选项卡
            tabControl1.TabPages.Add(newTp);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            //代码添加tab
            string title = "新增添选项卡" + (tabControl1.TabCount + 1).ToString();
            TabPage newTp = new TabPage(title);
            //使用tabControl1控件的TabPages属性的Add方法添加新的选项卡
            tabControl1.TabPages.Add(newTp);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (tabControl1.SelectedIndex == 0)
            {
                MessageBox.Show("请选择要删除的选项卡");
            }
            else {
                //使用tabControl1控件的TabPages属性的Remove方法删除选项卡
                tabControl1.TabPages.Remove(tabControl1.SelectedTab);
            }
        }
    }
}
