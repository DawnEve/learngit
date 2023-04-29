package chapter1;

// 这个只能通过命令行测试
// javac xx.java;  java xx this is a book
public class CmdParas {
	public static void main(String[] args) {
		for(int i=0; i<args.length; i++) {
			System.out.println("args["+i+"]="+args[i]);
		}
	}
}
