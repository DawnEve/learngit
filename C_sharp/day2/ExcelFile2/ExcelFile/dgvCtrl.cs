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
        public static void dataGridViewInit(DataGridView dgv,bool isSettings=false)
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



            //一共12列
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

                //控制控件居中显示
                if (isSettings)
                    dgv.Columns[i].DefaultCellStyle.Alignment = DataGridViewContentAlignment.MiddleCenter;
            }


            //一共8行
            string[] RowNames = { "A", "B", "C", "D", "E", "F", "G", "H" };
            dgv.Height = 302;//222
            for (int i = 0; i < 8; i++)
            {
                dgv.Rows.Add();
                dgv.Rows[i].HeaderCell.Value = RowNames[i];
                //最小高度
                dgv.Rows[i].MinimumHeight = 35;//25

                //不允许改变大小
                dgv.Rows[i].Resizable = DataGridViewTriState.False;
            }

            


            //如果是设置框，需要额外设置属性
            if (isSettings)
            {
                //设置只读
                dgv.ReadOnly = true;

                //方格内换行
                dgv.RowsDefaultCellStyle.WrapMode = DataGridViewTriState.True;
                //内容居中

            }
            else 
            {
                //消除焦点
                dgv.ClearSelection();
            }

        }

        //添加测试数据
        public static void addTestData(DataGridView dgv)
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
            //添加随机测试数据
            dgv.Rows[4].Cells[3].Value = 10.00;
        }

        //清除所选区域
        public static  void clearSelectCell(DataGridView dgv) {
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 8; j++)
                {
                    if (dgv.Rows[j].Cells[i].Selected==true)
                      dgv.Rows[j].Cells[i].Value = "";
                }
            }
        }


        //删除说有数据
        public static void clearAllCells(DataGridView dgv, DataGridView dgv1)
        {
            if (dgv.SelectedCells.Count == 0)
            {
                //MessageBox.Show("请先在左侧模板中选择一个孔。", "系统提示");
                return;
            }

            for (int i = 0; i < 8; i++)
            {
                for (int j = 0; j < 12; j++)
                {


                    dgv.Rows[i].Cells[j].Value = "";

                    //清除颜色 - 调整板子的颜色变化
                    DataReadWrite.changeODBackColor("", dgv, i, j);//set板子
                    DataReadWrite.changeODBackColor("", dgv1, i, j);//od板子

                }
            }
        }



        //从剪切板粘贴数据到dataGridView控件
        public static void pasteToDataGridView(DataGridView dgv)
        {
            //如果当前没有选中，则直接返回
            if (dgv.CurrentCell == null) return;

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
            int r = dgv.SelectedCells[0].RowIndex;
            int cc = dgv.SelectedCells[0].ColumnIndex;

            for (int iRow = 0; iRow < rowsInClipboard.Length; iRow++)
            {
                string[] valuesInRow = rowsInClipboard[iRow].Split(columnSplitter);
                for (int iCol = 0; iCol < valuesInRow.Length; iCol++)
                {
                    if ((r + iRow) > (dgv.Rows.Count - 1)) //如果拷贝数据超过现有单元格长度,要中止运行,否则会报错
                    { break; }
                    else if (dgv.ColumnCount - 1 >= cc + iCol)
                    {
                        dgv.Rows[r + iRow].Cells[cc + iCol].Value = valuesInRow[iCol]; //被注释的语句,与此处作用相同
                    }
                }
            }
        }


        //含有浓度的设置
        public static void setValueToUI(DataGridView dgv, DataGridView dgv1, int well_class_index, string well_num, double well_conc)
        {
            //MessageBox.Show("调用了赋值函数:" + well_class_index.ToString() + " - " + well_num + " - " + well_conc);
            for (int i = 0; i < 8; i++)
            {
                for (int j = 0; j < 12; j++)
                {
                    if (dgv.Rows[i].Cells[j].Selected == true)
                    {
                        //Info info = tpl[i, j];
                        Info info;
                        if (well_class_index == 0)
                        {
                            info = new Info(i, j, "std", well_num, well_conc);
                        }
                        else
                        {
                            info = new Info(i, j, "ctr", well_num, well_conc);
                        }

                        dgv.Rows[i].Cells[j].Value = info.well_class + " " + info.well_num + System.Environment.NewLine + info.well_conc;

                        //调整板子的颜色变化
                        DataReadWrite.changeODBackColor(info.well_class, dgv, info.i, info.j);//set板子
                        DataReadWrite.changeODBackColor(info.well_class, dgv1, info.i, info.j);//od板子
                    }
                }
            }
        }


        //含有浓度的设置
        public static void setValueToUI(DataGridView dgv, DataGridView dgv1, int well_class_index, string well_num)
        {
            //MessageBox.Show("调用了赋值函数:" + well_class_index.ToString() + " - " + well_num + " - " + well_conc);
            for (int i = 0; i < 8; i++)
            {
                for (int j = 0; j < 12; j++)
                {
                    if (dgv.Rows[i].Cells[j].Selected == true)
                    {
                        //Info info = tpl[i, j];
                        Info info;
                        if (well_class_index == 2)
                        {
                            info = new Info(i, j, "blank", well_num);
                        }
                        else
                        {
                            info = new Info(i, j, "smp", well_num);
                        }

                        dgv.Rows[i].Cells[j].Value = info.well_class + " " + info.well_num;

                        //调整板子的颜色变化
                        DataReadWrite.changeODBackColor(info.well_class, dgv, info.i, info.j);//set板子
                        DataReadWrite.changeODBackColor(info.well_class, dgv1, info.i, info.j);//od板子
                    }
                }
            }
        }


    }
}
