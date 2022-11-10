package chapter20.C1;

/**
 * 命令行参数
 * @author admin
 * 使用命令行运行: 
$ java chapter20/C1/A4_CmdPara 0 1
the length of args:2
args[0]=0
args[1]=1
 */
public class A4_CmdPara {
	public static void main(String[] args){
		System.out.print("the length of args:" +  args.length+"\n");
		
		for(int i=0; i<args.length; i++) {
			System.out.printf("args[%d]=%s\n", i, args[i]);
		}
	}
}
