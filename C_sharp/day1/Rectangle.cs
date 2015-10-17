using System;
//using 关键字用于在程序中包含命名空间。一个程序可以包含多个 using 语句。
namespace RectangleApplication
{
    class Rectangle
    {
        // 成员变量
        double length;
        double width;
		// 成员方法
        public void Acceptdetails()
        {
			//为什么没有this？
            length = 4.5;    
            width = 3.5;
        }
        public double GetArea()
        {
            return length * width;
        }
        public void Display()
        {
            Console.WriteLine("Length: {0}", length);
            Console.WriteLine("Width: {0}", width);
            Console.WriteLine("Area: {0}", GetArea());
        }
    }
    
	//另一个类
    class ExecuteRectangle
    {
        static void Main(string[] args)
        {
            Rectangle r = new Rectangle();
            r.Acceptdetails();
            r.Display();
            Console.ReadLine();//为了cmd窗体停留
        }
    }
}