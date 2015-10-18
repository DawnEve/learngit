using System;
//using 关键字用于在程序中包含命名空间。一个程序可以包含多个 using 语句。
namespace NewApp
{
    class TypeSwitch
    {
        static void Main(string[] args)
        {
			//double d = 5673.74;
			double d = 117.74;
            //int i;
            string i;

            // 强制转换 double 为 int
            //i = (int)d;
            i = d.ToString();
            Console.WriteLine(i);
            Console.ReadKey();
        }
    }
}