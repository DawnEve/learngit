using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using System.IO;

namespace fileReadWrite
{
    public partial class Form1 : Form
    {
        //类字段。字典保存一些板子的基本信息 http://bbs.csdn.net/topics/330090204
        private Dictionary<string, string> plate_info = new Dictionary<string, string>();

        public Form1()
        {
            InitializeComponent();
        }


        private void Form1_Load(object sender, EventArgs e)
        {
            lbInfo.Width = 100;
            //lbInfo.AutoSize = false;
            lbInfo.ForeColor = Color.Blue;

            
        }




        //写入按钮
        private void button2_Click(object sender, EventArgs e)
        {
            //设置保存文件格式
            //this.saveFileDialog1.Filter = "*.txt(文本文件)|*.txt|*.mub(模板文件)|*.mub";
            //this.saveFileDialog1.CreatePrompt = true;//不存在则新建
            //this.saveFileDialog1.OverwritePrompt = true;//文件覆盖前的提示

            //writeToFile(".\\aaa.txt", richTextBox1.Text);


            //保存文件
            Stream myStream ;
            SaveFileDialog saveFileDialog1 = new SaveFileDialog();

            saveFileDialog1.Filter = "*.mub(模板文件)|*.mub|txt files (*.txt)|*.txt|All files (*.*)|*.*";
            saveFileDialog1.FilterIndex = 1 ;
            saveFileDialog1.RestoreDirectory = true ;

            if(saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                if((myStream = saveFileDialog1.OpenFile()) != null)
                {
                    // Code to write the stream goes here.
                    myStream.Close();

                    using (StreamWriter writer = new StreamWriter(saveFileDialog1.FileName, true))
                    {
                        writer.Write(richTextBox1.Text);
                        writer.Write("======end======");
                    }
                }
                myStream.Close();
            }
        }


        //写入文件
        private bool writeToFile(string fileName, string str) 
        {

            //byte[] byData = new byte[100];
            //char[] charData = new char[1000];

            //打开文件
            FileStream fs = new FileStream(fileName, FileMode.OpenOrCreate);
            //获得字节数组
            byte[] data = System.Text.Encoding.Default.GetBytes(str);
            //开始写入
            fs.Write(data, 0, data.Length);
            //清空缓冲区，关闭流
            fs.Flush();
            fs.Close();

            //提示
            return true;
        
        }

        private void button1_Click(object sender, EventArgs e)
        {

            //打开文件
            Stream myStream = null;
            //OpenFileDialog openFileDialog1 = new OpenFileDialog();

            //设置文件标题
            openFileDialog1.Title = "请选择文件";

            //openFileDialog1.InitialDirectory = "c:\\";
            openFileDialog1.Filter = "txt files (*.txt)|*.txt|All files (*.*)|*.*";
            openFileDialog1.FilterIndex = 1;
            openFileDialog1.RestoreDirectory = true;
            openFileDialog1.Multiselect = true;

            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                try
                {
                    if ((myStream = openFileDialog1.OpenFile()) != null)
                    {
                        //using (myStream) { }
                        
                        //Insert code to read the stream here.
                        //MessageBox.Show("文件字符长度："+myStream.Length.ToString());
                        //显示文件名
                        textBox1.Text = openFileDialog1.FileName.ToString();

                        //读取文件
                        StreamReader sr = new StreamReader(openFileDialog1.FileName);
                        
                        //解析文件？
                        //可能需要逐行读取文本
                        //sr.ReadLine();

                        //显示文件
                        richTextBox1.Text = sr.ReadToEnd();
                        //在标题中显示文件名
                        this.Text = openFileDialog1.FileName.ToString();

                        //关闭资源
                        sr.Close();
                        myStream.Close();
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Error: Could not read file from disk. Original error: " + ex.Message);
                }
            }
        }


        //读取文件
        private string readFromFile(string fileName) {
            //打开文件
            StreamReader sr = new StreamReader(fileName, Encoding.Default);
            string line;
            string lines = "";
            //逐行读取文件
            while( (line=sr.ReadLine())!=null )
            {
                lines +=line;
            }
            //关闭流
            sr.Close();

            return lines;
        }

        //保存文件2
        private void btnSave2_Click(object sender, EventArgs e)
        {
            //1.创建文件
            FileStream fs = new FileStream(".\\log.txt", FileMode.Create);
            //2.创建写入
            StreamWriter sw = new StreamWriter(fs);
            //3.以流的方式写入数据
            //sw.Write(this.richTextBox1.Text.Trim());
            sw.Write(this.richTextBox1.Text);
            //4.关闭写入器
            sw.Close();
            //5.关闭文件流
            fs.Close();

            //自定义提示
            showInfo("已经保存日志文件！");
        }

