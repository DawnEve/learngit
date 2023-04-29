package chapter1;

public class VarArgsDemo {
	public static void main(String[] args) {
		printMax(1,5,9,3,7);
		printMax(new double[] {10,15,25});
	}

	private static void printMax(double... ds) {
		if(ds.length==0) {
			System.out.println("No argument passed");
			return;
		}
		
		double result=ds[0];
		for(int i=1; i<ds.length; i++) {
			if(ds[i] > result)
				result=ds[i];
		}
		System.out.println("max value is:"+result);	
	}
}
