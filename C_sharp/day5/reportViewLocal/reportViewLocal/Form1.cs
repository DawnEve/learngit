using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace reportViewLocal
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

            this.reportViewer1.RefreshReport();
        }

        private void reportViewer1_Load(object sender, EventArgs e)
        {
             DataTable dt = new DataTable();
             dt.Columns.Add(new DataColumn("row1", typeof(string)));
             dt.Columns.Add(new DataColumn("row2", typeof(string)));

             for (int i = 0; i < 6; i++)
             {
                 DataRow dr = dt.NewRow();
                 dr[0] = "a";
                 dr[1] = "b";
                 dt.Rows.Add(dr);
             }

             reportViewer1.LocalReport.ReportPath = @"F:\gitHub\learngit\C_sharp\day5\reportViewLocal\reportViewLocal\Report1.rdlc";
             //指定数据集,数据集名称后为表,不是DataSet类型的数据集
             this.reportViewer1.LocalReport.DataSources.Clear();
             this.reportViewer1.LocalReport.DataSources.Add(new Microsoft.Reporting.WinForms.ReportDataSource("message", dt));
             //显示报表
             this.reportViewer1.RefreshReport();
        }
    }
}
