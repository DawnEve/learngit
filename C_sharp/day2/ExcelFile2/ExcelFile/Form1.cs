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

namespace ExcelFile
{
    /// <summary>
    /// 坚持只在本文件中写事件处理函数，其他的函数写到单独的文件中
    /// </summary>
    public partial class Form1 : Form
    {
        /* 定义一些公用属性
         *  
         */
        //====================================中间信息（文件与界面之间）
        //板子基本信息-plate_Info
        private Dictionary<string, string> plate_info = new Dictionary<string, string>();

        //板子模板设置信息
        private Info[,] tpl = new Info[8, 12];

        //板子OD信息
        private Double[,] od = new double[8, 12];

        //====================================加工过的信息
        



        /// <summary>
        /// 开始定义方法
        /// </summary>

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            //设定界面底部颜色变化:从rgb和16进制来换算
            //this.label1.BackColor = System.Drawing.Color.FromArgb(69, 209, 208);
            this.label1.BackColor = System.Drawing.ColorTranslator.FromHtml("#008000");
            this.label3.BackColor = System.Drawing.ColorTranslator.FromHtml("#9ACD32");
            this.label5.BackColor = System.Drawing.ColorTranslator.FromHtml("#808080");
            this.label7.BackColor = System.Drawing.ColorTranslator.FromHtml("#87CEFA");

            

            //添加组合框-内置模板（因为要后续扩展，所以没写死）
            //实例化内置模板类
            InnerTpl form_inner_tpl = new InnerTpl();
            //调用方法，返回现有内置的模板名字
            string[] inner_tpls = form_inner_tpl.getInnerTplNames();
            //显示到下拉框控件中
            cmbTpl.DataSource = inner_tpls;
            cmbTpl.SelectedIndex = 0;
            //该控件只能选择，不能编辑
            cmbTpl.DropDownStyle = ComboBoxStyle.DropDownList;
            cmbTpl.FlatStyle = FlatStyle.Popup;//样式


            //添加分组单选框-拟合选项
            this.groupBox5.Controls.Add(this.radioButton1);
            this.groupBox5.Controls.Add(this.radioButton2);
            this.groupBox5.Controls.Add(this.radioButton3);
            this.groupBox5.Controls.Add(this.radioButton4);
            this.radioButton1.Checked = true;//默认选中第一项



            //添加组合框-样品类型（因为不需要修改，所以直接写死了）
            string[] well_classes ={ "标准品", "质控品", "空白对照", "送检样品" };
            comboBox1.DataSource = well_classes;
            comboBox1.SelectedIndex = 0;
            //只能选择，不能编辑
            comboBox1.DropDownStyle = ComboBoxStyle.DropDownList;
            comboBox1.FlatStyle = FlatStyle.Popup;//样式


            //窗体固定
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.Fixed3D;

            //设置数据显示框位置
            this.dataGridView1.Width = 787;
            this.dataGridView0.Width = 787;


            //实例化一个dataGridView类：0控制类
            DgvCtrl.dataGridViewInit(this.dataGridView0,true);
            

            //实例化一个dataGridView类：1数据显示
            DgvCtrl.dataGridViewInit(this.dataGridView1);
            //添加测试数据
            //DgvCtrl.addTestData(this.dataGridView1);

        }


       



        //上下文菜单在dataGridView1_CellMouseClick事件中，能避免表头响应上下文菜单
        //右键弹出菜单之前，选中右键单击时刻的单元格
        private void dataGridView1_CellMouseDown(object sender, DataGridViewCellMouseEventArgs e)
        {
            //如果右键，且不在上标题和左标题上，则弹出上下文菜单
            if (e.Button == MouseButtons.Right && e.RowIndex >= 0 && e.ColumnIndex >= 0)
            {
                this.contextMenuStrip1.Show(MousePosition);
            }
            else
            {
                return;
            }

            //判断单击的位置
            if (this.dataGridView1.Rows[e.RowIndex].Cells[e.ColumnIndex].Selected != true)
            {
                //如果右击的位置在选取之外,则清除选区，并选中当前单元格
                dataGridView1.ClearSelection();
                dataGridView1.Rows[e.RowIndex].Cells[e.ColumnIndex].Selected = true;
                //设定当前行为右击的单元格
                this.dataGridView1.CurrentCell = this.dataGridView1.Rows[e.RowIndex].Cells[e.ColumnIndex];
            }
        }


