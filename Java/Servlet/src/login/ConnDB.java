package login;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnDB {
	private Connection conn=null;
	/**
	 * 获取数据库连接
	 * @return
	 */
	public Connection getConn(){
		try {
			//1.连接数据库
			Class.forName("com.mysql.jdbc.Driver");
			//2.获得连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/think","root","");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