        //打开文件2
        private void btnOpen2_Click(object sender, EventArgs e)
        {
            //1.创建文件流
            FileStream fs = new FileStream(".\\log.txt", FileMode.Open);
            //2.创建读取
            StreamReader sr = new StreamReader(fs);
            //3.以流的方式读取数据
            this.richTextBox1.Text = sr.ReadToEnd();
            //4.关闭读取器
            sr.Close();
            //5.关闭文件流
            fs.Close();

            //自定义提示
            showInfo("已经打开日志文件！");
        }


        //追加方式写入文件
        private void btnAppend_Click(object sender, EventArgs e)
        {
            //1.创建文件流
            FileStream fs = new FileStream(".\\log.txt", FileMode.Append);
            //2.创建缓冲
            StreamWriter sw = new StreamWriter(fs);
            //3.以流的方式追加写入
            string str = DateTime.Now.ToString() + " 日志信息如下："+richTextBox1.Text;
            sw.WriteLine(str);
            //StringBuilder sb = new StringBuilder(fs);//提高效率的方式
            //4.关闭写入器
            sw.Close();
            //5.关闭文件流
            fs.Close();

            //自定义提示
            showInfo("已经追加到日志文件！");
        }


        //删除文件
        private void btnDelete_Click(object sender, EventArgs e)
        {
            //获取文件名
            string fName = this.txtTo.Text.Trim();
            if (File.Exists(fName))
            {
                //File类中的静态方法:删除文件
                File.Delete(fName);
                MessageBox.Show("删除成功", "提示",MessageBoxButtons.OK,MessageBoxIcon.Information);

                //自定义提示
                showInfo("已经删除日志文件: "+fName);
            }
            else {
                MessageBox.Show("文件不存在！", "提示",MessageBoxButtons.OK, MessageBoxIcon.Warning);

                //自定义提示
                showInfo("该文件不存在！"+fName);
            }
            
        }


        //复制文件
        private void btnCopyFile_Click(object sender, EventArgs e)
        {
            //获取文件名
            string fName=this.txtTo.Text.Trim();
            //File类中的静态方法：文件是否存在?
            if(File.Exists(fName) ){
                //获取对话框的结果
                DialogResult result=MessageBox.Show("该文件["+ fName +"]已存在，是否覆盖？","文件已经存在",MessageBoxButtons.YesNo,MessageBoxIcon.Question);
                if (result == DialogResult.Yes)
                {
                    //删除文件
                    File.Delete(fName);
                    //拷贝文件
                    File.Copy(".\\log.txt", fName);
                    showInfo("备份文件到：" + fName);
                }
            }
            else
            {
                //拷贝文件
                File.Copy(".\\log.txt", fName);
                showInfo("备份文件到："+fName);
            }
        }//end of btnCopyFile




        //自定义 - 提示框中的文字
        private void showInfo(string str) {
            lbInfo.Text = str;
        }



        //解析txt文件
        private void btnParse_Click(object sender, EventArgs e)
        {
            //openFileDialog1.InitialDirectory = "E:\\";
            openFileDialog1.Filter = "Md1 File(*.md1)|*.md1|All files|*.*";
            openFileDialog1.RestoreDirectory = true;
            openFileDialog1.FilterIndex = 2;
            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                string fName = openFileDialog1.FileName;
                //调用类文件读取   
                DataFormat df=new DataFormat();
                plate_info = df.readDatFile(fName);//获取基本信息
                Template tpl= df.getTpl();//模板信息


                //输出结果todo
                this.richTextBox1.Text = "";
                foreach (string item in plate_info.Keys)
                {
                    string info = this.plate_info[item];
                    this.richTextBox1.Text += item + " [:] " + info + "\n";
                }

                //读取模板信息
                this.richTextBox1.Text += "===标准品设置===\n";
                foreach (string item in tpl.std.Keys)
                {
                    Info info = tpl.std[item];
                    this.richTextBox1.Text += item + "(" + info.i +","+info.j+"), conc="+info.conc+ "\n";
                }

                this.richTextBox1.Text += "===质控品设置===\n";
                foreach (string item in tpl.ctr.Keys)
                {
                    Info info = tpl.ctr[item];
                    this.richTextBox1.Text += item + "(" + info.i + "," + info.j + "), conc=" + info.conc + "\n";
                }

                this.richTextBox1.Text += "===样品设置===\n";
                foreach (string item in tpl.smp.Keys)
                {
                    Info info = tpl.smp[item];
                    this.richTextBox1.Text += item + "(" + info.i + "," + info.j + "), conc=" + info.conc + "\n";
                }

            }  
        }

        private void btnTest_Click(object sender, EventArgs e)
        {
           // string txt = "SaveTime:2014-12-13 12:04:37";
           // string[] info = txt.Split(':');
           //// string info2 = info.Join(':');
           // MessageBox.Show(info[1] + ':' + info[2] + ':' + info[3]);

            Template t = new Template();
            t = new DataFormat().test();
            MessageBox.Show(t.std["01"].i.ToString());
        }




    }
}
