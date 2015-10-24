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

        private void Form1_Load(object sender, EventArgs e)
        {
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;


            DgvInit();//初始化dataGridView控件
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




        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            this.richTextBox1.Text = (string)this.dataGridView1.CurrentCell.Value;
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



       

        private void 复制ToolStripMenuItem_Click_1(object sender, EventArgs e)
        {
           // if (dataGridView1.SelectedRows.Count > 0)
           // SendKeys.Send("^C");//可用的方法，发送ctrl+c

            if (this.dataGridView1.SelectedCells.Count > 0)
                 Clipboard.SetDataObject(dataGridView1.GetClipboardContent());
        }

        private void 粘贴ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            pasteToDataGridView();
        }


        //右键弹出菜单之前，选中右键单击时刻的单元格
        private void dataGridView1_CellMouseDown(object sender, DataGridViewCellMouseEventArgs e)
        {
            if (e.RowIndex >= 0)
            {
                if (e.Button == System.Windows.Forms.MouseButtons.Right)
                {
                    if ( this.dataGridView1.Rows[e.RowIndex].Cells[e.ColumnIndex].Selected != true )
                    {
                        //如果右击的位置在选取之外,则清除选区，并选中当前单元格
                        dataGridView1.ClearSelection();
                        dataGridView1.Rows[e.RowIndex].Cells[e.ColumnIndex].Selected = true;
                        //设定当前行为右击的单元格
                        this.dataGridView1.CurrentCell = this.dataGridView1.Rows[e.RowIndex].Cells[e.ColumnIndex];
                    }
                }
            }
        }

        //从剪切板粘贴数据到dataGridView控件
        private void pasteToDataGridView() {
            if (this.dataGridView1.CurrentCell == null) return;
            string paste = Clipboard.GetText();
            paste = paste.ToString().Trim();
            if (string.IsNullOrEmpty(paste)) return;
            char[] rowSplitter = { '\r', '\n' };
            char[] columnSplitter = { '\t' };
            IDataObject dataInClipboard = Clipboard.GetDataObject();
            string stringInClipboard = (string)dataInClipboard.GetData(DataFormats.Text);
            string[] rowsInClipboard = stringInClipboard.Split(rowSplitter, StringSplitOptions.RemoveEmptyEntries);
            stringInClipboard = stringInClipboard.Replace("?", ""); //刪除转行的行未空格
            int r = dataGridView1.SelectedCells[0].RowIndex; //获得单元格位置
            int cc = dataGridView1.SelectedCells[0].ColumnIndex;

            for (int iRow = 0; iRow < rowsInClipboard.Length; iRow++)
            {
                string[] valuesInRow = rowsInClipboard[iRow].Split(columnSplitter);
                for (int iCol = 0; iCol < valuesInRow.Length; iCol++)
                {
                    if ((r + iRow) > (dataGridView1.Rows.Count - 1)) //如果拷贝数据超过现有单元格长度,要中止运行,否则会报错
                    { break; }
                    else if (dataGridView1.ColumnCount - 1 >= cc + iCol)
                    {
                        dataGridView1.Rows[r + iRow].Cells[cc + iCol].Value = valuesInRow[iCol]; //被注释的语句,与此处作用相同
                    }
                }
            }
        }

        //键盘事件ctrl+c和ctrl+v
        private void dataGridView1_KeyDown(object sender, KeyEventArgs e)
        {
            if (Control.ModifierKeys == Keys.Control && e.KeyCode == Keys.V)
            {
                if (sender != null && sender.GetType() == typeof(DataGridView)) {
                    MessageBox.Show("Data in right format!!");
                
                }
                // 调用上面的粘贴代码
                pasteToDataGridView();
            }

            if (Control.ModifierKeys == Keys.Control && e.KeyCode == Keys.C)
            {
                Clipboard.SetDataObject(dataGridView1.GetClipboardContent());
            }
        }


    }
}
