using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ExcelFile
{
    public class myDebug
    {

        public static void a(string str, string str2="")
        {
            MessageBox.Show(str+" : "+str2);
        }

        //输出数组
        public static string showArray(double[] d)
        {
            string s = "";
            int iMax = d.Length;
            for (int i = 0; i < iMax; i++)
            {
                s += "array(" + i + ")=" + d[i] + "\r";
            }
            return s;
        }


    }
}
