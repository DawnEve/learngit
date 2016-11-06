package chapter17;

import java.sql.DriverManager;
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
    
	public static void main(String[] args) {
		JDBCDemo j=new JDBCDemo();
//		j.query("show tables;");
		j.query("select * from t1;");
	}
	
	private void query(String sql){
		JDBCDemo d=new JDBCDemo();
		Connection conn=d.getConnection();
		//String sql="show tables;";
		
		//3.创建statement，并查询

		try {
			stmt = conn.createStatement();
			//PreparedStatement pstmt = conn.prepareStatement(sql) ;   
			//CallableStatement cstmt = conn.prepareCall("{CALL demoSp(? , ?)}") ;  
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
		if(rs != null){  // 关闭记录集   
			try{   
				rs.close() ;   
			}catch(SQLException e){   
				e.printStackTrace() ;   
			}   
		}   
		if(stmt != null){   // 关闭声明   
			try{   
				stmt.close() ;   
			}catch(SQLException e){   
				e.printStackTrace() ;   
			}   
		}   
		if(conn != null){  // 关闭连接对象   
			try{   
				conn.close() ;   
			}catch(SQLException e){   
				e.printStackTrace() ;   
			}   
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
