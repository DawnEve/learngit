package chapter20.C1;

public class A3_Math {
	public static void main(String[] args) {
		double rs1=Math.sin( Math.PI/2 ); //1  三角函数，使用弧度
		double rs2=Math.log(Math.E); //1 对数，使用自然对数为底
		
		System.out.printf("PI=%.15f\n", Math.PI);
		System.out.printf("e=%.15f\n", Math.E);
		System.out.println();
		//		
		System.out.printf("sin(pi/2)=%.5f\n", rs1);
		System.out.printf("log(e)=%.5f\n", rs2);
		
		System.out.printf("log2(8)=%.5f\n", Math.log(8)/Math.log(2) );
	}
}
