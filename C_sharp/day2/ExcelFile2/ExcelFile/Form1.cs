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
    /// <summary>
    /// 坚持只在本文件中写事件处理函数，其他的函数写到单独的文件中
    /// </summary>
    public partial class Form1 : Form
    {

        //定义一个模板对象 dataGridView1;


        //定义一个数据对象 dataGridView2;


        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            //窗体固定
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.Fixed3D;

            //设置数据显示框位置
            this.dataGridView1.Width = 787;
            this.dataGridView0.Width = 787;


            //实例化一个dataGridView类：0控制类
            DgvCtrl.dataGridViewInit(this.dataGridView0);
            //添加测试数据
            //dc0.addTestData(this.dataGridView0);
            //设置为只读
            this.dataGridView0.ReadOnly = true;  

            //实例化一个dataGridView类：1数据显示
            DgvCtrl.dataGridViewInit(this.dataGridView1);
            //添加测试数据
            DgvCtrl.addTestData(this.dataGridView1);

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
                    this.dataGridView1.Rows[e.RowIndex].Cells[e.ColumnIndex].Value= float.Parse(e.FormattedValue.ToString());
                }
            }

        }




        private void btnOpen_Click(object sender, EventArgs e)
        {

        }

        private void btnSave_Click(object sender, EventArgs e)
        {

        }

        private void dataGridView1_Leave(object sender, EventArgs e)
        {
            this.dataGridView1.ClearSelection();
        }

        private void dataGridView2_Leave(object sender, EventArgs e)
        {
            this.dataGridView0.ClearSelection();
        }



        

    }
                
}
