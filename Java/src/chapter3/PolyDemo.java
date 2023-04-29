package chapter3;

public class PolyDemo {
	public static void main(String[] args) {
		demo1();
	}

	private static void demo1() {
		Shape s1=new Circle();  s1.draw();
		Shape s2=new Square();  s2.draw();
		Shape s3=new Triangle();  s3.draw();
	}

}



class Shape {
    void draw() {}
}
 
class Circle extends Shape {
    void draw() {
        System.out.println("Circle.draw()");
    }
}
 
class Square extends Shape {
    void draw() {
        System.out.println("Square.draw()");
    }
}
 
class Triangle extends Shape {
    void draw() {
        System.out.println("Triangle.draw()");
    }
}