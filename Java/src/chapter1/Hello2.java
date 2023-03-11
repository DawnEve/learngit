package chapter1;

//一个源文件只能包含一个公共的类
//多个源文件可以位于一个文件夹，这个文件夹有特定的称呼，叫做包
public class Hello2 {
	static public void main(String[] args) {
		// 内部类：定义到方法中
		class Student{
			String name;
			int age;
			float score;
			
			void say() {
				System.out.println(name + "\n  age:"+age+ "\n  score:"+score);
			}
		}
		
		// 创建类
		Student stu1=new Student();
		stu1.name="Tom";
		stu1.age=15;
		stu1.score=63.5f;
		stu1.say();		
		
	}
}
