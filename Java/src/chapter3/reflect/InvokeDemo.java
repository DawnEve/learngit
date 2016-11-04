package chapter3.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeDemo {
	//包开头是com表示是sun内部用的，java打头的才是用户的
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		String str="abcd";
		Method mtCharAt=str.getClass().getMethod("charAt", int.class);
		
		Object ch=mtCharAt.invoke(str, 0);
		System.out.println(ch);
		
		//为什么Object数组可以，而int数组不行？
		System.out.println(mtCharAt.invoke(str, new Object[]{1}));//1.4语法
		//System.out.println(mtCharAt.invoke(str, new int[]{2}));//1.4语法
		System.out.println(mtCharAt.invoke(str, Integer.valueOf(3)));
	}

}
