using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace myCurve
{



    public partial class FitForm : Form
    {
        private float num;//从前一个窗体接收变量
        public FitForm()
        {
            InitializeComponent();
        }

        private void btnFitAgain_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }
        private void FitForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            this.Dispose();
        }

        private void pictureBox1_Paint(object sender, PaintEventArgs e)
        {
            //初始化图片框样式
            this.pictureBox1.BorderStyle = BorderStyle.Fixed3D;
            this.pictureBox1.Width = 800;
            this.pictureBox1.Height = 400;

            //创建Graphics对象
            Graphics g = e.Graphics;
            //白色背景
            g.Clear(Color.White);

            //画笔画图
            Pen pen = new Pen(Color.Red);
            g.DrawString("The xxx curve", new Font("宋体", 12), new SolidBrush(Color.Blue), new Point(Width/3, 10));


            //获取第一窗体输入的数字
            num = ((Form1)this.Owner).num;

            int dot_num = (int)(num);
            int dot_radius = 6;
            for (int i = 0; i < dot_num; i++)
            {
                float x = Width * i / dot_num;
                float y = (float)(Height / 5 * Math.Sin(x*3.1415926/180)) + Height / 3;//Height * i / dot_num;

                //g.FillEllipse(new SolidBrush(Color.Green), x, y, dot_radius, dot_radius);
                g.DrawEllipse(new Pen(Color.Green), x, y, dot_radius, dot_radius);
            }

                
        }

        private void FitForm_Load(object sender, EventArgs e)
        {
            //初始化重新拟合按钮
            btnFitAgain.BackColor = Color.Red;
            btnFitAgain.ForeColor = Color.White;
            btnFitAgain.FlatStyle = FlatStyle.Flat;
        }


        //保存按钮
        private void btnSave_Click(object sender, EventArgs e)
        {
            SaveFileDialog saveFileDialog1 = new SaveFileDialog();

            //设置过滤文件类型
            //saveFileDialog1.InitialDirectory = "D:\\";
            //saveFileDialog1.Filter = "jpg|*.jpg;*.jpeg;|bmp|*.bmp;|*.gif,*.ico,*.png,*.tif,*.wmf|*.jpg;*.jpeg;*.bmp;*.gif;*.ico;*.png;*.tif;*.wmf";
            saveFileDialog1.Filter = "jpg|*.jpg;*.jpeg|bmp|*.bmp|gif|*.gif|png|*.png";//设置文件类型 
            saveFileDialog1.FilterIndex = 1;//设置默认文件类型显示顺序 

            //保存对话框是否记忆上次打开的目录
            saveFileDialog1.RestoreDirectory = true;

            //文件标题
            saveFileDialog1.Title = "保存图像";

            //设置默认文件名-日期
            saveFileDialog1.FileName = DateTime.Now.ToString("yyyy-MM-dd");
            //saveFileDialog1.FileName = null;

            saveFileDialog1.ShowDialog();
            //点了保存按钮进入 
            string fileName = saveFileDialog1.FileName.ToString();
            try
            {
                if (fileName != "" && fileName != null)
                {
                    /*
                     * http://zhidao.baidu.com/link?url=HUR9AhZduHR8QeqxW1Nt0yn2zBtl5pjBkLxpi03zrxFUVjxN6Ti1rli4iYMqFQeEZbG3Y_Hk4iEblLfuv1uPlq
                     * 对于创建自窗体的graphics对象，不能直接获取它的位图，
                     * 而是要先获取它所代表的窗体，然后调用窗体的DrawToBitmap方法
                     * 把窗体的图像画到已有的bitmap对象里，然后再由bitmap的save方法保存
                     * 下面跳过graphics对象，直接用this获取窗体：
                     */
                    //先新建位图
                    Bitmap b = new Bitmap(this.pictureBox1.Width, this.pictureBox1.Height);
                    //通过pictureBox1的DrawToBitmap方法获取该图片到位图中
                    this.pictureBox1.DrawToBitmap(b, new Rectangle(0, 0, this.pictureBox1.Width, this.pictureBox1.Height));

                    //防止覆盖的代码
                    if (File.Exists(fileName)) { fileName = GetNewPathForDupes(fileName); }

                    //保存位图
                    b.Save(fileName);
                    //释放位图资源
                    b.Dispose();
                }
            }
            catch (Exception ex)
            {
                System.Console.WriteLine("Exception " + ex);
            }
        }

        //防止重名的函数
        private string GetNewPathForDupes(string path)
        {
            string directory = Path.GetDirectoryName(path);
            string filename = Path.GetFileNameWithoutExtension(path);
            string extension = Path.GetExtension(path);
            int counter = 1;

            string newFullPath = path;

            while (File.Exists(newFullPath))
            {
                string newFilename = filename + " (" + counter + ")" + extension;
                newFullPath = Path.Combine(directory, newFilename);
                counter++;
            }
            //debug(newFullPath);
            return newFullPath;
        }


        //复制函数
        private void btnCopy_Click(object sender, EventArgs e)
        {
            //Bitmap b = new Bitmap(pictureBox1.Image);

            //先新建位图
            Bitmap b = new Bitmap(this.pictureBox1.Width, this.pictureBox1.Height);
            //通过pictureBox1的DrawToBitmap方法获取该图片到位图中
            this.pictureBox1.DrawToBitmap(b, new Rectangle(0, 0, this.pictureBox1.Width, this.pictureBox1.Height));

            Clipboard.SetImage(b);
            MessageBox.Show("照片复制成功！", "系统提示");
        }


    }
}