        //控制框不能输入
        private void dataGridView0_KeyDown(object sender, KeyEventArgs e)
        {
            if ((e.KeyCode >= Keys.A && e.KeyCode <= Keys.Z) || (e.KeyValue >= '0' && e.KeyValue <= '9') || e.KeyValue == '.' || (e.KeyCode >= Keys.NumPad0 && e.KeyCode <= Keys.NumPad9))

                // if (!(e.KeyChar > '0' && e.KeyChar < '9' || e.KeyChar == '.' || e.KeyChar == 8))
                MessageBox.Show("请使用右侧控制区完成设置！", "系统提示");
        }


        //键盘事件ctrl+c和ctrl+v和ctrl+x和delete
        private void dataGridView1_KeyDown(object sender, KeyEventArgs e)
        {
            //ctrl+c
            if (Control.ModifierKeys == Keys.Control && e.KeyCode == Keys.C)
                Clipboard.SetDataObject(dataGridView1.GetClipboardContent());

            //ctrl+x
            if (Control.ModifierKeys == Keys.Control && e.KeyCode == Keys.X)
            {
                Clipboard.SetDataObject(dataGridView1.GetClipboardContent());
                //this.dataGridView1.CurrentCell = null;
                DgvCtrl.clearSelectCell(this.dataGridView1);
            }


            //ctrl+v
            if (Control.ModifierKeys == Keys.Control && e.KeyCode == Keys.V)
                DgvCtrl.pasteToDataGridView(this.dataGridView1);

            //delete
            if (e.KeyCode == Keys.Delete)
            {
                DgvCtrl.clearSelectCell(this.dataGridView1);
            }

        }


