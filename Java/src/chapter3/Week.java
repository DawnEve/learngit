package chapter3;

//枚举的本质是类
//定义枚举：代替常量使用很方便！之前 常量大都是用public static final 来定义的。
//http://blog.csdn.net/qq_27093465/article/details/52180865

enum Grade{
	w1,w2,w3,w4,w5,w6,w7
}

class Week {
	
	static public void main(String[] args){
		Grade g=Grade.w2;//枚举类型的数据
		System.out.println(g);//输出 w2
		
		System.out.println(isGrade2(Grade.w2));//true
		System.out.println(isGrade2(Grade.w3));//false
	}
	
	static boolean isGrade2(Grade grade){
		if(Grade.w2.equals(grade)){
			return true;
		}
		return false;
	}

}
