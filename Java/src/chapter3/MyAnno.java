package chapter3;

import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;
/*
 * 1.声明为 public @interface MyAnno {}
 * 2.成员变量: 用无参数方法的形式声明。其方法名和返回值定义了该成员变量的名字和类型
 * 	可以是以下类型：8种基本类型，String 类型, Class类型，enum类型，Annotation类型的数组
 * 	如果只有一个成员变量，建议名字叫 value
 * 	如果指定成员变量的初始值，可以使用 default 关键字。
 * 	如果没有成员变量，则叫做标记，使用时不用加()指定值
 * 3.使用时，如果只有一个变量且名字为value，则可以省略名字
 * 
 * */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, TYPE_PARAMETER, TYPE_USE})
//@Target({ FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME) //只有RUNTIME才能被反射获取
@Inherited //该注释修饰后，注释能被继承
public @interface MyAnno {
	String[] value() default "";
	
	int[] number() default 100; //指定默认值
}
