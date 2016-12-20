import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Hello6 extends HttpServlet {

	/** 
	 * session操作 db判断
	 */
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException
	{
		// 执行必需的初始化
		System.out.println("Hello World, today");
	}
	
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException, IOException
	{
		res.setContentType("text/html;charSet=utf8");
		//关于session部分
		HttpSession hs=req.getSession(true);
		
		//判断是否合格
		String val=(String) hs.getAttribute("pass");
		
		if(val==null){
			//非法登录
			//res.sendRedirect("hello4?info=error");//重定向到某个url
			//return;
			System.out.println("invalide visit");
			
		}
		

		
		try {
			//1.连接数据库
			Class.forName("com.mysql.jdbc.Driver");
			//2.获得连接
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
		
			//3.获取statement
			Statement stmt=conn.createStatement();
			stmt.executeQuery("use think;");
			ResultSet rs = stmt.executeQuery("select * from think_user where user='Jim' limit 1;");//结果集
			
			//4.输出结果
			//获取输出流
			PrintWriter out = res.getWriter();
			
			while(rs.next()){
				String user = rs.getString(2) ; //此方法比较高效，第一列编号是1，不是0。
				String psw=rs.getString(3); 
				
				String str=user + ": "+psw;
				out.println(str + "<br />");
				System.out.println(str+"\n");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
