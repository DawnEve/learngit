package chapter17;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

/**
 * http://www.cnblogs.com/hongten/archive/2011/03/29/1998311.html
 * @author admin
 */
public class JDBCDemo {
	//0.连接MySql数据库，用户名和密码都是root   
	String url = "jdbc:mysql://localhost:3306/test" ;    
	String username = "root" ;   
	String password = "" ;
	
	Statement stmt=null;
	ResultSet rs=null;
	Connection conn=null;

	public static void main(String[] args) throws SQLException {
//		demo1(); //相对独立的案例
		demo2();
//		demo10();
	}

	// 防止注入，要使用 PreparedStatement 拼凑字符串
	private static void demo2() {
		// JDBC连接的URL, 不同数据库有不同的格式:
		String JDBC_URL = "jdbc:mysql://localhost:3306/test";
		String JDBC_USER = "root";
		String JDBC_PASSWORD = "";
		// 获取连接: 并打印结果
		try(Connection conn = (Connection) DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);){
			try(PreparedStatement ps = conn.prepareStatement("SELECT host,user,password FROM mysql.user where user=? and host=?")){
				ps.setObject(1, "root");
				ps.setObject(2, "127.0.0.1");
				try(ResultSet rs = ps.executeQuery()){
					System.out.println("host, usr, pass");
					while(rs.next()) {
						String host=rs.getString(1); //索引从1开始
						String usr=rs.getString(2);
						String pass=rs.getString(3);
						System.out.printf("[%s]\t [%s]\t [%s]\n", host, usr, pass);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	//连接数据库
	private static void demo1() throws SQLException {
		// JDBC连接的URL, 不同数据库有不同的格式:
		String JDBC_URL = "jdbc:mysql://localhost:3306/test";
		String JDBC_USER = "root";
		String JDBC_PASSWORD = "";
		// 获取连接: 并打印结果
		try(Connection conn = (Connection) DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);){
			try(Statement stmt = conn.createStatement()){
				try(ResultSet rs = stmt.executeQuery("SELECT host,user,password FROM mysql.user")){
					System.out.println("host, usr, pass");
					while(rs.next()) {
						String host=rs.getString(1); //索引从1开始
						String usr=rs.getString(2);
						String pass=rs.getString(3);
						System.out.printf("[%s]\t [%s]\t [%s]\n", host, usr, pass);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 关闭连接:
		//conn.close();
	}

	
	
	//综合案例
	private static void demo10() {
		JDBCDemo j=new JDBCDemo();
//		j.query("show tables;");
		j.query("select * from t1;");
	}
	
	private void query(String sql){
		JDBCDemo d=new JDBCDemo();
		Connection conn=d.getConnection();
		sql="show tables;";
		
		//3.创建statement，并查询

		try {
			stmt = conn.createStatement();
			//PreparedStatement pstmt = conn.prepareStatement(sql) ;   
			//CallableStatement cstmt = conn.prepareCall("{CALL demoSp(? , ?)}") ;
			stmt.executeQuery("use phpcms;");
			rs = stmt.executeQuery(sql);
			//4.输出结果
			while(rs.next()){   
		         //String name = rs.getString("Tables_in_test") ;   
				 //System.out.print(name +":");
		         String tb_name = rs.getString(1) ; //此方法比较高效，第一列编号是1，不是0。
		         System.out.println(tb_name);
		     }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		/**
		//5.关闭连接
 			1)关闭记录集   
			2)关闭声明   
			3)关闭连接对象   
		 */
		try {
			if(rs!=null){ rs.close(); }
			if(stmt!=null){ stmt.close(); }
			if(conn!=null){ conn.close(); }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private Connection getConnection() {
		//1.加载驱动类
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){   
		   System.out.println("找不到驱动程序类 ，加载驱动失败！");   
		   e.printStackTrace() ;   
		}
		
		//2.数据库连接
		Connection conn =  null;
		try{   
		   conn = (Connection) DriverManager.getConnection(this.url , this.username , this.password) ;   
		}catch(SQLException se){   
		   System.out.println("数据库连接失败！");   
		   se.printStackTrace() ;   
		}
		
		return conn;
	}
}
