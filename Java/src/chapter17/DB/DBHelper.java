package chapter17.DB;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

/**
 * http://www.cnblogs.com/hongten/archive/2011/03/29/1998311.html
 * @author admin
 */

public class DBHelper {
    Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
    
	//构造函数
	public DBHelper(){
		super();
		this.getConnection();//初始化，获取数据库链接 
	}


	/**
	 * 查询语句，获取单个
	 * @param sql
	 */
	public void getOne(int id){
		String sql="select * from think.think_user where id="+id+" limit 1;";
		this.getAll(sql);
	}
	/**
	 * 查询语句
	 * @param sql
	 */
	public void getAll(String sql){
		//3.创建statement，并查询
		try {
			this.stmt = this.conn.createStatement();
			//PreparedStatement pstmt = conn.prepareStatement(sql) ;   
			//CallableStatement cstmt = conn.prepareCall("{CALL demoSp(? , ?)}") ;  
			this.rs = this.stmt.executeQuery(sql);
			
			//4.输出结果
			int col = this.rs.getMetaData().getColumnCount();
			System.out.println("============================");
			for(int i=1; i<=col;i++){
				System.out.print(this.rs.getMetaData().getColumnName(i)+"\t");//表头
			}
			System.out.println();	
			System.out.println("----------------------------");	
			
			while(this.rs.next()){
				for (int i = 1; i <= col; i++) {
					System.out.print(this.rs.getString(i)+"\t");//每一条记录
				}
				System.out.println();
		     }
			System.out.println("============================");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();//5.关闭资源
		}
	}
	
	/**
	 * insert 
	 * @param sql
	 * @return
	 */
	public int insert(String sql){
		int i=0;
		try {
			this.stmt = this.conn.createStatement();
			i = this.stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	

	/**
	 * 获取db链接
	 * @return
	 */
	private void getConnection() {
		//0.连接MySql数据库，用户名和密码都是root
		String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://localhost:3306/test" ;    
	    String username = "root" ;   
	    String password = "" ;
//	    Connection conn =  null;
	    
		//1.加载驱动类
		try{
			Class.forName(driver);//classLoader,加载对应驱动
		}catch(ClassNotFoundException e){   
		   System.out.println("找不到驱动程序类 ，加载驱动失败！");   
		   e.printStackTrace() ;   
		}
		
		//2.数据库连接
		try{   
		   this.conn = (Connection) DriverManager.getConnection(url , username , password) ;
		}catch(SQLException se){
		   System.out.println("数据库连接失败！");
		   se.printStackTrace() ;
		}
	}

	

	/**
	 * 关闭资源
	 */
	private void close(){
		/**
		//5.关闭连接
 			1)关闭记录集   
			2)关闭声明   
			3)关闭连接对象   
		 */
		if(this.rs != null){  // 关闭记录集   
			try{
				this.rs.close() ;
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(this.stmt != null){// 关闭声明   
			try{
				this.stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(this.conn != null){  // 关闭连接对象   
			try{
				this.conn.close() ;
			}catch(SQLException e){
				e.printStackTrace() ;
			}
		} 
	}

}
