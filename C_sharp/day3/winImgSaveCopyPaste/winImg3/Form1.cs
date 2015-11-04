using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Imaging;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace winImg3
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void pictureBox1_Paint(object sender, PaintEventArgs e)
        {
            float[] x = new float[12];
            for (int i = 0; i < 12; i++)
            {
                x[i] = i + 1;
            }

            float[] y = new float[12] { 20.5f, 60, 10.8f, 15.6f, 30, 70.9f, 50.3f, 30.7f, 70, 50.4f, 30.8f, 20 };

            //画布属性设定
            this.pictureBox1.SizeMode = PictureBoxSizeMode.Zoom;
            this.pictureBox1.BorderStyle = BorderStyle.FixedSingle;

            pictureBox2.BorderStyle = BorderStyle.Fixed3D;

            //创建画布
            Graphics g = e.Graphics;
            g.Clear(Color.White);
            g.DrawString("标题", new Font("宋体", 12), new SolidBrush(Color.Red), new Point(pictureBox1.Width/2, 10));

            //缺乏坐标变换，所以点比较密集

            //画点
            //g.FillEllipse(new SolidBrush(Color.Blue), 100, 100, 10, 10);//空心点
            g.DrawEllipse(new Pen(Color.Blue), 100, 100, 15, 15);//实心点

            //循环画点
            for (int i = 0; i < 12; i++)
            {
                int x0 = (int)( x[i]/20 * this.pictureBox1.Width);
                int y0 = (int)(y[i] / 100 * this.pictureBox1.Height);
                g.FillEllipse(new SolidBrush(Color.Purple), x0, y0, 10, 10);
            }

            //g.Dispose();
        }


        //保存按钮
        private void button1_Click(object sender, EventArgs e)
        {
            //SaveFileDialog saveFileDialog1 = new SaveFileDialog();
            
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
                    if (File.Exists(fileName)){   fileName = GetNewPathForDupes(fileName); }

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

            string newFullPath=path;

            while (File.Exists(newFullPath)){
                string newFilename = filename+" (" +counter+")"+ extension;
                newFullPath = Path.Combine(directory, newFilename);
                counter++;
            } 
            //debug(newFullPath);
            return newFullPath;
        }


        //排错函数
        private void debug(string s)
        {
            this.label1.Text = s;
        }


        //粘贴函数
        private void btnPaste_Click(object sender, EventArgs e)
        {
            this.pictureBox1.Refresh();

            IDataObject iData = Clipboard.GetDataObject();
            if (iData.GetDataPresent(DataFormats.Bitmap))
            {
                pictureBox2.Image = (Bitmap)iData.GetData(DataFormats.Bitmap);
            }
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



        //截屏函数
        private void btnPrintScreen_Click(object sender, EventArgs e)
        {
            Image objImage = new Bitmap(400, 300);
            Graphics g = Graphics.FromImage(objImage);
            g.CopyFromScreen(new Point(Cursor.Position.X + 50, Cursor.Position.Y + 25), new Point(0, 0), new Size(400, 300));
            IntPtr dc1 = g.GetHdc();
            g.ReleaseHdc(dc1);
            this.pictureBox1.Image = objImage;

            SaveFileDialog sfd = new SaveFileDialog();
            //sfd.ShowDialog();

            sfd.Filter = "jpg|*.jpg;*.jpeg;|bmp|*.bmp;|gif|*.gif|png|*.png";//设置文件类型 
            sfd.FilterIndex = 1;//设置默认文件类型显示顺序 


            //保存对话框是否记忆上次打开的目录
            sfd.RestoreDirectory = true;

            //点了保存按钮进入 
            if (sfd.ShowDialog() == DialogResult.OK)
            {
                if (sfd.FileName != null)
                {
                    string fileName = sfd.FileName.ToString();
                    objImage.Save(fileName);
                }
            }
        }
    }
}
