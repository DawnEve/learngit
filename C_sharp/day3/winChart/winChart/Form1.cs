using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Windows.Forms.DataVisualization.Charting;

namespace winChart
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            chart1.Series.Clear();
            Series series = new Series("销售量");
            series.ChartType = SeriesChartType.Spline;  //设置为曲线模式
            series.BorderWidth = 1;
            series.ShadowOffset = 1;             // Populate new series with data  
            series.MarkerStyle = MarkerStyle.Circle;//数据点形状
            series.MarkerColor = Color.Red;//数据点的颜色


            this.chart1.ChartAreas[0].AxisX.Minimum = 1; //x坐标最小值 
            this.chart1.ChartAreas[0].AxisX.Maximum = 5;//x坐标最大值
            
            this.chart1.ChartAreas[0].AxisY.Minimum = 20; //y坐标最小值 
           // this.chart1.ChartAreas[0].AxisY.Maximum = 85;//y坐标最大值

            this.chart1.ChartAreas[0].AxisX.Interval = 2;//坐标大刻度间隔
            this.chart1.ChartAreas[0].AxisX.MinorTickMark.Interval = 1;//小刻度间隔，就像厘米下的毫

            series.IsValueShownAsLabel = true; //数据值是否显示，建议代码控制
            series.SmartLabelStyle.Enabled = false; //直接控制可用不可用，建议不可用
            //series.SmartLabelStyle.AllowOutsidePlotArea = LabelOutsidePlotAreaStyle.No;//数据值显示是否允许在外面

            series.Points.AddY(67);
            series.Points.AddY(57);
            series.Points.AddY(83);
            series.Points.AddY(23);
            series.Points.AddY(123);
            //添加到series中
            chart1.Series.Add(series);
            chart1.Series[0].XAxisType = AxisType.Primary;

            chart1.Series[0].XValueMember = "Conc.";
            chart1.Series[0].YValueMembers = "OD";
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            button1_Click(sender,e);
        }
    }
}
