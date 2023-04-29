package chapter2;

public class EnumDemo {
	enum FruitJuice{ SMALL, MEDIUM , LARGE };
	
    public static void main(String[] args) {
		FruitJuice fj1=FruitJuice.SMALL;
		System.out.println(fj1); //SMALL
		System.out.println(fj1.equals(0)); //false
	}
}


