using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ExcelFile
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            //窗体固定
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.Fixed3D;

            //实例化一个dataGridView控制类
            DgvCtrl dc = new DgvCtrl();
            //初始化一个dataGridView
            dc.dataGridView1Init(this.dataGridView1);
            //添加测试数据
            dc.addTestData(this.dataGridView1);
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




        //从剪切板粘贴数据到dataGridView控件
        private void pasteToDataGridView()
        {
            //如果当前没有选中，则直接返回
            if (this.dataGridView1.CurrentCell == null) return;

            //------------从剪切板获得数据字符文本
            string paste = Clipboard.GetText();
            //剪切板数据转化成字符串，并去除首尾空格
            paste = paste.ToString().Trim();
            //如果字符串为空，则直接返回
            if (string.IsNullOrEmpty(paste)) return;
            //---------经过检验不为空

            //设置行和列分隔符
            char[] rowSplitter = { '\r', '\n' };
            char[] columnSplitter = { '\t' };

            //从剪切板获得数据
            IDataObject dataInClipboard = Clipboard.GetDataObject();
            string stringInClipboard = (string)dataInClipboard.GetData(DataFormats.Text);
            //?
            string[] rowsInClipboard = stringInClipboard.Split(rowSplitter, StringSplitOptions.RemoveEmptyEntries);
            stringInClipboard = stringInClipboard.Replace("?", ""); //刪除转行的行未空格
            //获得单元格位置
            int r = dataGridView1.SelectedCells[0].RowIndex;
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
                new DgvCtrl().clearSelectCell(this.dataGridView1);
            }


            //ctrl+v
            if (Control.ModifierKeys == Keys.Control && e.KeyCode == Keys.V)
                pasteToDataGridView();

            //delete
            if (e.KeyCode == Keys.Delete)
            {
                new DgvCtrl().clearSelectCell(this.dataGridView1);
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
            pasteToDataGridView();
        }

        private void 剪切ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Clipboard.SetDataObject(dataGridView1.GetClipboardContent());
            //this.dataGridView1.CurrentCell = null;
            new DgvCtrl().clearSelectCell(this.dataGridView1);
        }

        private void 删除ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new DgvCtrl().clearSelectCell(this.dataGridView1);
        }



        private void dataGridView1_CellValidating(object sender, DataGridViewCellValidatingEventArgs e)
        {
            //numbers only
            this.dataGridView1.Rows[e.RowIndex].ErrorText = "";
            double NewVal = 0;
            //empty or number, or go error
            if ( e.FormattedValue.ToString()!="" && (!double.TryParse(e.FormattedValue.ToString(), out NewVal) || NewVal < 0))
            {
                e.Cancel = true;
                this.dataGridView1.Rows[e.RowIndex].ErrorText = "只能输入数字";
                return;
            }

        }




        private void btnOpen_Click(object sender, EventArgs e)
        {

        }

        private void btnSave_Click(object sender, EventArgs e)
        {

        }



        

    }
                
}
