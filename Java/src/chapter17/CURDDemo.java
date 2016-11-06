package chapter17;

import java.util.Date;

import chapter17.DB.DBHelper;

/**
 * 测试 增删改查
 * http://www.cnblogs.com/wuyuegb2312/p/3872607.html
 * @author admin
 */
public class CURDDemo {
	public static void main(String[] args) {
		DBHelper db=new DBHelper();
//		db.query("select * from t1;");
//		db.getAll("select * from think.think_user;");
		
		//按照id获取单个
		db.getOne(2);
		
/*		String sql2="insert into think.think_user(user,passwd,email)values('wjl_a1','123','w@11.com')";
		int i=db.insert(sql2);
		System.out.println(i);*/
//		System.out.println(new Date().getTime());
		System.out.println(System.currentTimeMillis()/1000);//获取时间戳，和php兼容。精确到秒。
		
	}
}
