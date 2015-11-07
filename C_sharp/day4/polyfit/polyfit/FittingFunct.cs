using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace polyfit
{
    class FittingFunct
    {

     /** 
     * 多项式拟合函数,输出系数是y=a0+a1*x+a2*x*x+.........，按a0,a1,a2输出 
     *  
     * @param y 
     * @param x 
     * @param order 
     * @return 
     */
        public static double[] polyfit(double[] y, double[] x, int order)
        {
            double[,] guass = get_Array(y, x, order);


            double[] ratio = cal_Guass(guass, order + 1);


            return ratio;
        }


        /** 
         * 一次拟合函数，y=a0+a1*x,输出次序是a0,a1 
         *  
         * @param y 
         * @param x 
         * @return 
         */
        public static double[] linear(double[] y, double[] x)
        {
            double[] ratio = polyfit(y, x, 1);
            return ratio;
        }


        /** 
         * 对数拟合函数,.y= c*(ln x)+b,输出为b,c 
         *  
         * @param y 
         * @param x 
         * @return 
         */
        public static double[] Logest(double[] y, double[] x)
        {
            double[] lnX = new double[x.Length];


            for (int i = 0; i < x.Length; i++)
            {
                if (x[i] == 0 || x[i] < 0)
                {
                    //System.out.println("正对非正数取对数！");  
                    return null;
                }
                lnX[i] = Math.Log(x[i]);
            }


            return linear(y, lnX);
        }


        /** 
         * 幂函数拟合模型, y=c*x^b,输出为c,b 
         *  
         * @param y 
         * @param x 
         * @return 
         */
        public static double[] PowEST(double[] y, double[] x)
        {
            double[] lnX = new double[x.Length];
            double[] lnY = new double[y.Length];
            double[] dlinestRet;


            for (int i = 0; i < x.Length; i++)
            {
                lnX[i] = Math.Log(x[i]);
                lnY[i] = Math.Log(y[i]);
            }


            dlinestRet = linear(lnY, lnX);


            dlinestRet[0] = Math.Exp(dlinestRet[0]);


            return dlinestRet;
        }


        /** 
         * 指数函数拟合函数模型，公式为 y=c*m^x;输出为 c,m 
         *  
         * @param y 
         * @param x 
         * @return 
         */
        public static double[] indexEST(double[] y, double[] x)
        {
            double[] lnY = new double[y.Length];
            double[] ratio;
            for (int i = 0; i < y.Length; i++)
            {
                lnY[i] = Math.Log(y[i]);
            }


            ratio = linear(lnY, x);


            for (int i = 1; i < ratio.Length; i++)
            {
                ratio[i] = Math.Exp(ratio[i]);
            }
            return ratio;
        }


        /** 
         * 最小二乘法部分， 计算增广矩阵 
         *  
         * @param guass 
         * @param count 
         * @return 
         */
        private static double[] cal_Guass(double[,] guass, int count)
        {
            double temp;
            double[] x_value;


            for (int j = 0; j < count; j++)
            {
                int k = j;
                double min = guass[j, j];


                for (int i = j; i < count; i++)
                {
                    if (Math.Abs(guass[i, j]) < min)
                    {
                        min = guass[i, j];
                        k = i;
                    }
                }


                if (k != j)
                {
                    for (int x = j; x <= count; x++)
                    {
                        temp = guass[k, x];
                        guass[k, x] = guass[j, x];
                        guass[j, x] = temp;
                    }
                }


                for (int m = j + 1; m < count; m++)
                {
                    double div = guass[m, j] / guass[j, j];
                    for (int n = j; n <= count; n++)
                    {
                        guass[m, n] = guass[m, n] - guass[j, n] * div;
                    }
                }
            }
            x_value = get_Value(guass, count);


            return x_value;
        }


        /** 
         * 回带计算X值 
         *  
         * @param guass 
         * @param count 
         * @return 
         */
        private static double[] get_Value(double[,] guass, int count)
        {
            double[] x = new double[count];
            double[,] X_Array = new double[count, count];


            for (int i = 0; i < count; i++)
                for (int j = 0; j < count; j++)
                    X_Array[i, j] = guass[i, j];


            if (2 < count - 1)// 表示有多解  
            {
                return null;
            }
            // 回带计算x值  
            x[count - 1] = guass[count - 1, count] / guass[count - 1, count - 1];
            for (int i = count - 2; i >= 0; i--)
            {
                double temp = 0;
                for (int j = i; j < count; j++)
                {
                    temp += x[j] * guass[i, j];
                }
                x[i] = (guass[i, count] - temp) / guass[i, i];
            }


            return x;
        }


        /** 
         * 得到数据的法矩阵,输出为发矩阵的增广矩阵 
         *  
         * @param y 
         * @param x 
         * @param n 
         * @return 
         */
        private static double[,] get_Array(double[] y, double[] x, int n)
        {
            double[,] result = new double[n + 1, n + 2];


            if (y.Length != x.Length)
            {
                //System.out.println("两个输入数组长度不一！");  
            }


            for (int i = 0; i <= n; i++)
            {
                for (int j = 0; j <= n; j++)
                {
                    result[i, j] = cal_sum(x, i + j);
                }
                result[i, n + 1] = cal_multi(y, x, i);
            }


            return result;
        }


        /** 
         * 累加的计算 
         *  
         * @param input 
         * @param order 
         * @return 
         */
        private static double cal_sum(double[] input, int order)
        {
            double result = 0;
            int Length = input.Length;


            for (int i = 0; i < Length; i++)
            {
                result += Math.Pow(input[i], order);
            }


            return result;
        }


        /** 
         * 计算∑(x^j)*y 
         *  
         * @param y 
         * @param x 
         * @param order 
         * @return 
         */
        private static double cal_multi(double[] y, double[] x, int order)
        {
            double result = 0;


            int Length = x.Length;


            for (int i = 0; i < Length; i++)
            {
                result += Math.Pow(x[i], order) * y[i];
            }


            return result;
        }


        public static double calRSquare_linear(double[] x, double[] y, double a, double b)
        {


            int num = y.Length;
            double[] yLine = new double[num];
            for (int i = 0; i < num; i++)
            {
                yLine[i] = x[i] * b + a;
            }


            return calRSquare(x, y, yLine, a, b);
        }


        public static double calRSquare_Logest(double[] x, double[] y, double a, double b)
        {


            int num = y.Length;
            double[] yLine = new double[num];
            for (int i = 0; i < num; i++)
            {
                yLine[i] = Math.Log(x[i]) * b + a;
            }


            return calRSquare(x, y, yLine, a, b);
        }


        public static double calRSquare_PowEST(double[] x, double[] y, double c, double b)
        {


            int num = y.Length;


            double[] yLine = new double[num];


            for (int i = 0; i < num; i++)
            {
                // y=c*x^b,输出为c,b  
                yLine[i] = c * Math.Pow(x[i], b);
            }


            return calRSquare(x, y, yLine, c, b);
        }


        public static double calRSquare_indexEST(double[] x, double[] y, double c, double m)
        {


            int num = y.Length;
            double[] yLine = new double[num];
            for (int i = 0; i < num; i++)
            {
                // y=c*m^x  
                yLine[i] = c * Math.Pow(m, x[i]);
            }


            return calRSquare(x, y, yLine, c, m);
        }


        /** 
         * 计算R2值：R2=1-SSE/SST。SSE为实际值减去预测值的平方和；SST为实际值减去平均值的平方和 
         *  
         * @param x 
         *            实际坐标x的值数组 
         * @param y 
         *            实际坐标y的值数组 
         * @param yLine 
         *            预测线坐标y的值数组 
         * @param a 
         *            前一个参数 
         * @param b 
         *            后一个参数 
         * @return 
         */
        private static double calRSquare(double[] x, double[] y, double[] yLine,
                double a, double b)
        {


            // 1、获取线性函数对应的数组值  
            int num = y.Length;


            // 2、y平均值  
            double sum = 0;
            foreach (double yi in y)
            {
                sum = sum + yi;
            }
            double yAverage = sum / num;


            // 3、计算实际值减去预算值的平方和  
            double sse = 0;
            for (int i = 0; i < num; i++)
            {
                sse = sse + (y[i] - yLine[i]) * (y[i] - yLine[i]);
            }


            // 4、计算实际值减去平均值的平方和  
            double sst = 0;
            for (int i = 0; i < num; i++)
            {
                sst = sst + (y[i] - yAverage) * (y[i] - yAverage);
                //sst = sst + y[i] * y[i];//我认为应该是这个
            }


            return 1 - sse / sst;
        }
    }
}
