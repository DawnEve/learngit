using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Drawing;

namespace ExcelFile
{
    /// <summary>
    /// dataGridView控件的初始化
    /// </summary>
    class DgvCtrl
    {
        //初始化控件
        public void dataGridView1Init(DataGridView dgv)
        {
            //样式
            //列标题居中显示
            dgv.ColumnHeadersDefaultCellStyle.Alignment = DataGridViewContentAlignment.MiddleCenter;
            //单元格中字符靠右显示
            dgv.DefaultCellStyle.Alignment = DataGridViewContentAlignment.MiddleRight;
            dgv.BackgroundColor = Color.White;

            //行为
            dgv.AutoGenerateColumns = false;//不自动创建列
            dgv.AllowUserToAddRows = false;//不允许用户添加条目



            //一共12行
            int dgvWidth = dgv.Width;
            for (int i = 0; i < 12; i++)
            {
                dgv.Columns.Add((string)("c" + i + 1), (i + 1).ToString());
                //设置列宽
                dgv.Columns[i].Width = (int)(dgvWidth / 13);
                //设置最小列宽
                dgv.Columns[i].MinimumWidth = (int)(dgvWidth / 12.58);
                //不允许排序
                dgv.Columns[i].SortMode = DataGridViewColumnSortMode.NotSortable;
                //填充满
                dgv.Columns[i].AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill;
            }


            //一共8列
            string[] RowNames = { "A", "B", "C", "D", "E", "F", "G", "H" };
            dgv.Height = 222;
            for (int i = 0; i < 8; i++)
            {
                dgv.Rows.Add();
                dgv.Rows[i].HeaderCell.Value = RowNames[i];
                //最小高度
                dgv.Rows[i].MinimumHeight = 25;

                //不允许改变大小
                dgv.Rows[i].Resizable = DataGridViewTriState.False;
            }

        }

        //添加测试数据
        public void addTestData(DataGridView dgv)
        {
            for (int i = 0; i < 8; i++)
            {
                //添加测试数据
                dgv.Rows[i].Cells[0].Value = i + 0.121;
                dgv.Rows[i].Cells[1].Value = i + 0.232;
                dgv.Rows[i].Cells[2].Value = i + 0.387;
                dgv.Rows[i].Cells[3].Value = i + 0.474;
                dgv.Rows[i].Cells[4].Value = i + 0.593;
                dgv.Rows[i].Cells[5].Value = i + 0.616;
                dgv.Rows[i].Cells[6].Value = i + 0.754;
                dgv.Rows[i].Cells[7].Value = i + 0.820;
            }
            //添加测试数据
            dgv.Rows[4].Cells[3].Value = 10.00;
        }


        public void clearSelectCell(DataGridView dgv) {
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 8; j++)
                {
                    if (dgv.Rows[j].Cells[i].Selected==true)
                      dgv.Rows[j].Cells[i].Value = "";

                }
            
            }
        }



    }
}
