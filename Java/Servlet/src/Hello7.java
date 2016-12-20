import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Hello7 extends HttpServlet {

	/** 
	 * session操作 db分页
	 */
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException
	{
		// 执行必需的初始化
		System.out.println("Hello World, init hello7~");
	}
	
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException, IOException
	{
		res.setContentType("text/html;charSet=utf8");
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			//1.连接数据库
			Class.forName("com.mysql.jdbc.Driver");
			//2.获得连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
		
			//3.获取statement
			stmt=conn.createStatement();
			stmt.executeQuery("use think;");
			rs = stmt.executeQuery("select * from think_user;");//结果集
			
			//4.输出结果
			//获取输出流
			PrintWriter out = res.getWriter();
			out.println("<table border='1'>");
			out.println("<tr><td>id</td><td>name</td><td>pass</td></tr>");
			while(rs.next()){
				out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+
						"</td><td>"+rs.getString(3)+"</td></tr>");
			}
			out.println("</table>");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}
}
