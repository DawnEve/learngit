using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExcelFile
{
    /// <summary>
    /// 定义一些内部模板
    /// </summary>
    class InnerTpl
    {
        //用字典保存内置的模板文件
        private Dictionary<string,Info[,]> tpls=new Dictionary<string,Info[,]>();

        public InnerTpl() {
            //初始化-加载内置模板数据
            setTpls();
        }


        //获得内置模板名字
        public string[] getInnerTplNames()
        {
            //获取内置模板数据的keys
            string[] inner_tpl_names = new string[tpls.Keys.Count];
            int i=0;
            foreach (string k in tpls.Keys) {
                inner_tpl_names[i] = k;
                i++;
            }
                return inner_tpl_names;
        }

        public Info[,] getTplByName(string tpl_name)
        {
            return tpls[tpl_name];
        }

        //设置内置模板文件
        private void setTpls()
        {
            //设置瘦肉精的模板文件
            Info[,] tpl=new Info[8,12];

            //==============================默认是空模板：也就是自定义模板。
            tpls.Add("自定义模板", tpl);

            
            //==========================第1个内置模板
            //初始化数组
            tpl=new Info[8,12];
            //设置标准品
            tpl[0,0]=new Info(0,1,"std","0",0);
            tpl[0,1]=new Info(0,1,"std","1",10);
            tpl[0,2]=new Info(0,2,"std","2",20);
            tpl[0,3]=new Info(0,3,"std","3",30);
            tpl[0,4]=new Info(0,4,"std","4",40);
            tpl[0,5]=new Info(0,5,"std","5",50);
            tpl[0,6]=new Info(0,6,"std","6",60);
            tpl[0,7]=new Info(0,7,"std","7",70);
            //设置结束，增加到模板中
            tpls.Add("瘦肉精", tpl);


            //==========================第2个内置模板
            //初始化数组
            tpl = new Info[8, 12];
            //设置标准品
            tpl[0, 0] = new Info(0, 1, "std", "0", 0);
            tpl[0, 1] = new Info(0, 1, "std", "1", 20);
            tpl[0, 2] = new Info(0, 2, "std", "2", 40);
            tpl[0, 3] = new Info(0, 3, "std", "3", 60);
            tpl[0, 4] = new Info(0, 4, "std", "4", 80);
            tpl[0, 5] = new Info(0, 5, "std", "5", 100);
            tpl[0, 6] = new Info(0, 6, "std", "6", 120);
            tpl[0, 7] = new Info(0, 7, "std", "7", 140);
            //设置质控品
            tpl[1, 0] = new Info(1, 0, "ctr", "1", 100);
            //设置结束，增加到模板中
            tpls.Add("霉菌毒素", tpl);


            //==========================第3个内置模板
            //初始化数组
            tpl = new Info[8, 12];
            //设置标准品
            tpl[0, 0] = new Info(0, 1, "std", "0", 0);
            tpl[0, 1] = new Info(0, 1, "std", "1", 30);
            tpl[0, 2] = new Info(0, 2, "std", "2", 60);
            tpl[0, 3] = new Info(0, 3, "std", "3", 90);
            tpl[0, 4] = new Info(0, 4, "std", "4", 120);
            tpl[0, 5] = new Info(0, 5, "std", "5", 150);
            tpl[0, 6] = new Info(0, 6, "std", "6", 180);
            tpl[0, 7] = new Info(0, 7, "std", "7", 210);
            //设置质控品
            tpl[1, 0] = new Info(1, 0,"ctr","1",100);
            tpl[1, 1] = new Info(1, 1, "ctr", "2", 200);
            //设置结束，增加到模板中
            tpls.Add("黄曲霉毒素B1", tpl);


            //==========================第4个内置模板
            //初始化数组
            tpl = new Info[8, 12];
            //设置标准品
            tpl[0, 0] = new Info(0, 1, "std", "0", 0);
            tpl[0, 1] = new Info(0, 1, "std", "1", 30);
            tpl[0, 2] = new Info(0, 2, "std", "2", 60);
            tpl[0, 3] = new Info(0, 3, "std", "3", 90);
            tpl[0, 4] = new Info(0, 4, "std", "4", 120);
            tpl[0, 5] = new Info(0, 5, "std", "5", 150);
            tpl[0, 6] = new Info(0, 6, "std", "6", 180);
            //设置质控品
            tpl[1, 0] = new Info(1, 0, "ctr", "1", 100);
            tpl[1, 1] = new Info(1, 1, "ctr", "2", 200);
            tpl[1, 2] = new Info(1, 2, "ctr", "3", 300);
            //设置结束，增加到模板中
            tpls.Add("干豆腐黄色素", tpl);
        }

    }
}
