package chapter8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class E1 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		demo1(); //序列化java对象到文件
//		demo2(); //从序列化文件中，读取对象到内存
		
//		demo3(); //写多个对象
		demo4(); //读多个对象
	}
	
	//读多个对象
	private static void demo4() throws IOException, ClassNotFoundException {
		String root="src//dustbin//temp//";
		ObjectInputStream ois=
				new ObjectInputStream(new FileInputStream(root+"stus.txt"));
		ArrayList<Student> arr = (ArrayList<Student>) ois.readObject();
		/*for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));			
		}*/
		for(Student stu: arr) {
			System.out.println(stu);
		}
	}

	//写多个对象
	private static void demo3() throws IOException {
		Student s1=new Student("张三", 20);
		Student s2=new Student("李斯", 21);
		Student s3=new Student("王二", 22);
		//放到集合中
		ArrayList<Student> arr=new ArrayList<>();
		arr.add(s1);
		arr.add(s2);
		arr.add(s3);
		//新建流
		String root="src//dustbin//temp//";
		ObjectOutputStream oos=
				new ObjectOutputStream(new FileOutputStream(root + "stus.txt"));
		oos.writeObject(arr);
		oos.close();
	}
	
	// 从文件读取对象
	private static void demo2() throws IOException, ClassNotFoundException {
		String root="src//dustbin//temp//";
		ObjectInputStream ois=
				new ObjectInputStream(new FileInputStream(root+"Stu1.obj"));
		Student stu1 = (Student)ois.readObject();
		System.out.println(stu1);
	}

	// 写对象到文件
	private static void demo1() throws IOException {
		Student stu1=new Student("张三", 20);
		//新建流
		String root="src//dustbin//temp//";
		ObjectOutputStream oos=
				new ObjectOutputStream(new FileOutputStream(root + "Stu1.obj"));
		oos.writeObject(stu1);
		// 报错:  java.io.NotSerializableException
		oos.close();
	}

}

