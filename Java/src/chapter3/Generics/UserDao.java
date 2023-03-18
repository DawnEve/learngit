package chapter3.Generics;

// 泛型的信息只存在编译阶段，在class字节码就看不到泛型的信息了。那为什么下面这段代码能获取得到泛型的信息呢？
import java.lang.reflect.ParameterizedType;

abstract class BaseDao<T>{
	public BaseDao() {
		Class clazz=this.getClass();
		ParameterizedType pt=(ParameterizedType) clazz.getGenericSuperclass();
		clazz = (Class) pt.getActualTypeArguments()[0];
		System.out.println(clazz);
	}
}

class User{};

public class UserDao extends BaseDao<User> {
	public static void main(String[] args) {
		BaseDao<User> userDao=new UserDao();
	}
}

// class chapter3.Generics.User
// https://mp.weixin.qq.com/s/-dJzaG6CndWLXLpsqCo8Uw