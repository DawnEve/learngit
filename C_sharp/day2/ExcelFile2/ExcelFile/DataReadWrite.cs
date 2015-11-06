using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ExcelFile
{
    //保存well信息
    class Info
    {
        //位置信息
        public int i;//8行
        public int j;//12列
        //数据信息
        public string well_class;//样品类别 std ctr smp
        public string well_num;//样品编号
        public double well_conc;//样品浓度

        //标准品和质控品
        public Info(int i, int j, string well_class, string well_num, double well_conc)
        {
            this.i = i;
            this.j = j;
            this.well_class = well_class;
            this.well_num = well_num;
            this.well_conc = well_conc;
        }
        //待测样品
        public Info(int i, int j, string well_class, string well_num)
        {
            this.i = i;
            this.j = j;
            this.well_class = well_class;
            this.well_num = well_num;
            //this.well_conc = well_conc;
        }
    }


    class DataReadWrite
    {
        /* 定义一些公用属性
        *  
        */
        //====================================中间信息（文件与界面之间）
        //板子基本信息-plate_Info
        private Dictionary<string, string> plate_Info = new Dictionary<string, string>();

        //板子模板设置信息
        private Info[,] tpl = new Info[8, 12];

        //板子OD信息
        private Double[,] od = new double[8, 12];

        //public static string textDebug { get; set; }




        //获取模板信息
        public Info[,] getTpl()
        {
            return this.tpl;
        }

        //获取OD读数
        public double[,] getOd()
        {
            return this.od;
        }


        //从文件读取到中间格式
        public Dictionary<string, string> readFromFile(string fileName)
        {
            //流读取
            string txt = "";
            //使用之后会自动销毁流对象
            using (StreamReader sr = new StreamReader(fileName, true))
            {

                //定义文件分隔符
                bool flag_head = true;//文件头部信息是否完整
                bool flag_Value = false; //值开始
                bool flag_Layout = false;//模板开始
                bool flag_Curve = false;//拟合曲线类型开始
                bool flag_MD5 = false;//文件sha1编码


                //设置od和模板数据的循环初始值
                int i = 0;
                int iM = 0;



                //进行文件循环
                while (sr.Peek() >= 0)
                {
                    //Console.WriteLine(sr.ReadLine());
                    txt = sr.ReadLine().ToString();

                    //如果是空行，则过滤掉。
                    if (txt == "") continue;

                    //根据文本标记设置开关-OD数据
                    if (txt == "[OD Value]")
                    {
                        flag_head = false;
                        flag_Value = true;
                        flag_Layout = false;
                        flag_Curve = false;
                        flag_MD5 = false;

                        continue;
                    }

                    //根据文本标记设置开关-布局数据
                    if (txt == "[Layout]")
                    {
                        flag_head = false;
                        flag_Value = false;
                        flag_Layout = true;
                        flag_Curve = false;
                        flag_MD5 = false;

                        continue;
                    }

                    //根据文本标记设置开关-尾部数据
                    if (txt.Contains("Curve"))
                    {
                        flag_head = false;
                        flag_Value = false;
                        flag_Layout = false;
                        flag_Curve = true;
                        flag_MD5 = false;

                        //continue;
                    }

                    //根据文本标记设置开关-尾部数据
                    if (txt.Contains("-END-"))
                    {
                        flag_head = false;
                        flag_Value = false;
                        flag_Layout = false;
                        flag_Curve = false;
                        flag_MD5 = true;

                        continue;
                    }

                    //========================================

                    //----------------
                    //根据开关进行处理-头部文件
                    if (flag_head)
                    {
                        //MessageBox.Show(txt, "Head");
                        if (txt.Contains("SaveTime"))
                        {
                            string[] info = txt.Split(':');
                            plate_Info.Add(info[0], info[1] + ':' + info[2] + ':' + info[3]);
                        } if (txt.Contains("Name"))
                        {
                            string[] info = txt.Split(':');
                            plate_Info.Add(info[0], info[1]);
                        }
                        if (txt.Contains("Lot"))
                        {
                            string[] info = txt.Split(':');
                            plate_Info.Add(info[0], info[1]);
                        }
                        if (txt.Contains("LabDate"))
                        {
                            string[] info = txt.Split(':');
                            plate_Info.Add(info[0], info[1]);
                        }
                        if (txt.Contains("Unit"))
                        {
                            string[] info = txt.Split(':');
                            plate_Info.Add(info[0], info[1]);
                        }
                        if (txt.Contains("Notice"))
                        {
                            string[] info = txt.Split(':');
                            plate_Info.Add(info[0], info[1]);
                        }
                    }


                    //----------------
                    //根据开关进行处理-OD数据
                    //if (flag_Value && false)//先跳过OD data
                    if (flag_Value)
                    {
                        string[] d_value = txt.Split('\t');

                        //j相当于列
                        //string Location = "";
                        for (int j = 0; j < 12; j++)
                        {
                            if (d_value[j].Trim() != "")
                            {
                                //Location = (string)(i + "行" + j + "列");
                                //MessageBox.Show(d_value[j], "OD-" + Location);
                                od[i, j] = Double.Parse(d_value[j]);
                            }
                        }

                        i++;//i相当于行
                    }



                    //----------------
                    //根据开关进行处理-布局数据
                    //if (flag_Layout && false)//先跳过模板data
                    if (flag_Layout)
                    {
                        //MessageBox.Show(txt, "Layout");
                        string[] d_value = txt.Split('\t');

                       
                        //j相当于列
                        //string Location = "";
                        string MuBan_info = "";
                        string[] info = new string[2];
                        string[] info2 = new string[2];
                        for (int j = 0; j < 12; j++)
                        {
                            MuBan_info = d_value[j] + "  \n";
                            if (d_value[j].Trim() != "")
                            {
                                if (d_value[j].Contains("std") || d_value[j].Contains("ctr") )
                                {
                                    info = d_value[j].Split('#');
                                    info2 = info[0].Split(' ');
                                    //tpl.std.Add(info2[1], Convert.ToDouble(info[1]) );
                                    //MuBan_info += "标准品" + info2[0] + ", 编号" + info2[1] + "， 浓度" + info[1];
                                    //Info wi = new Info(Convert.ToDouble(info[1]), iM, j);
                                    Info wi = new Info(iM, j, info2[0], info2[1], Convert.ToDouble(info[1]) );
                                    tpl[iM,j]=wi;
                                }
                                else if (d_value[j].Contains("smp"))
                                {
                                    info = d_value[j].Split(' ');
                                    //tpl.ctr.Add(info[1],-1);
                                    //MuBan_info += "待测样品" + info[0] + "， 编号" + info[1];
                                    Info wi = new Info(iM, j, info[0], info[1]);
                                    tpl[iM, j] = wi;
                                }
                            }
                        }

                        iM++;//i相当于行
                    }


                    //----------------
                    //根据开关进行处理-尾部文件
                    if (flag_Curve)
                    {
                        //MessageBox.Show(txt, "Curve");
                        if (txt.Contains("Curve"))
                        {
                            string[] info = txt.Split(':');
                            plate_Info.Add(info[0], info[1]);
                        }
                        if (txt.Contains("备注"))
                        {
                            string[] info = txt.Split(':');
                            plate_Info.Add(info[0], info[1]);
                        }
                    }


                    //----------------
                    //根据开关进行处理-验证码
                    if (flag_MD5)
                    {
                        plate_Info.Add("MD5", txt.ToString().Trim());
                    }
                }
            }
            return plate_Info;
        }


        //中间文件到界面-设置
        public static void readIntoUI(Info[,] tpl, DataGridView dgv, DataGridView dgv1)
        {
            //输出模板信息
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 12; j++) {
                    if (tpl[i, j] != null)
                    {
                        Info info = tpl[i, j];
                        //textDebug += "(" + info.i + "," + info.j + ")," + info.well_class + "(" + info.well_num + "): " + " conc=" + info.well_conc + "\n";
                        //dgv.Rows[i].Cells[j].Value = info.well_class + " " + info.well_num + System.Environment.NewLine + info.well_conc;
                        dgv.Rows[i].Cells[j].Value = info.well_class + " " + info.well_num + '\r' + info.well_conc;

                        //调整板子的颜色变化
                        changeODBackColor(info.well_class, dgv, info.i, info.j);//set板子
                        changeODBackColor(info.well_class, dgv1, info.i,info.j);//od板子
                    }
                    
                }
            }
        }


        //中间文件到界面-od
        public static void readIntoUI(Double[,] od, DataGridView dgv)
        {
            //输出OD值
            for (int i = 0; i < 8; i++)
            {
                for (int j = 0; j < 12; j++)
                {
                    if (od[i, j] != 0)
                    {
                        //textDebug += "(" + i + "," + j + ")" + od[i, j] + "\n";
                        dgv.Rows[i].Cells[j].Value = od[i, j];
                    }
                }
            }
        }

        //根据行列设置孔的颜色变化
        public static void changeODBackColor(string well_class,DataGridView dgv, int i, int j) {
            if (well_class == "std")
                dgv.Rows[i].Cells[j].Style.BackColor = System.Drawing.ColorTranslator.FromHtml("#008000");
            else if (well_class == "ctr")
                dgv.Rows[i].Cells[j].Style.BackColor = System.Drawing.ColorTranslator.FromHtml("#9ACD32");
            else if (well_class == "blank")
                dgv.Rows[i].Cells[j].Style.BackColor =System.Drawing.ColorTranslator.FromHtml("#808080");
            else if (well_class == "smp")
                dgv.Rows[i].Cells[j].Style.BackColor =System.Drawing.ColorTranslator.FromHtml("#87CEFA");
            else
            {
                dgv.Rows[i].Cells[j].Style.BackColor = System.Drawing.ColorTranslator.FromHtml("#ffffff");
            }

        }



        //=================================从界面到文件
        //返回模板设置信息
        public Info[,] readFromUI(DataGridView dgv, bool isContrl)
        {


            for (int i = 0; i < 8; i++)
            {
                for (int j = 0; j < 12; j++)
                {
                    
                    //if (dgv.Rows[i].Cells[j].Value != null)
                    if ((dgv.Rows[i].Cells[j].Value != null) && (dgv.Rows[i].Cells[j].Value.ToString() != ""))
                    {
                        //保存拆分后的字符串
                        string[] info = new string[2];
                        string[] info2 = new string[2];
                        //定义cell信息类
                        Info wi;

                        //获取单元格内容字符串
                        string txt = dgv.Rows[i].Cells[j].Value.ToString();
                        //拆分字符串
                        info = txt.Split(' ');

                        if (info[1].IndexOf('\r') != -1)
                        {
                            info2 = info[1].Split('\r');
                            //if (i < 2 && j < 2) MessageBox.Show(info[0] + " " + info2[0] + "#" + info2[1]);//todo
                            wi = new Info(i, j, info[0], info2[0], double.Parse(info2[1]));

                        }
                        else
                        {
                            //if (i < 2 && j < 2) MessageBox.Show(info[0] + " " + info[1]);//todo
                            wi = new Info(i, j, info[0], info[1]);

                        }

                        tpl[i, j] = wi;
                    }
                    else 
                    {
                        tpl[i, j] = null;
                    }
                }
            }
            return tpl;
        }

        //返回od数据
        public string[,] readFromUI(DataGridView dgv)
        {
            string[,] odStr=new string[8,12];

            for (int i = 0; i < 8; i++)
            {
                for (int j = 0; j < 12; j++)
                {
                    if ((dgv.Rows[i].Cells[j].Value != null) && (dgv.Rows[i].Cells[j].Value.ToString() != ""))
                    {
                        //获取单元格内容字符串
                        odStr[i, j] = dgv.Rows[i].Cells[j].Value.ToString();
                    }
                    else 
                    {
                        odStr[i, j] = "";
                    }
                }
            }
            return odStr;
        }




    }
}
