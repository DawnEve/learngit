using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace dgv
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        //初始化dataGridView的样式
        private void DgvInit(){
            //样式
            dataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.None;//列宽不自动调整,手工添加列
            dataGridView1.RowHeadersWidth = 40;//行标题宽度固定
            dataGridView1.RowHeadersWidthSizeMode = DataGridViewRowHeadersWidthSizeMode.DisableResizing;//不能用鼠标调整列标头宽度
            dataGridView1.AlternatingRowsDefaultCellStyle.BackColor = Color.LemonChiffon;//奇数行背景色
            dataGridView1.BackgroundColor = Color.White;//控件背景色
            dataGridView1.ColumnHeadersDefaultCellStyle.Alignment = DataGridViewContentAlignment.MiddleCenter;//列标题居中显示
            dataGridView1.DefaultCellStyle.Alignment = DataGridViewContentAlignment.MiddleCenter;//单元格内容居中显示

            //行为
            dataGridView1.AutoGenerateColumns = false;//不自动创建列
            dataGridView1.AllowUserToAddRows = false;//不启用添加
            dataGridView1.ReadOnly = true;//不启用编辑
            dataGridView1.AllowUserToDeleteRows = false;//不启用删除
            //dataGridView1.SelectionMode = DataGridViewSelectionMode.FullRowSelect;//单击单元格选中整行
            //dataGridView1.MultiSelect = false;//不能多选

            //增加右键菜单
            dataGridView1.ContextMenuStrip = this.contextMenuStrip1;

            //添加列标题
            this.dataGridView1.Columns[0].HeaderText = "OrderID";

            //获取总列数和总宽度
            int intColumnCount = this.dataGridView1.ColumnCount;
            int width = this.dataGridView1.Width;

            // int index = this.dataGridView1.Rows.Add();
            //this.dataGridView1.Rows[index].Cells[0].Value = "1";
            //this.dataGridView1.Rows[index].Cells[1].Value = "2";
            //this.dataGridView1.Rows[index].Cells[2].Value = "监听";
            //  this.dataGridView1.Rows[0].HeaderCell.Value = "A";
            //  this.dataGridView1.Rows.Add();

            //循环设置行标题
            string[] rowName = { "A", "B", "C", "D", "E", "F", "G", "H" };
            for (int i = 0; i < 8; i++)
            {
                this.dataGridView1.Rows.Add();
                this.dataGridView1.Rows[i].HeaderCell.Value = rowName[i];
                this.dataGridView1.Rows[i].MinimumHeight = 25;
                //取消右键菜单
                this.dataGridView1.Rows[i].HeaderCell.ContextMenuStrip = null;

                //添加测试数据
                this.dataGridView1.Rows[i].Cells[0].Value = "1";
                this.dataGridView1.Rows[i].Cells[1].Value = "2";
                this.dataGridView1.Rows[i].Cells[2].Value = "3";
                this.dataGridView1.Rows[i].Cells[3].Value = "4";
            }
            this.dataGridView1.Rows[7].Cells[3].Value = "5";


            //循环设置列宽度
            for (int i = 0; i < intColumnCount; i++)
            {

                //不允许排序
                this.dataGridView1.Columns[i].SortMode = DataGridViewColumnSortMode.Programmatic;

                // dataGridView1.SelectionMode = DataGridViewSelectionMode.ColumnHeaderSelect;

                //设置最小列宽
                this.dataGridView1.Columns[i].MinimumWidth = (int)(width / 12.5);
                //自动调整列宽
                //this.dataGridView1.Columns[i].AutoSizeMode = DataGridViewAutoSizeColumnMode.AllCells;

                //取消右键菜单
                this.dataGridView1.Columns[i].HeaderCell.ContextMenuStrip = null;
                //.ContextMenuStrip = null;
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;


            DgvInit();//初始化dataGridView控件
        }


        //粘贴剪切板的东西到当前dataGridView控件
        private void pasteToDgv() {
            //当前单元格是否选择的判断
            if (dataGridView1.CurrentCell == null)
                return;
            int insertRowIndex = dataGridView1.CurrentCell.RowIndex;
            // 获取剪切板的内容，并按行分割
            string pasteText = Clipboard.GetText();

            

            if (string.IsNullOrEmpty(pasteText))
                return;
            pasteText = pasteText.Replace(" ", " ");
            pasteText = pasteText.Replace(' ', ' ');
            pasteText.TrimEnd(new char[] { ' ' });
            string[] lines = pasteText.Split(' ');

            //this.richTextBox1.Text = pasteText;//debug here


            bool isHeader = true;
            foreach (string line in lines)
            {
                // 是否是列头
                if (isHeader)
                {
                    isHeader = false;
                    continue;
                }
                // 按 Tab 分割数据
                string[] vals = line.Split(' ');
                // 判断列数是否统一
                if (vals.Length - 1 != dataGridView1.ColumnCount)
                    throw new ApplicationException("粘贴的列数不正确。");
                DataGridViewRow row = dataGridView1.Rows[insertRowIndex];
                // 行头设定
                row.HeaderCell.Value = vals[0];
                // 单元格内容设定
                for (int i = 0; i < row.Cells.Count; i++)
                {
                    row.Cells[i].Value = vals[i + 1];
                }
                // DataGridView的行索引+1
                insertRowIndex++;
            }
        }



        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            this.richTextBox1.Text = (string)this.dataGridView1.CurrentCell.Value;
        }



        private void dataGridView1_CellMouseClick(object sender, DataGridViewCellMouseEventArgs e)
        {
           
        }

        //控制上下文菜单是否可用
        private void contextMenuStrip1_Opening(object sender, CancelEventArgs e)
        {
            //如果点击无效区域,返回,不弹出菜单
            if (this.dataGridView1.SelectedCells.Count < 0)
            {
                this.复制ToolStripMenuItem.Enabled = false;
            }
            else {
                this.复制ToolStripMenuItem.Enabled = true;
            }
        }


       

        public void dataGridView1_KeyDown(object sender, KeyEventArgs e)
        {
            if (Control.ModifierKeys == Keys.Control && e.KeyCode == Keys.V)
            {
                if (sender != null && sender.GetType() == typeof(DataGridView))
                    // 调用上面的粘贴代码
                    DataGridViewCopy((DataGridView)sender);
            }
        }

        //[复制]从DataGridView控件拷贝数据
        public void DataGridViewEnableCopy(DataGridView dgv)
        {
            Clipboard.SetData(DataFormats.Text, dgv.GetClipboardContent());
        }

        //向DataGridView控件粘贴数据
        public void DataGridViewCopy(DataGridView p_Data)
        {
            try
            {
                // 获取剪切板的内容，并按行分割
                string pasteText = Clipboard.GetText();
                if (string.IsNullOrEmpty(pasteText))
                    return;
                string[] lines = pasteText.Split(new char[] { ' ', ' ' });
                foreach (string line in lines)
                {
                    if (string.IsNullOrEmpty(line.Trim()))
                        continue;
                    // 按 Tab 分割数据
                    string[] vals = line.Split(' ');
                    p_Data.Rows.Add(vals);
                }
            }
            catch
            {
                // 不处理
            }
        }

        private void 复制ToolStripMenuItem_Click_1(object sender, EventArgs e)
        {
             //Clipboard.SetDataObject(dataGridView1.GetClipboardContent());
            //DataGridViewClipboardCopyMode.EnableWithoutHeaderText;
            //Clipboard.SetData(DataGridView, dataGridView1.GetClipboardContent());
            //Clipboard.SetDataObject(dataGridView1.GetClipboardContent());

           // MessageBox.Show("this is me");

            //if (sender != null && sender.GetType() == typeof(DataGridView))
                // 调用上面的粘贴代码
           //     DataGridViewCopy((DataGridView)sender);


           // if (dataGridView1.SelectedRows.Count > 0)
           // SendKeys.Send("^C");//可用的方法，发送ctrl+c

            if (this.dataGridView1.SelectedCells.Count > 0)
                 Clipboard.SetDataObject(dataGridView1.GetClipboardContent());
        }

        private void 粘贴ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            pasteToDgv();
        }


    }
}
