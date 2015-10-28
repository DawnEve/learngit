using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace fileReadWrite
{
    //定义基本信息
    class Info
    {
        //编号、浓度
        //public string name;//编号，如果编号相同怎么办？
        public double conc;//浓度，如果浓度相同怎么办？
        //定义位置
        public int i;//8行
        public int j;//12列
        public Info(double conc, int i, int j){
            this.conc = conc;
            this.i = i;
            this.j = j;
        }
    }


    //定义一个模板类，包括标准品、质控品、样品 的（编号和浓度）
    class Template
    {
        public Dictionary<string, Info> std = new Dictionary<string, Info>();//标准品编号和浓度
        public Dictionary<string, Info> ctr = new Dictionary<string, Info>();//质控品编号和浓度
        public Dictionary<string, Info> smp = new Dictionary<string, Info>();//样品编号和浓度
    }
}
