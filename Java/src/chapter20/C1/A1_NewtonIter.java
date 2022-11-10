package chapter20.C1;
/**
 * 牛顿迭代法求平方根
 * @author admin
 *
 */
public class A1_NewtonIter{
	public static void main(String[] args) {
		//System.out.println("test");
		double x=-3;
		System.out.printf("sqrt(%.3f)=%.10f\n", x, sqrt2(x));
	}
	
	public static double sqrt2(double x) {
		if(x<0) {
			return Double.NaN;
		}
		double err=1e-15;
		double result=x;
		int i=0;
		while(0.25* Math.pow( (result - x/result), 2) > err ) {
			i+=1;
			result = (x/result + result) /2;
			System.out.printf("[%d] x=%.3f, result=%.10f\n", i, x, result);
		}
		return result;
	}
}