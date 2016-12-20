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
	 * http://localhost:8080/mywebsite/hello7?page=3
	 * 
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
			
			//分页设置
			int pageSize=5;//一页多少条-设置
			int totalRow=0;//一共多少行？查表
			int totalPage=0;//一共多少页-计算
			int currentPage=1;//get传过来
			
			//获取总页码
			rs=stmt.executeQuery("select count(*) from think_user;");
			if(rs.next()){
				totalRow=rs.getInt(1);
			}
			if(rs!=null){
				rs.close();
			}

			//计算总页码
			if(totalRow%pageSize==0){
				totalPage=totalRow/pageSize;
			}else{
				totalPage=totalRow/pageSize+1;
			}
			
			//获得当前页码
			String gcurrentPage=req.getParameter("page");
			if(gcurrentPage != null){
				currentPage=Integer.parseInt(gcurrentPage);
				if(currentPage<1)currentPage=1;
				if(currentPage>totalPage)currentPage=totalPage;
			}
			
			int start=(currentPage-1)*pageSize;
			rs = stmt.executeQuery("select * from think_user limit "+start+","+pageSize);//结果集
			
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
			
			//输出分页代码
			if(currentPage>1){
				out.print(" <a href='?page="+(currentPage-1)+"'>上一页</a> ");
			}
			for(int i=1;i<=totalPage;i++){
				if(i!=currentPage){
					out.print(" <a href='?page="+i+"'>"+i+"</a> ");
				}else{
					out.print(i);
				}
					
			}
			if(currentPage<totalPage){
				out.print(" <a href='?page="+(currentPage+1)+"'>下一页</a> ");
			}
			
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