        //右键菜单命令-复制
        private void 复制ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (this.dataGridView1.SelectedCells.Count > 0)
                Clipboard.SetDataObject(dataGridView1.GetClipboardContent());
        }
        //右键菜单命令-粘贴
        private void 粘贴ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            DgvCtrl.pasteToDataGridView(this.dataGridView1);
        }
        //右键菜单命令-剪切
        private void 剪切ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Clipboard.SetDataObject(dataGridView1.GetClipboardContent());
            //this.dataGridView1.CurrentCell = null;
            DgvCtrl.clearSelectCell(this.dataGridView1);
        }

        //右键菜单命令-删除
        private void 删除ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            DgvCtrl.clearSelectCell(this.dataGridView1);
        }


        //表格内数据验证
        private void dataGridView1_CellValidating(object sender, DataGridViewCellValidatingEventArgs e)
        {
            //numbers only
            this.dataGridView1.Rows[e.RowIndex].ErrorText = "";
            double NewVal = 0;
            //empty or number, or go error
            if ( e.FormattedValue.ToString()!="")
            {
                if ((!double.TryParse(e.FormattedValue.ToString(), out NewVal) || NewVal < 0))
                {
                    e.Cancel = true;
                    //this.dataGridView1.Rows[e.RowIndex].ErrorText = "只能输入数字";
                    MessageBox.Show("请输入数字！","系统提示");
                    return;
                }
                else
                {
                    //todo:如果输入001，应该显示1，而不是001.
                    //this.dataGridView1.Rows[e.RowIndex].Cells[e.ColumnIndex].Value= float.Parse(e.FormattedValue.ToString());
                }
            }

        }

        //失去焦点-0
        private void dataGridView0_Leave(object sender, EventArgs e)
        {
            //this.dataGridView0.ClearSelection();
        }

        //失去焦点-1
        private void dataGridView1_Leave(object sender, EventArgs e)
        {
            this.dataGridView1.ClearSelection();
        }
        //获得焦点-0
        private void dataGridView1_Enter(object sender, EventArgs e)
        {
            this.dataGridView0.ClearSelection();
        }


        //解析文件
        private void btnOpen_Click(object sender, EventArgs e)
        {
            OpenFileDialog openFileDialog1 = new OpenFileDialog();

            //openFileDialog1.InitialDirectory = "E:\\";
            openFileDialog1.Filter = "mub File(*.mub)|*.mub|All files|*.*";
            openFileDialog1.RestoreDirectory = true;
            openFileDialog1.FilterIndex = 2;
            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                string fName = openFileDialog1.FileName;
                //调用类文件读取文件，并获取模板信息、OD信息   
                DataReadWrite dfw = new DataReadWrite();
                plate_info = dfw.readFromFile(fName);//获取基本信息
                Info[,] tpl = dfw.getTpl();//模板信息
                double[,] od = dfw.getOd();//OD信息



                //输出板子基本信息：标题、日期、单位、模型编号
                //this.richTextBox1.Text = "";
                /*foreach (string item in plate_info.Keys)
                {
                    string info = this.plate_info[item];
                    this.richTextBox1.Text += item + " [:] " + info + "\n";
                }*/
                this.textName.Text = plate_info["Name"];
                this.dateTimePicker1.Text = plate_info["LabDate"];
                this.textLot.Text = plate_info["Lot"];
                this.txtUnit.Text = plate_info["Unit"];
                this.richTextBox1.Text = plate_info["Note"];


                //先初始化模板-重置所有方格 + //清空od数据
                DgvCtrl.clearAllCells(this.dataGridView0, this.dataGridView1,true);
                


                //从中间数据读取到表格中
                DataReadWrite.readIntoUI(tpl, this.dataGridView0,this.dataGridView1);//模板文件
                DataReadWrite.readIntoUI(od, this.dataGridView1);//od文件

                //this.richTextBox1.Text += DataReadWrite.textDebug;
            }
        }




        //保存文件
        private void btnSave_Click(object sender, EventArgs e)
        {
            //清空字典
            plate_info = new Dictionary<string,string>();
            //重新初始化中间数组
            tpl = new Info[8, 12];
            od = new double[8, 12];
            //string[,] odStr = new string[8, 12];//使用字符数组更好？


            //读取文件到中间数组
            //合法性检测
            if (this.textName.Text.Trim() == null)
            {
                MessageBox.Show("请输入项目名称！", "系统提示");
                return;
            }
            if (this.txtUnit.Text.Trim() == null)
            {
                MessageBox.Show("请输入单位名称！", "系统提示");
                return;
            }


            //基本信息-》中间数据
            plate_info["SaveTime"] = DateTime.Now.ToString();//保存文件时的时间
            plate_info["Name"] = this.textName.Text.Trim();
            plate_info["Lot"] = this.textLot.Text.Trim();
            plate_info["LabDate"] = this.dateTimePicker1.Text.Trim();
            plate_info["Unit"] = this.txtUnit.Text.Trim();
            plate_info["Notice"] = "不要随意更改文件内容，否则再次读取时将发生错误。";
            
            //tpl-》中间数据

            //tpl=>中间数据
            DataReadWrite drw = new DataReadWrite();

            //从UI读取到中间数组
            tpl = drw.readFromUI(this.dataGridView0,true);
            od = drw.readFromUI(this.dataGridView1);


            //中间数据-》文件

            //保存文件
            Stream myStream;
            SaveFileDialog saveFileDialog1 = new SaveFileDialog();

            saveFileDialog1.Filter = "*.mub(模板文件)|*.mub|*.dat(数据文件)|*.dat|txt files (*.txt)|*.txt|All files (*.*)|*.*";
            saveFileDialog1.FilterIndex = 2;
            saveFileDialog1.RestoreDirectory = true;

            if (saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                if ((myStream = saveFileDialog1.OpenFile()) != null)
                {
                    // Code to write the stream goes here.
                    myStream.Close();

                    using (StreamWriter writer = new StreamWriter(saveFileDialog1.FileName, true))
                    {
                        //中间数据写入文件-基本信息
                        foreach (string k in plate_info.Keys)
                        {
                            writer.WriteLine(k+":"+plate_info[k]);
                        }
                        //中间数据写入文件-od
                        writer.WriteLine();
                        writer.WriteLine("[OD Value]");

                        for (int i = 0; i < 8; i++)
                        {
                            for (int j = 0; j < 12; j++)
                            {
                                //writer.Write(i + "\t");
                                //if (od[i, j] != null && od[i, j].ToString() != "")
                                if (od[i, j] != null && od[i, j]>=0)
                                {
                                    writer.Write(od[i, j] + "\t");
                                }
                                else
                                {
                                    writer.Write("\t");
                                }
                            }
                            writer.WriteLine();
                        }

                        //中间数据写入文件-tpl
                        writer.WriteLine();
                        writer.WriteLine("[Layout]");

                        for (int i = 0; i < 8; i++)
                        {
                            for (int j = 0; j < 12; j++)
                            {
                                Info info = tpl[i, j];
                                if (info != null)
                                {
                                    writer.Write(info.well_class + " " + info.well_num + "#" + info.well_conc + "\t");
                                }
                                else 
                                {
                                    writer.Write( "\t");
                                }
                            }
                            writer.WriteLine();
                        }
                        
                        //写曲线类型
                        writer.WriteLine("Curve:"+getRadioIndex().ToString());
                        //写备注
                        writer.WriteLine("Note:"+this.richTextBox1.Text);
                        //plate_info["Note"] = this.richTextBox1.Text;

                        writer.WriteLine("======end======");

                        //写md5验证码：考虑使用tpl和od联合生成

                    }
                }
                myStream.Close();
            }


        }


        //删除模板上的数据：
        private void btnClear_Click(object sender, EventArgs e)
        {
            if (this.dataGridView0.SelectedCells.Count == 0)
            {
                MessageBox.Show("请先在左侧模板中选择一个孔。", "系统提示");
                return;
            }

            for (int i = 0; i < 8; i++)
            {
                for (int j = 0; j < 12; j++)
                {
                    if (this.dataGridView0.Rows[i].Cells[j].Selected == true)
                    {

                        this.dataGridView0.Rows[i].Cells[j].Value = "";

                        //清除颜色 - 调整板子的颜色变化
                        DataReadWrite.changeODBackColor("", this.dataGridView0, i, j);//set板子
                        DataReadWrite.changeODBackColor("", this.dataGridView1, i, j);//od板子
                    }
                }
            }
        }


        //设置模板：要注意对用户数据的验证过滤
        private void btnAsign_Click(object sender, EventArgs e)
        {
            //如果没有选择文本框，报错
            // int i=dataGridView1.SelectedRows.Count; //选择的行数。
            if (this.dataGridView0.SelectedCells.Count == 0) {
                MessageBox.Show("请先在左侧模板中选择一个孔。","系统提示");
                return;
            }


            //如果是标准品/质控品没有填写编号，则报错
            if (this.comboBox1.SelectedIndex < 2)
            {
                if (this.txtNum.Text.Trim() == "")
                {
                    MessageBox.Show("请填写编号");
                    return;
                }
                if (this.txtConc.Text.Trim() == "")
                {
                    MessageBox.Show("请填写浓度");
                    return;
                }
                //浓度不能是负数
                if (float.Parse(this.txtConc.Text.Trim()) < 0)
                {
                    MessageBox.Show("浓度不能为负值");
                    return;
                }

                //给图形界面赋值
                DgvCtrl.setValueToUI(this.dataGridView0, this.dataGridView1, this.comboBox1.SelectedIndex, this.txtNum.Text.Trim(), double.Parse(this.txtConc.Text.Trim()));
            }
            else
            {
                //如果是空白对照 或未知样品 没填写编号，则报错
                if (this.comboBox1.SelectedIndex >= 2)
                {
                    if (this.txtNum.Text.Trim() == "")
                    {
                        MessageBox.Show("请填写编号");
                        return;
                    }
                }
                //给图形界面赋值
                DgvCtrl.setValueToUI(this.dataGridView0, this.dataGridView1, this.comboBox1.SelectedIndex, this.txtNum.Text.Trim() );
            }
        }



        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            //计数从0开始。01234
            if (this.comboBox1.SelectedIndex >= 2)
            {
                this.txtConc.Text = "";
                this.txtConc.Enabled = false;
            }
            else 
            {
                this.txtConc.Enabled = true;
            }
            

        }

        //单击内置模板会载入内置模板
        private void cmbTpl_SelectedIndexChanged(object sender, EventArgs e)
        {
            string tpl_name=this.cmbTpl.Text;//.SelectedIndex. >= 2)
            //实例化内置模板类
            InnerTpl form_inner_tpl = new InnerTpl();
            //MessageBox.Show(tpl_name);
            //获取模板内容
            Info[,] tpl = form_inner_tpl.getTplByName(tpl_name);


            //先初始化模板-重置所有方格
            DgvCtrl.clearAllCells(this.dataGridView0, this.dataGridView1);


            //中间信息写到界面上
            DataReadWrite.readIntoUI(tpl, this.dataGridView0, this.dataGridView1);

        }

        private void btnOpenTpl_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Sorry, 该功能尚未实现", "作者提示");

        }

        private void btnSaveTpl_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Sorry, 该功能尚未实现", "作者提示");
        }

        //按照指定模型对曲线进行拟合
        private void btnStartFit_Click(object sender, EventArgs e)
        {
            int curve_type = getRadioIndex();
            richTextBox1.Text = curve_type.ToString();

            if (curve_type >= 2)
                MessageBox.Show("Sorry, 该功能尚未实现", "作者提示");

        }

        //获取单选按钮的序号
        private int getRadioIndex() {
            int curve_type=-1;
            if (radioButton1.Checked == true)
            {
                //richTextBox1.Text = "选择了radioButton1";
                curve_type= 1;
            }
            else if (radioButton2.Checked == true)
            {
                //richTextBox1.Text = "选择了radioButton2";
                curve_type= 2;
            }
            else if (radioButton3.Checked == true)
            {
                //richTextBox1.Text = "选择了radioButton3";
                curve_type= 3;
            }
            else if (radioButton4.Checked == true)
            {
                //richTextBox1.Text = "选择了radioButton4";
                curve_type= 4;
            }

            return curve_type;
        }





      
    }
                
}
