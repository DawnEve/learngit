package chapter6;

public class MathDemo {
	public static void main(String[] args) {
		System.out.println("使用弧度制");
		System.out.println("sin(90°)=" + Math.sin(Math.PI/2));
		System.out.println("cos(60)="+Math.cos(Math.PI/3));
		System.out.println("1的反正切值:"+Math.atan(1)/Math.PI);
		System.out.println("pi/2的角度值："+Math.toDegrees(Math.PI/2));
		System.out.println("60的弧度值："+Math.toRadians(60)/Math.PI);
		System.out.println("随机数："+Math.random()); //[0,1]随机数
		System.out.println(Math.PI);
		
		System.out.println();
		System.out.println(Math.sqrt(2)); //开方 1.4142135623730951
		System.out.println(Math.exp(1)); // e^1=2.718281828459045
		System.out.println(Math.log(2.718281829)); //ln(e)=1
		
	}
}
