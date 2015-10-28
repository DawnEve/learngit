using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace fileReadWrite
{
    class DataFormat
    {

        //类字段。字典保存一些板子的基本信息 http://bbs.csdn.net/topics/330090204
        private Dictionary<string, string> plate_Info = new Dictionary<string, string>();
        private Dictionary<int, double> std = new Dictionary<int, double>();//保存标准品和浓度


        //读取并解析文件
        public Dictionary<string, string> read(string fileName) 
        {
            //StreamReader sr = new StreamReader(Application.StartupPath + "\\txtreader.txt", false);

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
                        }
                        if (txt.Contains("Name"))
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
                        if (txt.Contains("Union"))
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
                    if (flag_Value && false)//先跳过OD data
                    //if (flag_Value)
                    {
                        string[] d_value = txt.Split('\t');

                        i++;//i相当于行
                        //j相当于列
                        string Location = "";
                        for (int j = 0; j < 12; j++)
                        {
                            if (d_value[j].Trim() != "")
                            {
                                Location = (string)(i + "行" + j + "列");
                                MessageBox.Show(d_value[j], "OD-" + Location);
                            }
                        }
                    }



                    //----------------
                    //根据开关进行处理-布局数据
                    //if (flag_Layout && false)//先跳过模板data
                    if (flag_Layout)
                    {
                        //MessageBox.Show(txt, "Layout");
                        string[] d_value = txt.Split('\t');

                        iM++;//i相当于行
                        //j相当于列
                        string Location = "";
                        string MuBan_info = "";
                        string[] info = new string[2];
                        string[] info2 = new string[2];
                        for (int j = 0; j < 12; j++)
                        {
                            MuBan_info = d_value[j] + "  \n";
                            if (d_value[j].Trim() != "")
                            {
                                if (d_value[j].Contains("std"))
                                {
                                    info = d_value[j].Split('#');
                                    info2 = info[0].Split(' ');
                                    MuBan_info += "标准品" + info2[0] + ", 编号" + info2[1] + "， 浓度" + info[1];
                                }
                                else if (d_value[j].Contains("ctr"))
                                {
                                    info = d_value[j].Split('#');
                                    info2 = info[0].Split(' ');
                                    MuBan_info += "质控品" + info2[0] + ", 编号" + info2[1] + "， 浓度" + info[1];

                                }
                                else if (d_value[j].Contains("smp"))
                                {
                                    info = d_value[j].Split(' ');
                                    MuBan_info += "待测样品" + info[0] + "， 编号" + info[1];
                                }

                                Location = (string)(iM + "行" + j + "列");
                                MessageBox.Show(MuBan_info, "Mub-" + Location);
                            }
                        }
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



                //输出结果todo
                //string text = "";
                //foreach (string item in plate_Info.Keys)
                //{
                //    string info = plate_Info[item];
                //    text += item + " [:] " + info + "\n";
                //}
                //返回一个字典
                return plate_Info;


            }
            //
        
        }


    }
}
