using System;
//using 关键字用于在程序中包含命名空间。一个程序可以包含多个 using 语句。
namespace NewApp
{
    class SizeOf
    {
        static void Main(string[] args)
        {
			Console.WriteLine("Size of int: {0}", sizeof(int));
			Console.ReadLine();
        }
    }
}